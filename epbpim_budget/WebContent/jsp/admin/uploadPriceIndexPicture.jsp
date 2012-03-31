<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>价格指数上传</title>
<script type="text/javascript">
	function checkError() 
	{
		var msg = "<s:property value='msg'/>";
		if (msg) {
			if("true"==msg)
			{
				alert("上传成功！");
			}
			else if("false"==msg)
			{
				alert("出错了，请重试！");
			}
		}
	}
	function chooseFile() 
	{
		var uploadFile = $('uploadFile');
		var filePath = uploadFile.value;
		var fileName = filePath.substring(filePath.lastIndexOf('\\') + 1,
				filePath.length);
		document.getElementById('priceIndexPicture.realName').value = fileName;
	}
</script>
</head>
<body onload="checkError();">
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">价格指数上传</h4>
					<div id="">
						<s:form action="uploadPriceIndexPicture.do" id="uploadBookForm"
							enctype="multipart/form-data" method="post">
							<ul class="fullScreenUl">
								<li class="width100Li">省份：</li>
								<li class="width200Li">
									<s:select cssClass="width150Select" id="priceIndexPicture.provinceCity.id" name="priceIndexPicture.provinceCity.id"
										list="provinceCities" listKey="id" listValue="city" multiple="false" required="true" onchange="" headerKey="0" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">专业：</li>
								<li class="width200Li"><s:select cssClass="width150Select" id="priceIndexPicture.major.id" name="priceIndexPicture.major.id"
										list="majors" listKey="id" listValue="name" multiple="false" required="true" onchange="" headerKey="0" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">时间：</li>
								<li class="width100Li"><input class="Wdate width100Input"
									id="priceIndexPicture.priceIndexPagePage"
									name="priceIndexPicture.priceIndexPagePage"
									onclick="WdatePicker({dateFmt:'yyyy-MM'})" /></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">文件：</li>
								<li class="width300Li"><s:file name="uploadFile" cssClass="width300Input"
										id="uploadFile"  onchange="chooseFile()" /> <input
									type="hidden" name="priceIndexPicture.realName"
									id="priceIndexPicture.realName"></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><input type="button" class="button" onclick="checkAndSubmit()"
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
	<script type="text/javascript">
		function checkAndSubmit(){
			if($("uploadFile").value==null){
				alert("请选择文件");
			}
			else if(!$("uploadFile").value.endWith("swf")&&!$("uploadFile").value.endWith("SWF")){
				alert("请上传swf文件");
			}else{
				$("uploadBookForm").submit();
			}
		}
	</script>

</html>