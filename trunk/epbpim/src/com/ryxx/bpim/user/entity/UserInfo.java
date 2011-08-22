package com.ryxx.bpim.user.entity;

import java.sql.Timestamp;
import java.util.List;

import com.ryxx.bpim.entity.VoBase;

public class UserInfo extends VoBase {
	private static final long serialVersionUID = -5736014916018823802L;
	
	private Long id;
	private String realName;
	private String identify;
	private String username;
	private Integer sex;
	private String idCard;
	private String humenFile;
	private Timestamp birthday;
	private String familyAddress;
	private String phone;
	private String mobilePhone;
	private String party;
	private Integer eduBackground;
	private String school;
	private String major;
	private Integer eduCountinue;
	private Timestamp graduateDate;
	private Timestamp onboardDate;
	private Timestamp leaveDate;
	private String relation;
	private Integer status;
	private Integer insuranceType;
	private String remark;
	private String password;
	private Timestamp registerDate;
	private String email;
	private Integer title;
	private List<AdminRole> role;
	private List<AdminDept> dept;
	private List<UserCertification> certifies;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getHumenFile() {
		return humenFile;
	}
	public void setHumenFile(String humenFile) {
		this.humenFile = humenFile;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public String getFamilyAddress() {
		return familyAddress;
	}
	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Integer getEduBackground() {
		return eduBackground;
	}
	public void setEduBackground(Integer eduBackground) {
		this.eduBackground = eduBackground;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getEduCountinue() {
		return eduCountinue;
	}
	public void setEduCountinue(Integer eduCountinue) {
		this.eduCountinue = eduCountinue;
	}
	public Timestamp getGraduateDate() {
		return graduateDate;
	}
	public void setGraduateDate(Timestamp graduateDate) {
		this.graduateDate = graduateDate;
	}
	public Timestamp getOnboardDate() {
		return onboardDate;
	}
	public void setOnboardDate(Timestamp onboardDate) {
		this.onboardDate = onboardDate;
	}
	public Timestamp getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Timestamp leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
	}
	public List<AdminRole> getRole() {
		return role;
	}
	public void setRole(List<AdminRole> role) {
		this.role = role;
	}
	public List<AdminDept> getDept() {
		return dept;
	}
	public void setDept(List<AdminDept> dept) {
		this.dept = dept;
	}
	public List<UserCertification> getCertifies() {
		return certifies;
	}
	public void setCertifies(List<UserCertification> certifies) {
		this.certifies = certifies;
	}
}

