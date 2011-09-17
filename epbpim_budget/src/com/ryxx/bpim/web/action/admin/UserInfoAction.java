package com.ryxx.bpim.web.action.admin;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class UserInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(UserInfoAction.class);

	private UserInfoService userInfoService;
	
	private List<UserInfo> userInfos;
	private String userName;
	private String password;
	private Long eId;
	
	public String login() {
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
	
	public String batch() {
		
		return SUCCESS;
	}
	
	public String list() {
		userInfos = userInfoService.list(eId);
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

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
}
