package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.UserInfoDAO;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.util.page.PageTools;

public class UserInfoServiceImpl  extends AbstractService<UserInfo,UserInfoDAO, Long> implements UserInfoService{
	public List<UserInfo> listPage(UserInfo userInfo, PageTools page) {
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
	
	public List<UserInfo> list(Long enterpriseId) {
		return getDao().list(enterpriseId);
	}

	@Override
	public String getMaxIdentify() {
		return getDao().getMaxIdentify();
	}

	/* (non-Javadoc)
	 * @see com.ryxx.bpim.service.UserInfoService#getByLogin(com.ryxx.bpim.entity.UserInfo)
	 */
	@Override
	public UserInfo getByLogin(UserInfo userInfo) {
		return getDao().getByLogin(userInfo);
	}
}
