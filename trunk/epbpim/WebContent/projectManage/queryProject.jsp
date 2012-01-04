<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>项目管理</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css"
		media="screen" />
	<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet"  
	            href="../js/My97DatePicker/skin/default/datepicker.css"  
	            type="text/css"></link> 
	<link href="../images/logo.ico" rel="SHORTCUT ICON" />
	<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
	<script type='text/javascript' src='../dwr/engine.js'></script>
	<script type='text/javascript' src='../dwr/util.js'></script>
	<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
	<script type="text/javascript" src="../js/common.js"></script>
</head>
<body onload="setSearchValue()">
<div id="main"><jsp:include page="../main/mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">项目管理</h3>
<form id="queryForm" action="schProjectList.do" method="post">
	<div id="searchCondition">
		<input type="hidden" name="projectInfo.queryType" id="projectInfo.queryType" value="<s:property value='projectInfo.queryType'/>"/>
		<ul class="fullScreenUl">
			<li class="width400Li"><label class="width4Lb">项目名称:</label>
			<input class="width300Input" name="projectInfo.name" id="projectInfo.name" value="<s:property value='projectInfo.name'/>"/></li>
			<li class="width250Li"><label class="width4Lb">项目编号:</label>
			<input class="width150Input" name="projectInfo.number" id="projectInfo.number" value="<s:property value='projectInfo.number'/>"/></li>
			<li class="width200Li"><label class="width4Lb">承接部门:</label>
			<input class="width100Input" name="projectInfo.dept.name" id="projectInfo.dept.name" value="<s:property value='projectInfo.dept.name'/>"/></li>
		</ul>
		<ul class="fullScreenUl">
			<li class="width200Li"><label class="width4Lb">工程专业:&nbsp;</label><select name="projectInfo.majorType" id="projectInfo.majorType">
				<option value="">--请选择--</option>
				<option value="土建">土建</option>
				<option value="园林">园林</option>
				<option value="市政">市政</option>
				<option value="安装">安装</option>
				<option value="公用">公用</option>
				<option value="水利">水利</option>
				<option value="人防">人防</option>
				<option value="房修">房修</option>
			</select></li>
			<li class="width200Li"><label class="width4Lb">项目经理:</label>
				<s:select cssClass="width100Select" id="projectInfo.manager.id" name="projectInfo.manager.id"
						list="userInfoList" listKey="id" listValue="realName" multiple="false" required="true" headerKey="0" />	
			</li>
			<li class="width200Li"><label class="width2Lb">从:</label>
			<input class="Wdate width150Input" name="projectInfo.startDateFrom" id="projectInfo.startDateFrom" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:property value='projectInfo.startDateFrom'/>"/></li>
			<li class="width200Li"><label class="width2Lb">到:</label>
			<input class="Wdate width150Input" name="projectInfo.startDateTo" id="projectInfo.startDateTo" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:property value='projectInfo.startDateTo'/>"/></li>
			<li><input type="submit" class="mediumRightButton" style="float:right" class="button" value="查询"></li>
		</ul>
	</div>
	<div class="searchResult">
		<s:if test="projectInfoList==null || projectInfoList.size()==0">
			<tr>
				<td>
				<h3><s:text name="Common.Nodata" /></h3>
				</td>
			</tr>
		</s:if>
		<s:else>
			<div class="searchResult" id="searchResult">
				<ul class="fullScreenUl">
					<li class="width200Li"><label>项目名称</label></li>
					<li class="width100Li"><label>项目编号</label></li>
					<li class="width100Li"><label>承接部门</label></li>
					<li class="width100Li"><label>合同金额</label></li>
					<li class="width100Li"><label>开票金额</label></li>
					<li class="width100Li"><label>结算金额</label></li>
					<li class="width50Li"><label>项目状态</label></li>
					<li class="width50Li"><label><s:text name="Common.Update" /></label></li>
					<li class="width50Li"><label><s:text name="Common.Delete" /></label></li>
				</ul>
				<s:iterator value="projectInfoList" status="st">
					<ul class="fullScreenUl">
						<li class="width200Li"><a href="schProject.do?projectInfo.id=<s:property value='id' />"><s:property value="name" /></a></li>
						<li class="width100Li"><s:property value="number" /></li>
						<li class="width100Li"><s:property value="dept.name" /></li>
						<li class="width100Li"><s:property value="contractMoney" /></li>
						<li class="width100Li"><s:property value="subInvoice" /></li>
						<li class="width100Li"><s:property value="subCost" /></li>
						<li class="width50Li">					
							<s:if test="status == 0">已保存</s:if>
							<s:elseif test="status == 1">已提交</s:elseif>
							<s:else><font size="1" color="red">已结项</font></></s:else>
						</li>
						<li class="width50Li">
								<input type="button" <s:if test="projectInfo.queryType!=3 && (status == 1 || status == 2)">disabled</s:if> onclick='preModProject(<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name="Common.Update" />">
						</li>
						<li class="width50Li">
								<input type="button" <s:if test="projectInfo.queryType!=3 && (status == 1 || status == 2)">disabled</s:if> onclick='delProject(<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name="Common.Delete" />">
						</li>	
					</ul>
				</s:iterator>
				<ul class="fullScreenUl">
					<jsp:include page="../common/pagination.jsp" flush="true">
						<jsp:param name="action_page" value="projectManage/schProjectList.do" />
					</jsp:include>
				</ul>
			</div>
		</s:else>
	</div>
</form>
<form action="preModProject.do" method="post" id="preModProject">
	<input type="hidden" name="projectInfo.id" id="premod.projectInfo.id" value="" />
	<input type="hidden" name="projectInfo.queryType" value="<s:property value='projectInfo.queryType'/>"/>
</form>		
<form action="delProject.do" method="post" id="delProject">
	<input type="hidden" name="projectInfo.id" id="del.projectInfo.id" value="" />
</form>	
<div></div>


</div>


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function setSearchValue()
	{
		document.getElementById("projectInfo.majorType").value="<s:property value='projectInfo.majorType'/>";
		
		var option=new Option("--请选择--","0");
		if(""=="<s:property value='projectInfo.manager.id'/>" || "0"=="<s:property value='projectInfo.manager.id'/>")
		{
			option.selected = true;
		}		
		document.getElementById("projectInfo.manager.id").add(option);
		
		
	}
	function delProject(id){
		if(confirm('<s:text name="AdminRole.IfDelete" />')){
			document.getElementById("del.projectInfo.id").value=id;
			document.getElementById("delProject").submit();
		}
	}
	function preModProject(id){
		document.getElementById("premod.projectInfo.id").value=id;
		document.getElementById("preModProject").submit();
	}
</script>
</html>
