package com.ryxx.bpim.user.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.AdminDept;
import com.ryxx.bpim.user.entity.AdminRole;
import com.ryxx.bpim.user.entity.UserCertification;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.user.enums.CertificationTypeEnum;
import com.ryxx.bpim.user.enums.EduBackgroundEnum;
import com.ryxx.bpim.user.enums.InsuranceTypeEnum;
import com.ryxx.bpim.user.enums.UserStatusEnum;
import com.ryxx.bpim.user.enums.UserTitleEnum;
import com.ryxx.bpim.user.service.AdminDeptService;
import com.ryxx.bpim.user.service.AdminLogService;
import com.ryxx.bpim.user.service.AdminRoleService;
import com.ryxx.bpim.user.service.UserCertificationService;
import com.ryxx.bpim.user.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.date.DateTools;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;
import com.ryxx.util.string.StringTools;

public class UserInfoAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory.getLog(UserInfoAction.class);

	private UserInfoService userInfoService;
	private AdminRoleService adminRoleService;
	private AdminDeptService adminDeptService;
	private UserCertificationService userCertificationService;
	private AdminLogService adminLogService;
	
	private Long id;
	private Integer eduBackGround;
	private Integer title;
	private Integer status;
	private Integer type;
	private List<Integer> certifiTypes;
	private Timestamp stamp;
	
	private List<UserInfo> userInfos;
	private UserInfo userInfo;
	private List<UserCertification> certifies;
	
	private List<AdminRole> allRoles;
	private List<AdminDept> allDepts;
	
	private List<Long> deptGroup;
	private List<Long> roleGroup;
	
	private String realName;
	private String identify;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private PageTools page;
	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}
	
	public String save() {
		return SUCCESS;
	}
	
	public String newUserInfo() {
		List<AdminRole> roles = adminRoleService.findAll();
		userInfo = new UserInfo();
		setAllRoles(roles);
		List<AdminDept> depts = adminDeptService.findAll();
		setAllDepts(depts);
		userInfo.setBirthday(new Timestamp(StringTools.string2date(userInfo.getBirthdayTmp()+" 00:00:00").getTime()));
		userInfo.setGraduateDate(new Timestamp(StringTools.string2date(userInfo.getGraduateDateTmp()+" 00:00:00").getTime()));
		userInfo.setLeaveDate(new Timestamp(StringTools.string2date(userInfo.getLeaveDateTmp()+" 00:00:00").getTime()));
		userInfo.setOnboardDate(new Timestamp(StringTools.string2date(userInfo.getOnboardDateTmp()+" 00:00:00").getTime()));
		userInfo.setRegisterDate(new Timestamp(System.currentTimeMillis()));
		return SUCCESS;
	}
	
	public String showUser() {
		List<AdminRole> roles = adminRoleService.findAll();
		setAllRoles(roles);
		List<AdminDept> depts = adminDeptService.findAll();
		setAllDepts(depts);
		setUserInfo(userInfoService.fetchById(id));
		setEduBackGround(userInfo.getEduBackground().getKey());
		setTitle(userInfo.getTitle().getKey());
		setStatus(userInfo.getStatus().getKey());
		setType(userInfo.getInsuranceType().getKey());
		List<Long> deptGp = new ArrayList<Long>();
		for(AdminDept dept: userInfo.getDepts()) {
			deptGp.add(dept.getId());
		}
		setDeptGroup(deptGp);
		List<Long> roleGp = new ArrayList<Long>();
		for(AdminRole role: userInfo.getRoles()) {
			roleGp.add(role.getId());
		}
		for(UserCertification certification: userInfo.getCertifies()) {
			certification.setSelectId(certification.getTypeId().getKey());
			certification.setExpireDateFromPage(DateUtil.formatDate(certification.getExpireDate(), "yyyy-MM-dd"));
		}
		setCertifies(userInfo.getCertifies());
		userInfo.setBirthdayTmp(DateTools.date2string(userInfo.getBirthday(), "yyyy-MM-dd"));
		userInfo.setGraduateDateTmp(DateTools.date2string(userInfo.getGraduateDate(), "yyyy-MM-dd"));
		userInfo.setLeaveDateTmp(DateTools.date2string(userInfo.getLeaveDate(), "yyyy-MM-dd"));
		userInfo.setOnboardDateTmp(DateTools.date2string(userInfo.getOnboardDate(), "yyyy-MM-dd"));
		userInfo.setRegisterDate(new Timestamp(System.currentTimeMillis()));
		setRoleGroup(roleGp);
		return SUCCESS;
	}
	
	public String saveUsers() {
		if(certifies != null) {
			List<UserCertification> certifs = new ArrayList<UserCertification>();
			for(UserCertification certification: certifies) {
				if(certification.getSelectId()>0) {
					certification.setTypeId(CertificationTypeEnum.getType(certification.getSelectId()));
					certification.setExpireDate(new Timestamp(StringTools.string2date(certification.getExpireDateFromPage()+" 00:00:00").getTime()));
					certifs.add(certification);
				}
			}
			userInfo.setCertifies(certifs);
		}
		userInfo.setEduBackground(EduBackgroundEnum.getType(eduBackGround));
		userInfo.setTitle(UserTitleEnum.getType(title));
		userInfo.setStatus(UserStatusEnum.getType(status));
		userInfo.setInsuranceType(InsuranceTypeEnum.getType(type));
		if(deptGroup != null) {
			List<AdminDept> depts = new ArrayList<AdminDept>();
			for(Long id: deptGroup) {
				AdminDept dept = new AdminDept();
				dept.setId(id);
				depts.add(dept);
			}
			userInfo.setDepts(depts);
		}
		if(roleGroup != null) {
			List<AdminRole> roles = new ArrayList<AdminRole>();
			for(Long id: roleGroup) {
				AdminRole role = new AdminRole();
				role.setId(id);
				roles.add(role);
			}
			userInfo.setRoles(roles);
		}
		userInfo.setBirthday(new Timestamp(StringTools.string2date(userInfo.getBirthdayTmp()+" 00:00:00").getTime()));
		userInfo.setGraduateDate(new Timestamp(StringTools.string2date(userInfo.getGraduateDateTmp()+" 00:00:00").getTime()));
		userInfo.setLeaveDate(new Timestamp(StringTools.string2date(userInfo.getLeaveDateTmp()+" 00:00:00").getTime()));
		userInfo.setOnboardDate(new Timestamp(StringTools.string2date(userInfo.getOnboardDateTmp()+" 00:00:00").getTime()));
		userInfo.setRegisterDate(new Timestamp(System.currentTimeMillis()));
		userInfo.setPassword(StringTools.md5("123456"));
		userInfoService.save(userInfo);
		return SUCCESS;
	}
	
	public String updateUser() {
		if(certifies != null) {
			List<UserCertification> certifs = new ArrayList<UserCertification>();
			for(UserCertification certification: certifies) {
				if(certification.getSelectId()>0) {
					certification.setTypeId(CertificationTypeEnum.getType(certification.getSelectId()));
					certification.setExpireDate(new Timestamp(StringTools.string2date(certification.getExpireDateFromPage()+" 00:00:00").getTime()));
					certifs.add(certification);
				}
			}
			userInfo.setCertifies(certifs);
		}
		userInfo.setEduBackground(EduBackgroundEnum.getType(eduBackGround));
		userInfo.setTitle(UserTitleEnum.getType(title));
		userInfo.setStatus(UserStatusEnum.getType(status));
		userInfo.setInsuranceType(InsuranceTypeEnum.getType(type));
		if(deptGroup != null) {
			List<AdminDept> depts = new ArrayList<AdminDept>();
			for(Long id: deptGroup) {
				AdminDept dept = new AdminDept();
				dept.setId(id);
				depts.add(dept);
			}
			userInfo.setDepts(depts);
		}
		if(roleGroup != null) {
			List<AdminRole> roles = new ArrayList<AdminRole>();
			for(Long id: roleGroup) {
				AdminRole role = new AdminRole();
				role.setId(id);
				roles.add(role);
			}
			userInfo.setRoles(roles);
		}
		userInfo.setBirthday(new Timestamp(StringTools.string2date(userInfo.getBirthdayTmp()+" 00:00:00").getTime()));
		userInfo.setGraduateDate(new Timestamp(StringTools.string2date(userInfo.getGraduateDateTmp()+" 00:00:00").getTime()));
		userInfo.setLeaveDate(new Timestamp(StringTools.string2date(userInfo.getLeaveDateTmp()+" 00:00:00").getTime()));
		userInfo.setOnboardDate(new Timestamp(StringTools.string2date(userInfo.getOnboardDateTmp()+" 00:00:00").getTime()));
		userInfo.setRegisterDate(new Timestamp(System.currentTimeMillis()));
		userInfo.setId(id);
		UserInfo newUserInfo = userInfoService.fetchById(id);
		userInfo.setPassword(newUserInfo.getPassword());
		userInfoService.save(userInfo);
		return SUCCESS;
	}

	public String listUserInfo() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			UserInfo userInfo1 = new UserInfo();
			if(userInfo == null) {
				userInfo = new UserInfo();
			}
			List<AdminRole> roles = adminRoleService.findAll();
			userInfo.setRoles(roles);
			List<AdminDept> depts = adminDeptService.findAll();
			userInfo.setDepts(depts);
			if(userInfo.getDeptId() != null && userInfo.getDeptId()>0L) {
				userInfo1.setDeptId(userInfo.getDeptId());
			}
			if(userInfo.getRoleId() != null && userInfo.getRoleId()>0L) {
				userInfo1.setRoleId(userInfo.getRoleId());
			}
			userInfo1.setRealName(userInfo.getRealName());
			userInfo1.setIdentity(userInfo.getIdentity());
			userInfo.setStatus(UserStatusEnum.getType(status==null?0:status));
