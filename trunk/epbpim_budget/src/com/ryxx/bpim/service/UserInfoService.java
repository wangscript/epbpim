package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.UserInfoDAO;
import com.ryxx.bpim.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo,UserInfoDAO, Long> {
//	List<UserInfo> listPage(UserInfo userInfo, PageTools page);
	public List<UserInfo> list(Long enterpriseId);
}
