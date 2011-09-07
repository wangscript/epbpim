package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.AdminMenu;

public interface AdminMenuDAO extends BaseDAO<AdminMenu, Long> {
	public List<AdminMenu> findAllParentNode();
	
	public List<AdminMenu> findAllSubNode(Integer parentId);
}
