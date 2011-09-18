package com.ryxx.bpim.web.action.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.enums.RoleEnum;
import com.ryxx.bpim.service.AdminMenuService;
import com.ryxx.bpim.service.EnterpriseInfoService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.string.StringTools;

public class UserInfoAction extends ActionSupportBase {
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
	private String userName;
	private String password;
	private Integer userCount;
	private List listCheck;
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
	
	public String newUser() {
		provinceCities = provinceCityService.list();
		enterpriseInfo = enterpriseInfoService.findById(eId);
		modules = adminMenuService.findAllUseModuleByRegion(enterpriseInfo.getProvinceCity().getId());
		return SUCCESS;
	}
	
	public String batch() {
		if(userCount != null && userCount > 0) {
			enterpriseInfo.setId(eId);
			for(int i=0; i<userCount; i++) {
				UserInfo userInfo = new UserInfo();
				userInfo.setRoleType(RoleEnum.NORMAL_USER);
				userInfo.setEnterpriseInfo(enterpriseInfo);
				userInfo.setRegisterDate(new Timestamp(System.currentTimeMillis()));
				String maxIdentify = userInfoService.getMaxIdentify();
				if(maxIdentify == null || maxIdentify.length() == 0) {
					userInfo.setIdentifier("yr10000001");
				} else {
					userInfo.setIdentifier("ry"+(Long.parseLong(maxIdentify.substring(2))+1));
				}
				List<AdminMenu> menus = new ArrayList<AdminMenu>();
				if(listCheck != null && listCheck.size()>0) {
					for(int j=0; j<listCheck.size(); j++) {
						AdminMenu menu = new AdminMenu();
						menu.setId(Integer.parseInt(listCheck.get(j).toString()));
						menus.add(menu);
					}
				}
				userInfo.setMenus(menus);
				UserInfo user = userInfoService.save(userInfo);
			}
		}
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

	public List<ProvinceCity> getProvinceCities() {
		return provinceCities;
	}

	public void setProvinceCities(List<ProvinceCity> provinceCities) {
		this.provinceCities = provinceCities;
	}

	public ProvinceCityService getProvinceCityService() {
		return provinceCityService;
	}

	public void setProvinceCityService(ProvinceCityService provinceCityService) {
		this.provinceCityService = provinceCityService;
	}

	public EnterpriseInfoService getEnterpriseInfoService() {
		return enterpriseInfoService;
	}

	public void setEnterpriseInfoService(EnterpriseInfoService enterpriseInfoService) {
		this.enterpriseInfoService = enterpriseInfoService;
	}

	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}

	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}

	public AdminMenuService getAdminMenuService() {
		return adminMenuService;
	}

	public void setAdminMenuService(AdminMenuService adminMenuService) {
		this.adminMenuService = adminMenuService;
	}

	public List<AdminMenu> getModules() {
		return modules;
	}

	public void setModules(List<AdminMenu> modules) {
		this.modules = modules;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public List getListCheck() {
		return listCheck;
	}

	public void setListCheck(List listCheck) {
		this.listCheck = listCheck;
	}
}
