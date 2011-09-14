package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.EnterpriseInfoDAO;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.util.page.PageTools;

public class EnterpriseInfoServiceImpl  extends AbstractService<EnterpriseInfo,EnterpriseInfoDAO, Long> implements EnterpriseInfoService{
	public List<EnterpriseInfo> listPage(EnterpriseInfo enterpriseInfo, PageTools page) {
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = getDao().getRowCount(enterpriseInfo);
				page.setRecordCount(count);
			}
			enterpriseInfo.setStartRow(page.getPageStartRow());
			enterpriseInfo.setPageSize(page.getPageSize());
		}
		return getDao().findByCount(enterpriseInfo);
	}
}
