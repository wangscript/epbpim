package com.ryxx.bpim.service;

import java.util.List;

import org.apache.commons.mail.EmailException;

import com.ryxx.bpim.dao.UserInfoDAO;
import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo,UserInfoDAO, Long> {
//	List<UserInfo> listPage(UserInfo userInfo, PageTools page);
	public List<UserInfo> list(Long enterpriseId);

	public String getMaxIdentify();

	/**
	 * @param userInfo
	 * @return
	 */
	public UserInfo getByLogin(UserInfo userInfo);

	/**
	 * @param userCount
	 * @param enterpriseInfo 
	 * @param eId 
	 * @param listCheck
	 * @throws EmailException 
	 */
	public void batchAddUsers(Integer userCount, EnterpriseInfo enterpriseInfo, List<AdminMenu> menus, List regionCheck) throws EmailException;

	/**
	 * @param identifier
	 * @return
	 */
	public UserInfo getUserByIdentifier(String identifier);
}