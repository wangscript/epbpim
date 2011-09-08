package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.AdminLog;
import com.ryxx.bpim.user.entity.AdminMenu;

public interface AdminLogDAO extends BaseDAO<AdminLog, Long> {
	public List<AdminLog> list();
}
