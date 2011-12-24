<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>项目录入</title>
<script type="text/javascript">
 	function addProjectInfo(statusValue){
		document.getElementById("projectInfo.status").value=statusValue;
		if(validate($("addForm"))){
			$("addForm").submit();
		}
 	}
 	function changeProjectType() {
 		var type = document.getElementById("projectType").value;
 		var dispDiv1 = document.getElementById("projectType1");
 		var dispDiv2 = document.getElementById("projectType2");
 		var dispDiv3 = document.getElementById("projectType3");
 		var dispDiv4 = document.getElementById("projectType4");
 		if(type == "投资监理" || type=="财务监理") {
 			dispDiv1.style.display="none";
 			dispDiv2.style.display="none";
 			dispDiv3.style.display="block";
 			dispDiv4.style.display="none";
 		} else if(type == "招标代理" || type=="政府采购") {
 			dispDiv1.style.display="none";
 			dispDiv2.style.display="block";
 			dispDiv3.style.display="none";
 			dispDiv4.style.display="none";
 		} else if(type == "工程咨询") {
 			dispDiv1.style.display="none";
 			dispDiv2.style.display="none";
 			dispDiv3.style.display="none";
 			dispDiv4.style.display="block";
 		} else {
 			dispDiv1.style.display="block";
 			dispDiv2.style.display="none";
 			dispDiv3.style.display="none";
 			dispDiv4.style.display="none";
 		}
 	}
 	
