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

public class EnterpriseInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(EnterpriseInfoAction.class);

	private EnterpriseInfoService enterpriseInfoService;
	private ProvinceCityService provinceCityService;
	private UserInfoService userInfoService;
	private BalanceRecordService balanceRecordService;
	
	private List<EnterpriseInfo> enterpriseInfos;
	private EnterpriseInfo enterpriseInfo;
	private List<ProvinceCity> provinceCities;
	private Long id;
	private Long eId;
	private Float balance;
	private List<BalanceRecord> balanceRecords;
	
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
	
	public String listRecharge() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			BalanceRecord balance = new BalanceRecord();
			EnterpriseInfo enterpriseInfo1 = new EnterpriseInfo();
			enterpriseInfo1.setId(eId);
			balance.setEnterpriseInfo(enterpriseInfo1);
			balance.setRowCount(pageNo);
			balance.setPageSize(pageSize);
			balanceRecords = balanceRecordService.listPage(balance, page);
			if (balanceRecords != null && balanceRecords.size() > 0) {
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
	
	public String add() throws EmailException {
		enterpriseInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		enterpriseInfo.setInsertTime(new Timestamp(System.currentTimeMillis()));
		enterpriseInfo.setBalance((float) 0);
		enterpriseInfoService.save(enterpriseInfo);
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(enterpriseInfo.getEmail());
		userInfo.setEnterpriseInfo(enterpriseInfo);
		String maxIdentify = userInfoService.getMaxIdentify();
		if(maxIdentify == null || maxIdentify.length() == 0) {
			userInfo.setIdentifier("ry10000001");
		} else {
			userInfo.setIdentifier("ry"+(Long.parseLong(maxIdentify.substring(2))+1));
		}
		userInfo.setPassword(StringTools.md5(Constants.DEFAULT_PASSWORD));
		userInfo.setMobilePhone(enterpriseInfo.getPhone());
		userInfo.setRoleType(RoleEnum.ENTERPRISE_USER);
		userInfo.setRegisterDate(enterpriseInfo.getUpdateTime());
		userInfo.setEnable(new Integer(1));
		userInfoService.save(userInfo);
		String emailContent = EmailTools.generateEnterPriseUserContent(userInfo);
		List<String> addresses = new ArrayList<String>();
		addresses.add(enterpriseInfo.getEmail());
		addresses.add(Constants.MAIL_USER_NAME);
		try {
			EmailTools.send(addresses, Constants.EMAIL_SUBJECT, emailContent);
		} catch (EmailException e) {
			LOG.error(e.getMessage());
			throw e;
		}
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
	
	public String balance() {
		enterpriseInfo = enterpriseInfoService.findById(eId);
		enterpriseInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		enterpriseInfo.setBalance(balance+enterpriseInfo.getBalance());
		enterpriseInfoService.save(enterpriseInfo);
		BalanceRecord balanceRecord = new BalanceRecord();
		balanceRecord.setBalance(balance);
		balanceRecord.setBalanceDate(new Timestamp(System.currentTimeMillis()));
		balanceRecord.setEnterpriseInfo(enterpriseInfo);
		// TODO
		balanceRecord.setIdentifier("ry10000001");
		balanceRecordService.save(balanceRecord);
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

	public List<BalanceRecord> getBalanceRecords() {
		return balanceRecords;
	}

	public void setBalanceRecords(List<BalanceRecord> balanceRecords) {
		this.balanceRecords = balanceRecords;
	}
}
