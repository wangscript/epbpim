package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.UserInfo;

public class UserInfoDAOImpl extends AbstractBaseDAO<UserInfo, Long> implements UserInfoDAO{
	public List<UserInfo> list(Long enterpriseId) {
		Criterion criterion = Restrictions.eq("enterpriseId", enterpriseId);
		return findByCriteria(criterion);
	}
}
