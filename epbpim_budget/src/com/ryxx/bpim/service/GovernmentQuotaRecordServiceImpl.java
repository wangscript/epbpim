package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.GovernmentQuotaRecordDAO;
import com.ryxx.bpim.entity.GovernmentQuota;
import com.ryxx.bpim.entity.GovernmentQuotaRecord;

/**
 * author Delgado
 */
public class GovernmentQuotaRecordServiceImpl extends AbstractService<GovernmentQuotaRecord, GovernmentQuotaRecordDAO, Long>  implements GovernmentQuotaRecordService {

	@Override
	public void delete() throws SQLException {
		getDao().delete();
	}
	public void saveGovernmentQuotaRecord(List<GovernmentQuotaRecord> records)
		throws SQLException {
		for (GovernmentQuotaRecord record : records) {
			getDao().save(record);
		}
	}

	public List<GovernmentQuotaRecord> listGovernmentQuotaDetail(Long id) throws SQLException {
		GovernmentQuotaRecord record = new GovernmentQuotaRecord();
		GovernmentQuota quota = new GovernmentQuota();
		quota.setId(id);
		record.setGovernmentQuota(quota);
		return getDao().listByQuota(record);
	}
}
