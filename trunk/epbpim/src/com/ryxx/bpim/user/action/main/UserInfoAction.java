package com.ryxx.bpim.user.action.main;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.user.service.AdminLogService;
import com.ryxx.bpim.user.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
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
        }
		return SUCCESS;
	}
	
	public String logout() {
		String userid = String.valueOf((Long)session.get(Constants.LOGIN_USER_ID));
        session.remove(Constants.LOGIN_USER_NAME);
        session.remove(Constants.LOGIN_USER_ID);
        session.remove(Constants.USER_LOGIN_TIME);
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
}