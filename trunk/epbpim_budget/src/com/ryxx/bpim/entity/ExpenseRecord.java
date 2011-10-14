package com.ryxx.bpim.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;

public class ExpenseRecord extends VoBase {
	private static final long serialVersionUID = 9099318722246620482L;

	private Long id;
	private Float spend;
	private Timestamp spendDate;
	private Timestamp spendDateTmp;
	private String identifier;
	private String realName;
	private String productName;
	private EnterpriseInfo enterpriseInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getSpend() {
		return spend;
	}
	public void setSpend(Float spend) {
		this.spend = spend;
	}
	public Timestamp getSpendDate() {
		return spendDate;
	}
	public void setSpendDate(Timestamp spendDate) {
		this.spendDate = spendDate;
	}
	public Timestamp getSpendDateTmp() {
		return spendDateTmp;
	}
	public void setSpendDateTmp(Timestamp spendDateTmp) {
		this.spendDateTmp = spendDateTmp;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}
	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}

