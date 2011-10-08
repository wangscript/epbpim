package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.AdminMenuDAO;
import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.ProvinceCity;

public interface AdminMenuService extends BaseService<AdminMenu,AdminMenuDAO, Long> {
	public List<AdminMenu> list();
	public List<AdminMenu> list(List<ProvinceCity> cities, Long userId);
	public List<AdminMenu> findAllUseModuleByRegion(Integer regionId);
	public List<AdminMenu> list(ProvinceCity city);
	public List<AdminMenu> getMenuTree(List<AdminMenu> nodes);
	/**
	 * @param listCheck
	 * @return
	 */
	public List<AdminMenu> getMenuListById(List listCheck);
}
