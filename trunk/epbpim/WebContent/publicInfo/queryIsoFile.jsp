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
<body onload="setValue()">
<div id="main"><jsp:include page="../main/mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">业务文件管理</h3>
<div id="searchCondition">
	<s:form id="searchFileForm" action="schIsoList.do" method="post">
		<input type="hidden" name="adminFile.fileModule" id="adminFile.fileModule" value="2">
		<ul class="fullScreenUl">
			<li class="width200Li">
				<label>文件名:</label>
				<input type="text" class="" name="adminFile.fileName" id="adminFile.fileName" value="<s:property value='adminFile.fileName' />"/>
			</li>
			<li>
				<input type="submit" class="mediumButton" style="float: right" class="button" onclick="searchFileList()" value="查询">
			</li>
		</ul>
	</s:form>
</div>

<s:if test="adminFileList==null || adminFileList.size()==0">
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
			<li class="width200Li"><label><s:text name="文件类型" /></label></li>
			<li class="width200Li"><label><s:text name="上传时间" /></label></li>
			<li class="width50Li"><label><s:text name="预览" /></label></li>
			<li class="width50Li"><label><s:text name="下载" /></label></li>
			<li class="width50Li"><label><s:text name="删除" /></label></li>
		</ul>
		<s:iterator value="adminFileList" status="st">
			<ul class="fullScreenUl">
				<li class="width200Li"><s:property value="fileName" /></li>
				<li class="width200Li"><s:property value="fileType" /></li>
				<li class="width200Li"><s:date name="uploadDate" format="yyyy-MM-dd hh:mm:ss" /></li>
				<li class="width50Li">
					<form action="schBusinessFile.do" method="post" id='searchfile<s:property value="id" />'>
						<input type="hidden" name="adminFile.id" value='<s:property value="id" />' />
						<input type="button" onclick='searchFile("searchfile"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name='预览' />">
					</form>
				</li>
				<li class="width50Li">
					<a href="<s:property value='filePath' />"><input type="button" onclick="this.parentNode.click();" class="mediumRightButton" class="button" value="<s:text name='下载' />"></a>
				</li>
				<li class="width50Li">
					<form action="delIsoList.do" method="post" id='deletefile<s:property value="id" />'>
						<input type="hidden" name="adminFile.id" value='<s:property value="id" />' />
						<input type="hidden" name="adminFile.fileModule" value="2" />						
						<input type="hidden" name="adminFile.filePath" value='<s:property value="filePath" />' />
						<input type="button" onclick='deleteFile("deletefile"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name='Common.Delete' />">
					</form>
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
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function searchFile(id)
	{
		// document.getElementById(id).submit();
	}
	function deleteFile(id)
	{
		if(confirm('<s:text name="AdminRole.IfDelete" />'))
		{
			document.getElementById(id).submit();
		}
	}
</script>
</html>
