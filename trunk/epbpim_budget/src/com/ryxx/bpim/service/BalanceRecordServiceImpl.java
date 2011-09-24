package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.BalanceRecordDAO;
import com.ryxx.bpim.entity.BalanceRecord;
import com.ryxx.util.page.PageTools;

public class BalanceRecordServiceImpl  extends AbstractService<BalanceRecord,BalanceRecordDAO, Long> implements BalanceRecordService{
	public List<BalanceRecord> listPage(BalanceRecord balanceRecord, PageTools page) {
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = getDao().getRowCount(balanceRecord);
				page.setRecordCount(count);
			}
			balanceRecord.setStartRow(page.getPageStartRow());
			balanceRecord.setPageSize(page.getPageSize());
		}
		return getDao().findByCount(balanceRecord);
	}
}
