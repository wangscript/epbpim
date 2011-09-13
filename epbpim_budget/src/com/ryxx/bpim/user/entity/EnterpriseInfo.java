package com.ryxx.bpim.user.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;

public class EnterpriseInfo extends VoBase {
	private static final long serialVersionUID = 9099318722246620482L;
	
	private Long id;
	private String enterpriseName;
	private String enterpriseAddress;
	private Timestamp logTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getEnterpriseAddress() {
		return enterpriseAddress;
	}
	public void setEnterpriseAddress(String enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}
	public Timestamp getLogTime() {
		return logTime;
	}
	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}
}

