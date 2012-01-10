package com.ryxx.bpim.entity;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class UserMenuReg extends VoBase {
	
	private static final long serialVersionUID = -3699089574630795142L;
	
	private Long id;
	private Timestamp registerDate;
	private Timestamp expireDate;
	private AdminMenu adminMenu;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public Timestamp getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}
	public AdminMenu getAdminMenu() {
		return adminMenu;
	}
	public void setAdminMenu(AdminMenu adminMenu) {
		this.adminMenu = adminMenu;
	}
	public boolean equals(Object obj) {
		if((this==obj)) {
			return true;
		}
		if(!(obj instanceof UserMenuReg)) {
			return false;
		}
		UserMenuReg userInfo = (UserMenuReg)obj;
		return new EqualsBuilder().append(this.getId(), userInfo.getId()).isEquals();
	}
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}

