package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.AdminLog;

public interface AdminLogDAO extends BaseDAO<AdminLog, Long> {
	public List<AdminLog> list();
}
