<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="AdminRole.QueryRole" /></title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title"><s:text name="AdminRole.QueryRole" /></h3>
					<div id="searchCondition">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb"><s:text name="AdminRole.RoleName" />:</label>
								<input class="width100Input" name="projectBean.deptName"
								id="deptName" />
							</li>
							<li><input type="button" id="searchProject"
								class="mediumRightButton" onclick="displayResult();"
								class="button" value="<s:text name="Common.Query" />">
							</li>
						</ul>
					</div>
					
					<s:if test="roleList==null || roleList.size()==0">
						<tr>
							<td>
							<h3><s:text name="Common.Nodata" /></h3>
							</td>
						</tr>
					</s:if>
					<s:else>
						<div class="searchResult" id="searchResult">
							<ul class="fullScreenUl">
								<li class="width100Li"><label><s:text name="AdminRole.RoleName" /></label>
								</li>
								<li class="width200Li"><label><s:text name="AdminRole.RoleCount" /></label>
								</li>
								<li class="width400Li"><label><s:text name="AdminRole.Remark" /></label>
								</li>
								<li class="width50Li"><label><s:text name="Common.Query" /></label>
								</li>
								<li class="width50Li"><label><s:text name="Common.Delete" /></label>
								</li>
							</ul>
							<s:iterator value="roleList" status="st">
								<ul class="fullScreenUl">
									<li class="width100Li"><s:property value="name" /></li>
									<li class="width200Li"><s:property value="roleCount" /></li>
									<li class="width400Li"><s:property value="remark" /></li>
									<li class="width50Li">
										<form action="getRole.do" id='getrole<s:property value="id" />'>
											<input type="button" onclick='getRole("getrole"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name="Common.Query" />"><s:hidden name="id" />
										</form>
									</li>
									<li class="width50Li">
										<form action="deleteRole.do" id='deleterole<s:property value="id" />'>
											<input type="button" onclick='deleteRole("deleterole"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name="Common.Delete" />"><s:hidden name="id" />
										</form>
									</li>
								</ul>
							</s:iterator>
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
	function deleteRole(id){
		if(confirm('<s:text name="AdminRole.IfDelete" />')){
			document.getElementById(id).submit();
		}
	}
	function getRole(id){
		document.getElementById(id).submit();
	}
	function displayResult(){
		document.getElementById("searchResult").style.display="block";
	}

</script>
</html>
