package com.ryxx.bpim.user.action.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.AdminMenu;
import com.ryxx.bpim.user.entity.AdminRole;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.user.service.AdminLogService;
import com.ryxx.bpim.user.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.cache.CacheMap;
import com.ryxx.util.date.DateTools;
import com.ryxx.util.string.StringTools;

public class UserInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(UserInfoAction.class);

	private String userName;
	private String password;
	private UserInfo userInfo;
	private String confirmPassword;
	private UserInfoService userInfoService;
	private AdminLogService adminLogService;
	
	public AdminLogService getAdminLogService() {
		return adminLogService;
	}

	public void setAdminLogService(AdminLogService adminLogService) {
		this.adminLogService = adminLogService;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public String login() {
		userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(StringTools.md5(password));
        UserInfo newUserInfo = userInfoService.getByLogin(userInfo);
        if (newUserInfo == null)
        {
            super.addFieldError("name", "用户名或密码错误，请重新输入");
            return INPUT;
        }
        else
        {
            session.put(Constants.LOGIN_USER_NAME, newUserInfo.getUserName());
            session.put(Constants.LOGIN_USER_ID, newUserInfo.getId());
            session.put(Constants.USER_LOGIN_TIME, new Date().getTime());
            List<AdminRole> roles = newUserInfo.getRoles();
            Set<AdminMenu> menus = new HashSet();
            for(AdminRole role: roles) {
            	menus.addAll(role.getMenuList());
            }
            System.out.println(menus.size());
            List<AdminMenu> newMenus = new ArrayList(menus);
    	    Collections.sort(newMenus, new MyComparator());
            CacheMap.getInstance().addCache(Constants.MENU_CACHE+Constants.LOGIN_USER_ID+newUserInfo.getId(), newMenus);
        }
		return SUCCESS;
	}
	
	public String logout() {
		String userid = String.valueOf((Long)session.get(Constants.LOGIN_USER_ID));
        session.remove(Constants.LOGIN_USER_NAME);
        session.remove(Constants.LOGIN_USER_ID);
        session.remove(Constants.USER_LOGIN_TIME);
        session.remove(Constants.ROLE+Constants.LOGIN_USER_ID);
        CacheMap.getInstance().removeCache(Constants.MENU_CACHE+Constants.LOGIN_USER_ID+userid);
        return SUCCESS;
	}

	public String showUser() {
		Long userid = (Long)session.get(Constants.LOGIN_USER_ID);
		setUserInfo(userInfoService.fetchById(userid));
		userInfo.setBirthdayTmp(DateTools.date2string(userInfo.getBirthday(), "yyyy-MM-dd"));
		return SUCCESS;
	}
	
	public String updateUser() {
		Long userId = (Long)session.get(Constants.LOGIN_USER_ID);
		if(StringUtils.isEmpty(confirmPassword)) {
			userInfo.setPassword(null);
		} else {
			userInfo.setPassword(StringTools.md5(confirmPassword));
		}
		userInfoService.savePrivateInfo(userId, userInfo);
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public static void main(String[] args) {
	    ArrayList<String> arrayList = new ArrayList<String>();

	    arrayList.add("A");
	    arrayList.add("F");
	    arrayList.add("C");
	    arrayList.add("D");
	    arrayList.add("E");
	    
	    Comparator comparator = Collections.reverseOrder();
	    System.out.println(arrayList);

	    Collections.sort(arrayList, comparator);
	    System.out.println(arrayList);
	  }
}