//			if(certifies != null) {
//				certifies.get(0).setTypeId(CertificationTypeEnum.getType(certifies.get(0).getSelectId()));
//			}
//			userInfo1.setCertifies(certifies);
			userInfo1.setRowCount(pageNo);
			userInfo1.setPageSize(pageSize);
			userInfos = userInfoService.listPage(userInfo1, page);
			if (userInfos != null && userInfos.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
		} catch (Exception ex) {
			LOG.error("UserInfoAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String delete() {
		userInfoService.delete(id);
		return SUCCESS;
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public AdminDeptService getAdminDeptService() {
		return adminDeptService;
	}

	public void setAdminDeptService(AdminDeptService adminDeptService) {
		this.adminDeptService = adminDeptService;
	}

	public AdminLogService getAdminLogService() {
		return adminLogService;
	}

	public void setAdminLogService(AdminLogService adminLogService) {
		this.adminLogService = adminLogService;
	}

	
	public Integer getEduBackGround() {
		return eduBackGround;
	}

	public void setEduBackGround(Integer eduBackGround) {
		this.eduBackGround = eduBackGround;
	}

	public Integer getTitle() {
		return title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Integer> getCertifiTypes() {
		return certifiTypes;
	}

	public void setCertifiTypes(List<Integer> certifiTypes) {
		this.certifiTypes = certifiTypes;
	}

	public List<UserCertification> getCertifies() {
		return certifies;
	}

	public void setCertifies(List<UserCertification> certifies) {
		this.certifies = certifies;
	}

	public UserCertificationService getUserCertificationService() {
		return userCertificationService;
	}

	public void setUserCertificationService(
			UserCertificationService userCertificationService) {
		this.userCertificationService = userCertificationService;
	}

	public Timestamp getStamp() {
		return stamp;
	}

	public void setStamp(Timestamp stamp) {
		this.stamp = stamp;
	}

	public List<Long> getDeptGroup() {
		return deptGroup;
	}

	public void setDeptGroup(List<Long> deptGroup) {
		this.deptGroup = deptGroup;
	}

	public List<Long> getRoleGroup() {
		return roleGroup;
	}

	public void setRoleGroup(List<Long> roleGroup) {
		this.roleGroup = roleGroup;
	}

	public List<AdminRole> getAllRoles() {
		return allRoles;
	}

	public void setAllRoles(List<AdminRole> allRoles) {
		this.allRoles = allRoles;
	}

	public List<AdminDept> getAllDepts() {
		return allDepts;
	}

	public void setAllDepts(List<AdminDept> allDepts) {
		this.allDepts = allDepts;
	}

	public static void main(String[] args) {
		Date date = StringTools.string2date("2011-08-29 00:00:00");
		System.out.println(date.toString());
		Timestamp stamp = new Timestamp(date.getTime());
		System.out.println(stamp.toString());
	}
}