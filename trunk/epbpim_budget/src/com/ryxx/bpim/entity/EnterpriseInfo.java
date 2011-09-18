package com.ryxx.bpim.entity;

import java.sql.Timestamp;

public class EnterpriseInfo extends VoBase {
	private static final long serialVersionUID = 9099318722246620482L;

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String principal;
	private Timestamp logTime;
	private ProvinceCity provinceCity;
	
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
	public Timestamp getLogTime() {
		return logTime;
	}
	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}
	public ProvinceCity getProvinceCity() {
		return provinceCity;
	}
	public void setProvinceCity(ProvinceCity provinceCity) {
		this.provinceCity = provinceCity;
	}
}

