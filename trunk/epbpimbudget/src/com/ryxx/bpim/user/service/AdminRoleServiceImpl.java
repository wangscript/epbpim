package com.ryxx.bpim.user.service;

import java.util.ArrayList;
import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.AdminRoleDAO;
import com.ryxx.bpim.user.entity.AdminMenu;
import com.ryxx.bpim.user.entity.AdminRole;
import com.ryxx.util.cache.CacheMap;

public class AdminRoleServiceImpl  extends AbstractService<AdminRole,AdminRoleDAO, Long> implements AdminRoleService{
	public List<AdminRole> findByRoleName(String name) {
		if(name != null) {
			return this.getDao().findByRoleName(name);
		} else {
			return this.getDao().findAll();
		}
	}
	
	public List<AdminRole> findRolesWithMenus() {
		List<AdminRole> roleList = this.getDao().findAll();
        List<AdminRole> newList = new ArrayList<AdminRole>();
        if(roleList != null && roleList.size()>0) {
        	for(int i=0; i<roleList.size(); i++) {
        		AdminRole role = this.getDao().fetchById(roleList.get(i).getId());
        		role.getMenuList();
        		newList.add(role);
        	}
        }
        return newList;
	}
}
