package com.ryxx.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.GovernmentQuota;

/**
 * author Delgado
 */
public class GovernmentQuotaDAOImpl extends AbstractBaseDAO<GovernmentQuota, Long> implements GovernmentQuotaDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<GovernmentQuota> findByCount(GovernmentQuota governmentQuota) {
		Criteria criteria = createSelection(governmentQuota);
		criteria.addOrder(Order.desc("governmentQuotaNum"));
		criteria.setFirstResult(governmentQuota.getStartRow());
		criteria.setMaxResults(governmentQuota.getPageSize());
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRowCount(GovernmentQuota governmentQuota) {
		Criteria criteria = createSelection(governmentQuota);
		List<GovernmentQuota> list = criteria.list();
		if(list != null) {
			return list.size();
		}
		return 0;
	}
	
	private Criteria createSelection(GovernmentQuota governmentQuota) {
		Criteria criteria = getSession().createCriteria(GovernmentQuota.class);
		if(governmentQuota != null) {
			if(StringUtils.isNotEmpty(governmentQuota.getArea())) {
				criteria.add(Restrictions.like("area", "%" + governmentQuota.getArea() + "%"));
			}
		}
		if(governmentQuota != null) {
			if(StringUtils.isNotEmpty(governmentQuota.getGovernmentQuotaClass())) {
				criteria.add(Restrictions.like("governmentQuotaClass", "%" + governmentQuota.getGovernmentQuotaClass() + "%"));
			}
		}
		if(governmentQuota != null) {
			if(StringUtils.isNotEmpty(governmentQuota.getGovernmentQuotaNum())) {
				criteria.add(Restrictions.like("governmentQuotaNum", "%" + governmentQuota.getGovernmentQuotaNum() + "%"));
			}
		}
		if(governmentQuota != null) {
			if(StringUtils.isNotEmpty(governmentQuota.getGovernmentQuotaName())) {
				criteria.add(Restrictions.like("governmentQuotaName", "%" + governmentQuota.getGovernmentQuotaName() + "%"));
			}
		}
		return criteria;
	}

	public void delete() throws SQLException {
		getSession().createQuery("delete GOVERNMENT_QUOTA").executeUpdate();
	}
}
