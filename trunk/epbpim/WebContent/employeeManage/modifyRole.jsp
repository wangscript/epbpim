<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>修改职务</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<form >
						<h3 class="title">修改职务</h3>
						<div id="addRoleTable">
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width4Lb">职务名称:</label><input
									class="width100Input" name="projectBean.number" id="projectNum" />
								</li>
								<li class="width300Li"><label class="width9Lb">该职务用户最大数量:</label><input
									class="width150Input" name="projectBean.number" id="projectNum" />
								</li>
								<li class="width400Li"><label class="width4Lb">职务说明:</label><input
									class="width300Input" name="projectBean.number" id="projectNum" />
								</li>
							</ul>
							<ul class="barUl">
								<li id="leftBar">
									<h4>权限列表:</h4> <select name="possible" MULTIPLE
									class="multiSelect" id="fromList">
										<option value="1">营业执照
										<option value="2">税务登记执照
										<option value="3">ISO文件查询
										<option value="4">典型工程查询
										<option value="5">ISO文件上传
								</select>
								</li>
								<li id="linkLi"><input type="button" id="addProject"
									class="mediumLeftButton"
									onclick="copyToList('possible','chosen')" value="增加"><br>
								<br>
								<br> <input type="button" id="addProject"
									class="mediumLeftButton"
									onclick="copyToList('chosen','possible')" value="移除"></li>

								<li id="rightBar">
									<h4>已选择权限:</h4> <select MULTIPLE class="multiSelect"  name="chosen" 
									id="toList">
								</select></li>
							</ul>
							<ul class="fullScreenUl">
								<li><input type="button" id="addProject"
									class="mediumLeftButton"
									onclick="window.location.href='../main/main.jsp'" value="保存">
								</li>
							</ul>
						</div>
						<div></div>

					</form>
				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script language="JavaScript">
	function copyToList(from, to) {
		fromList = eval('document.forms[0].' + from);
		toList = eval('document.forms[0].' + to);
		if (toList.options.length > 0 && toList.options[0].value == 'temp') {
			toList.options.length = 0;
		}
		var sel = false;
		for (i = 0; i < fromList.options.length; i++) {
			var current = fromList.options[i];
			if (current.selected) {
				sel = true;
				if (current.value == 'temp') {
					alert('你不能选择这个项目!');
					return;
				}
				txt = current.text;
				val = current.value;
				toList.options[toList.length] = new Option(txt, val);
				fromList.options[i] = null;
				i--;
			}
		}
		if (!sel)
			alert('你还没有选择任何项目');
	}
	
</script>

</html>
