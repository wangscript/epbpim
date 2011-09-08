<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.bpim.user.enums.UserStatusEnum"%>
<%@ page import="com.ryxx.bpim.user.enums.CertificationTypeEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>员工查询</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
<script type="text/javascript">
function clearPage(updateId){
	var ps = document.getElementById("ps");
	var pn = document.getElementById("pn");
	if(ps != null) {
		ps.options[1].selected = true;
	}
	if(pn != null) {
		pn.options[0].selected = true;
	}
}
</script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">员工查询</h3>
					<div id="searchCondition">
					<s:form>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width2Lb">部门:</label>
								<s:select name="userInfo.deptId" list="userInfo.depts"
									listKey="id" listValue="name" multiple="false"
									required="true" onchange="" headerKey="0"
									headerValue="--------请选择-------" />
							</li>
							<li class="width200Li"><label class="width4Lb">员工编号:</label>
								<input class="width100Input" name="userInfo.identity"
								id="userInfo.identity" /></li>
							<li class="width200Li"><label class="width3Lb">姓名:</label>
								<input class="width100Input" name="userInfo.realName"
								id="userInfo.realName" /></li>
								
							<li class="width250Li"><label class="width2Lb">状态:</label>
								<%
									UserStatusEnum[] userStatus = UserStatusEnum.values();
									request.setAttribute("userStatus", userStatus);
								%>
								<select id="status" name="status">
									<s:iterator value="#request.userStatus" status="st">
										<option value="<s:property value='key'/>"><s:property value='value'/></option>
									</s:iterator>
								</select>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width2Lb">职务:</label>
							<s:select name="userInfo.roleId" list="userInfo.roles"
									listKey="id" listValue="name" multiple="false"
									required="true" onchange="" headerKey="0"
									headerValue="--------请选择-------" />
							</li>
							
							<li class="width200Li"><label class="width4Lb">执业资格:</label>
								<%
									CertificationTypeEnum[] certifiTypes = CertificationTypeEnum.values();
									request.setAttribute("certifiTypes", certifiTypes);
								%>
								<select id="certifies[0].selectId" name="certifies[0].selectId">
									<s:iterator value="#request.certifiTypes" status="st">
										<option value="<s:property value='key'/>"><s:property value='value'/></option>
									</s:iterator>
								</select>
							</li>
							<li><input type="submit" id="searchProject"
								class="mediumRightButton"
								class="button" value="查询"></li>
						</ul>
						</s:form>
					</div>
					<div class="searchResult" id="searchResult">
						<ul class="fullScreenUl">
							<li class="width150Li"><label>部门</label></li>
							<li class="width50Li"><label>姓名</label></li>
							<li class="width200Li"><label>职务</label></li>
							<li class="width50Li"><label>手机号</label></li>
							<li class="width300Li"><label>职业资质</label></li>
							<li class="width50Li"><label>修改</label></li>
							<li class="width50Li"><label>删除</label></li>
						</ul>
						<s:iterator value="userInfos" status="st">
							<ul class="fullScreenUl">
								<li class="width150Li">
									<label>
										<s:iterator value="depts" status="depindx">
											<s:property value="name" />
											<s:if test="!#depindx.last"><br/></s:if>
										</s:iterator>
									</label>
								</li>
								<li class="width50Li"><label><s:property value="realName" /></label></li>
								<li class="width200Li">
									<label>
										<s:iterator value="roles" status="rolindx">
											<s:property value="name" />
											<s:if test="!#rolindx.last"><br/></s:if>
										</s:iterator>
									</label>
								</li>
								<li class="width50Li"><label><s:property value="mobilePhone" /></label></li>
								<li class="width300Li">
									<label>
										<s:iterator value="certifies" status="certindx">
											<s:property value="typeId.value" />
											<s:if test="!#certindx.last"><br/></s:if>
										</s:iterator>
									</label>
								</li>
								<li class="width50Li">
									<form action="showUser.do" id='showUser<s:property value="id"/>' method="post">
										<input type="submit" id="searchProject" class="mediumRightButton" class="button" value="修改"><s:hidden name="id" />
									</form>
								</li>
									<li class="width50Li"><input type="button" id="searchProject"
									class="mediumRightButton" onclick="displayResult();"
									class="button" value="删除"></li>
							</ul>
						</s:iterator>
						<ul class="fullScreenUl">
							<jsp:include page="../common/pagination.jsp" flush="true">
								<jsp:param name="action_page" value="employeeManage/listUserInfo.do" />
							</jsp:include>
						</ul>
					</div>
					<div></div>


				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function displayResult(){
		document.getElementById("searchResult").style.display="block";
	}

</script>
</html>
