<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String username = (String) session
			.getAttribute(Constants.LOGIN_USER_NAME);
	if (StringUtils.isEmpty(username)) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建设工程综合信息管理系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
</head>
<body>
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<div class="entry"><s:if
	test="newsAnnounces!=null && newsAnnounces.size()!=0">
	<h3 class="title">最新公告</h3>
	<table style="width:900px">
		<s:iterator value="newsAnnounces" status="st">
			<s:if test="#st.index<3">
				<tr>
					<td align="left"><s:hidden name="id" /><h3><s:property value="newsTitle" /></h3></td>
				</tr>
				<tr>
					<td align="left"><s:date name="addTimeTemp" format="yyyy-MM-dd" /><s:hidden
						name="addTime" /></td>
				</tr>
				<tr>
					<td align="left" style="text-align:left"><s:property value="content"/></td>
				</tr>
			</s:if>
		</s:iterator>
	</table>
</s:if></div>
</div>


</div>
<!-- end #content -->


<div class="clr"></div>
</div>

<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>
</html>