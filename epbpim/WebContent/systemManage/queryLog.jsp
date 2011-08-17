<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>日志查询</title>
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
					<h3 class="title">日志查询</h3>
					<div id="searchCondition">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">开始时间:</label><input
								class="Wdate width100Input" name="projectBean.startDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
							<li class="width200Li"><label class="width4Lb">结束时间:</label><input
								class="Wdate width100Input" name="projectBean.startDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>

							<li class="width150Li"><label class="width2Lb">类型:</label> <select
								id="projectType" name="projectBean.majorType">
									<option value="0">-----请选择-----</option>
									<option value="无">在职</option>
									<option value="咨询1部">增</option>
									<option value="咨询1部">删</option>
									<option value="咨询1部">改</option>
							</select>
							</li>
							<li class="width200Li"><label class="width3Lb">员工名:</label>
								<input class="width100Input" name="projectBean.deptName"
								id="deptName" /></li>
							<li><input type="button" id="searchProject"
								class="mediumRightButton" onclick="displayResult();"
								class="button" value="查询"></li>
						</ul>
					</div>
					<div class="searchResult" id="searchResult" style="display: none">
						<ul class="fullScreenUl">
							<li class="width100Li"><label>姓名</label></li>
							<li class="width150Li"><label>IP</label></li>
							<li class="width150Li"><label>日期</label></li>
							<li class="width150Li"><label>模块</label></li>
							<li class="width150Li"><label>操作</label></li>
							<li class="width100Li"><label>操作是否成功</label></li>
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
	function displayResult(){
		document.getElementById("searchResult").style.display="block";
	}

</script>
</html>
