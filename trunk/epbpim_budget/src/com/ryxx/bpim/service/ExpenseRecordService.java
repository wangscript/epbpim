package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.ExpenseRecordDAO;
import com.ryxx.bpim.entity.ExpenseRecord;
import com.ryxx.util.page.PageTools;

public interface ExpenseRecordService extends BaseService<ExpenseRecord,ExpenseRecordDAO, Long> {
	List<ExpenseRecord> listPage(ExpenseRecord expenseRecord, PageTools page);
}
