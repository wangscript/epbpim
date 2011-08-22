package com.ryxx.bpim.user.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.user.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class UserInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(UserInfoAction.class);

	private UserInfoService userInfoService;
	
	private List<UserInfo> userInfos;
	
	private PageTools page;
	private String userName;
	private String password;
	private boolean checkExpire;
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

	
	
	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}
	
	public String adminLogin() { 
//		String userName = request.getParameter("username");
//		String password = request.getParameter("password");
		try {
			String[] passUser = ParamTools.getProperty(request, Constants.ADMINLOGININFO).split(",");
			for(int i=0;i<passUser.length;i++) {
				String[] users = passUser[i].split(":");
				if(userName.equals(users[0]) && password.equals(users[1])) {
					session.put(Constants.ADMIN_LOGIN_USER_NAME, userName);
					return SUCCESS;
				}
			}
			super.addFieldError("validateCode", super.getText("ç”¨æˆ·å��æˆ–å¯†ç �é”™è¯¯"));
			return INPUT;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String listUserInfo() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(userName);
//			userInfo.setPhone(request.getParameter("groupName"));
			userInfo.setRowCount(pageNo);
			userInfo.setPageSize(pageSize);
			userInfos = userInfoService.listPage(userInfo, page);
			if (userInfos != null && userInfos.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (Exception ex) {
			LOG.error("UserInfoAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
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