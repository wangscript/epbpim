package com.ryxx.bpim.user.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.buf.TimeStamp;

import com.ryxx.bpim.user.service.AdminLogService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;

public class AdminLogAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(AdminLogAction.class);
	
	private AdminLogService adminLogService;

	private String userName;

	private Long id;
	private String actionName;
	private TimeStamp logTime;
	private Integer moduleId;
	private String logRemark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public AdminLogService getAdminLogService() {
		return adminLogService;
	}

	public void setAdminLogService(AdminLogService adminLogService) {
		this.adminLogService = adminLogService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public TimeStamp getLogTime() {
		return logTime;
	}

	public void setLogTime(TimeStamp logTime) {
		this.logTime = logTime;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getLogRemark() {
		return logRemark;
	}

	public void setLogRemark(String logRemark) {
		this.logRemark = logRemark;
	}

	private PageTools page;
	
	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}
	
	public String listAdminLogs() {
		return SUCCESS;
	}
	
	public String adminLogin() {
		
		return SUCCESS;
	}
}
