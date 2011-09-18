package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.AdminMenu;

public class AdminMenuDAOImpl extends AbstractBaseDAO<AdminMenu, Long> implements AdminMenuDAO{
	
	@Override
	public List<AdminMenu> findAllParentNode() {
		Criterion[] crits = {Restrictions.eq("enable", 1), Restrictions.eq("parentId", 0)};
		return findByCriteria(crits);
	}
	
	@Override
	public List<AdminMenu> findAllUseModuleByRegion(Integer regionId) {
		Criterion[] crits = {Restrictions.eq("enable", 1), Restrictions.eq("region.id", regionId)};
		return findByCriteria(crits);
	}
	
	@Override
	public List<AdminMenu> findAllSubNode (Integer parentId) {
		Criterion[] crits = {Restrictions.eq("enable", 1), Restrictions.eq("parentId", parentId)};
		return findByCriteria(crits);
	}
}