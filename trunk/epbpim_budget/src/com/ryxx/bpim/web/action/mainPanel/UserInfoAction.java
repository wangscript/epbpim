package com.ryxx.bpim.web.action.mainPanel;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.enums.RoleEnum;
import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.string.StringTools;

public class UserInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(UserInfoAction.class);

	private UserInfoService userInfoService;

	private String identifier;
	private String password;
	private String userType;
	private Long eId;
	private UserInfo userInfo;

	public String login() {
		userInfo = new UserInfo();
		userInfo.setIdentifier(identifier);
		userInfo.setPassword(StringTools.md5(password));
		userInfo = userInfoService.getByLogin(userInfo);
		if (userInfo == null) {
			super.addFieldError("name", "用户名或密码错误,请重新输入");
			return INPUT;
		} else {
			session.put(Constants.LOGIN_USER_NAME, identifier);
			session.put(Constants.LOGIN_USER_ID, userInfo.getId());
			session.put(Constants.USER_LOGIN_TIME, new Date().getTime());
			if (RoleEnum.ENTERPRISE_USER.equals(userInfo.getRoleType())) {
				return "enterpriseMain";
			} else if (RoleEnum.NORMAL_USER.equals(userInfo.getRoleType())) {
				if (userInfo.getRealName() != null) {
					return "userMain";
				} else {
					userInfo.setPassword(null);
					return "userInfoManage";
				}
			}
		}
		return null;
	}
	
	public String updateUserInfo(){
		UserInfo userInfoForUpdate = new UserInfo();
		Long id = userInfo.getId();
		if(id!=null&&id!=0){
			userInfoForUpdate = userInfoService.findById(id);
			String newPassword = userInfo.getPassword();
			userInfoForUpdate.setPassword(StringTools.md5(newPassword));
			userInfoForUpdate.setRealName(userInfo.getRealName());
			userInfoForUpdate.setEmail(userInfo.getEmail());
			userInfoForUpdate.setMobilePhone(userInfo.getMobilePhone());
			userInfoForUpdate = userInfoService.merge(userInfoForUpdate);
			return SUCCESS;
		}
		return INPUT;
	}


	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}


	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}


	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
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


	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}


	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
