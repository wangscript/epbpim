<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/admin.css" rel="stylesheet" type="text/css"
	media="screen" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="header">
    <div class="header_resize">
      <div class="nav_menu">
		<ul>
			<li id="adminUser"><a href="listui.do">企业查询</a></li>
			<li id="adminUser"><a href="addCompany.jsp">新增企业账号</a></li>
			<li id="adminOperation"><a href="lister.do">充值查询</a></li>
			<li id="adminScheme"><a href="listnews.do">消息发布</a></li>
			<li id="adminGovernmentGuidePriceImport"><a href="adminGovernmentGuidePriceImport.jsp">政府指导价导入</a></li>
			<li id="adminDeleteGuideData"><a href="adminDeleteGuideData.jsp">政府指导价删除</a></li>
			<li id="adminGovernmentFileImport"><a href="adminGovernmentFileImport.jsp">政府文件导入</a></li>
			<li id="adminUserAdvice"><a href="listua.do">用户反馈</a></li>
		 </ul>
      </div>
      <div class="logo"><h1><small></small></h1></div>
    </div>
  </div>
</body>
</html>