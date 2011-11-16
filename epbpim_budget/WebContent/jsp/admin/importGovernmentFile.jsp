<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员管理界面</title>
<script type="text/javascript">
	function getObject(id)
	{
		return document.getElementById(id);
	}
	function checkError() 
	{
		var msg = "<s:property value='msg'/>";
		if (msg) {
			if("true"==msg)
			{
				alert("导入成功！");
			}
			else if("false"==msg)
			{
				alert("出错了，请重试！");
			}
			else
			{
				alert("文件格式不对！");
			}
		}
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

					<h4 class="title">法律文件导入:</h4>
					<div class="entry">

						<s:form action="importGovernmentFile.do" method="post"
							name="importGovernmentFileForm" id="importGovernmentFileForm"
							enctype="multipart/form-data">
							<ul class="fullScreenUl">
								<li class="width100Li">文件类别：</li>
								<li class="width200Li"><select id="fileType"
									class="width150Select" name="fileType" onchange="changeType();">
										<option value="法律">法律</option>
										<option value="行政法规">行政法规</option>
										<option value="地方性法规和规章">地方性法规和规章</option>
										<option value="部门规章">部门规章</option>
										<option value="各类文件">各类文件</option>
								</select>
								</li>

								<li class="width300Li" style="display: none" id="fileSubTypeLi">文件小类：<select
									id="fileSubType" name="fileSubType" class="width150Select"
									onchange="changeSubType()">
										<option value="国务院">国务院</option>
										<option value="部委">部委</option>
										<option value="市政府">市政府</option>
										<option value="市建交委及相关部门">市建交委及相关部门</option>
								</select>
								</li>
								<li class="width300Li" style="display: none" id="proviceLi">
									<s:select cssClass="width150Select" id="provice" name="provice"
										list="provinceCities" listKey="id" listValue="city" multiple="false" required="true" onchange="" headerKey="0" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">文件上传：</li>
								<li class="width200Li"><s:file name="importGovernmentFile"
										id="importGovernmentFile" cssClass="width300Input"
										onchange="getObject('importGovernmentFileInput').value=this.value" />
									<input type="text" class="file"
									name="importGovernmentFileInput" style="display: none"
									id="importGovernmentFileInput"> <!-- <input type="button" value="选择" class="button"
		onClick="getObject('uploadUserCustomDataFile').click()"> --></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><input type="button"
									onclick="submit();" class="button" value="上传">
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
<script type="text/javascript">
	function changeType() {
		if (document.getElementById("fileType").value == "各类文件") {
			document.getElementById("fileSubTypeLi").style.display = "BLOCK";
		} else if (document.getElementById("fileType").value == "地方性法规和规章") {
			document.getElementById("proviceLi").style.display = "BLOCK";
		} else {
			document.getElementById("fileSubTypeLi").style.display = "NONE";
			document.getElementById("proviceLi").style.display = "NONE";
		}
	}

	function changeSubType() {
		if (document.getElementById("fileSubType").value == "市建交委及相关部门"
				|| document.getElementById("fileSubType").value == "市政府") {
			document.getElementById("proviceLi").style.display = "BLOCK";
		} else {
			document.getElementById("proviceLi").style.display = "NONE";
		}
	}
</script>
</html>