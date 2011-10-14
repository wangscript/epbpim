package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.GovernmentQuotaRecordDAO;
import com.ryxx.bpim.entity.GovernmentQuotaRecord;

/**
 * author Delgado
 */
public interface GovernmentQuotaRecordService extends BaseService<GovernmentQuotaRecord, GovernmentQuotaRecordDAO, Long>
{
	void delete() throws SQLException;
	void importGovernmentQuotaRecord(List<GovernmentQuotaRecord> records) throws SQLException;
	List<GovernmentQuotaRecord> viewGovernmentQuotaDetail(Long id) throws SQLException;
}

