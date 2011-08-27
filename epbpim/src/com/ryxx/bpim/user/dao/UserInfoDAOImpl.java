package com.ryxx.bpim.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.UserInfo;

public class UserInfoDAOImpl extends AbstractBaseDAO<UserInfo, Long> implements UserInfoDAO{
	public int getRowCount(UserInfo userInfo) {
		List<Criterion> list = new ArrayList<Criterion>();
		if(userInfo != null) {
			if(!StringUtils.isEmpty(userInfo.getUserName())) {
				Criterion criterion1 = Restrictions.like("userName", "%" + userInfo.getUserName() + "%");
				list.add(criterion1);
			}
		}
		Criterion[] criterions = {};
		if(list != null && list.size() > 0) {
			for(int i=0; i<list.size(); i++) {
				criterions[i] = list.get(i);
			}
		}
		return findByCriteria(criterions).size();
	}
	
	public List<UserInfo> findByCount(UserInfo userInfo1) {
		List<Criterion> list = new ArrayList<Criterion>();
		if(userInfo1 != null) {
			if(!StringUtils.isEmpty(userInfo1.getUserName())) {
				Criterion criterion1 = Restrictions.like("userName", "%" + userInfo1.getUserName() + "%");
				list.add(criterion1);
			}
		}
		Criterion[] criterions = {};
		if(list != null && list.size() > 0) {
			for(int i=0; i<list.size(); i++) {
				criterions[i] = list.get(i);
			}
		}
		return findPageByPage(userInfo1.getStartRow(), userInfo1.getPageSize(), criterions);
	}
}
