package com.ryxx.bpim.user.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.AdminLog;
import com.ryxx.bpim.user.entity.AdminMenu;
import com.ryxx.bpim.user.entity.AdminRole;
import com.ryxx.bpim.user.service.AdminLogService;
import com.ryxx.bpim.user.service.AdminMenuService;
import com.ryxx.bpim.user.service.AdminRoleService;
import com.ryxx.bpim.user.service.UserCertificationService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.cache.CacheMap;

public class AdminRoleAction extends ActionSupportBase {
	private static final long serialVersionUID = 4734813498862066564L;

	private static final Log LOG = LogFactory.getLog(AdminRoleAction.class);

	private Long id;
	private String name;
	private Integer roleCount;
	private String remark;
	private List listCheck;
	private List<AdminRole> roleList;
	private List<AdminMenu> menuList;
	
	private AdminRoleService adminRoleService;
	private AdminMenuService adminMenuService;
	private AdminLogService adminLogService;
	
	public String save() {
		AdminRole role = new AdminRole();
		role.setName(name);
		role.setRoleCount(roleCount);
		role.setRemark(remark);
		List<AdminMenu> menus = new ArrayList<AdminMenu>();
		if(listCheck != null && listCheck.size()>0) {
			for(int i=0; i<listCheck.size(); i++) {
				AdminMenu menu = new AdminMenu();
				menu.setId(Integer.parseInt(listCheck.get(i).toString()));
				menus.add(menu);
			}
		}
		role.setMenuList(menus);
		AdminRole adminRole = adminRoleService.save(role);
		adminRoleService.evict(adminRole);
		AdminRole adminRole2 = adminRoleService.fetchById(adminRole.getId());
		CacheMap.getInstance().addCache(Constants.ROLE+role.getId(), adminMenuService.getMenuTree(adminRole2.getMenuList()));
		
		AdminLog log = new AdminLog();
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setModuleId(14);
		log.setActionType(Constants.OPER_TYPE_CREATE);
		log.setUserName(session.get(Constants.LOGIN_USER_NAME).toString());   //;
		log.setUserIp(request.getRemoteAddr());
		log.setRemark("添加职务 '" + name + "' 成功");
		adminLogService.save(log);
		return SUCCESS;
	}
	
	public String list() {
		roleList = adminRoleService.findByRoleName(name);
		return SUCCESS;
	}
	
	public String delete() {
		adminRoleService.delete(id);
		
		AdminLog log = new AdminLog();
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setModuleId(15);
		log.setActionType(Constants.OPER_TYPE_DELETE);
		log.setUserName(session.get(Constants.LOGIN_USER_NAME).toString());   //;
		log.setUserIp(request.getRemoteAddr());
		log.setRemark("删除职务 (Id: '" + id + "') 成功");
		adminLogService.save(log);
		return SUCCESS;
	}
	
	public String get() {
		AdminRole adminRole = adminRoleService.fetchById(id);
		setName(adminRole.getName());
		setId(adminRole.getId());
		setRoleCount(adminRole.getRoleCount());
		setRemark(adminRole.getRemark());
		setMenuList(adminRole.getMenuList());
		return SUCCESS;
	}
	
	public String update() {
		AdminRole role = new AdminRole();
		role.setName(name);
		role.setRoleCount(roleCount);
		role.setRemark(remark);
		role.setId(id);
		List<AdminMenu> menus = new ArrayList<AdminMenu>();
		if(listCheck != null && listCheck.size()>0) {
			for(int i=0; i<listCheck.size(); i++) {
				AdminMenu menu = new AdminMenu();
				menu.setId(Integer.parseInt(listCheck.get(i).toString()));
				menus.add(menu);
			}
		}
		role.setMenuList(menus);
		AdminRole adminRole = adminRoleService.merge(role);
		adminRoleService.evict(adminRole);
		AdminRole adminRole2 = adminRoleService.fetchById(adminRole.getId());
		List<AdminMenu> cacheMenus = (List<AdminMenu>)CacheMap.getInstance().getCache(Constants.ROLE+role.getId());
		if(cacheMenus!=null && cacheMenus.size()>0) {
			CacheMap.getInstance().removeCache(Constants.ROLE+role.getId());
		}
		CacheMap.getInstance().addCache(Constants.ROLE+role.getId(), adminMenuService.getMenuTree(adminRole2.getMenuList()));
		
		AdminLog log = new AdminLog();
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setModuleId(15);
		log.setActionType(Constants.OPER_TYPE_UPDATE);
		log.setUserName(session.get(Constants.LOGIN_USER_NAME).toString());   //;
		log.setUserIp(request.getRemoteAddr());
		log.setRemark("更新职务 '" + name + "' 成功");
		adminLogService.save(log);
		return SUCCESS;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleCount() {
		return roleCount;
	}

	public void setRoleCount(Integer roleCount) {
		this.roleCount = roleCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public AdminMenuService getAdminMenuService() {
		return adminMenuService;
	}

	public void setAdminMenuService(AdminMenuService adminMenuService) {
		this.adminMenuService = adminMenuService;
	}

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public List getListCheck() {
		return listCheck;
	}

	public void setListCheck(List listCheck) {
		this.listCheck = listCheck;
	}

	public List<AdminRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<AdminRole> roleList) {
		this.roleList = roleList;
	}

	public List<AdminMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<AdminMenu> menuList) {
		this.menuList = menuList;
	}

	public AdminLogService getAdminLogService() {
		return adminLogService;
	}

	public void setAdminLogService(AdminLogService adminLogService) {
		this.adminLogService = adminLogService;
	}
}