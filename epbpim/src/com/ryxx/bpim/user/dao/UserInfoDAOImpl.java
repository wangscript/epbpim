package com.ryxx.bpim.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.user.enums.CertificationTypeEnum;

public class UserInfoDAOImpl extends AbstractBaseDAO<UserInfo, Long> implements UserInfoDAO{
	@SuppressWarnings("unchecked")
	public int getRowCount(UserInfo userInfo) {
		Criteria criteria = createSelection(userInfo);
		List<UserInfo> list = criteria.list();
		if(list != null) {
			return list.size();
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> findByCount(UserInfo userInfo) {
		Criteria criteria = createSelection(userInfo);
		criteria.setFirstResult(userInfo.getStartRow());
		criteria.setMaxResults(userInfo.getPageSize());
		return criteria.list();
	}
	
	public UserInfo getByLogin(UserInfo userInfo) {
		Criterion[] crits = {Restrictions.eq("userName", userInfo.getUserName()), Restrictions.eq("password", userInfo.getPassword())};
		List<UserInfo> userInfos = findByCriteria(crits);
		return userInfos.size()>0?userInfos.get(0):null;
	}
	
	private Criteria createSelection(UserInfo userInfo) {
		Criteria criteria = getSession().createCriteria(UserInfo.class);
		if(userInfo != null) {
		    
		    criteria.add(Restrictions.ne("userName", "chairman"));
		    
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
			if(userInfo.getCertifieId() > 0) {
				criteria.createCriteria("certifies").add(Restrictions.in("typeId", new Object[]{CertificationTypeEnum.getType(userInfo.getCertifieId())}));
			}
			if(userInfo.getStatus() != null && userInfo.getStatus().getKey() != 0) {
				criteria.add(Restrictions.eq("status", userInfo.getStatus()));
			}
		}
		return criteria;
	}
}
