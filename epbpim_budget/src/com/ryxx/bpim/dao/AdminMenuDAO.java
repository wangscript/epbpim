package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.AdminMenu;

public interface AdminMenuDAO extends BaseDAO<AdminMenu, Long> {
	public List<AdminMenu> findAllParentNode();
	
	public List<AdminMenu> findAllSubNode(Integer parentId);
}
