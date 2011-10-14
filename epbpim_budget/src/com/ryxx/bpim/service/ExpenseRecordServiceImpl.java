package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.ExpenseRecordDAO;
import com.ryxx.bpim.entity.ExpenseRecord;
import com.ryxx.util.page.PageTools;

public class ExpenseRecordServiceImpl  extends AbstractService<ExpenseRecord,ExpenseRecordDAO, Long> implements ExpenseRecordService{
	public List<ExpenseRecord> listPage(ExpenseRecord expenseRecord, PageTools page) {
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = getDao().getRowCount(expenseRecord);
				page.setRecordCount(count);
			}
			expenseRecord.setStartRow(page.getPageStartRow());
			expenseRecord.setPageSize(page.getPageSize());
		}
		return getDao().findByCount(expenseRecord);
	}
}
