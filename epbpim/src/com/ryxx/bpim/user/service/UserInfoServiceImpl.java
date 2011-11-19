package com.ryxx.bpim.user.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.UserInfoDAO;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.string.StringTools;

public class UserInfoServiceImpl  extends AbstractService<UserInfo,UserInfoDAO, Long> implements UserInfoService{
	public List<UserInfo> listPage(UserInfo userInfo, PageTools page) {
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = getDao().getRowCount(userInfo);
				page.setRecordCount(count);
			}
			userInfo.setStartRow(page.getPageStartRow());
			userInfo.setPageSize(page.getPageSize());
		}
		return getDao().findByCount(userInfo);
	}

	@Override
	public UserInfo getByLogin(UserInfo userInfo) {
		return getDao().getByLogin(userInfo);
	}
	
	public void savePrivateInfo(Long userId, UserInfo userInfo) {
		UserInfo newUserInfo = fetchById(userId);
		newUserInfo.setRealName(userInfo.getRealName());
		newUserInfo.setUserName(userInfo.getUserName());
		newUserInfo.setSex(userInfo.getSex());
		newUserInfo.setBirthday(new Timestamp(StringTools.string2date(userInfo.getBirthdayTmp()+" 00:00:00").getTime()));
		newUserInfo.setIdCard(userInfo.getIdCard());
		newUserInfo.setFamilyAddress(userInfo.getFamilyAddress());
		newUserInfo.setPhone(userInfo.getPhone());
		newUserInfo.setMobilePhone(userInfo.getMobilePhone());
		if(StringUtils.isNotEmpty(userInfo.getPassword())) {
			newUserInfo.setPassword(userInfo.getPassword());
		}
		save(newUserInfo);
	}
}
