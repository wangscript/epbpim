package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.enums.RoleEnum;

public class UserInfoDAOImpl extends AbstractBaseDAO<UserInfo, Long> implements UserInfoDAO{
	@SuppressWarnings("unchecked")
	public List<UserInfo> list(Long enterpriseId) {
		Criteria criteria = getSession().createCriteria(UserInfo.class);
		criteria.add(Restrictions.eq("enterpriseInfo.id", enterpriseId));
		criteria.add(Restrictions.eq("roleType", RoleEnum.getType("ENTERPRISE_USER")));
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see com.ryxx.bpim.dao.UserInfoDAO#getByLogin(com.ryxx.bpim.entity.UserInfo)
	 */
	@Override
	public UserInfo getByLogin(UserInfo userInfo) {
		Criteria criteria = getSession().createCriteria(UserInfo.class);
		criteria.add(Restrictions.eq("identifier", userInfo.getIdentifier()));
		criteria.add(Restrictions.eq("password", userInfo.getPassword()));
		criteria.add(Restrictions.eq("enable", new Integer(1)));
		if(criteria.list()!=null&&criteria.list().size()>0){
			return (UserInfo) criteria.list().get(0);
		}
		return null;
	}
}
