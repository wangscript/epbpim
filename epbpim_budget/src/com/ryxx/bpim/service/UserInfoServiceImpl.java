package com.ryxx.bpim.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ryxx.bpim.dao.UserInfoDAO;
import com.ryxx.bpim.entity.AdminMenu;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.enums.RoleEnum;
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


	/* (non-Javadoc)
	 * @see com.ryxx.bpim.service.UserInfoService#batchAddUsers(java.lang.Integer, com.ryxx.bpim.entity.EnterpriseInfo, java.util.List)
	 */
	@Override
	public void batchAddUsers(Integer userCount, EnterpriseInfo enterpriseInfo, Long eId,
			List listCheck) {
		if(userCount != null && userCount > 0) {
			enterpriseInfo.setId(eId);
			for(int i=0; i<userCount; i++) {
				UserInfo userInfo = new UserInfo();
				userInfo.setRoleType(RoleEnum.NORMAL_USER);
				userInfo.setEnterpriseInfo(enterpriseInfo);
				userInfo.setRegisterDate(new Timestamp(System.currentTimeMillis()));
				String maxIdentify = getDao().getMaxIdentify();
				if(maxIdentify == null || maxIdentify.length() == 0) {
					userInfo.setIdentifier("ry10000001");
				} else {
					userInfo.setIdentifier("ry"+(Long.parseLong(maxIdentify.substring(2))+1));
				}
				List<AdminMenu> menus = new ArrayList<AdminMenu>();
				if(listCheck != null && listCheck.size()>0) {
					for(int j=0; j<listCheck.size(); j++) {
						AdminMenu menu = new AdminMenu();
						menu.setId(Integer.parseInt(listCheck.get(j).toString()));
						menus.add(menu);
					}
				}
				try{
				userInfo.setMenus(menus);
				UserInfo user = getDao().save(userInfo);
				}catch (Exception e){
					System.out.println(e);
				}
			}
		}
	}
}
