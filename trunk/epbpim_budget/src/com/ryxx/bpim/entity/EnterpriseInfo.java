package com.ryxx.bpim.entity;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class EnterpriseInfo extends VoBase {
	private static final long serialVersionUID = 9099318722246620482L;

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String principal;
	private Timestamp insertTime;
	private Timestamp updateTime;
	private Float balance;
	private ProvinceCity provinceCity;
	private Timestamp logTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public ProvinceCity getProvinceCity() {
		return provinceCity;
	}
	public void setProvinceCity(ProvinceCity provinceCity) {
		this.provinceCity = provinceCity;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	
	public Timestamp getLogTime() {
		return logTime;
	}
	/**
	 * @param logTime the logTime to set
	 */
	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}
	public boolean equals(Object obj) {
		if((this==obj)) {
			return true;
		}
		if(!(obj instanceof UserInfo)) {
			return false;
		}
		EnterpriseInfo enterpriseInfo = (EnterpriseInfo)obj;
		return new EqualsBuilder().append(this.getId(), enterpriseInfo.getId()).isEquals();
	}
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}

