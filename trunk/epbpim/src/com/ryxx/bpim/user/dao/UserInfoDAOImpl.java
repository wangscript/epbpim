package com.ryxx.bpim.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.UserInfo;

public class UserInfoDAOImpl extends AbstractBaseDAO<UserInfo, Long> implements UserInfoDAO{
	public int getRowCount(UserInfo userInfo) {
		List<Criterion> list = new ArrayList<Criterion>();
		Criteria criteria = getSession().createCriteria(UserInfo.class);
		if(userInfo != null) {
			if(!StringUtils.isEmpty(userInfo.getRealName())) {
				criteria.add(Restrictions.like("realName", "%" + userInfo.getRealName() + "%"));
			}
			if(!StringUtils.isEmpty(userInfo.getIdentity())) {
				criteria.add(Restrictions.like("identity", "%" + userInfo.getIdentity() + "%"));
			}
			if(userInfo.getDeptId() != null && userInfo.getDeptId()>0L) {
				criteria.createCriteria("depts").add(Restrictions.in("id", new Object[]{userInfo.getDeptId()}));
			}
			if(userInfo.getRoleId() != null && userInfo.getRoleId()>0L) {
				criteria.createCriteria("roles").add(Restrictions.in("id", new Object[]{userInfo.getRoleId()}));
			}
		}
		return criteria.list().size();
	}
	
	public List<UserInfo> findByCount(UserInfo userInfo) {
		Criteria criteria = getSession().createCriteria(UserInfo.class);
		if(userInfo != null) {
			if(!StringUtils.isEmpty(userInfo.getRealName())) {
				criteria.add(Restrictions.like("realName", "%" + userInfo.getRealName() + "%"));
			}
			if(!StringUtils.isEmpty(userInfo.getIdentity())) {
				criteria.add(Restrictions.like("identity", "%" + userInfo.getIdentity() + "%"));
			}
			if(userInfo.getDeptId() != null && userInfo.getDeptId()>0L) {
				criteria.createCriteria("depts").add(Restrictions.in("id", new Object[]{userInfo.getDeptId()}));
			}
			if(userInfo.getRoleId() != null && userInfo.getRoleId()>0L) {
				criteria.createCriteria("roles").add(Restrictions.in("id", new Object[]{userInfo.getRoleId()}));
			}
		}
		criteria.setFirstResult(userInfo.getStartRow());
		criteria.setMaxResults(userInfo.getPageSize());
		return criteria.list();
	}
}
