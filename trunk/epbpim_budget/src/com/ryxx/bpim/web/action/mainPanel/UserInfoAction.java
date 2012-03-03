package com.ryxx.bpim.web.action.mainPanel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailException;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.enums.RoleEnum;
import com.ryxx.bpim.service.AdminMenuService;
import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.cache.CacheMap;
import com.ryxx.util.date.DateTools;
import com.ryxx.util.email.EmailTools;
import com.ryxx.util.string.StringTools;

public class UserInfoAction extends ActionSupportBase
{
    private static final long serialVersionUID = -5620230655376038210L;
    
    private static final Log LOG = LogFactory.getLog(UserInfoAction.class);
    
    public static Map<String, List> userSessionMap = new HashMap<String, List>();
    
    private UserInfoService userInfoService;
    
    private AdminMenuService adminMenuService;
    
    private String identifier;
    
    private String password;
    
    private String userType;
    
    private Long eId;
    
    private UserInfo userInfo;
    
    public String login()
    {
        userInfo = new UserInfo();
        userInfo.setIdentifier(identifier);
        userInfo.setPassword(StringTools.md5(password));
        userInfo = userInfoService.getByLogin(userInfo);
        if (userInfo == null)
        {
            super.addFieldError("name", "用户名或密码错误，请重新输入");
            return INPUT;
        }
        else
        {
            
            //  当前登录用户为普通用户，如果用户已被锁定或当前用户已经登录，则登录失败
            if (1 == userInfo.getRoleType().getKey())
            {
                if (0 == userInfo.getEnable())
                {
                    super.addFieldError("name", "用户账号已被锁定，请联系您的企业账号管理员或平台客服人员");
                    return INPUT;
                }
            }
            
            session.put(Constants.LOGIN_USER_NAME, identifier);
            session.put(Constants.LOGIN_USER_ID, userInfo.getId());
            session.put(Constants.USER_LOGIN_TIME, new Date().getTime());
            session.put(Constants.USER, userInfo);
            
            // 保存当前用户登录session，用户处理不可能有多个用户同时登录
            saveUserSession(session);
            if (CacheMap.getInstance().getCache(Constants.USER + userInfo.getId()) != null)
            {
                CacheMap.getInstance().removeCache(Constants.USER + userInfo.getId());
            }
            if (RoleEnum.ENTERPRISE_USER.equals(userInfo.getRoleType()))
            {
                if (userInfo.getEnterpriseInfo() == null || userInfo.getEnterpriseInfo().getProvinceCity() == null)
                {
                    super.addFieldError("name", "该用户未订阅任何应用。请订阅应用后再登录。");
                    return INPUT;
                }
                else
                {
                    CacheMap.getInstance().addCache(Constants.USER + userInfo.getId(),
                        adminMenuService.list(userInfo.getEnterpriseInfo().getProvinceCity()));
                    return "enterpriseMain";
                }
            }
            else if (RoleEnum.NORMAL_USER.equals(userInfo.getRoleType()))
            {
                if (userInfo.getProvinceCities() == null)
                {
                    super.addFieldError("name", "该用户未订阅任何应用。请订阅应用后再登录。");
                    return INPUT;
                } else if(userInfo.getMenus().get(0).getExpireDate().getTime() > new Date().getTime()) {
                	super.addFieldError("name", "该用户订阅已经过期。请重新订阅应用后再登录。");
                    return INPUT;
                }
                else
                {
                    CacheMap.getInstance().addCache(Constants.USER + userInfo.getId(),
                        adminMenuService.list(userInfo.getProvinceCities(), userInfo.getId()));
                    if (userInfo.getRealName() != null)
                    {
                        return "userMain";
                    }
                    else
                    {
                        userInfo.setPassword(null);
                        return "userInfoManage";
                    }
                }
            }
        }
        return null;
    }
    
    public String listMenus()
    {
        
        return SUCCESS;
    }
    
