package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.ProvinceCity;

public interface AdminMenuDAO extends BaseDAO<AdminMenu, Long> {
	public List<AdminMenu> findAllParentNode(List<ProvinceCity> cities);
	public List<AdminMenu> findAllUseModuleByRegion(Long regionId);
	public List<AdminMenu> findAllDefaultParentNode(ProvinceCity city);
	public List<AdminMenu> findAllDefaultSubNode (Long parentId, ProvinceCity city);
	public List<AdminMenu> findAllSubNode(Long parentId, List<ProvinceCity> cities, Long userId);
}
