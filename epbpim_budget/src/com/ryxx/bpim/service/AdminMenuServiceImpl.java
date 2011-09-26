package com.ryxx.bpim.service;

import java.util.ArrayList;
import java.util.List;

import com.ryxx.bpim.dao.AdminMenuDAO;
import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.ProvinceCity;

public class AdminMenuServiceImpl  extends AbstractService<AdminMenu,AdminMenuDAO, Long> implements AdminMenuService{
	public List<AdminMenu> list() {
		return getMenuTree(this.getDao().findAll());
	}
	
	public List<AdminMenu> findAllUseModuleByRegion(Integer regionId) {
		return getDao().findAllUseModuleByRegion(regionId);
	}
	
	public List<AdminMenu> list(List<ProvinceCity> cities, Long userId) {
		List<AdminMenu> parentNodes = this.getDao().findAllParentNode(cities);
		for(AdminMenu parentNode: parentNodes) {
			List<AdminMenu> subNodes = this.getDao().findAllSubNode(parentNode.getId(), cities, userId);
			parentNode.setSubMenus(subNodes);
		}
		return parentNodes;
	}
	
	public List<AdminMenu> list(ProvinceCity city) {
		List<AdminMenu> parentNodes = this.getDao().findAllDefaultParentNode(city);
		for(AdminMenu parentNode: parentNodes) {
			List<AdminMenu> subNodes = this.getDao().findAllDefaultSubNode(parentNode.getId(), city);
			parentNode.setSubMenus(subNodes);
		}
		return parentNodes;
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