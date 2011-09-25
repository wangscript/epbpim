<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>找回密码</title>

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
<div class="mainbar"><s:form action="sendPassword.do" 
	method="post" >
	<h2 class="title">找回密码</h2> 
	<div id= "loginbar">
	<ul class="fullScreenNoMarginUl">
		<li class="width50Li"><label><s:text name="Index.UserName" /></label></li>
		<li class="width150Li"><input class="width150Input" name="identifier" maxlength="10" id="idInput" tabindex="1"></li>
	</ul>
	<s:fielderror theme="Struts">
		<ul class="fullScreenNoMarginUl">
			<li><input type="submit" class="button"  value="找回密码"></li>
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
</script>
</html>
