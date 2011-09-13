<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String username = "";
if (session != null) {
	username = (String) session
			.getAttribute(Constants.ADMIN_LOGIN_USER_NAME);
}
%>
<html>
<script type="text/javascript">
function changeTitleBackground(){
	if(<%=username%>==null||<%=username%>==""){
		var index = "<%=request.getContextPath()%>"+"/admin/adminLogin.jsp";
		window.location.href = index;
	}
	 var sURL = window.location.href.toString();
	 var className= "active";
	 if(sURL.indexOf("listui.do")>0||sURL.indexOf("adminUser")>0){
		 document.getElementById("adminUser").className = className;
	 }
}
</script>
<body onload="changeTitleBackground();">
<div class="header">
    <div class="header_resize">
      <div class="nav_menu">
		<ul>
			<li id="adminUser"><a href="listui.do">企业查询</a></li>
			<li id="adminOperation"><a href="lister.do">充值查询</a></li>
			<li id="adminScheme"><a href="listnews.do">消息发布</a></li>
			<li id="adminGovernmentGuidePriceImport"><a href="adminGovernmentGuidePriceImport.jsp">政府指导价导入</a></li>
			<li id="adminDeleteGuideData"><a href="adminDeleteGuideData.jsp">政府指导价删除</a></li>
			<li id="adminGovernmentFileImport"><a href="adminGovernmentFileImport.jsp">政府文件导入</a></li>
			<li id="adminUserAdvice"><a href="listua.do">用户反馈</a></li>
		 </ul>
      </div>
      <div class="logo"><h1>任远建筑造价平台<small></small></h1></div>
    </div>
  </div>
</body>
</html>