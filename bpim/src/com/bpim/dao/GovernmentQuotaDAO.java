package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.GovernmentQuota;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface GovernmentQuotaDAO {

	List<GovernmentQuota> searchGovernmentQuota(SearchDataCondition condition) throws SQLException;
	
	int countSearchGovernmentQuota(SearchDataCondition condition) throws SQLException;
}

