package com.ryxx.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.GovernmentQuota;
import com.ryxx.bpim.entity.GovernmentQuotaRecord;
import com.ryxx.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface GovernmentQuotaDAO extends BaseDAO<GovernmentQuota, Long> {
	
	List<GovernmentQuota> findByCount(GovernmentQuota governmentQuota);
	int getRowCount(GovernmentQuota governmentQuota);

	void delete() throws SQLException;
}

