package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.BaseService;
import com.ryxx.bpim.user.dao.EnterpriseInfoDAO;
import com.ryxx.bpim.user.entity.EnterpriseInfo;
import com.ryxx.util.page.PageTools;

public interface EnterpriseInfoService extends BaseService<EnterpriseInfo,EnterpriseInfoDAO, Long> {
	List<EnterpriseInfo> listPage(EnterpriseInfo enterpriseInfo, PageTools page);
}
