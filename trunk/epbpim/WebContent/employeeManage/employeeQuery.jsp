<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>员工查询</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
</head>
<body>
<div id="main"><jsp:include page="../main/mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">员工查询</h3>
<div id="searchCondition">
<ul class="fullScreenUl">
	<li class="width200Li"><label>部门：</label><select
		id="uploadUserProjectDataType" name="uploadUserProjectDataType">
		<option value="0">--请选择--</option>
		<option value="0">部门1</option>
		<option value="0">部门2</option>
		<option value="0">部门3</option>
	</select></li>
	<li class="width200Li"><label>员工名:</label> <input
		class="width100Input" name="projectBean.deptName" id="deptName" /></li>
	<li><input type="button" id="searchProject" class="mediumButton"
		style="float: right" onclick="displayResult();" class="button"
		value="查询"></li>
</ul>

</div>
<div class="searchResult" id="searchResult" style="display: none">
<ul class="fullScreenUl">
	<li class="width100Li"><label>部门</label></li>
	<li class="width200Li"><label>姓名</label></li>
	<li class="width200Li"><label>职务</label></li>
	<li class="width100Li"><label>手机号</label></li>
	<li class="width100Li"><label>职业资质</label></li>
</ul>
<ul class="fullScreenUl">
	<li class="width100Li"><label>部门1</label></li>
	<li class="width200Li"><label>高志峰</label></li>
	<li class="width200Li"><label>经理</label></li>
	<li class="width100Li"><label>1293405966</label></li>
	<li class="width100Li"><label>造价工程师</label></li>
</ul>
<ul class="fullScreenUl">
	<li class="width100Li"><label>部门2</label></li>
	<li class="width200Li"><label>杨祚</label></li>
	<li class="width200Li"><label>副经理</label></li>
	<li class="width100Li"><label>13033405966</label></li>
	<li class="width100Li"><label>造价工程师</label></li>
</ul>

</div>
<div></div>


</div>


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function displayResult(){
		document.getElementById("searchResult").style.display="block";
	}

</script>
</html>
