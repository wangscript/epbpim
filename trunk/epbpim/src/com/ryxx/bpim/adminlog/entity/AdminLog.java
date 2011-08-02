package com.ryxx.bpim.adminlog.entity;

import org.apache.tomcat.util.buf.TimeStamp;

import com.ryxx.bpim.entity.VoBase;

public class AdminLog extends VoBase {
	private static final long serialVersionUID = -7195395829054471936L;
	
	private Long id;
	private String userName;
	private Long actionType;
	private String userIp;
	private TimeStamp logTime;
	private Integer moduleId;
	private String logRemark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getActionType() {
		return actionType;
	}
	public void setActionType(Long actionType) {
		this.actionType = actionType;
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
}

