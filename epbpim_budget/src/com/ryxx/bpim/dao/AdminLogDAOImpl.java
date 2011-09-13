package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.AdminLog;

public class AdminLogDAOImpl extends AbstractBaseDAO<AdminLog, Long> implements AdminLogDAO{
	public List<AdminLog> list() {
		Criterion criterion = Restrictions.eq("enable", 1);
		return findByCriteria(criterion);
	}
}
