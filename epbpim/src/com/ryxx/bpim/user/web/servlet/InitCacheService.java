package com.ryxx.bpim.user.web.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.service.AdminMenuService;
import com.ryxx.util.cache.CacheMap;

public class InitCacheService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7424034770029029671L;
	
	public void init() throws ServletException {
		super.init();
        ApplicationContext app = (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		AdminMenuService menuService = (AdminMenuService) app.getBean("com.ryxx.bpim.user.service.AdminMenuService");
		CacheMap.getInstance().addCache(Constants.MENU_CACHE, menuService.list());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		CacheMap.getInstance().clearCache();
		ApplicationContext app = (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		AdminMenuService menuService = (AdminMenuService) app.getBean("com.ryxx.bpim.user.service.AdminMenuService");
		CacheMap.getInstance().addCache(Constants.MENU_CACHE, menuService.list());
		PrintWriter out = response.getWriter();
		out.println("Cache size is: "+CacheMap.getInstance().getCacheSize());
	}
}
