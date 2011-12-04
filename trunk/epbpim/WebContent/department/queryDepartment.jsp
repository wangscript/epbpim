<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title><s:text name="Department.QueryDepartment" /></title>
	<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
	<link href="../images/logo.ico" rel="SHORTCUT ICON" />
	<script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title"><s:text name="Department.QueryDepartment" /></h3>
					<form id="queryForm" action="schAdminDeptList.do" method="post">
						<div id="searchCondition">
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width4Lb"><s:text name="Department.DepartmentName" />:</label>
									<input class="width100Input" name="adminDept.name" id="adminDept.name" value='<s:property value="adminDept.name"/>'/>
								</li>
								<li class="width100Li"><input type="submit" id="searchDept" class="mediumRightButton" value="<s:text name="Common.Query" />">
								</li>
							</ul>
						</div>
					</form>
					
					<s:if test="adminDeptList==null || adminDeptList.size()==0">
						<tr>
							<td>
							<h3><s:text name="Common.Nodata" /></h3>
							</td>
						</tr>
					</s:if>
					<s:else>
						<div class="searchResult" id="searchResult">
							<ul class="fullScreenUl">
								<li class="width100Li"><label>部门名称</label>
								</li>
								<li class="width600Li"><label>部门说明</label>
								</li>
								<li class="width50Li"><label><s:text name="Common.Update" /></label>
								</li>
								<li class="width50Li"><label><s:text name="Common.Delete" /></label>
								</li>
							</ul>
							<s:iterator value="adminDeptList" status="st">
								<ul class="fullScreenUl">
									<li class="width100Li"><s:property value="name" /></li>
									<li class="width600Li"><s:property value="remark" /></li>
									<li class="width50Li">
										<form action="preModAdminDept.do" method="post" id='preModDept<s:property value="id" />'>
											<input type="hidden" name="adminDept.id" value='<s:property value="id" />' />
											<input type="button" onclick='preModDept("preModDept"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name="Common.Update" />">
										</form>
									</li>
									<li class="width50Li">
										<form action="delAdminDept.do" method="post" id='deleteDept<s:property value="id" />'>
											<input type="hidden" name="adminDept.id" value='<s:property value="id" />' />
											<input type="button" onclick='deleteDept("deleteDept"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name="Common.Delete" />">
										</form>
									</li>
								</ul>
							</s:iterator>
							<ul class="fullScreenUl">
								<s:form id="paginationForm">
									<jsp:include page="../common/pagination.jsp" flush="true">
										<jsp:param name="action_page" value="department/schAdminDeptList.do" />
									</jsp:include>
								</s:form>
							</ul>
						</div>
					</s:else>
				<div class="clr"></div>
			</div>
		</div>
	</div>
	<!-- end #page -->
	<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function deleteDept(id){
		if(confirm('<s:text name="AdminRole.IfDelete" />')){
			document.getElementById(id).submit();
		}
	}
	function preModDept(id){
		document.getElementById(id).submit();
	}	
</script>
</html>
