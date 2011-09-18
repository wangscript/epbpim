<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>电子杂志导入</title>
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type="text/javascript">
	function checkError() {
		var msg = "<s:property value='msg'/>";
		if (msg) {
			alert(msg);
		}
	}
	function chooseFile() {
		var uploadFile = $('uploadFile');
		var filePath = uploadFile.value;
		var fileName = filePath.substring(filePath.lastIndexOf('\\') + 1,
				filePath.length);
		document.getElementById('periodicalFile.periodicalName').value = fileName;
	}
</script>
<style>
.WithBreaks {
	word-wrap: break-word;
}
</style>
</head>
<body onload="checkError();">
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">电子杂志导入:</h4>
					<div class="entry">
						<s:form action="importPeriodicalFile.do" method="post" id="importPeriodicalFileForm" enctype="multipart/form-data">
							<ul class="fullScreenUl">
								<li class="width100Li">省份：</li>
								<li class="width200Li"><select
									id="periodicalFile.periodicalProvice"
									name="periodicalFile.periodicalProvice" class="width150Select">
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
								</select></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">专业：</li>
								<li class="width200Li"><select
									id="periodicalFile.periodicalType"
									name="periodicalFile.periodicalType" class="width150Select">
										<option value="土建">土建</option>
										<option value="市政">市政</option>
								</select></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">时间：</li>
								<li class="width100Li"><input class="Wdate width100Input"
									id="periodicalFile.periodicalDatePage"
									name="periodicalFile.periodicalDatePage"
									onclick="WdatePicker({dateFmt:'yyyy-MM'})" /></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">文件：</li>
								<li class="width300Li"><s:file name="uploadFile" cssClass="width300Input"
										id="uploadFile" size="40" onchange="chooseFile()" /> <input
									type="hidden" name="periodicalFile.periodicalName"
									id="periodicalFile.periodicalName"></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><input type="submit" class="button" value="上传">
								</li>
							</ul>

						</s:form>
					</div>
					<div class="clr"></div>
				</div>
			</div>
			<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
</html>