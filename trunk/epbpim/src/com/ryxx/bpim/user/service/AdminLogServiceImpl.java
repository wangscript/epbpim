package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.AdminMenuDAO;
import com.ryxx.bpim.user.entity.AdminMenu;

public class AdminLogServiceImpl  extends AbstractService<AdminMenu,AdminMenuDAO, Long> implements AdminMenuService{
	public List<AdminMenu> list() {
		return this.getDao().findAll();
	}

	@Override
	public List<AdminMenu> getMenuTree(List<AdminMenu> nodes) {
		// TODO Auto-generated method stub
		return null;
	}
}