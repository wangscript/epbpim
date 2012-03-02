<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ryxx.test.LineXYChart"%>
<%@ page import = "java.io.PrintWriter" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
LineXYChart xyChart=new LineXYChart();
String fileName=xyChart.getLineXYChart(session,new PrintWriter(out));
String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
%>
<html>
</head>
<title> JFreeChart使用例子</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
<img src="<%= graphURL %>" width=500 height=300 border=0 usemap="<%= fileName %>">
</body>
</html> 