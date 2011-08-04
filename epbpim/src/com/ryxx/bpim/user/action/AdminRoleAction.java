package com.ryxx.bpim.user.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.user.entity.AdminRole;
import com.ryxx.bpim.user.service.AdminRoleService;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class AdminRoleAction extends ActionSupportBase {
	private static final long serialVersionUID = 4734813498862066564L;

	private static final Log LOG = LogFactory.getLog(AdminRoleAction.class);

	private Long id;
	private String name;
	private Integer roleCount;
	private String remark;
	
	private AdminRoleService adminRoleService;
	private List<AdminRole> adminRoles;
	
	public String save() {
		AdminRole role = new AdminRole();
		role.setName(name);
		role.setRoleCount(roleCount);
		role.setRemark(remark);
		adminRoleService.save(role);
		return SUCCESS;
	}
	
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

	public Integer getRoleCount() {
		return roleCount;
	}

	public void setRoleCount(Integer roleCount) {
		this.roleCount = roleCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public List<AdminRole> getAdminRoles() {
		return adminRoles;
	}

	public void setAdminRoles(List<AdminRole> adminRoles) {
		this.adminRoles = adminRoles;
	}
}