package com.ryxx.bpim.user.service;

import java.util.ArrayList;
import java.util.List;

import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.AdminMenuDAO;
import com.ryxx.bpim.user.entity.AdminMenu;

public class AdminMenuServiceImpl  extends AbstractService<AdminMenu,AdminMenuDAO, Long> implements AdminMenuService{
	public List<AdminMenu> list() {
		return getMenuTree(this.getDao().findAll());
	}
	
	public List<AdminMenu> getMenuTree(List<AdminMenu> nodes) {
		List<AdminMenu> parentNodes = new ArrayList<AdminMenu>();
		for(AdminMenu node: nodes) {
			if(node.getParentId()==0) {
				parentNodes.add(node);
			}
		}
		for(AdminMenu parentNode: parentNodes) {
			List<AdminMenu> subNodes = new ArrayList<AdminMenu>();
			for(AdminMenu node: nodes) {
				if(node.getParentId().equals(parentNode.getId())) {
					subNodes.add(node);
				}
			}
			parentNode.setSubMenus(subNodes);
		}
		return parentNodes;
	}
}