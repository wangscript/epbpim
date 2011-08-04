package com.ryxx.bpim.user.entity;

import org.apache.tomcat.util.buf.TimeStamp;

import com.ryxx.bpim.entity.VoBase;

public class AdminLog extends VoBase {
	private static final long serialVersionUID = 9099318722246620482L;
	
	private Long id;
	private String userName;
	private Long actionType;
	private String UserIp;
	private TimeStamp logTime;
	private Long moduleId;
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getUserIp() {
		return UserIp;
	}
	public void setUserIp(String userIp) {
		UserIp = userIp;
	}
	public TimeStamp getLogTime() {
		return logTime;
	}
	public void setLogTime(TimeStamp logTime) {
		this.logTime = logTime;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}

