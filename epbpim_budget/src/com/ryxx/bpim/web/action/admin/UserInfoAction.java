package com.ryxx.bpim.web.action.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailException;

import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.entity.UserMenuReg;
import com.ryxx.bpim.enums.RoleEnum;
import com.ryxx.bpim.service.AdminMenuService;
import com.ryxx.bpim.service.EnterpriseInfoService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.cache.CacheMap;
import com.ryxx.util.date.DateTools;

public class UserInfoAction extends ActionSupportBase
{
    private static final long serialVersionUID = -5620230655376038210L;
    
    private static final Log LOG = LogFactory.getLog(UserInfoAction.class);
    
    private UserInfoService userInfoService;
    
    private ProvinceCityService provinceCityService;
    
    private EnterpriseInfoService enterpriseInfoService;
    
    private AdminMenuService adminMenuService;
    
    private List<ProvinceCity> provinceCities;
    
    private List<UserInfo> userInfos;
    
    private List<AdminMenu> modules;
    
    private EnterpriseInfo enterpriseInfo;
    
    private UserInfo userInfo;
    
    private String userName;
    
    private String password;
    
    private Integer userCount;
    
    private String expireDateTmp;
    
    private List listCheck;
    
    private List regionCheck;
    
    private Long eId;
    
    private Long id;
    
    public String login()
    {
        //		List<AdminUser> users = adminUserService.findAll();
        //		for(AdminUser user: users) {
        //			if(user.getUserName().equals(userName) && user.getPassword().equals(StringTools.md5(password))) {
        //				session.put(Constants.ADMIN_LOGIN_USER_NAME, userName);
        //				return SUCCESS;
        //			}
        //		}
        //		super.addFieldError("validateCode", super.getText("ç”¨æˆ·å��æˆ–å¯†ç �é”™è¯¯"));
        return INPUT;
    }
    
    public String newUser()
    {
        provinceCities = provinceCityService.list();
        enterpriseInfo = enterpriseInfoService.findById(eId);
        modules = adminMenuService.findAllUseModuleByRegion(enterpriseInfo.getProvinceCity().getId());
        return SUCCESS;
    }
    
    public String updateLock()
    {
        userInfo = userInfoService.findById(id);
        if (userInfo.getEnable() == null || userInfo.getEnable() != 1)
        {
            userInfo.setEnable(new Integer(1));
        }
        else
        {
            userInfo.setEnable(new Integer(0));
        }
        userInfoService.merge(userInfo);
        seteId(userInfo.getEnterpriseInfo().getId());
        request.setAttribute("eId", eId);
        return SUCCESS;
    }
    
