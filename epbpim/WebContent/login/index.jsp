<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="Product.Name" /></title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/index.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script language="JavaScript">
function getFocus()
{
    document.getElementById("idInput").focus();
}
</script>
</head>
<body onload="getFocus();">
<div id="main"><jsp:include page="indexHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar"><s:form action="login.do" name="login"
	method="post" id="loginForm">
	<h2 class="title"><s:text name="Index.UserLogin" /></h2> 
	<div id= "loginbar">
	<ul>
		<li><label><s:text name="Index.UserName" /></label></li>
		<li><input name="userName" maxlength="10" id="idInput" tabindex="1"></li>
	</ul>
	<ul>
		<li><label><s:text name="Index.Password" /></label></li>
		<li><input type="password" name="password" tabindex="2" tabindex="2"></li>
	</ul>
	
	<s:fielderror theme="Struts">
		<ul>
			<li><input type="submit" class="button" style="width:70px" value="<s:text name="Index.Login" />"></li>
		</ul>
		<s:param>name</s:param>
	</s:fielderror>
	</div>
</s:form></div>

<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">

function toRegister(){
	window.location.href = "../login/register.jsp";
}
function reloadIMG()
{	
	var randNumImg = document.getElementById("randNumIMG");
	randNumImg.src = "${pageContext.request.contextPath}/image.jsp?" + Math.random();
}
</script>
</html>
