package com.ryxx.bpim.user.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;
import com.ryxx.bpim.user.enums.CertificationTypeEnum;

public class UserCertification extends VoBase {
	private static final long serialVersionUID = 5440631038707450449L;
	
	private Integer id;
	private CertificationTypeEnum typeId;
	private Integer selectId;
	private String identity;
	private Timestamp expireDate;
	private String expireDateFromPage;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public CertificationTypeEnum getTypeId() {
		return typeId;
	}
	public void setTypeId(CertificationTypeEnum typeId) {
		this.typeId = typeId;
	}
	public Integer getSelectId() {
		return selectId;
	}
	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}
	public String getExpireDateFromPage() {
		return expireDateFromPage;
	}
	public void setExpireDateFromPage(String expireDateFromPage) {
		this.expireDateFromPage = expireDateFromPage;
	}
}

