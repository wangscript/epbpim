package com.ryxx.bpim.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.enums.RoleEnum;

public class UserInfo extends VoBase {
	
	private static final long serialVersionUID = -3699089574630795142L;
	
	private Long id;
	private String password;
	private String userName;
	private String realName;
	private String identifier;
	private Integer sex;
	private String idCard;
	private String birthday;
	private String email;
	private String familyAdd;
	private String mobilePhone;
	private Timestamp registerDate;
	private RoleEnum roleType;
	private Integer enable;
	private String remark;
	private EnterpriseInfo enterpriseInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFamilyAdd() {
		return familyAdd;
	}
	public void setFamilyAdd(String familyAdd) {
		this.familyAdd = familyAdd;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public RoleEnum getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleEnum roleType) {
		this.roleType = roleType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}
	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
}

