package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.UserInfo;

public class UserInfoDAOImpl extends AbstractBaseDAO<UserInfo, Long> implements UserInfoDAO{
	@SuppressWarnings("unchecked")
	public List<UserInfo> list(Long enterpriseId) {
		Criteria criteria = getSession().createCriteria(UserInfo.class);
		criteria.add(Restrictions.eq("enterpriseId", enterpriseId));
		criteria.add(Restrictions.eq("roleType", "ENTERPRISE_USER"));
		criteria.add(Restrictions.eq("enable", "1"));
		return criteria.list();
	}
}
