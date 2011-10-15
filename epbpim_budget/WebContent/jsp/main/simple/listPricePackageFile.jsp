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
<script type="text/javascript">
	function downloadFile(id)
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
<h3 class="title">价格包下载</h3> 
<s:if test="dates==null || dates.size()==0">
	<tr>
		<td>
		<h3><s:text name="Common.Nodata" /></h3>
		</td>
	</tr>
</s:if>
<s:else>
	<div class="searchResult" id="searchResult">
		<ul class="fullScreenResultUl">
			<li class="width400Li"><s:text name="文件名" /></li>
			<li class="width200Li"><s:text name="专业" /></li>
			<li class="width200Li"><s:text name="时间" /></li>
			<li class="width50Li"><s:text name="下载" /></li>
		</ul>
		<s:iterator value="dates" status="st">
			<ul class="fullScreenResultUl">
				<li class="width400Li"><s:property value="pricePackageName" /></li>
				<li class="width200Li"><s:property value="major.name" /></li>
				<li class="width200Li"><s:date name="pricePackageDate" format="yyyy-MM" /></li>
				<li class="width50Li">
					<form action="downloadPricePackageFile.do" method="post" id='downloadFile<s:property value="id" />'>
						<input type="hidden" name="pricePackageFile.pricePackagePath" value='<s:property value='pricePackagePath' />' />
						<input type="hidden" name="pricePackageFile.pricePackageName" value='<s:property value="pricePackageName" />' />						
						<input type="button" onclick='downloadFile("downloadFile"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name='下载' />">
					</form>
					<a href=""></a>
				</li>
			</ul>
		</s:iterator>
		<ul class="fullScreenResultUl">
			<s:form>
				<jsp:include page="../../common/pagination.jsp" flush="true">
					<jsp:param name="action_page" value="main/searchPricePackageFile.do"/>
				</jsp:include>
			</s:form>
		</ul>
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
