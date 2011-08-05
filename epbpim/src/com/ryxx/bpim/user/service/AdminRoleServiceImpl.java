package com.ryxx.bpim.user.service;

import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.AdminRoleDAO;
import com.ryxx.bpim.user.entity.AdminRole;

public class AdminRoleServiceImpl  extends AbstractService<AdminRole,AdminRoleDAO, Long> implements AdminRoleService{
	public void test() {
		this.getDao();
	}
}
