package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.BaseService;
import com.ryxx.bpim.user.dao.UserInfoDAO;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.util.page.PageTools;

public interface UserInfoService extends BaseService<UserInfo,UserInfoDAO, Long> {
	List<UserInfo> listPage(UserInfo userInfo, PageTools page);
	UserInfo getByLogin(UserInfo userInfo);
	void savePrivateInfo(Long userId, UserInfo userInfo);
}
