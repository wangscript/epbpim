package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.EnterpriseInfo;

public interface EnterpriseInfoDAO extends BaseDAO<EnterpriseInfo, Long> {
	List<EnterpriseInfo> findByCount(EnterpriseInfo enterpriseInfo);
	int getRowCount(EnterpriseInfo enterpriseInfo);
}
