package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.AdminMenuDAO;
import com.ryxx.bpim.user.entity.AdminMenu;

public class AdminMenuServiceImpl  extends AbstractService<AdminMenu,AdminMenuDAO, Long> implements AdminMenuService{
	public List<AdminMenu> list() {
		List<AdminMenu> parentNodes = this.getDao().findAllParentNode();
		for(AdminMenu parentNode: parentNodes) {
			parentNode.setSubMenus(this.getDao().findAllSubNode(parentNode.getId()));
		}
		return parentNodes;
	}
}