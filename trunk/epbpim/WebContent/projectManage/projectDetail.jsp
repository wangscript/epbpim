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
				<div class="mainbar">
					<h3 class="title">项目详情</h3>
					<div id="addProjectTable">
						<h4 class="title">项目基本信息</h4>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width4Lb">项目名称:</label>
								废水治理及清洁生产、铬回收项目</li>
							<li class="width250Li"><label class="width4Lb">项目编号:</label>
								FS203049506</li>
							<li class="width200Li"><label class="width4Lb">承接部门:</label>
								1部</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">工程专业:</label>市政</li>
							<li class="width200Li"><label class="width4Lb">计价模式:</label>清单</li>
							<li class="width250Li"><label class="width4Lb">开始时间:</label>2011-07-30</li>
							<li class="width200Li"><label class="width4Lb">质量要求:</label>
								高</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width4Lb">委托单位:</label>
								河南省政府</li>
							<li class="width250Li"><label class="width3Lb">联系人:</label>
								杨祚</li>
							<li class="width200Li"><label class="width2Lb">电话:</label>13044940506</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width4Lb">建设单位:</label>
								河南省政府</li>
							<li class="width250Li"><label class="width3Lb">联系人:</label>
								杨祚</li>
							<li class="width200Li"><label class="width2Lb">电话:</label>13044940506</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width7Lb">送审/施工单位:</label>
								建工集团</li>
							<li class="width250Li"><label class="width3Lb">联系人:</label>李先生</li>
							<li class="width200Li"><label class="width2Lb">电话:</label>1305949566</li>
						</ul>
						<h4 class="title">合同信息</h4>
						<ul class="fullScreenUl" id="contract1">
							<li class="width200Li"><label class="width4Lb">合同编号:</label> HT2034949</li>
							<li class="width200Li"><label class="width4Lb">合同金额:</label> 100,400</li>
							<li class="width400Li"><label class="width4Lb">合同摘要:</label> 建工集团</li>
						</ul>
						<ul class="fullScreenUl">
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="结项">
							</li>
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="审批不通过">
							</li>
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="审批通过">
							</li>
						</ul>
						<h4 class="title">财务信息</h4>
						<ul class="fullScreenUl">
							<li class="width300Li"><label class="width4Lb">项目金额:</label> <input
								class="width200Input" name="projectBean.financeMoney"
								id="financeMoney" value="" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="结项">
							</li>
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="审批不通过">
							</li>
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="审批通过">
							</li>
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="财务提交项目">
							</li>
						</ul>
						<h4 class="title">核算信息</h4>
						<ul class="fullScreenUl">
							<li class="width300Li"><label class="width4Lb">核算金额:</label> <input
								class="width200Input" name="projectBean.financeMoney"
								id="financeMoney" value="" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="结项">
							</li>
							<li><input type="button" id="addProject"
								onclick="window.location.href='main.jsp'" class="mediumRightButton"
								value="提交核算金额">
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
 	function addContract(){
 		document.getElementById("contract2").style.display="block";
 	}
 	function removeContract(id){
 		document.getElementById(id).style.display="none";
 	}

</script>
</html>
