package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.ExpenseRecord;

public interface ExpenseRecordDAO extends BaseDAO<ExpenseRecord, Long> {
	List<ExpenseRecord> findByCount(ExpenseRecord expenseRecord);
	int getRowCount(ExpenseRecord expenseRecord);
}
