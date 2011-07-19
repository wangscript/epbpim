package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.UserInfoDAO;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.util.page.PageTools;

public interface UserInfoService extends BaseService<UserInfo,UserInfoDAO, Long>{
	List<UserInfo> listPage(UserInfo userInfo, PageTools page);
}
