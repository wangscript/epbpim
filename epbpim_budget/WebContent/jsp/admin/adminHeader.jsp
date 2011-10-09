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
<script type="text/javascript" src="../js/common.js"></script>
<script type='text/javascript' src='../js/validation.js'></script>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="header">
    <div class="header_resize">
      <div class="nav_menu">
		<ul class="fullScreenUl">
			<li id="adminUser"><a href="listEnterpriseInfo.do">企业查询</a></li>
			<li id="adminUser"><a href="newEnterpriseInfo.do">新增企业账号</a></li>
			<li id="adminScheme"><a href="listNews.do">消息发布</a></li>
			<li id="adminGovernmentGuidePriceImport"><a href="preImportGuidePrice.do">信息价导入</a></li>
			<li id="adminDeleteGuideData"><a href="preDeleteGuidePrice.do">信息价删除</a></li>
			<li id="adminGovernmentFileImport"><a href="preImportGovernmentFile.do">文件导入</a></li>
			<li id="adminPeriodicalFileImport"><a href="preImportPeriodicalFile.do">电子杂志导入</a></li>
			<li id="adminPricePackageFileUpload"><a href="preUploadPricePackageFile.do">价格包上传</a></li>
		 </ul>
		 <ul class="fullScreenUl">
			<li id="adminUserAdvice"><a href="listUserAdvice.do">用户反馈</a></li>
		 </ul>
      </div>
      <div class="logo"><h1><small></small></h1></div>
    </div>
  </div>
</body>
</html>