package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.EnterpriseInfoDAO;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.util.page.PageTools;

public interface EnterpriseInfoService extends BaseService<EnterpriseInfo,EnterpriseInfoDAO, Long> {
	List<EnterpriseInfo> listPage(EnterpriseInfo enterpriseInfo, PageTools page);
}
