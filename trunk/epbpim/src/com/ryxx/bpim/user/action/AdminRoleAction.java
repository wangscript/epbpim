package com.ryxx.bpim.user.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.user.entity.AdminMenu;
import com.ryxx.bpim.user.entity.AdminRole;
import com.ryxx.bpim.user.service.AdminMenuService;
import com.ryxx.bpim.user.service.AdminRoleService;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class AdminRoleAction extends ActionSupportBase {
	private static final long serialVersionUID = 4734813498862066564L;

	private static final Log LOG = LogFactory.getLog(AdminRoleAction.class);

	private Long id;
	private String name;
	private Integer roleCount;
	private String remark;
	private List<AdminMenu> menuList;
	
	private AdminRoleService adminRoleService;
	private AdminMenuService adminMenuService;
	
	public String save() {
		AdminRole role = new AdminRole();
		role.setName(name);
		role.setRoleCount(roleCount);
		role.setRemark(remark);
		role.setMenuList(menuList);
		adminRoleService.save(role);
		return SUCCESS;
	}
	
	public String newRole() {
		AdminRole role = new AdminRole();
		role.setMenuList(adminMenuService.list());
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

	public AdminMenuService getAdminMenuService() {
		return adminMenuService;
	}

	public void setAdminMenuService(AdminMenuService adminMenuService) {
		this.adminMenuService = adminMenuService;
	}

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public List<AdminMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<AdminMenu> menuList) {
		this.menuList = menuList;
	}

}