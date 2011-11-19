package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.UserInfo;

public interface UserInfoDAO extends BaseDAO<UserInfo, Long> {
	int getRowCount(UserInfo userInfo);
	List<UserInfo> findByCount(UserInfo userInfo);
	UserInfo getByLogin(UserInfo userInfo);
}
