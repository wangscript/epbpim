package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.EnterpriseInfo;

public interface EnterpriseInfoDAO extends BaseDAO<EnterpriseInfo, Long> {
	public List<EnterpriseInfo> list();
}