    public String save()
    {
        userInfo = userInfoService.findById(id);
        
        if (regionCheck != null && regionCheck.size() > 0)
        {
            List<ProvinceCity> provinces = new ArrayList<ProvinceCity>();
            for (int k = 0; k < regionCheck.size(); k++)
            {
                ProvinceCity province = new ProvinceCity();
                province.setId(Long.valueOf(regionCheck.get(k).toString()));
                provinces.add(province);
            }
            userInfo.setProvinceCities(provinces);
        }
        List<AdminMenu> menus = adminMenuService.getMenuListById(listCheck);
        
        try
        {
            List<UserMenuReg> regs = new ArrayList<UserMenuReg>();
            for (AdminMenu adminMenu : menus)
            {
                UserMenuReg reg = new UserMenuReg();
                reg.setAdminMenu(adminMenu);
                if (userInfo.getMenus() == null || userInfo.getMenus().size() == 0)
                {
                    reg.setRegisterDate(new Timestamp(new Date().getTime()));
                    reg.setExpireDate(new Timestamp(DateUtils.addYears(new Date(), 1).getTime()));
                }
                else
                {
                    for (int i = 0; i < userInfo.getMenus().size(); i++)
                    {
                        UserMenuReg userMenuReg = userInfo.getMenus().get(i);
                        reg.setRegisterDate(userMenuReg.getRegisterDate());
                        //reg.setExpireDate(userMenuReg.getExpireDate());
                        reg.setExpireDate(new Timestamp(DateTools.string2Date(expireDateTmp, "yyyy-MM-dd").getTime()));
                        //						if(userMenuReg.getAdminMenu().getId().equals(adminMenu.getId())) {
                        //							reg.setRegisterDate(userMenuReg.getRegisterDate());
                        //							//reg.setExpireDate(userMenuReg.getExpireDate());
                        //							reg.setExpireDate(new Timestamp(StringTools.string2date(userInfo.getExpireDateTmp()).getTime()));
                        //							break;
                        //						}
                        //						if(i==userInfo.getMenus().size()) {
                        //							reg.setRegisterDate(new Timestamp(new Date().getTime()));
                        //							reg.setExpireDate(new Timestamp(DateUtils.addYears(new Date(), 1).getTime()));
                        //						}
                    }
                }
                regs.add(reg);
            }
            userInfo.setMenus(regs);
            UserInfo user = userInfoService.merge(userInfo);
            CacheMap.getInstance().addCache(RoleEnum.NORMAL_USER + userInfo.getIdentifier(),
                adminMenuService.list(userInfo.getProvinceCities(), userInfo.getId()));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("eId", eId);
        return SUCCESS;
    }
    
    public String batch()
        throws EmailException
    {
        enterpriseInfo = enterpriseInfoService.findById(eId);
        try
        {
            List<AdminMenu> menus = adminMenuService.getMenuListById(listCheck);
            userInfoService.batchAddUsers(userCount, enterpriseInfo, menus, regionCheck);
        }
        catch (EmailException e)
        {
            LOG.error(e.getMessage());
            throw e;
        }
        request.setAttribute("eId", eId);
        return SUCCESS;
    }
    
    public String list()
    {
        userInfos = userInfoService.list(eId);
        return SUCCESS;
    }
    
    public String get()
    {
        provinceCities = provinceCityService.list();
        userInfo = userInfoService.findById(id);
        modules = adminMenuService.findAllUseModuleByRegion(userInfo.getEnterpriseInfo().getProvinceCity().getId());
        regionCheck = new ArrayList();
        for (ProvinceCity provinces : userInfo.getProvinceCities())
        {
            regionCheck.add(provinces.getId());
        }
        listCheck = new ArrayList();
        for (UserMenuReg userMenuReg : userInfo.getMenus())
        {
            listCheck.add(userMenuReg.getAdminMenu().getId());
            setExpireDateTmp(DateTools.date2string(userMenuReg.getExpireDate(), "yyyy-MM-dd"));
        }
        seteId(userInfo.getEnterpriseInfo().getId());
        return SUCCESS;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
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
    
    public List<UserInfo> getUserInfos()
    {
        return userInfos;
    }
    
    public void setUserInfos(List<UserInfo> userInfos)
    {
        this.userInfos = userInfos;
    }
    
    public List<ProvinceCity> getProvinceCities()
    {
        return provinceCities;
    }
    
    public void setProvinceCities(List<ProvinceCity> provinceCities)
    {
        this.provinceCities = provinceCities;
    }
    
    public ProvinceCityService getProvinceCityService()
    {
        return provinceCityService;
    }
    
    public void setProvinceCityService(ProvinceCityService provinceCityService)
    {
        this.provinceCityService = provinceCityService;
    }
    
    public EnterpriseInfoService getEnterpriseInfoService()
    {
        return enterpriseInfoService;
    }
    
    public void setEnterpriseInfoService(EnterpriseInfoService enterpriseInfoService)
    {
        this.enterpriseInfoService = enterpriseInfoService;
    }
    
    public EnterpriseInfo getEnterpriseInfo()
    {
        return enterpriseInfo;
    }
    
    public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo)
    {
        this.enterpriseInfo = enterpriseInfo;
    }
    
    public AdminMenuService getAdminMenuService()
    {
        return adminMenuService;
    }
    
    public void setAdminMenuService(AdminMenuService adminMenuService)
    {
        this.adminMenuService = adminMenuService;
    }
    
    public List<AdminMenu> getModules()
    {
        return modules;
    }
    
    public void setModules(List<AdminMenu> modules)
    {
        this.modules = modules;
    }
    
    public Integer getUserCount()
    {
        return userCount;
    }
    
    public void setUserCount(Integer userCount)
    {
        this.userCount = userCount;
    }
    
    public List getListCheck()
    {
        return listCheck;
    }
    
    public void setListCheck(List listCheck)
    {
        this.listCheck = listCheck;
    }
    
    public UserInfo getUserInfo()
    {
        return userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public List getRegionCheck()
    {
        return regionCheck;
    }
    
    public void setRegionCheck(List regionCheck)
    {
        this.regionCheck = regionCheck;
    }
    
    public String getExpireDateTmp()
    {
        return expireDateTmp;
    }
    
    public void setExpireDateTmp(String expireDateTmp)
    {
        this.expireDateTmp = expireDateTmp;
    }
    
    public static void main(String[] args)
    {
        String str = "2012-03-29";
        System.out.println(new Timestamp(DateTools.string2Date(str, "yyyy-MM-dd").getTime()));
    }
}
