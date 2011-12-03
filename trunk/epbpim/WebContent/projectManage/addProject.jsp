<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>项目录入</title>
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
					<h3 class="title">项目录入</h3>
					<div id="addProjectTable">
						<h4 class="title">项目基本信息</h4>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width4Lb">项目名称:</label> <input
								class="width350Input" name="projectBean.name" id="projectName" />
							</li>
							<li class="width400Li"><label class="width4Lb">项目编号:</label> <input
								class="width300Input" name="projectBean.number" id="projectNum" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">工程专业:</label><select
								id="projectType" name="projectBean.majorType">
									<option value="土建">土建</option>
									<option value="园林">园林</option>
									<option value="市政">市政</option>
									<option value="安装">安装</option>
									<option value="公用">公用</option>
									<option value="水利">水利</option>
									<option value="人防">人防</option>
									<option value="房修">房修</option>
							</select>
							</li>
							<li class="width250Li"><label class="width4Lb">计价模式:</label><select
								id="projectType" name="projectBean.valuationType">
									<option value="清单">清单</option>
									<option value="2000定额">2000定额</option>
									<option value="其他">其他</option>
							</select>
							</li>
							<li class="width250Li"><label class="width4Lb">开始时间:</label> <input
								class="Wdate width150Input" name="projectBean.startDate"
								id="startDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width4Lb">质量要求:</label> <input
								class="width100Input" name="projectBean.quality" id="quality" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">委托(建设)单位:</label> <input
								class="width350Input" name="projectBean.customerCompany"
								id="customerCompany" />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectBean.customerContactor"
								id="customerContactor" />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectBean.customerContact"
								id="customerContact" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">相关(关系)单位:</label> <input
								class="width350Input" name="projectBean.mediatorCompany"
								id="mediatorCompany" />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectBean.mediatorContactor"
								id="mediatorContactor" />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectBean.mediatorContact"
								id="mediatorContact" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">送审(施工)单位:</label> <input
								class="width350Input" name="projectBean.vendorCompany"
								id="vendorCompany" />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectBean.vendorContactor"
								id="vendorContactor" />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectBean.vendorContact"
								id="vendorContact" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">中标单位:</label> <input
								class="width350Input" name="projectBean.vendorCompany"
								id="vendorCompany" />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectBean.vendorContactor"
								id="vendorContactor" />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectBean.vendorContact"
								id="vendorContact" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width7Lb">承接部门:</label> <select
								id="projectType" name="projectBean.dept">
									<option value="0">--请选择--</option>
									<option value="咨询1部">咨询1部</option>
									<option value="咨询1部">咨询2部</option>
									<option value="咨询1部">咨询3部</option>
							</select>
							</li>
							<li class="width250Li"><label class="width6Lb">部门流转单号:</label> <input
								class="width150Input"
								name="projectBean.deptTransferNumber"
								id="contractNumber" />
							</li>
							<li class="width200Li"><label class="width4Lb">负责人:</label> <select
								id="projectType" name="projectBean.owner">
									<option value="0">--请选择--</option>
									<option value="咨询1部">杨老板</option>
									<option value="咨询1部">高老板</option>
							</select>
							</li>
						</ul>
						
						<ul class="fullScreenUl" id="addNewMember">
							<li class="width200Li" ><label class="width6Lb">项目性质:</label>
								<select id="projectType" name="projectBean.projectType">
									<option value="咨询1部">工程审价</option>
									<option value="咨询1部">招标代理</option>
									<option value="咨询1部">投资监理</option>
									<option value="咨询1部">工程咨询</option>
							</select></li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">送审价:</label> <input
								class="width100Input"
								name="projectBean.judgePrice1"
								id="contractNumber" />
							</li>
							<li class="width200Li"><label class="width6Lb">审定价:</label> <input
								class="width100Input"
								name="projectBean.judgePrice2"
								id="contractMoney" />
							</li>
							<li class="width200Li"><label class="width6Lb">审定天数:</label> <input
								class="width100Input"
								name="projectBean。judgeDays"
								id="contractMoney" />
							</li>
							<li class="width200Li"><label class="width6Lb">报告日/文号:</label> <input
								class="width100Input"
								name="projectBean。reportDate"
								id="contractMoney" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">核增额:</label> <input
								class="width100Input"
								name="projectBean.plusPrice"
								id="contractNumber" />
							</li>
							<li class="width200Li"><label class="width6Lb">核减额:</label> <input
								class="width100Input"
								name="projectBean.minusPrice"
								id="contractMoney" />
							</li>
							<li class="width200Li"><label class="width6Lb">征询日/评价:</label> <input
								class="width100Input"
								name="projectBean.comments"
								id="contractMoney" />
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label> <input
								class="width100Input"
								name="projectBean.achiveDate"
								id="contractMoney" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">报告编号:</label> <input
								class="width100Input"
								name="projectBean.reportNumber"
								id="contractNumber" />
							</li>
							<li class="width200Li"><label class="width6Lb">总师审核:</label> <input
								class="width100Input"
								name="projectBean.masterJudgeComments"
								id="contractMoney" />
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label> <input
								class="width100Input"
								name="projectBean.achiveReceiver"
								id="contractMoney" />
							</li>
						</ul>
						<h4 class="title">合同信息</h4>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">合同编号:</label> <input
								class="width100Input"
								name="projectBean.contractNumber"
								id="contractNumber" />
							</li>
							<li class="width200Li"><label class="width6Lb">合同金额:</label> <input
								class="width100Input"
								name="projectBean.contractMoney"
								id="contractMoney" />
							</li>
							<li class="width500Li"><label class="width6Lb">合同摘要:</label> <input
								class="width400Input"
								name="projectBean.contractAbstract"
								id="contractAbstract" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">开票日期:</label> <input
								class="width100Input"
								name="projectBean.invoiceDate"
								id="contractNumber" />
							</li>
							<li class="width200Li"><label class="width6Lb">发票单号:</label> <input
								class="width100Input"
								name="projectBean.invoiceNumber"
								id="contractMoney" />
							</li>
							<li class="width500Li"><label class="width6Lb">开票金额:</label> <input
								class="width400Input"
								name="projectBean.invoicePrice"
								id="contractAbstract" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li><input type="button" id="addProject"
								class="mediumRightButton" 
								onclick="window.location.href='../main/main.jsp'" 
								value="提交项目">
							</li>
							<li><input type="button" id="addProject"
								class="mediumRightButton" 
								onclick="window.location.href='../main/main.jsp'"
								value="保存">
							</li>
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
 	function addProjectMember(){
 		document.getElementById("addNewMember").style.display="block";
 	}
</script>
</html>
