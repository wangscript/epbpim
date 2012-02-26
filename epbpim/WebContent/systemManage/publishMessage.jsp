<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>消息发布</title>
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
					<h3 class="title">消息发布</h3>
					<div id="addMessage">
						<ul class="fullScreenUl">
							<li class="width400Li"><label>消息标题:</label> <input
								class="width300Input" name="projectBean.name" id="projectName" />
							</li>
						</ul>
						<ul class="fullScreenUl" style="height: 260px;">
							<li class="width400Li"><label>消息内容:</label> <textarea
									class="width500Input" name="projectBean.name" id="projectName"></textarea>
							</li>

						</ul>
						<ul class="fullScreenUl">
							<li class="width300Li"><s:file name="uploadFile"
									id="uploadFile" size="30" onchange="chooseFile()" /> <input
								type="hidden" name="adminFile.fileName" id="adminFile.fileName">
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width600Li"><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="button"
								value="发布">
							</li>
						</ul>
					</div>

					<div></div>


				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function chooseFile()
	{
		var uploadFile = $('uploadFile');
		var filePath=uploadFile.value;
	    var fileName=filePath.substring(filePath.lastIndexOf('\\')+1,filePath.length);
	    document.getElementById('adminFile.fileName').value=fileName;
	}
</script>
</html>
