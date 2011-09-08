package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.BaseService;
import com.ryxx.bpim.user.dao.AdminRoleDAO;
import com.ryxx.bpim.user.entity.AdminRole;

public interface AdminRoleService extends BaseService<AdminRole,AdminRoleDAO, Long> {
	public List<AdminRole> findByRoleName(String name);
	public List<AdminRole> findRolesWithMenus();
}
