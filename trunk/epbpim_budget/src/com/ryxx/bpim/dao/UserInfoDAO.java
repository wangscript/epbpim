package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.UserInfo;

public interface UserInfoDAO extends BaseDAO<UserInfo, Long> {
	public List<UserInfo> list();
}
