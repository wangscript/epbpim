package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.EnterpriseInfoDAO;
import com.ryxx.bpim.user.entity.EnterpriseInfo;
import com.ryxx.util.page.PageTools;

public class EnterpriseInfoServiceImpl  extends AbstractService<EnterpriseInfo,EnterpriseInfoDAO, Long> implements EnterpriseInfoService{
	public List<EnterpriseInfo> listPage(EnterpriseInfo enterpriseInfo, PageTools page) {
//		if (page != null) {
//			if (page.getRecordCount() == 0) {
//				int count = getDao().getRowCount(enterpriseInfo);
//				page.setRecordCount(count);
//			}
//			enterpriseInfo.setStartRow(page.getPageStartRow());
//			enterpriseInfo.setPageSize(page.getPageSize());
//		}
//		return getDao().findByCount(enterpriseInfo);
		return null;
	}
}
