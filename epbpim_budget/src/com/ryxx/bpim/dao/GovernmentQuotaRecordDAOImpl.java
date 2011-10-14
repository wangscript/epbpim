package com.ryxx.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.GovernmentQuota;
import com.ryxx.bpim.entity.GovernmentQuotaRecord;

/**
 * author Delgado
 */
public class GovernmentQuotaRecordDAOImpl extends AbstractBaseDAO<GovernmentQuotaRecord, Long> implements GovernmentQuotaRecordDAO{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GovernmentQuota> findByCount(GovernmentQuotaRecord governmentQuotaRecord) {
		Criteria criteria = createSelection(governmentQuotaRecord);
		criteria.addOrder(Order.desc("governmentQuotaNum"));
		criteria.setFirstResult(governmentQuotaRecord.getStartRow());
		criteria.setMaxResults(governmentQuotaRecord.getPageSize());
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getRowCount(GovernmentQuotaRecord governmentQuotaRecord) {
		Criteria criteria = createSelection(governmentQuotaRecord);
		List<GovernmentQuota> list = criteria.list();
		if(list != null) {
			return list.size();
		}
		return 0;
	}
	
	public void insert(List<GovernmentQuotaRecord> records)
		throws SQLException {
		for (GovernmentQuotaRecord record : records) {
			save(record);
		}
	}
	
	private Criteria createSelection(GovernmentQuotaRecord governmentQuotaRecord) {
		Criteria criteria = getSession().createCriteria(GovernmentQuota.class);
//		if(governmentQuotaRecord != null) {
//			if(StringUtils.isNotEmpty(governmentQuotaRecord.getArea())) {
//				criteria.add(Restrictions.like("area", "%" + governmentQuotaRecord.getArea() + "%"));
//			}
//		}
		return criteria;
	}
	
	public void delete() throws SQLException {
		getSession().createQuery("delete GOVERNMENT_QUOTA_RECORD").executeUpdate();
	}
	
	private Criteria createQuotaSelection(GovernmentQuotaRecord governmentQuotaRecord) {
		Criteria criteria = getSession().createCriteria(GovernmentQuotaRecord.class);
		criteria.add(Restrictions.like("area", "%" + governmentQuotaRecord.getGovernmentQuota().getArea() + "%"));
		criteria.add(Restrictions.like("recordUnit", "%" + governmentQuotaRecord.getRecordUnit() + "%"));
		criteria.add(Restrictions.like("recordName", "%" + governmentQuotaRecord.getRecordName() + "%"));
		criteria.add(Restrictions.like("quotaClass", "%" + governmentQuotaRecord.getGovernmentQuota().getGovernmentQuotaClass() + "%"));
		if(governmentQuotaRecord != null) {
			if(StringUtils.isNotEmpty(governmentQuotaRecord.getGovernmentQuota().getGovernmentQuotaNum())) {
				criteria.add(Restrictions.like("governmentQuotaNum", "%" + governmentQuotaRecord.getGovernmentQuota().getGovernmentQuotaNum() + "%"));
			}
		}
		if(governmentQuotaRecord != null) {
			if(StringUtils.isNotEmpty(governmentQuotaRecord.getGovernmentQuota().getGovernmentQuotaName())) {
				criteria.add(Restrictions.like("governmentQuotaName", "%" + governmentQuotaRecord.getGovernmentQuota().getGovernmentQuotaName() + "%"));
			}
		}
		return criteria;
	}
	
	public List<GovernmentQuotaRecord> listByQuota(GovernmentQuotaRecord governmentQuotaRecord) throws SQLException {
		Criteria criteria = getSession().createCriteria(GovernmentQuotaRecord.class);
		criteria.add(Restrictions.eq("governmentQuota.id",  governmentQuotaRecord.getGovernmentQuota().getId()));
		return criteria.list();
	}

	public Double getRecordGrossOfGovernmentQuota(GovernmentQuotaRecord governmentQuotaRecord) throws SQLException {
		Criteria criteria = createQuotaSelection(governmentQuotaRecord);
		List<GovernmentQuotaRecord> quotas = criteria.list();
		Double amount = 0.00;
		if(quotas!= null && quotas.size()>0) {
			amount = quotas.get(0).getRecordAmount();
		}
		return amount;
	}
}
