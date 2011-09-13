package com.ryxx.bpim.user.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.UserInfo;

public class UserInfoDAOImpl extends AbstractBaseDAO<UserInfo, Long> implements UserInfoDAO{
	public List<UserInfo> list() {
		Criterion criterion = Restrictions.eq("enable", 1);
		return findByCriteria(criterion);
	}
}
