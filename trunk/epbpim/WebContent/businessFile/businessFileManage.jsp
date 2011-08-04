<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>业务文件管理</title>
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
<h3 class="title">业务文件管理</h3>
<div id="searchCondition">
<ul class="fullScreenUl">
	<li class="width200Li"><label>文件类别：</label><select
		id="uploadUserProjectDataType" name="uploadUserProjectDataType">
		<option value="0">--请选择--</option>
		<option value="0">董事会文件</option>
		<option value="0">财税文件</option>
		<option value="0">工商文件</option>
	</select></li>
	<li class="width200Li"><label>文件名:</label> <input
		class="width100Input" name="projectBean.deptName" id="deptName" /></li>
	<li><input type="button" id="searchProject" class="mediumButton"
		style="float: right" onclick="displayResult();" class="button"
		value="查询"></li>
</ul>

</div>
<div class="searchResult" id="searchResult" style="display: none">
<ul class="fullScreenUl">
	<li class="width600Li"><label>文件名</label></li>
	<li class="width100Li"><label>公司</label></li>
	<li class="width100Li"><label>文件类别</label></li>
	<li class="width50Li"><label>操作</label></li>
</ul>
<ul class="fullScreenUl">
	<li class="width600Li">《国务院关于预防煤矿生产安全事故的特别规定》[中华人民共和国国务院令 第446号] 2005-09-03</li>
	<li class="width100Li">建惠</li>
	<li class="width100Li">业务技术文件</li>
	<li class="width50Li"><input type="button" class="button"
		value="下载"></li>
</ul>
<ul class="fullScreenUl">
	<li class="width600Li">公共机构节能条例[中华人民共和国国务院令第531号]2008-08-01 2008-10-01</li>
	<li class="width100Li">任远</li>
	<li class="width100Li">业务技术文件</li>
	<li class="width50Li"><input type="button" class="button"
		value="下载"></li>
</ul>
<ul class="fullScreenUl">
	<li class="width600Li">城市房地产开发经营管理条例 [中华人民共和国国务院令 第248号 ] 1988-07-20</li>
	<li class="width100Li">建惠</li>
	<li class="width100Li">业务技术文件</li>
	<li class="width50Li"><input type="button" class="button"
		value="下载"></li>
</ul>
<ul class="fullScreenUl">
	<li class="width600Li">建设工程勘察设计管理条例(中华人民共和国国务院令第293号) 2000-09-25</li>
	<li class="width100Li">建惠</li>
	<li class="width100Li">业务技术文件</li>
	<li class="width50Li"><input type="button" class="button"
		value="下载"></li>
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
