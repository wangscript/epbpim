<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.util.cache.CacheMap"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<%@ page import="com.ryxx.bpim.entity.AdminMenu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />

</head>
<script type="text/javascript">
function changeTitleBackground(){
	 var sURL = window.location.href.toString();
	 var className= "active";
	 if(sURL.indexOf("userInfoManage")>0||sURL.indexOf("changePassword")>0){
		 document.getElementById("userInfoManage").className = className;
	 }else if(sURL.indexOf("rechargeMain")>0||sURL.indexOf("rechargeMain")>0){
		 document.getElementById("rechargeMain").className = className;
	 }else if(sURL.indexOf("messageMain")>0||sURL.indexOf("messageMain")>0){
		 document.getElementById("messageMain").className = className;
	 }else if(sURL.indexOf("index")>0||sURL.indexOf("messageMain")>0){
	 document.getElementById("index").className = className;
	}
	 
	 if(sURL.indexOf("templateDownload")>0||sURL.indexOf("templateDownload")>0){
		 document.getElementById("templateDownload").className = className;
	 }else if(sURL.indexOf("uploadData")>0||sURL.indexOf("uploadData")>0){
		 document.getElementById("uploadData").className = className;
	 }else if(sURL.indexOf("searchData")>0||sURL.indexOf("searchUserProjectData")>0){
		 document.getElementById("searchData").className = className;
	 }else if(sURL.indexOf("searchGovernmentQuota")>0||sURL.indexOf("searchGovernmentQuota")>0){
		 document.getElementById("searchGovernmentQuota").className = className;
	 }else if(sURL.indexOf("searchGovernmentInventory")>0||sURL.indexOf("searchGovernmentInventory")>0){
		 document.getElementById("searchGovernmentInventory").className = className;
	 }else if(sURL.indexOf("searchGovernmentFile")>0||sURL.indexOf("searchGovernmentFile")>0){
		 document.getElementById("searchGovernmentFile").className = className;
	 }else if(sURL.indexOf("uploadCustomPriceData")>0||sURL.indexOf("uploadCustomPriceData")>0){
		 document.getElementById("uploadCustomPriceData").className = className;  
	 }else if(sURL.indexOf("searchCustomPriceData")>0||sURL.indexOf("searchCustomData")>0){
		 document.getElementById("searchCustomPriceData").className = className;
	 }else if(sURL.indexOf("searchGuidePriceData")>0||sURL.indexOf("searchGuideData")>0){
		 document.getElementById("searchGuidePriceData").className = className;
	 }else if(sURL.indexOf("personalRecordAnalyse")>0||sURL.indexOf("personalRecordAnalyse")>0){
		 document.getElementById("personalRecordAnalyse").className = className;
	 }else if(sURL.indexOf("personalQuotaAnalyse")>0||sURL.indexOf("personalQuotaAnalyse")>0){
		 document.getElementById("personalQuotaAnalyse").className = className;
	 }
	 
	 var messageCount = "1";
	 //var messageCount = "<%//=newMessageCount%>";
		if (messageCount > 0) {
			var message = document.getElementById("message");
			message.innerHTML = messageCount + "条新消息";
		}

	}
	function displayCategory(id) {
		document.getElementById(id).style.display = "BLOCK";
	}
	function unDisplayCategory(id) {
		document.getElementById(id).style.display = "NONE";
	}
	function addMenu(parentId, id, url, name) {
		var obj = document.getElementById(parentId);
		if (obj != null) {
			var newObj = document.createElement("li");
			newObj.id = id;
			newObj.innerHTML = "<a href=\"url\">" + name + "</a>";
			obj.appendChild(newObj);
		}
	}
</script>
<body onunload="javacript: document.getElementById('logoutLink').click();" >
	<div class="header">
		<div class="header_resize">
			<div class="nav_menu">
				<ul>
					<li id="userInfoManage"><a href="userInfoManage.do"><s:text name="Header.UserManage" /></a></li>
					<li id="messageMain"><a id="message"href="../main/messageMain.jsp"><font color="red">有1个待办事项</font></a></li>
					<li id="help"><a href="#">用户手册</a></li>
					<li id="index"><a id="logoutLink" href="../login/logout.do"><s:text name="Header.Logout" /></a></li>
				</ul>
			</div>
			<div class="logo">
				<h1>
					<s:text name="Product.Name" />
					<small>欢迎您！尊敬的用户。</small> <small></small>
				</h1>
			</div>
			<div class="categoryDiv">
				<ul class="category">
					<%
						Long userId = (Long)session.getAttribute(Constants.LOGIN_USER_ID);
						List<AdminMenu> menus = (List)CacheMap.getInstance().getCache(Constants.USER+userId);
						request.setAttribute("menus", menus);
					%>
					<s:if test="#request.menus!=null && #request.menus.size()>0">
						<s:iterator value="#request.menus" status="st">
							<s:if test="subMenus !=null && subMenus.size()>0">
								<li onmouseenter="displayCategory('<s:property value="id"/>')"
									onmouseleave="unDisplayCategory('<s:property value="id"/>')"
									onmouseover="displayCategory('<s:property value="id"/>')"
									onmouseout="unDisplayCategory('<s:property value="id"/>')"><a><s:property
											value="name" />
								</a>
									<ul id="<s:property value="id"/>" style="display: none">
										<s:iterator value="subMenus" status="st1">
											<li id="<s:property value="id"/>"><a
												href="<s:property value="url"/>"><s:property
														value="name" />
											</a>
											</li>
										</s:iterator>
									</ul></li>
							</s:if>
						</s:iterator>
					</s:if>
					<li class="otherCategory"></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>