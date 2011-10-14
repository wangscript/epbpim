package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.ExpenseRecord;

public class ExpenseRecordDAOImpl extends AbstractBaseDAO<ExpenseRecord, Long> implements ExpenseRecordDAO{
	@SuppressWarnings("unchecked")
	@Override
	public List<ExpenseRecord> findByCount(ExpenseRecord expenseRecord) {
		Criteria criteria = createSelection(expenseRecord);
		criteria.setFirstResult(expenseRecord.getStartRow());
		criteria.setMaxResults(expenseRecord.getPageSize());
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRowCount(ExpenseRecord expenseRecord) {
		Criteria criteria = createSelection(expenseRecord);
		List<EnterpriseInfo> list = criteria.list();
		if(list != null) {
			return list.size();
		}
		return 0;
	}
	
	private Criteria createSelection(ExpenseRecord expenseRecord) {
		Criteria criteria = getSession().createCriteria(EnterpriseInfo.class);
		if(expenseRecord != null) {
//			if(!StringUtils.isEmpty(userInfo.getRealName())) {
//				criteria.add(Restrictions.like("realName", "%" + userInfo.getRealName() + "%"));
//			}
		}
		return criteria;
	}
}