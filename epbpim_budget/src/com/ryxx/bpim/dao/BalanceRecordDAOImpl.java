package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.BalanceRecord;
import com.ryxx.bpim.entity.UserInfo;

public class BalanceRecordDAOImpl extends AbstractBaseDAO<BalanceRecord, Long> implements BalanceRecordDAO{
	@SuppressWarnings("unchecked")
	@Override
	public List<BalanceRecord> findByCount(BalanceRecord balanceRecord) {
		Criteria criteria = getSession().createCriteria(BalanceRecord.class);
		criteria.add(Restrictions.eq("enterpriseInfo.id", balanceRecord.getEnterpriseInfo().getId()));
		criteria.setFirstResult(balanceRecord.getStartRow());
		criteria.setMaxResults(balanceRecord.getPageSize());
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRowCount(BalanceRecord balanceRecord) {
		Criteria criteria = getSession().createCriteria(BalanceRecord.class);
		criteria.add(Restrictions.eq("enterpriseInfo.id", balanceRecord.getEnterpriseInfo().getId()));
		List<BalanceRecord> records = criteria.list();
		if(records != null && records.size()>0) {
			return records.size();
		}
		return 0;
	}
//	
//	private Criteria createSelection(BalanceRecord balanceRecord) {
//		Criteria criteria = getSession().createCriteria(BalanceRecord.class);
//		if(balanceRecord != null && balanceRecord.getEnterpriseInfo() != null) {
//			criteria.add(Restrictions.like("realName", "%" + userInfo.getRealName() + "%"));
//		}
//		return criteria;
//	}
}