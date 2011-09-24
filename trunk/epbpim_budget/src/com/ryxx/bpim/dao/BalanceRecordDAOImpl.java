package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.ryxx.bpim.entity.BalanceRecord;
import com.ryxx.bpim.entity.EnterpriseInfo;

public class BalanceRecordDAOImpl extends AbstractBaseDAO<BalanceRecord, Long> implements BalanceRecordDAO{
	@SuppressWarnings("unchecked")
	@Override
	public List<BalanceRecord> findByCount(BalanceRecord balanceRecord) {
		Criteria criteria = createSelection(balanceRecord);
		criteria.setFirstResult(balanceRecord.getStartRow());
		criteria.setMaxResults(balanceRecord.getPageSize());
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRowCount(BalanceRecord balanceRecord) {
		Criteria criteria = createSelection(balanceRecord);
		List<EnterpriseInfo> list = criteria.list();
		if(list != null) {
			return list.size();
		}
		return 0;
	}
	
	private Criteria createSelection(BalanceRecord balanceRecord) {
		Criteria criteria = getSession().createCriteria(BalanceRecord.class);
		if(balanceRecord != null) {
//			if(!StringUtils.isEmpty(userInfo.getRealName())) {
//				criteria.add(Restrictions.like("realName", "%" + userInfo.getRealName() + "%"));
//			}
		}
		return criteria;
	}
}