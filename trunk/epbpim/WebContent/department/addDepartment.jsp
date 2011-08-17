<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="Department.AddDepartment" /></title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<script type='text/javascript' src='../js/common.js'></script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<s:form action="saveDepartment.do" method="post">
						<h3 class="title"><s:text name="Department.AddDepartment" /></h3>
						<div id="addDepartmentTable">
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width4Lb"><s:text name="Department.DepartmentName" />:</label>
								<input class="width100Input" name="name" id="name" /></li>
								<li class="width600Li"><label class="width4Lb"><s:text name="Department.DepartmentDesc" />:</label>
								<input class="width150Input" name="desc" id="desc" /></li>
							</ul>
						
							<ul class="fullScreenUl">
							</ul>
							<ul class="fullScreenUl">
								<li><input type="submit" id="addDepartment"
									class="mediumLeftButton" value="<s:text name="Common.Save" />">
								</li>
							</ul>
						</div>
						<div></div>
					</s:form>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script language="JavaScript">

</script>

</html>
