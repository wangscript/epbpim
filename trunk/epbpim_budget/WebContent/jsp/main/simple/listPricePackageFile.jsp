<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>价格包下载</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
</head>
<body onload="setValue()">
<div id="main"><jsp:include page="../mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">价格包下载</h3>
<div id="searchCondition">
	<s:form id="searchFileForm" action="schBusinessFileList.do" method="post">
		<input type="hidden" name="pricePackageFile.fileModule" id="pricePackageFile.fileModule" value="1">
		<ul class="fullScreenUl">
			<li class="width300Li"><label class="lb">省：</label>
				<select id="pricePackageFile.pricePackageProvice" name="pricePackageFile.provice" style="width: 150px;">
					<option value="0">---------请选择---------</option>
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
				<select id="pricePackageFile.pricePackageType" name="pricePackageFile.pricePackageType" style="width: 150px;">
					<option value="">--请选择--</option>
					<option value="董事会文件">土建</option>
					<option value="财税文件">市政</option>
				</select>							  
			</li>
			<li class="width300Li"><label class="lb">时间：</label>
				<input class="Wdate width100Input" id="pricePackageFile.pricePackageDate" name="pricePackageFile.pricePackageDate" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
			</li>
			<li>
				<input type="submit" class="mediumButton" style="float: right" class="button" onclick="searchFileList()" value="查询">
			</li>
		</ul>
	</s:form>
</div>

<s:if test="pricePackageFileList==null || pricePackageFileList.size()==0">
	<tr>
		<td>
		<h3><s:text name="Common.Nodata" /></h3>
		</td>
	</tr>
</s:if>
<s:else>
	<div class="searchResult" id="searchResult">
		<ul class="fullScreenUl">
			<li class="width200Li"><label><s:text name="文件名" /></label></li>
			<li class="width200Li"><label><s:text name="省" /></label></li>
			<li class="width200Li"><label><s:text name="专业" /></label></li>
			<li class="width200Li"><label><s:text name="时间" /></label></li>
			<li class="width50Li"><label><s:text name="下载" /></label></li>
		</ul>
		<s:iterator value="pricePackageFileList" status="st">
			<ul class="fullScreenUl">
				<li class="width200Li"><s:property value="pricePackageName" /></li>
				<li class="width200Li"><s:property value="pricePackageProvice" /></li>
				<li class="width200Li"><s:property value="pricePackageType" /></li>
				<li class="width200Li"><s:date name="pricePackageDate" format="yyyy-MM" /></li>
				<li class="width50Li">
					<a href="<s:property value='pricePackagePath' />"><input type="button" onclick="this.parentNode.click();" class="mediumRightButton" class="button" value="<s:text name='下载' />"></a>
				</li>
			</ul>
		</s:iterator>
	</div>
</s:else>

<div></div>
</div>
<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>
