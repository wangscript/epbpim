package com.ryxx.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.EnterpriseInfo;

public class EnterpriseInfoDAOImpl extends AbstractBaseDAO<EnterpriseInfo, Long> implements EnterpriseInfoDAO{
	@SuppressWarnings("unchecked")
	@Override
	public List<EnterpriseInfo> findByCount(EnterpriseInfo enterpriseInfo) {
		Criteria criteria = createSelection(enterpriseInfo);
		criteria.setFirstResult(enterpriseInfo.getStartRow());
		criteria.setMaxResults(enterpriseInfo.getPageSize());
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRowCount(EnterpriseInfo enterpriseInfo) {
		Criteria criteria = createSelection(enterpriseInfo);
		List<EnterpriseInfo> list = criteria.list();
		if(list != null) {
			return list.size();
		}
		return 0;
	}
	
	private Criteria createSelection(EnterpriseInfo enterpriseInfo) {
		Criteria criteria = getSession().createCriteria(EnterpriseInfo.class);
		if(enterpriseInfo != null) {
//			if(!StringUtils.isEmpty(userInfo.getRealName())) {
//				criteria.add(Restrictions.like("realName", "%" + userInfo.getRealName() + "%"));
//			}
		}
		return criteria;
	}
}