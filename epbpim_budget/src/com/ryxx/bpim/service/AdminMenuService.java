package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.AdminMenuDAO;
import com.ryxx.bpim.entity.AdminMenu;

public interface AdminMenuService extends BaseService<AdminMenu,AdminMenuDAO, Long> {
	public List<AdminMenu> list();
	public List<AdminMenu> getMenuTree(List<AdminMenu> nodes);
}
