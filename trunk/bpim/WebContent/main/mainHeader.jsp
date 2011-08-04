<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	 if(messageCount>0){
		var message = document.getElementById("message");
		message.innerHTML = messageCount+"条新消息";
}

	}
	function displayCategory(id){
		 document.getElementById(id).style.display="BLOCK";
	}
	function unDisplayCategory(id){
		 document.getElementById(id).style.display="NONE";
	}
</script>
<body>
<div class="header">
<div class="header_resize">
<div class="nav_menu">
<ul>
	<li id="userInfoManage"><a href="#">用户信息管理</a></li>
	<!-- <li id="rechargeMain"><a href="rechargeMain.jsp">充值续费</a></li> -->
	<li id="messageMain"><a id="message" href="../main/messageMain.jsp"><font
		color="red">有1个待办事项</font></a></li>
	<li id="help"><a href="#">用户手册</a></li>
	<li id="index"><a href="#">退出</a></li>
</ul>
</div>
<div class="logo">
<h1>咨询公司综合信息管理系统 <small>欢迎您！尊敬的用户。</small> <small></small></h1>
</div>
<div class="categoryDiv">
<ul class="category">
	<li onmouseover="displayCategory('publicInfo')"
		onmouseout="unDisplayCategory('publicInfo')"><a>公共信息平台</a>
	<ul id="publicInfo" style="display: none">
		<li id="#"><a href="../publicInfo/businessLicense.jsp">营业执照</a></li>
		<li id="#"><a href="../publicInfo/taxLicense.jsp">税务登记执照</a></li>
		<li id="#"><a href="../publicInfo/isoFileQuery.jsp">ISO文件查询</a></li>
		<li id="#"><a href="../publicInfo/historyProject.jsp">典型工程查询</a></li>
		<li id="#"><a href="../publicInfo/isoFileUpload.jsp">ISO文件上传</a></li>
		<li id="#"><a href="../publicInfo/messagePublish.jsp">发布通知</a></li>
	</ul>
	</li>
	<li onmouseover="displayCategory('businessFileManage')"
		onmouseout="unDisplayCategory('businessFileManage')"><a>业务文件管理</a>
	<ul id="businessFileManage" style="display: none">
		<li id="#"><a href="../businessFile/businessFileUpload.jsp">文件上传</a></li>
		<li id="#"><a href="../businessFile/businessFileManage.jsp">业务文件查询</a></li>
	</ul>
	</li>
	<li onmouseover="displayCategory('employeeManage')"
		onmouseout="unDisplayCategory('employeeManage')"><a>人力资源管理</a>
	<ul id="employeeManage" style="display: none">
		<li id="#"><a href="../employeeManage/employeeQuery.jsp">员工查询</a></li>
		<li id="#"><a href="../employeeManage/addEmployee.jsp">新增员工</a></li>
	</ul>
	</li>
	<li onmouseover="displayCategory('projectManage')"
		onmouseout="unDisplayCategory('projectManage')"><a>工程项目管理</a>
	<ul id="projectManage" style="display: none">
		<li id="addProject"><a href="../projectManage/addProject.jsp">项目录入</a></li>
		<li id="projectManage"><a
			href="../projectManage/projectManage.jsp">项目查询</a></li>
	</ul>
	</li>
	<li onmouseover="displayCategory('managerFileManage')"
		onmouseout="unDisplayCategory('managerFileManage')"><a>总经理文件管理</a>
	<ul id="managerFileManage" style="display: none">
		<li id="#"><a href="../managerFile/managerFileUpload.jsp">文件上传</a></li>
		<li id="#"><a href="../managerFile/managerFileManage.jsp">文件查询</a></li>
	</ul>
	</li>

	<li class="otherCategory"></li>
</ul>
</div>
</div>
</div>
</body>
</html>