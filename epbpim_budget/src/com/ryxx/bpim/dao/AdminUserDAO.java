package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.AdminUser;

public interface AdminUserDAO extends BaseDAO<AdminUser, Long> {
	public List<AdminUser> list();
}
