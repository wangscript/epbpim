package com.ryxx.bpim.user.entity;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.ryxx.bpim.entity.VoBase;
import com.ryxx.bpim.user.enums.EduBackgroundEnum;
import com.ryxx.bpim.user.enums.InsuranceTypeEnum;
import com.ryxx.bpim.user.enums.UserStatusEnum;
import com.ryxx.bpim.user.enums.UserTitleEnum;

public class UserInfo extends VoBase {
	private static final long serialVersionUID = -5736014916018823802L;
	
	private Long id;
	private String realName;
	private String identity;
	private String userName;
	private Integer sex;
	private String idCard;
	private String humenFile;
	private Timestamp birthday;
	private String birthdayTmp;
	private String familyAddress;
	private String phone;
	private String mobilePhone;
	private String party;
	private EduBackgroundEnum eduBackground;
	private String school;
	private String major;
	private Timestamp eduCountinue;
	private String eduCountiuneTemp;
	private Timestamp graduateDate;
	private String graduateDateTmp;
	private Timestamp onboardDate;
	private String onboardDateTmp;
	private Timestamp leaveDate;
	private String leaveDateTmp;
	private String relation;
	private UserStatusEnum status;
	private InsuranceTypeEnum insuranceType;
	private String remark;
	private String password;
	private Timestamp registerDate;
	private String registerDateTmp;
	private String email;
	private UserTitleEnum title;
	private List<AdminRole> roles;
	private List<AdminDept> depts;
	private List<UserCertification> certifies;
	private Long roleId;
	private Long deptId;
	private int certifieId;
	private List<WorkingExperience> workingExperiences;
	
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
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Timestamp getEduCountinue() {
		return eduCountinue;
	}
	public void setEduCountinue(Timestamp eduCountinue) {
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
	public UserTitleEnum getTitle() {
		return title;
	}
	public void setTitle(UserTitleEnum title) {
		this.title = title;
	}
	public List<AdminRole> getRoles() {
		return roles;
	}
	public void setRoles(List<AdminRole> roles) {
		this.roles = roles;
	}
	public List<AdminDept> getDepts() {
		return depts;
	}
	public void setDepts(List<AdminDept> depts) {
		this.depts = depts;
	}
	public List<UserCertification> getCertifies() {
		return certifies;
	}
	public void setCertifies(List<UserCertification> certifies) {
		this.certifies = certifies;
	}
	public EduBackgroundEnum getEduBackground() {
		return eduBackground;
	}
	public void setEduBackground(EduBackgroundEnum eduBackground) {
		this.eduBackground = eduBackground;
	}
	public UserStatusEnum getStatus() {
		return status;
	}
	public void setStatus(UserStatusEnum status) {
		this.status = status;
	}
	public InsuranceTypeEnum getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(InsuranceTypeEnum insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getBirthdayTmp() {
		return birthdayTmp;
	}
	public void setBirthdayTmp(String birthdayTmp) {
		this.birthdayTmp = birthdayTmp;
	}
	public String getGraduateDateTmp() {
		return graduateDateTmp;
	}
	public void setGraduateDateTmp(String graduateDateTmp) {
		this.graduateDateTmp = graduateDateTmp;
	}
	public String getOnboardDateTmp() {
		return onboardDateTmp;
	}
	public void setOnboardDateTmp(String onboardDateTmp) {
		this.onboardDateTmp = onboardDateTmp;
	}
	public String getLeaveDateTmp() {
		return leaveDateTmp;
	}
	public void setLeaveDateTmp(String leaveDateTmp) {
		this.leaveDateTmp = leaveDateTmp;
	}
	public String getRegisterDateTmp() {
		return registerDateTmp;
	}
	public void setRegisterDateTmp(String registerDateTmp) {
		this.registerDateTmp = registerDateTmp;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public boolean equals(Object obj) {
		if((this==obj)) {
			return true;
		}
		if(!(obj instanceof UserInfo)) {
			return false;
		}
		UserInfo userInfo = (UserInfo)obj;
		return new EqualsBuilder().append(this.getId(), userInfo.getId()).isEquals();
	}
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
	/**
	 * @return the certifieId
	 */
	public int getCertifieId() {
		return certifieId;
	}
	/**
	 * @param certifieId the certifieId to set
	 */
	public void setCertifieId(int certifieId) {
		this.certifieId = certifieId;
	}
	public List<WorkingExperience> getWorkingExperiences() {
		return workingExperiences;
	}
	public void setWorkingExperiences(List<WorkingExperience> workingExperiences) {
		this.workingExperiences = workingExperiences;
	}
	public String getEduCountiuneTemp() {
		return eduCountiuneTemp;
	}
	public void setEduCountiuneTemp(String eduCountiuneTemp) {
		this.eduCountiuneTemp = eduCountiuneTemp;
	}
	
}