    public String get()
    {
        Long id = (Long)session.get(Constants.LOGIN_USER_ID);
        if (id != null && id != 0)
        {
            userInfo = userInfoService.findById(id);
        }
        return SUCCESS;
    }
    
    public String showSubscribe() {
    	Long id = (Long)session.get(Constants.LOGIN_USER_ID);
        if (id != null && id != 0)
        {
            userInfo = userInfoService.findById(id);
        }
    	return SUCCESS;
    }
    
    public String updateUserInfo()
    {
        UserInfo userInfoForUpdate = new UserInfo();
        Long id = (Long)session.get(Constants.LOGIN_USER_ID);
        if (id != null && id != 0)
        {
            userInfoForUpdate = userInfoService.findById(id);
            if (StringUtils.isNotEmpty(userInfo.getPassword()))
            {
                String newPassword = userInfo.getPassword();
                userInfoForUpdate.setPassword(StringTools.md5(newPassword));
            }
            userInfoForUpdate.setRealName(userInfo.getRealName());
            userInfoForUpdate.setEmail(userInfo.getEmail());
            userInfoForUpdate.setMobilePhone(userInfo.getMobilePhone());
            userInfoForUpdate = userInfoService.merge(userInfoForUpdate);
            return SUCCESS;
        }
        return INPUT;
    }
    
    public String sendPasswordByEmail()
    {
        UserInfo userInfo = userInfoService.getUserByIdentifier(identifier);
        if (userInfo == null)
        {
            super.addFieldError("name", "用户名不存在");
        }
        else if (userInfo.getEmail() == null || "".equals(userInfo.getEmail()))
        {
            super.addFieldError("name", "您还没有填写过邮箱，无法发送。请联系您的企业账号管理员或平台客服人员");
        }
        else
        {
            String newPassword = StringTools.generateString(6);
            userInfo.setPassword(StringTools.md5(newPassword));
            userInfoService.merge(userInfo);
            String emailContent = EmailTools.generateFindPasswordContent(userInfo.getRealName(), newPassword);
            List<String> addresses = new ArrayList<String>();
            addresses.add(userInfo.getEmail());
            try
            {
                EmailTools.send(addresses, Constants.EMAIL_SUBJECT, emailContent);
                super.addFieldError("name", "新密码已发送至您的邮箱，请使用新密码登陆平台");
            }
            catch (EmailException e)
            {
                LOG.error(e.getMessage());
                super.addFieldError("name", "邮箱服务器连接失败，请稍后再试，或联系平台管理员");
            }
        }
        return INPUT;
    }
    
    private void saveUserSession(Map session)
    {
        
        String userid = String.valueOf((Long)session.get(Constants.LOGIN_USER_ID));
        
        if (null == userSessionMap.get(userid))
        {
            List userSessionList = new ArrayList();
            userSessionList.add(session);
            userSessionMap.put(userid, userSessionList);
        }
        else
        {
            userSessionMap.get(userid).add(session);
        }
    }
    
    /**
     * @return the identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }
    
    /**
     * @param identifier
     *            the identifier to set
     */
    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }
    
    /**
     * @return the userType
     */
    public String getUserType()
    {
        return userType;
    }
    
    /**
     * @param userType
     *            the userType to set
     */
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Long geteId()
    {
        return eId;
    }
    
    public void seteId(Long eId)
    {
        this.eId = eId;
    }
    
    public UserInfoService getUserInfoService()
    {
        return userInfoService;
    }
    
    public void setUserInfoService(UserInfoService userInfoService)
    {
        this.userInfoService = userInfoService;
    }
    
    /**
     * @return the userInfo
     */
    public UserInfo getUserInfo()
    {
        return userInfo;
    }
    
    /**
     * @param userInfo
     *            the userInfo to set
     */
    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }
    
    public AdminMenuService getAdminMenuService()
    {
        return adminMenuService;
    }
    
    public void setAdminMenuService(AdminMenuService adminMenuService)
    {
        this.adminMenuService = adminMenuService;
    }
    
}
