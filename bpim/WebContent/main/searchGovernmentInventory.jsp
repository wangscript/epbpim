<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String username = (String) session.getAttribute(Constants.LOGIN_USER_NAME);
	if(StringUtils.isEmpty(username)) {
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript" src="../js/common.js">

</script>
<script type="text/javascript">
	function setSearchValue() {
		var provice = "<s:property value="condition.provice"/>";
		if(provice!="")
		document.getElementById("provice").value=provice;
		var quotaNum = "<s:property value="condition.quotaNum"/>";
		if(quotaNum!="")
		document.getElementById("quotaNum").value=quotaNum;
		var quotaName = "<s:property value="condition.quotaName"/>";
		if(quotaName!="")
		document.getElementById("quotaName").value=quotaName;
		var quotaClass = "<s:property value="condition.quotaClass"/>";
		if(quotaClass!="")
		document.getElementById("quotaClass").value=quotaClass;
	}
	function clearPage(updateId){
		var ps = document.getElementById("ps");
		var pn = document.getElementById("pn");
		if(ps != null) {
			ps.options[1].selected = true;
		}
		if(pn != null) {
			pn.options[0].selected = true;
		}
		document.getElementById("searchGovernmentQuotaForm").submit();
	}
</script>
</head>
<title>清单查询</title>
</head>
<body onload="setSearchValue();changeTitleBackground();">
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<s:form	action="searchGovernmentQuota.do" method="post"
	name="searchGovernmentQuota" id="searchGovernmentQuotaForm">
<div class="mainbar">
<h3 class="title">清单查询</h3>
<div id="searchCondition">
		<ul>
	<li style="width:150px;">清单类别：<select id="quotaClass" name="condition.quotaClass"
		style="width: 80px;"> 
		<option value="0">--请选择--</option>
		<option value="2000土建装饰">土建</option>
		<option value="2000园林">园林</option>
		<option value="2000市政定额">市政</option>
		<option value="2000安装">安装</option>
		<option value="2000公用">公用</option>
		<option value="2000水利">水利</option>
		<option value="2000人防">人防</option>
		<option value="2000房修">房修</option>
	</select></li>
	
			<li><label class="lb">编号：</label><input style="width: 60px"
				class="inputText" name="condition.quotaNum" id="quotaNum"></li>
			<li><label class="lb">名称：</label><input
				style="width: 120px" class="inputText" name="condition.quotaName"
				id="quotaName"></li>
			<li><input name="searchButton" 
				type="button" id="searchButton" class="button" value="查询"></li>
		</ul>
</div>

<div class="searchResult" id="searchResult" style="margin-top:15px;">
<ul>
	<li style="width: 100px">清单大类</li>
	<li style="width: 100px">编号</li>
	<li style="width: 300px">名称</li>
	<li style="width: 50px">查看详情</li>
</ul>
<ul>
	<li style="width: 100px">土方工程</li>
	<li style="width: 100px">010101</li>
	<li style="width: 300px">土方工程</li>
	<li style="width: 50px"><a target="blank" href="../temple/4.html">查看</a></li>
</ul>
<ul>
	<li style="width: 100px">土方工程</li>
	<li style="width: 100px">010101</li>
	<li style="width: 300px">土方工程</li>
	<li style="width: 50px"><a target="blank" href="../temple/4.html">查看</a></li>
</ul>
<ul>
	<li style="width: 100px">土方工程</li>
	<li style="width: 100px">010101</li>
	<li style="width: 300px">土方工程</li>
	<li style="width: 50px"><a target="blank" href="../temple/4.html">查看</a></li>
</ul>
<s:if test="datas==null || datas.size()==0">
</s:if> <s:else>
	<s:iterator value="datas" status="st">
		<ul id="<s:property value='id'/>">
			<li style="width: 100px"><s:property value="governmentQuotaClass" /></li>
			<li style="width: 140px"><s:property value="governmentQuotaType" /></li>
			<li style="width: 100px"><s:property value="governmentQuotaNum" /></li>
			<li style="width: 160px"><s:if
				test="%{null!=governmentQuotaName&&governmentQuotaName.length()>12}">
				<s:property value="governmentQuotaName.substring(0, 11)+'...'" />
			</s:if> <s:else>
				<s:property value="governmentQuotaName" />
			</s:else></li>
			<li style="width: 60px"><s:property value="governmentQuotaModel" /></li>
			<li style="width: 60px"><s:property value="governmentQuotaUnit" /></li>
			<li style="width: 60px"><s:property value='governmentQuotaAmount' /></li>
			<li style="width: 50px"><input type="button" class="button"
				onclick="window.location.href = 'viewGovernmentQuotaDetail.do?id=<s:property value='id'/>'"
				value="查看"></li>
		</ul>
	</s:iterator>
	<ul>
				<jsp:include page="../common/pagination.jsp" flush="true">
				 	<jsp:param name="action_page" value="main/searchGovernmentQuota.do"/>
				</jsp:include>
	</ul>
</s:else></div>
</div></s:form>

 <!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>
</html>