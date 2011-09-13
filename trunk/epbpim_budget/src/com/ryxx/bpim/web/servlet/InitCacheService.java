package com.ryxx.bpim.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitCacheService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7424034770029029671L;
	
	public void init() throws ServletException {
		super.init();
//        ApplicationContext app = (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        AdminRoleService roleService = (AdminRoleService) app.getBean("com.ryxx.bpim.user.service.AdminRoleService");
//        AdminMenuService menuService = (AdminMenuService) app.getBean("com.ryxx.bpim.user.service.AdminMenuService");
//        List<AdminRole> roleList = roleService.findRolesWithMenus();
//		CacheMap.getInstance().addCache(Constants.MENU_CACHE, menuService.list());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		CacheMap.getInstance().clearCache();
//		ApplicationContext app = (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//		AdminRoleService roleService = (AdminRoleService) app.getBean("com.ryxx.bpim.user.service.AdminRoleService");
//        List<AdminRole> roleList = roleService.findAll();
//        if(roleList != null && roleList.size()>0) {
//        	for(int i=0; i<roleList.size(); i++) {
//        		AdminRole role = roleList.get(i);
//            	CacheMap.getInstance().addCache("role"+role.getId(), role.getMenuList());
//        	}
//        }
//		AdminMenuService menuService = (AdminMenuService) app.getBean("com.ryxx.bpim.user.service.AdminMenuService");
//		CacheMap.getInstance().addCache(Constants.MENU_CACHE, menuService.list());
//		PrintWriter out = response.getWriter();
//		out.println("Cache size is: "+CacheMap.getInstance().getCacheSize());
	}
}
