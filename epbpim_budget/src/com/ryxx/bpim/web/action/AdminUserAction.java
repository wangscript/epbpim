package com.ryxx.bpim.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.AdminUser;
import com.ryxx.bpim.service.AdminUserService;
import com.ryxx.util.string.StringTools;

public class AdminUserAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(AdminUserAction.class);

	private AdminUserService adminUserService;
	
	private String userName;
	private String password;
	
	public String login() {
		List<AdminUser> users = adminUserService.findAll();
		for(AdminUser user: users) {
			if(user.getUserName().equals(userName) && user.getPassword().equals(StringTools.md5(password))) {
				session.put(Constants.ADMIN_LOGIN_USER_NAME, userName);
				return SUCCESS;
			}
		}
		super.addFieldError("validateCode", super.getText("用户名或密码错误"));
		return INPUT;
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

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
}
