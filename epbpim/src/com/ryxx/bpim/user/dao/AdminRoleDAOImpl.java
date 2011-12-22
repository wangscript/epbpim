package com.ryxx.bpim.user.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.AdminMenu;
import com.ryxx.bpim.user.entity.AdminRole;

public class AdminRoleDAOImpl extends AbstractBaseDAO<AdminRole, Long> implements AdminRoleDAO{
	public List<AdminRole> findByRoleName(String name) {
		Criterion[] crits = {Restrictions.eq("name", name)};
		return findByCriteria(crits);
	}
}
