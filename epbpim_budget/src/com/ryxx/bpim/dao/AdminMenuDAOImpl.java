package com.ryxx.bpim.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.entity.UserInfo;

public class AdminMenuDAOImpl extends AbstractBaseDAO<AdminMenu, Long> implements AdminMenuDAO{
	
	@Override
	public List<AdminMenu> findAllParentNode(List<ProvinceCity> cities) {
		Long[] cityList = new Long[cities.size()];
		if(cities != null && cities.size()>0) {
			for(int i=0;i<cities.size();i++) {
				cityList[i] = cities.get(i).getId();
			}
		}
		Criterion[] crits = {Restrictions.eq("enable", 1), Restrictions.eq("parentId", Long.valueOf(0)), Restrictions.in("region.id", cityList)};
		return findByCriteria(crits);
	}
	
	@Override
	public List<AdminMenu> findAllDefaultParentNode(ProvinceCity city) {
		Long[] cityList = {};
		Criterion[] crits = {Restrictions.eq("enable", 1), Restrictions.eq("parentId", Long.valueOf(0)), Restrictions.in("region.id", new Object[]{city.getId()}), Restrictions.eq("mDefault", 1)};
		return findByCriteria(crits);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdminMenu> findAllSubNode (Long parentId, List<ProvinceCity> cities, Long userId) {
		Criteria criteria = createSelection(parentId, cities, userId);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdminMenu> findAllDefaultSubNode (Long parentId, ProvinceCity city) {
		Criteria criteria = getSession().createCriteria(AdminMenu.class);
		criteria.add(Restrictions.eq("enable", 1));
		criteria.add(Restrictions.eq("parentId", parentId));
		Integer[] cityList = {};
		criteria.add(Restrictions.eq("mDefault", 1));
		criteria.add(Restrictions.in("region.id", new Object[]{city.getId()}));
		return criteria.list();
	}
	
	@Override
	public List<AdminMenu> findAllUseModuleByRegion(Long regionId) {
		Criterion[] crits = {Restrictions.eq("enable", 1), Restrictions.gt("region.id", Long.valueOf(0))};
		return findByCriteria(crits);
	}
	
	private Criteria createSelection(Long parentId, List<ProvinceCity> cities, Long userId) {
		Criteria criteria = getSession().createCriteria(AdminMenu.class);
		criteria.add(Restrictions.eq("enable", 1));
		criteria.add(Restrictions.eq("parentId", parentId));
		Long[] cityList = new Long[cities.size()];
		if(cities != null && cities.size()>0) {
			for(int i=0;i<cities.size();i++) {
				cityList[i] = cities.get(i).getId();
			}
		}
		criteria.add(Restrictions.in("region.id", cityList));
		criteria.createCriteria("users").add(Restrictions.in("id", new Object[]{userId}));
		return criteria;
	}
}