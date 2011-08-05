<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务文件上传</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<script language="javascript" type="text/javascript"
	src="../js/common.js"></script>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
</head>
<body>
<div id="main"><jsp:include page="../main/mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">业务文件上传</h3>
<div id="">
<ul class="fullScreenUl">
	<li class="width200Li"><label>文件类别：</label><select
		id="uploadUserProjectDataType" name="uploadUserProjectDataType">
		<option value="0">--请选择--</option>
	</select></li>
</ul>
<ul class="fullScreenUl">
	<li><s:file name="uploadUserProjectData"
		id="uploadUserProjectDataFile"
		onchange="getObject('uploadUserProjectDataInput').value=this.value" />
	<input type="text" class="file" name="uploadUserProjectDataInput"
		style="display: none" id="uploadUserProjectDataInput"> <!-- <input type="button" value="选择" class="button"
		onClick="getObject('uploadUserProjectDataFile').click()"> --></li>
	<li><input type="button"
		onclick="upload('uploadUserProjectData');" class="button"
		style="width: 70px;" value="上传"></li>
</ul>


</div>
</div>

<!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/MessageService.js'></script>
<script type="text/javascript">

</script>
</html>