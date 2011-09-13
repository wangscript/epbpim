package com.ryxx.bpim.user.action;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.request.ParamTools;

public class UserInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(UserInfoAction.class);

	private String userName;
	private String password;
	
	public String adminLogin() {
		try {
			String[] passUser = ParamTools.getProperty(request, Constants.ADMINLOGININFO).split(",");
			for(int i=0;i<passUser.length;i++) {
				String[] users = passUser[i].split(":");
				if(userName.equals(users[0]) && password.equals(users[1])) {
					session.put(Constants.ADMIN_LOGIN_USER_NAME, userName);
					return SUCCESS;
				}
			}
			super.addFieldError("validateCode", super.getText("用户名或密码错误"));
			return INPUT;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listUserInfo() {
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
}