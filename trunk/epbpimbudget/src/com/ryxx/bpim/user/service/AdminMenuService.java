package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.BaseService;
import com.ryxx.bpim.user.dao.AdminMenuDAO;
import com.ryxx.bpim.user.entity.AdminMenu;

public interface AdminMenuService extends BaseService<AdminMenu,AdminMenuDAO, Long> {
	public List<AdminMenu> list();
	public List<AdminMenu> getMenuTree(List<AdminMenu> nodes);
}
