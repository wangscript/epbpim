<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>价格包上传</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/admin.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="javascript" type="text/javascript"
	src="../js/common.js"></script>
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">价格包上传</h4>
					<div id="">
						<s:form action="uploadPricePackageFile.do"
							enctype="multipart/form-data" method="post">
							<ul class="fullScreenUl">
								<li class="width100Li">省份：</li>
								<li class="width200Li">
									<s:select cssClass="width150Select" id="pricePackageFile.pricePackageProvice" name="pricePackageFile.pricePackageProvice"
										list="provinceCities" listKey="id" listValue="city" multiple="false" required="true" onchange="" headerKey="0" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">专业：</li>
								<li class="width200Li"><select
									id="pricePackageFile.pricePackageType"
									name="pricePackageFile.pricePackageType" style="width: 150px;">
										<option value="土建">土建</option>
										<option value="市政">市政</option>
								</select></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">时间：</li>
								<li class="width200Li"><input class="Wdate width100Input"
									id="pricePackageFile.pricePackageDatePage"
									name="pricePackageFile.pricePackageDatePage"
									onclick="WdatePicker({dateFmt:'yyyy-MM'})" /></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">价格包：</li>
								<li class="width200Li"><s:file name="uploadFile"
										cssClass="width300Input" id="uploadFile"
										onchange="chooseFile()" /> <input type="hidden"
									name="pricePackageFile.pricePackageName"
									id="pricePackageFile.pricePackageName"></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><input type="submit" class="button"
									value="上传"></li>
							</ul>
						</s:form>
					</div>
				</div>
				<!-- end #content -->
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" />
	</div>

</body>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/MessageService.js'></script>
<script type="text/javascript">
	function chooseFile() {
		var uploadFile = $('uploadFile');
		var filePath = uploadFile.value;
		var fileName = filePath.substring(filePath.lastIndexOf('\\') + 1,
				filePath.length);
		document.getElementById('pricePackageFile.pricePackageName').value = fileName;
	}
</script>
</html>