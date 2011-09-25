package com.ryxx.bpim.web.action.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailException;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.BalanceRecord;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.enums.RoleEnum;
import com.ryxx.bpim.service.BalanceRecordService;
import com.ryxx.bpim.service.EnterpriseInfoService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.email.EmailTools;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;
import com.ryxx.util.string.StringTools;

public class BalanceRecordAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(BalanceRecordAction.class);

	private BalanceRecordService balanceRecordService;
	
	private List<EnterpriseInfo> enterpriseInfos;
	private EnterpriseInfo enterpriseInfo;
	private List<ProvinceCity> provinceCities;
	private Long id;
	private Long eId;
	private Float balance;
	
	private PageTools page;
	
	public String newEnterpriseInfo() {
		return SUCCESS;
	}
	
	public String list() {
		return SUCCESS;
	}
	
	public String add() throws EmailException {
		return SUCCESS;
	}
	
	public String get() {
		return SUCCESS;
	}
	
	public String update() {
		return SUCCESS;
	}
	
	public String delete() {
		return SUCCESS;
	}
	
	public String balance() {
		return SUCCESS;
	}

	public List<EnterpriseInfo> getEnterpriseInfos() {
		return enterpriseInfos;
	}

	public void setEnterpriseInfos(List<EnterpriseInfo> enterpriseInfos) {
		this.enterpriseInfos = enterpriseInfos;
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

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public BalanceRecordService getBalanceRecordService() {
		return balanceRecordService;
	}

	public void setBalanceRecordService(BalanceRecordService balanceRecordService) {
		this.balanceRecordService = balanceRecordService;
	}
}
