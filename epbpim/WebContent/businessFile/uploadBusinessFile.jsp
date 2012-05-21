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
	<s:form action="addBusinessFile.do" enctype="multipart/form-data" method="post">
		<input type="hidden" name="adminFile.fileModule" id="adminFile.fileModule" value="1">
		<ul class="fullScreenUl">
			<li class="width400Li">
				<table>
					<tr>
						<td><label>文件类别：</label></td>
						<td>
							<div id="moveSpan1" style="position:relative;" >
							<span style="margin-left:147px;width:175px;overflow:hidden;position:relative;" id="devmodelNamespan">
							<select id="devmodelBak" name="mainDevInfo.deviceModelId" style="width:165px;margin-left:-147px;BORDER-LEFT:#9DE4FF 1px solid;BORDER-RIGHT:#9DE4FF 1px solid;FONT-SIZE: 9pt;HEIGHT:21px;"  onchange="fillFileType(this)">
								<option value="">--请选择--</option>
								<option value="董事会文件">董事会文件</option>
								<option value="财税文件">财税文件</option>
								<option value="工商文件">工商文件</option>
				     			<s:iterator id="model" value="#request.mainDevInfo" status="stats">
				         			<option value="${model.deviceModelId }"><s:property value="#model.deviceModelName"/></option>
								</s:iterator>
							</select>
							</span>
							<input id="adminFile.fileType" name="adminFile.fileType" type="text" style="width:142px;position:absolute;left:0px;BORDER-RIGHT:#9DE4FF 1px solid;FONT-SIZE: 9pt;HEIGHT:15px;color: #cdcdcd;" value="<s:text name='请输入文件类别'/>"
									onclick="clearValue(this)" onblur="setValue(this)" maxlength="50"/>
							</div>
						</td>
					</tr>
				</table>								  
			</li>
			<li class="width300Li">
				<s:file name="uploadFile" id="uploadFile" size="30" onchange="chooseFile()" />
				<input type="hidden" name="adminFile.fileName" id="adminFile.fileName">
			</li>
		</ul>	
		<ul class="fullScreenUl">	
			<li class="width200Li">
				<input type="submit" class="button" style="width: 70px;" value="上传" onclick="return checkParam();">
			</li>
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
function chooseFile()
{
	var uploadFile = $('uploadFile');
	var filePath=uploadFile.value;
    var fileName=filePath.substring(filePath.lastIndexOf('\\')+1,filePath.length);
    document.getElementById('adminFile.fileName').value=fileName;
}
function checkParam()
{
	var obj=document.getElementById("adminFile.fileType");
	if(obj.value==''||obj.value=="<s:text name='请输入文件类别'/>")
    {
		alert("请输入文件类别！");
		return false;
    }
	if(!document.getElementById('adminFile.fileName').value)
    {
		alert("请选择文件！");
		return false;
    }	
}

function fillFileType(obj)
{
	document.getElementById("adminFile.fileType").value= obj.options[obj.selectedIndex].value;
	setValue(document.getElementById("adminFile.fileType"));
}

function clearValue(obj)
{
	if(obj.style.color=="#cdcdcd")
	{
		obj.value="";
		obj.style.color="";
	}				   
}
//set input value when input is logindomain
function setValue(obj)
{
   if(obj.value!=""&&obj.value!="<s:text name='请输入文件类别'/>")
   {
       obj.style.color="";
   }
   else if(obj.value==''||obj.value=="<s:text name='请输入文件类别'/>")
   {
       obj.value="<s:text name='请输入文件类别'/>";
       obj.style.color="#cdcdcd";
   }
}
</script>
</html>