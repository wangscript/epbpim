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
	<s:form action="queryBusinessFileList.do" method="post">
		<input type="hidden" name="businessFile.fileModule" id="businessFile.fileModule">
		<ul class="fullScreenUl">
			<li class="width200Li">
				<label>文件类别：</label>
				<select id="businessFile.fileType" name="businessFile.fileType">
					<option value="0">--请选择--</option>
					<option value="1">董事会文件</option>
					<option value="2">财税文件</option>
					<option value="3">工商文件</option>
				</select>
			</li>
			<li class="width200Li">
				<label>文件名:</label>
				<input type="text" class="" name="businessFile.fileName" id="businessFile.fileName" />
			</li>
			<li>
				<input type="submit" class="mediumButton" style="float: right" class="button" value="查询">
			</li>
		</ul>
	</s:form>
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

</div>
<div></div>
</div>
<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">

</script>
</html>
