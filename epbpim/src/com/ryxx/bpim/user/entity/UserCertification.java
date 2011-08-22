package com.ryxx.bpim.user.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;

public class UserCertification extends VoBase {
	private static final long serialVersionUID = 5440631038707450449L;
	
	private Integer id;
	private Integer typeId;
	private String identity;
	private Timestamp expireDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Timestamp getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}
}

