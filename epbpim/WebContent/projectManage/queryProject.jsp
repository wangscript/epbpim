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
</head>
<body>
<div id="main"><jsp:include page="../main/mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">项目管理</h3>
<div id="searchCondition">
<ul class="fullScreenUl">
	<li class="width400Li"><label class="width4Lb">项目名称:</label>
	<input class="width300Input" name="projectBean.name" id="projectName" /></li>
	<li class="width250Li"><label class="width4Lb">项目编号:</label>
	<input class="width150Input" name="projectBean.number" id="projectNum" /></li>
	<li class="width200Li"><label class="width4Lb">承接部门:</label>
	<input class="width100Input" name="projectBean.deptName" id="deptName" /></li>
</ul>
<ul class="fullScreenUl">
	<li class="width200Li"><label class="width4Lb">工程专业:&nbsp;</label><select id="projectType"
		name="projectBean.majorType" >
		<option value="0">--请选择--</option>
		<option value="土建装饰">土建</option>
		<option value="园林">园林</option>
		<option value="市政">市政</option>
		<option value="安装">安装</option>
		<option value="公用">公用</option>
		<option value="水利">水利</option>
		<option value="人防">人防</option>
		<option value="房修">房修</option>
	</select></li>
	<li class="width200Li"><label class="width4Lb">计价模式:&nbsp;</label><select id="projectType"
		name="projectBean.valuationType" >
		<option value="清单">清单</option>
		<option value="2000定额">2000定额</option>
		<option value="其他">其他</option>
	</select></li>
	<li class="width200Li"><label class="width2Lb">从:</label>
	<input class="Wdate width150Input" name="projectBean.startDate" id="startDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
	<li class="width200Li"><label class="width2Lb">到:</label>
	<input class="Wdate width150Input" name="projectBean.startDate" id="startDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
	<li><input type="button" id="searchProject" class="mediumRightButton" style="float:right"
		onclick="displayResult();" class="button" value="查询"></li>
</ul>

</div>
<div class="searchResult" id="searchResult" style="display:none"> 
	<ul class="fullScreenUl">
	<li class="width300Li"><label>项目名称</label></li>
	<li class="width100Li"><label>项目编号</label></li>
	<li class="width100Li"><label>承接部门</label></li>
	<li class="width100Li"><label>合同金额</label></li>
	<li class="width100Li"><label>财务金额</label></li>
	<li class="width100Li"><label>结算金额</label></li>
	<li class="width100Li"><label>结算余额</label></li> 
</ul>
<ul class="fullScreenUl">
	<li class="width300Li"><label><a href="projectDetail.jsp">废水治理及清洁生产、铬回收项目  </a></label></li>
	<li class="width100Li"><label>001</label></li>
	<li class="width100Li"><label>1部</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>80,000</label></li>
	<li class="width100Li"><label>80,000</label></li>
</ul>
<ul class="fullScreenUl">
	<li class="width300Li"><label>工业标准厂房建设项目   </label></li>
	<li class="width100Li"><label>001</label></li>
	<li class="width100Li"><label>1部</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>80,000</label></li>
	<li class="width100Li"><label>80,000</label></li>
</ul>
<ul class="fullScreenUl">
	<li class="width300Li"><label>塑粉生产厂房及附属设施项目   </label></li>
	<li class="width100Li"><label>001</label></li>
	<li class="width100Li"><label>1部</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>80,000</label></li>
	<li class="width100Li"><label>80,000</label></li>
</ul>
<ul class="fullScreenUl">
	<li class="width300Li"><label>煤炭洗选项目 </label></li>
	<li class="width100Li"><label>001</label></li>
	<li class="width100Li"><label>1部</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>100,000</label></li>
	<li class="width100Li"><label>80,000</label></li>
	<li class="width100Li"><label>80,000</label></li>   
</ul>

</div>
<div></div>


</div>


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function displayResult(){
		document.getElementById("searchResult").style.display="block";
	}

</script>
</html>
