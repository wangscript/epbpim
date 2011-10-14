package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.GovernmentQuotaRecordDAO;
import com.ryxx.bpim.entity.GovernmentQuotaRecord;

/**
 * author Delgado
 */
public class GovernmentQuotaRecordServiceImpl extends AbstractService<GovernmentQuotaRecord, GovernmentQuotaRecordDAO, Long>  implements GovernmentQuotaRecordService {

	@Override
	public void delete() throws SQLException {
		getDao().delete();
	}
	public void importGovernmentQuotaRecord(List<GovernmentQuotaRecord> records)
		throws SQLException {
		for (GovernmentQuotaRecord record : records) {
			getDao().save(record);
		}
	}

	public List<GovernmentQuotaRecord> viewGovernmentQuotaDetail(Long id) throws SQLException {
		GovernmentQuotaRecord record = new GovernmentQuotaRecord();
		record.getGovernmentQuota().setId(id);
		return getDao().listByQuota(record);
	}
}
