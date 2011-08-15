<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>角色查询</title>
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
					<h3 class="title">角色查询</h3>
					<div id="searchCondition">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">角色名称:</label>
								<input class="width100Input" name="projectBean.deptName"
								id="deptName" />
							</li>
							<li><input type="button" id="searchProject"
								class="mediumRightButton" onclick="displayResult();"
								class="button" value="查询">
							</li>
						</ul>
					</div>
					
					<s:if test="roleList==null || roleList.size()==0">
						<tr>
							<td>
							<h3>没数据</h3>
							</td>
						</tr>
					</s:if>
					<s:else>
						<div class="searchResult" id="searchResult">
							<ul class="fullScreenUl">
								<li class="width100Li"><label>角色名</label>
								</li>
								<li class="width200Li"><label>角色最大数量</label>
								</li>
								<li class="width400Li"><label>角色说明</label>
								</li>
								<li class="width50Li"><label>查看</label>
								</li>
								<li class="width50Li"><label>删除</label>
								</li>
							</ul>
							<s:iterator value="roleList" status="st">
								<ul class="fullScreenUl">
									<li class="width100Li"><s:property value="name" /></li>
									<li class="width200Li"><s:property value="roleCount" /></li>
									<li class="width400Li"><s:property value="remark" /></li>
									<li class="width50Li">
										<form action="getRole.do" id='getrole<s:property value="id" />'>
											<input type="button" onclick='getRole("getrole"+<s:property value="id" />);' class="mediumRightButton" class="button" value="查看"><s:hidden name="id" />
										</form>
									</li>
									<li class="width50Li">
										<form action="deleteRole.do" id='deleterole<s:property value="id" />'>
											<input type="button" onclick='deleteRole("deleterole"+<s:property value="id" />);' class="mediumRightButton" class="button" value="删除"><s:hidden name="id" />
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
		if(confirm("是否删除?")){
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