</script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">项目录入</h3>
					<div id="addProjectTable">
						<s:form id="addForm" action="addProject.do" method="post" onsubmit="return validate(this);">
						<h4 class="title">项目基本信息</h4>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width4Lb">项目名称:</label> <input
								class="width350Input" name="projectInfo.name"/>
								<textValidate field="projectInfo.name" lableText="<s:text name='项目名称' />" isValidate="true" min="0" max="100">
							</li>
							<li class="width400Li"><label class="width4Lb">项目编号:</label> <input
								class="width300Input" name="projectInfo.number"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">工程专业:</label><select
								id="majorType" name="projectInfo.majorType">
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
								id="valuationType" name="projectInfo.valuationType">
									<option value="清单">清单</option>
									<option value="2000定额">2000定额</option>
									<option value="其他">其他</option>
							</select>
							</li>
							<li class="width250Li"><label class="width4Lb">开始时间:</label> <input
								class="Wdate width150Input" name="projectInfo.startDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width4Lb">质量要求:</label> <input
								class="width100Input" name="projectInfo.quality"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">委托(建设)单位:</label> <input
								class="width350Input" name="projectInfo.customerCompany"/>
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectInfo.customerContactor"/>
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectInfo.customerContact"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">相关(关系)单位:</label> <input
								class="width350Input" name="projectInfo.mediatorCompany"/>
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectInfo.mediatorContactor"/>
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectInfo.mediatorContact"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">送审(施工)单位:</label> <input
								class="width350Input" name="projectInfo.vendorCompany"/>
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectInfo.vendorContactor"/>
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectInfo.vendorContact"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width7Lb">中标单位:</label> <input
								class="width350Input" name="projectInfo.biddingCompany"/>
							</li>
							<li class="width250Li"><label class="width4Lb">联系人:</label> <input
								class="width150Input" name="projectInfo.biddingContactor"/>
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label> <input
								class="width150Input" name="projectInfo.biddingContact"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width7Lb">承接部门:</label>
								<s:select cssClass="width100Select" id="projectInfo.dept.id" name="projectInfo.dept.id"
										list="adminDeptList" listKey="id" listValue="name" multiple="false" required="true" headerKey="0" />	
							</li>
							<li class="width250Li"><label class="width6Lb">部门流转单号:</label> <input
								class="width150Input"
								name="projectInfo.deptTransferNumber"
								id="contractNumber" />
							</li>
							<li class="width200Li"><label class="width4Lb">负责人:</label>
								<s:select cssClass="width100Select" id="projectInfo.owner.id" name="projectInfo.owner.id"
										list="userInfoList" listKey="id" listValue="realName" multiple="false" required="true" headerKey="0" />	
							</li>
							<li class="width200Li"><label class="width4Lb">项目经理:</label>
								<s:select cssClass="width100Select" id="projectInfo.manager.id" name="projectInfo.manager.id"
										list="userInfoList" listKey="id" listValue="realName" multiple="false" required="true" headerKey="0" />	
							</li>
						</ul>
						
						<ul class="fullScreenUl" id="addNewMember">
							<li class="width200Li" ><label class="width6Lb">项目性质:</label>
								<select id="projectType" name="projectInfo.projectType" onChange="changeProjectType();">
									<option value="预算审价">预算审价</option>
									<option value="决算审价">决算审价</option>
									<option value="招标代理">招标代理</option>
									<option value="政府采购">政府采购</option>
									<option value="投资监理">投资监理</option>
									<option value="财务监理">财务监理</option>
									<option value="工程咨询">工程咨询</option>
							</select></li>
							<li class="width400Li"><label class="width6Lb">服务内容:</label><input
								class="width300Input"
								name="projectInfo.projectTypeComment"/>
							</li>
						</ul>
						<div id="projectType1">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">送审价:</label> <input
								class="width100Input"
								name="projectInfo.judgePrice1"/>
							</li>
							<li class="width200Li"><label class="width6Lb">审定价:</label> <input
								class="width100Input"
								name="projectInfo.judgePrice2"/>
							</li>
							<li class="width200Li"><label class="width6Lb">审定天数:</label> <input
								class="width100Input"
								name="projectInfo.judgeDays"/>
							</li>
							<li class="width200Li"><label class="width6Lb">报告日/文号:</label> <input
								class="Wdate width100Input" name="projectInfo.reportDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">核增额:</label> <input
								class="width100Input"
								name="projectInfo.plusPrice"/>
							</li>
							<li class="width200Li"><label class="width6Lb">核减额:</label> <input
								class="width100Input"
								name="projectInfo.minusPrice"/>
							</li>
							<li class="width200Li"><label class="width6Lb">征询日/评价:</label> <input
								class="width100Input"
								name="projectInfo.comments"/>
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label> <input
								class="Wdate width100Input" name="projectInfo.achiveDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">报告编号:</label> <input
								class="width100Input"
								name="projectInfo.reportNumber"/>
							</li>
							<li class="width200Li"><label class="width6Lb">总师审核:</label> <input
								class="width100Input"
								name="projectInfo.masterJudgeComments"/>
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label> <input
								class="width100Input"
								name="projectInfo.achiveReceiver"/>
							</li>
						</ul></div>
						<div id="projectType2" style="display:none;">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">总投资:</label> <input
								class="width100Input"
								name="projectInfo.proxyInvest"/>
							</li>
							<li class="width200Li"><label class="width6Lb">建安量:</label> <input
								class="width100Input"
								name="projectInfo.proxyQuantity"/>
							</li>
							<li class="width200Li"><label class="width6Lb">中标金额:</label> <input
								class="width100Input"
								name="projectInfo.proxyBiddingAmount"/>
							</li>
							<li class="width200Li"><label class="width6Lb">征询单日期:</label> <input
								class="Wdate width100Input" name="projectInfo.proxyConsult"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">代理开始日:</label> <input
								class="Wdate width100Input" name="projectInfo.proxyStartDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">开、评标日:</label> <input
								class="Wdate width100Input" name="projectInfo.proxyOpenEvalDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">评价:</label> <input
								class="width100Input"
								name="projectInfo.proxyEvaluate"/>
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label> <input
								class="Wdate width100Input" name="projectInfo.proxyArchiveDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">中标书编号:</label> <input
								class="width100Input"
								name="projectInfo.proxyBiddingIdentity"/>
							</li>
							<li class="width200Li"><label class="width6Lb">中标书发出:</label> <input
								class="width100Input"
								name="projectInfo.proxyBiddingSend"/>
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label> <input
								class="width100Input"
								name="projectInfo.proxyArchiveRecipient"/>
							</li>
						</ul></div>
						<div id="projectType3" style="display:none;">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">总投资:</label> <input
								class="width100Input"
								name="projectInfo.supervisorInvest"/>
							</li>
							<li class="width200Li"><label class="width6Lb">建安量:</label> <input
								class="width100Input"
								name="projectInfo.supervisorQuantity"/>
							</li>
							<li class="width400Li"><label class="width10Lb">投资监理大纲及成果:</label> <input
								class="width250Input"
								name="projectInfo.supervisorOutline"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">开始日:</label>
							<input class="Wdate width100Input" name="projectInfo.supervisorStartDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">实际完成日:</label> 
							<input class="Wdate width100Input" name="projectInfo.supervisorFinishDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label> <input
								class="Wdate width100Input" name="projectInfo.supervisorArchiveDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">征询评价1:</label> <input
								class="width100Input"
								name="projectInfo.supervisorConsultOne"/>
							</li>
							<li class="width200Li"><label class="width6Lb">征询评价2:</label> <input
								class="width100Input"
								name="projectInfo.supervisorConsultTwo"/>
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label> <input
								class="width100Input"
								name="projectInfo.supervisorArchiveRecipient"/>
							</li>
						</ul></div>
						<div id="projectType4" style="display:none;">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">总投资:</label> <input
								class="width100Input"
								name="projectInfo.consultInvest"/>
							</li>
							<li class="width200Li"><label class="width6Lb">建安量:</label> <input
								class="width100Input"
								name="projectInfo.consultQuantity"/>
							</li>
							<li class="width400Li"><label class="width9Lb">咨询成果主要内容:</label> <input
								class="width250Input"
								name="projectInfo.consultResultContent"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">发布日:</label> <input
								class="Wdate width100Input" name="projectInfo.consultAnnounceDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">咨询开始日:</label> <input
								class="Wdate width100Input" name="projectInfo.consultStartDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">咨询完成日:</label> <input
								class="Wdate width100Input" name="projectInfo.consultFinishDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label> <input
								class="Wdate width100Input" name="projectInfo.consultArchiveDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">评审日期:</label> <input
								class="Wdate width100Input" name="projectInfo.consultReviewDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">专家名单:</label> <input
								class="width100Input"
								name="projectInfo.consultExpertList"/>
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label> <input
								class="width100Input"
								name="projectInfo.consultArchiveRecipient"/>
							</li>
						</ul></div>
						
						
						<ul class="fullScreenUl">
							<li><input type="button" id="addProject"
								class="mediumRightButton" 
								onclick="addProjectInfo('1')" 
								value="提交项目"><input type="button" id="addProject"
								class="mediumRightButton" 
								onclick="addProjectInfo('0')"
								value="保存">
							</li>
							<li ><input type="hidden" id="projectInfo.status" name="projectInfo.status"/> </li>
						</ul>
						</s:form>
						<ul id="invoiceUL" class="fullScreenUl" style="display: none">
							<li class="width200Li"><label class="width6Lb">开票日期:</label> <input
								class="Wdate width100Input" name="projectInfo.invoiceDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">开票金额:</label> <input
								class="width100Input"
								name="projectInfo.invoicePrice"/>
							</li>
							<li class="width400Li"><label class="width6Lb">发票单号:</label> <input
								class="width300Input"
								name="projectInfo.invoiceNumber"/>
							</li>
							<li><input type="button" class="mediumLeftButton" onclick="delInvoice(this)" value="删除"></li>
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
</html>
