package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.AdminRole;

public interface AdminRoleDAO extends BaseDAO<AdminRole, Long> {
	public List<AdminRole> findByRoleName(String name);
}
