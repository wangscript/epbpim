package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.ProvinceCity;

public class ProvinceCityDAOImpl extends AbstractBaseDAO<ProvinceCity, Integer> implements ProvinceCityDAO{
	public List<ProvinceCity> list() {
		Criterion criterion = Restrictions.eq("enable", 1);
		return findByCriteria(criterion);
	}
}