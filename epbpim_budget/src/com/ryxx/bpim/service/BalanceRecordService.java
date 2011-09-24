package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.BalanceRecordDAO;
import com.ryxx.bpim.entity.BalanceRecord;
import com.ryxx.util.page.PageTools;

public interface BalanceRecordService extends BaseService<BalanceRecord,BalanceRecordDAO, Long> {
	List<BalanceRecord> listPage(BalanceRecord balanceRecord, PageTools page);
}
