package com.ryxx.bpim.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;

public class BalanceRecord extends VoBase {
	private static final long serialVersionUID = 9099318722246620482L;
	
	private Long id;
	private Float balance;
	private Timestamp balanceDate;
	private String identifier;
	private EnterpriseInfo enterpriseInfo;
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
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}
	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}
	public Timestamp getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Timestamp balanceDate) {
		this.balanceDate = balanceDate;
	}
}

