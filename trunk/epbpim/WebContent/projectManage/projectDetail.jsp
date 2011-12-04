<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>项目详情</title>
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
				<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">项目录入</h3>
					<div id="addProjectTable">
						<h4 class="title">项目基本信息</h4>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width4Lb">项目名称:</label><s:property value='projectInfo.name'/>
							</li>
							<li class="width400Li"><label class="width4Lb">项目编号:</label><s:property value='projectInfo.number'/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">工程专业:</label><s:property value='projectInfo.majorType'/>
							</li>
							<li class="width250Li"><label class="width4Lb">计价模式:</label><s:property value='projectInfo.valuationType'/>
							</li>
							<li class="width250Li"><label class="width4Lb">开始时间:</label><s:date name='projectInfo.startDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width4Lb">质量要求:</label><s:property value='projectInfo.quality' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">委托(建设)单位:</label><s:property value='projectInfo.customerCompany' />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label><s:property value='projectInfo.customerContactor' />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label><s:property value='projectInfo.customerContact' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">相关(关系)单位:</label><s:property value='projectInfo.mediatorCompany' />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label><s:property value='projectInfo.mediatorContactor' />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label><s:property value='projectInfo.mediatorContact' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">送审(施工)单位:</label><s:property value='projectInfo.vendorCompany' />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label><s:property value='projectInfo.vendorContactor' />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label><s:property value='projectInfo.vendorContact' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">中标单位:</label><s:property value='projectInfo.biddingCompany' />
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label><s:property value='projectInfo.biddingContactor' />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label><s:property value='projectInfo.vendorContact' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width7Lb">承接部门:</label><s:property value='projectInfo.dept.name' />
							</li>
							<li class="width250Li"><label class="width6Lb">部门流转单号:</label><s:property value='projectInfo.deptTransferNumber' />
							</li>
							<li class="width200Li"><label class="width4Lb">负责人:</label><s:property value='projectInfo.owner.name' />
							</li>
						</ul>
						
						<ul class="fullScreenUl" id="addNewMember">
							<li class="width200Li" ><label class="width6Lb">项目性质:</label><s:property value='projectInfo.projectType' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">送审价:</label><s:property value='projectInfo.judgePrice1' />
							</li>
							<li class="width200Li"><label class="width6Lb">审定价:</label><s:property value='projectInfo.judgePrice2' />
							</li>
							<li class="width200Li"><label class="width6Lb">审定天数:</label><s:property value='projectInfo.judgeDays' />
							</li>
							<li class="width200Li"><label class="width6Lb">报告日/文号:</label><s:date name='projectInfo.reportDate' format='yyyy-MM-dd' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">核增额:</label><s:property value='projectInfo.plusPrice' />
							</li>
							<li class="width200Li"><label class="width6Lb">核减额:</label><s:property value='projectInfo.minusPrice' />
							</li>
							<li class="width200Li"><label class="width6Lb">征询日/评价:</label><s:property value='projectInfo.comments' />
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label><s:date name='projectInfo.achiveDate' format='yyyy-MM-dd' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">报告编号:</label><s:property value='projectInfo.reportNumber' />
							</li>
							<li class="width200Li"><label class="width6Lb">总师审核:</label><s:property value='projectInfo.masterJudgeComments' />
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label><s:property value='projectInfo.achiveReceiver' />
							</li>
						</ul>
						<h4 class="title">合同信息</h4>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">合同编号:</label><s:property value='projectInfo.contractNumber' />
							</li>
							<li class="width200Li"><label class="width6Lb">合同金额:</label><s:property value='projectInfo.contractMoney' />
							</li>
							<li class="width500Li"><label class="width6Lb">合同摘要:</label><s:property value='projectInfo.contractAbstract' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">开票日期:</label><s:date name='projectInfo.invoiceDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">发票单号:</label><s:property value='projectInfo.invoiceNumber' />
							</li>
							<li class="width500Li"><label class="width6Lb">开票金额:</label><s:property value='projectInfo.invoicePrice' />
							</li>
						</ul>
					</div>
					<div></div>
				</div>
				<div class="clr"></div>
			</div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
 	function addContract(){
 		document.getElementById("contract2").style.display="block";
 	}
 	function removeContract(id){
 		document.getElementById(id).style.display="none";
 	}

</script>
</html>
