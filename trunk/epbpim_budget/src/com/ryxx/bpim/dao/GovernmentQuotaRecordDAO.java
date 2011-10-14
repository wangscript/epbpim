package com.ryxx.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.entity.GovernmentQuota;
import com.ryxx.bpim.entity.GovernmentQuotaRecord;
import com.ryxx.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface GovernmentQuotaRecordDAO extends BaseDAO<GovernmentQuotaRecord, Long> {
	List<GovernmentQuota> findByCount(GovernmentQuotaRecord governmentQuotaRecord);
	int getRowCount(GovernmentQuotaRecord governmentQuotaRecord);
	void delete() throws SQLException;
	List<GovernmentQuotaRecord> listByQuota(GovernmentQuotaRecord governmentQuotaRecord) throws SQLException;
	public void insert(List<GovernmentQuotaRecord> records)	throws SQLException; 
}

