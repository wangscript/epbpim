package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.AdminUser;

public class AdminUserDAOImpl extends AbstractBaseDAO<AdminUser, Long> implements AdminUserDAO{
	public List<AdminUser> list() {
		Criterion criterion = Restrictions.eq("enable", 1);
		return findByCriteria(criterion);
	}
}
