<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待办事项</title>
</head>
<body>
<div id="main"><jsp:include page="../mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">待办事项</h3>
<div id="messageMain">
<ul class="fullScreenUl">
	<li class="width100Li">状态</li>
	<li class="width100Li">收到时间</li>
	<li class="width600Li">工作内容</li>
	<li class="width100Li">处理</li>
</ul>
<ul class="fullScreenUl">
	<li class="width100Li">未处理</li>
	<li class="width100Li">2011-07-30</li>
	<li class="width600Li">废水治理及清洁生产、铬回收项目需要审批</li>
	<li class="width100Li"><input type="button" id="searchProject"
		class="mediumButton"
		onclick="window.location.href='../projectManage/projectDetail.jsp'"
		class="button" value="前去处理"></li>
</ul>


</div>
</div>

<!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../../common/footer.jsp" /></div>

</body>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/MessageService.js'></script>
<script type="text/javascript">

</script>
</html>