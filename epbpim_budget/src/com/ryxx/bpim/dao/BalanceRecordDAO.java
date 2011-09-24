package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.BalanceRecord;

public interface BalanceRecordDAO extends BaseDAO<BalanceRecord, Long> {
	List<BalanceRecord> findByCount(BalanceRecord balanceRecord);
	int getRowCount(BalanceRecord balanceRecord);
}
