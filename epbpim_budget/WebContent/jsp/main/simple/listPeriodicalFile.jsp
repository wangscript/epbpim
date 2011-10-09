<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>电子杂志查询</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
<script type="text/javascript">
	function searchFile(id)
	{
		document.getElementById(id).submit();
	}
</script>
</head>
<body>
<div id="main"><jsp:include page="../mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">电子杂志查询：</h3>
<!--
<div id="searchCondition">
	<s:form id="searchFileForm" action="searchPeriodicalFile.do" method="post">
		<ul class="fullScreenUl">
			<li class="width300Li"><label class="lb">省份：</label>
				<select id="periodicalFileFile.periodicalFileProvice" name="periodicalFileFile.periodicalProvice" style="width: 150px;">
					<option value="北京市">北京市</option>
					<option value="上海市" selected="selected">上海市</option>
					<option value="天津市">天津市</option>
					<option value="重庆市">重庆市</option>
					<option value="河北省">河北省</option>
					<option value="山西省">山西省</option>
					<option value="内蒙古自治区">内蒙古自治区</option>
					<option value="辽宁省">辽宁省</option>
					<option value="吉林省">吉林省</option>
					<option value="黑龙江省">黑龙江省</option>
					<option value="江苏省">江苏省</option>
					<option value="浙江省">浙江省</option>
					<option value="安徽省">安徽省</option>
					<option value="福建省">福建省</option>
					<option value="江西省">江西省</option>
					<option value="山东省">山东省</option>
					<option value="河南省">河南省</option>
					<option value="湖北省">湖北省</option>
					<option value="湖南省">湖南省</option>
					<option value="广东省">广东省</option>
					<option value="广西壮族自治区">广西壮族自治区</option>
					<option value="海南省">海南省</option>
					<option value="四川省">四川省</option>
					<option value="贵州省">贵州省</option>
					<option value="云南省">云南省</option>
					<option value="西藏自治区">西藏自治区</option>
					<option value="陕西省">陕西省</option>
					<option value="甘肃省">甘肃省</option>
					<option value="宁夏回族自治区">宁夏回族自治区</option>
					<option value="青海省">青海省</option>
					<option value="新疆维吾尔族自治区">新疆维吾尔族自治区</option>
					<option value="香港特别行政区">香港特别行政区</option>
					<option value="澳门特别行政区">澳门特别行政区</option>
					<option value="台湾省">台湾省</option>
					<option value="其它">其它</option>
				</select>
			</li>
			<li class="width300Li"><label class="lb">专业：</label>
				<select id="periodicalFileFile.periodicalFileType" name="periodicalFileFile.periodicalFileType" style="width: 150px;">
					<option value="土建">土建</option>
					<option value="市政">市政</option>
				</select>							  
			</li>
			<li class="width300Li"><label class="lb">时间：</label>
				<input class="Wdate width100Input" id="periodicalFileFile.periodicalFileDate" name="periodicalFileFile.periodicalFileDate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
			</li>
			<li>
				<input type="submit" class="mediumButton" style="float: right" class="button" onclick="searchFileList()" value="查询">
			</li>
		</ul>
	</s:form>
</div>
-->

<s:if test="datas==null || datas.size()==0">
	<tr>
		<td>
		<h3><s:text name="Common.Nodata" /></h3>
		</td>
	</tr>
</s:if>
<s:else>
	<div class="searchResult" id="searchResult">
		<ul class="fullScreenUl">
			<li class="width200Li"><label><s:text name="名称" /></label></li>
			<li class="width200Li"><label><s:text name="省份" /></label></li>
			<li class="width200Li"><label><s:text name="专业" /></label></li>
			<li class="width200Li"><label><s:text name="时间" /></label></li>
			<li class="width50Li"><label><s:text name="浏览" /></label></li>
		</ul>
		<s:iterator value="datas" status="st">
			<ul class="fullScreenUl">
				<li class="width200Li"><s:property value="periodicalName" /></li>
				<li class="width200Li"><s:property value="periodicalProvice" /></li>
				<li class="width200Li"><s:property value="periodicalType" /></li>
				<li class="width200Li"><s:date name="periodicalDate" format="yyyy-MM" /></li>
				<li class="width50Li">
					<form action="viewPeriodicalFile.do" method="post" id='searchfile<s:property value="id" />'>
						<input type="hidden" name="periodicalFile.id" value='<s:property value="id" />' />
						<input type="button" onclick='searchFile("searchfile"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name='预览' />">
					</form>
				</li>
			</ul>
		</s:iterator>
		<ul>
			<jsp:include page="../../common/pagination.jsp" flush="true">
				<jsp:param name="action_page" value="main/searchPeriodicalFile.do"/>
			</jsp:include>
		</ul>
	</div>
</s:else>
<div>
</div>
</div>
<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>
