package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.AdminUserDAO;
import com.ryxx.bpim.entity.AdminUser;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.util.page.PageTools;

public class AdminUserServiceImpl  extends AbstractService<AdminUser,AdminUserDAO, Long> implements AdminUserService{
	public List<UserInfo> listPage(AdminUser adminUser, PageTools page) {
//		if (page != null) {
//			if (page.getRecordCount() == 0) {
//				int count = getDao().getRowCount(userInfo);
//				page.setRecordCount(count);
//			}
//			userInfo.setStartRow(page.getPageStartRow());
//			userInfo.setPageSize(page.getPageSize());
//		}
//		return getDao().findByCount(userInfo);
		return null;
	}
}
