<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Long userId = (Long)session.getAttribute(Constants.LOGIN_USER_ID);
%>
<script type="text/javascript">
	if(<%=userId%>==null||<%=userId%>==""||<%=userId%>==0){
	var index = "<%=request.getContextPath()%>"+"/index.jsp";
	window.location.href = index;
	}
</script>