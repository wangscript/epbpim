package com.ryxx.bpim.web.action.admin;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.enums.RoleEnum;
import com.ryxx.bpim.service.EnterpriseInfoService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;
import com.ryxx.util.string.StringTools;

public class EnterpriseInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(EnterpriseInfoAction.class);

	private EnterpriseInfoService enterpriseInfoService;
	private ProvinceCityService provinceCityService;
	private UserInfoService userInfoService;
	
	private List<EnterpriseInfo> enterpriseInfos;
	private EnterpriseInfo enterpriseInfo;
	private List<ProvinceCity> provinceCities;
	private Long id;
	
	private PageTools page;
	
	public String newEnterpriseInfo() {
		provinceCities = provinceCityService.list();
		return SUCCESS;
	}
	
	public String list() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			EnterpriseInfo enterpriseInfo1 = new EnterpriseInfo();
			enterpriseInfo1.setRowCount(pageNo);
			enterpriseInfo1.setPageSize(pageSize);
			enterpriseInfos = enterpriseInfoService.listPage(enterpriseInfo1, page);
			if (enterpriseInfos != null && enterpriseInfos.size() > 0) {
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
	
	public String add() {
		enterpriseInfo.setLogTime(new Timestamp(System.currentTimeMillis()));
		enterpriseInfoService.save(enterpriseInfo);
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(enterpriseInfo.getEmail());
		userInfo.setEnterpriseInfo(enterpriseInfo);
		List<UserInfo> users = userInfoService.findAll();
		if(users == null || users.size() == 0) {
			userInfo.setIdentifier(StringTools.generateIdentify(1L));
		} else {
			userInfo.setIdentifier(StringTools.generateIdentify(users.size()+1));
		}
		userInfo.setPassword(StringTools.md5(Constants.DEFAULT_PASSWORD));
		userInfo.setMobilePhone(enterpriseInfo.getPhone());
		userInfo.setRoleType(RoleEnum.ENTERPRISE_USER);
		userInfo.setRegisterDate(enterpriseInfo.getLogTime());
		userInfoService.save(userInfo);
		return SUCCESS;
	}
	
	public String get() {
		enterpriseInfo = enterpriseInfoService.findById(id);
		provinceCities = provinceCityService.list();
		return SUCCESS;
	}
	
	public String update() {
		enterpriseInfoService.save(enterpriseInfo);
		return SUCCESS;
	}
	
	public String delete() {
		if(id != null) {
			EnterpriseInfo enterpriseInfo1 = new EnterpriseInfo();
			enterpriseInfo1.setId(id);
			enterpriseInfoService.delete(enterpriseInfo1);
		}
		return SUCCESS;
	}

	public List<EnterpriseInfo> getEnterpriseInfos() {
		return enterpriseInfos;
	}

	public void setEnterpriseInfos(List<EnterpriseInfo> enterpriseInfos) {
		this.enterpriseInfos = enterpriseInfos;
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

	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	public ProvinceCityService getProvinceCityService() {
		return provinceCityService;
	}

	public void setProvinceCityService(ProvinceCityService provinceCityService) {
		this.provinceCityService = provinceCityService;
	}

	public List<ProvinceCity> getProvinceCities() {
		return provinceCities;
	}

	public void setProvinceCities(List<ProvinceCity> provinceCities) {
		this.provinceCities = provinceCities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
