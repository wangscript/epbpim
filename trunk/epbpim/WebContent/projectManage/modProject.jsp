<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ryxx.util.cache.CacheMap"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<%@ page import="com.ryxx.bpim.user.entity.AdminMenu"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>项目录入</title>
<script type="text/javascript">
	function setSelectValue()
	{
		document.getElementById("majorType").value="<s:property value='projectInfo.majorType'/>";
		document.getElementById("valuationType").value="<s:property value='projectInfo.valuationType'/>";	
		document.getElementById("projectType").value = "<s:property value='projectInfo.projectType'/>";
		
		changeProjectType();
	}
	function modProjectInfo(statusValue){
		
		if('5' == statusValue)
		{
			if(!document.getElementById("projectInfo.number").value)
			{
				alert("请输入项目编号！");
				return;
			}
		}
		
		document.getElementById("status").value=statusValue;
		removeObjDisabled();
		document.getElementById("modForm").submit();
	}
	
	function removeObjDisabled()
	{
		for(i = 0; i < document.all.length; i++)
		{
			if(document.all(i).disabled)
			{
				document.all(i).disabled = false;
			}
		}

	}
	
	function changeProjectType() {			
		var type = document.getElementById("projectType").value;
		
		// 拥有业务权限
		if(document.getElementById("projectType1"))
		{
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
		// 拥有财务权限
		if(document.getElementById("earnestInPart"))
		{
			
			var earnestInPartObj = document.getElementById("earnestInPart");
	 		var tenderPartObj = document.getElementById("tenderPart");
	 		var agentPartObj = document.getElementById("agentPart");
	 		var vendorPartObj = document.getElementById("vendorPart");
	 		var earnestOutPartObj = document.getElementById("earnestOutPart");
	 		var meetingPlacePartObj = document.getElementById("meetingPlacePart");
	 		var expertPartObj = document.getElementById("expertPart");
	 		var costPartObj = document.getElementById("costPart");
	 		
	 		
	 		if(type == "投资监理" || type=="财务监理") {
	 			earnestInPartObj.style.display="none";
	 			tenderPartObj.style.display="none";
	 			agentPartObj.style.display="block";
	 			vendorPartObj.style.display="none";
	 			earnestOutPartObj.style.display="none";
	 			meetingPlacePartObj.style.display="none";
	 			expertPartObj.style.display="none";
	 			costPartObj.style.display="block";
	 		} else if(type == "招标代理" || type=="政府采购") {
	 			earnestInPartObj.style.display="block";
	 			tenderPartObj.style.display="block";
	 			agentPartObj.style.display="block";
	 			vendorPartObj.style.display="none";
	 			earnestOutPartObj.style.display="block";
	 			meetingPlacePartObj.style.display="block";
	 			expertPartObj.style.display="block";
	 			costPartObj.style.display="block";
	 		} else if(type == "工程咨询") {
	 			earnestInPartObj.style.display="none";
	 			tenderPartObj.style.display="none";
	 			agentPartObj.style.display="block";
	 			vendorPartObj.style.display="none";
	 			earnestOutPartObj.style.display="none";
	 			meetingPlacePartObj.style.display="none";
	 			expertPartObj.style.display="none";
	 			costPartObj.style.display="block";
	 		} else {
	 			earnestInPartObj.style.display="none";
	 			tenderPartObj.style.display="none";
	 			agentPartObj.style.display="block";
	 			vendorPartObj.style.display="block";
	 			earnestOutPartObj.style.display="none";
	 			meetingPlacePartObj.style.display="none";
	 			expertPartObj.style.display="none";
	 			costPartObj.style.display="block";
	 		}
		}		
 	}
	
	
	function addParticipant(obj)
 	{
 		var participantLIObj=document.getElementById("participantLI").cloneNode(true);
 		participantLIObj.id="";
 		document.getElementById("participantUL").removeChild(obj.parentNode); 		
 		document.getElementById("participantUL").appendChild(participantLIObj);
 		document.getElementById("participantUL").appendChild(obj.parentNode);
 	}
 	function delParticipant(obj)
 	{
 		document.getElementById("participantUL").removeChild(obj.parentNode);
 	}
 	
	
	function addCost()
 	{
 		var costDivObj=document.getElementById("costDiv").cloneNode(true);
 		costDivObj.id="";
 		costDivObj.style.display="inline";
 		document.getElementById("costPart").appendChild(costDivObj);
 	}
 	function delCost(obj)
 	{
 		var costDivObj=obj.parentNode.parentNode.parentNode;
 		costDivObj.parentNode.removeChild(costDivObj);
 	}
	
	function addAttachment()
 	{
 		var invoiceULObj=document.getElementById("attachmentUL").cloneNode(true);
 		invoiceULObj.id="";
 		invoiceULObj.style.display="inline";
 		document.getElementById("attachmentDIV").appendChild(invoiceULObj);
 	}
 	function delAttachment(obj)
 	{
 		var invoiceULObj=obj.parentNode.parentNode;
 		invoiceULObj.parentNode.removeChild(invoiceULObj);
 	}
 	
 	function chooseFile(obj)
 	{
 		var filePath=obj.value;
 	    var fileName=filePath.substring(filePath.lastIndexOf('\\')+1,filePath.length); 	    
		var reg = /,/g;
		fileName = fileName.replace(reg, "");
		obj.nextSibling.nextSibling.value = fileName;
 	}
 	
</script>
</head>
<body onload="setSelectValue()">
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">项目录入</h3>
					<div id="addProjectTable">
						<s:form id="modForm" action="modProject.do"
							enctype="multipart/form-data" method="post"
							onsubmit="return validate(this);">
							<h4 class="title">项目基本信息</h4>
							<input type="hidden" name="projectInfo.queryType"
								value="<s:property value='projectInfo.queryType'/>" />
							<input type="hidden" name="projectInfo.id"
								value="<s:property value='projectInfo.id'/>" />
							<input type="hidden" name="projectInfo.submitter.id"
								value="<s:property value='projectInfo.submitter.id'/>" />
							<ul class="fullScreenUl">	
								<li class="width200Li"><label class="width4Lb">承接部门:</label>
									<select id="projectInfo.dept.id" name="projectInfo.dept.id" class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>>
										<s:iterator value="adminDeptList" status="st">
											<option value="<s:property value='id' />"
											<s:if test="id==projectInfo.dept.id">selected</s:if>>
												<s:property value="name" />
											</option>
										</s:iterator>
									</select>
								</li>
							</ul>
							
							<%
								String userid = String.valueOf((Long) session
											.getAttribute(Constants.LOGIN_USER_ID));
									List<AdminMenu> menus = (List) CacheMap.getInstance()
											.getCache(
													Constants.MENU_CACHE + Constants.LOGIN_USER_ID
															+ userid);
									request.setAttribute("userid", userid);
									for (AdminMenu menu : menus) {
										if (menu.getId() == 301) {
											request.setAttribute("submitProject", true);
										}
										if (menu.getId() == 312) {
											request.setAttribute("deptApprove", true);
										}
										if (menu.getId() == 313) {
											request.setAttribute("masterApprove", true);
										}
										if (menu.getId() == 314) {
											request.setAttribute("managerApprove", true);
										}
										if (menu.getId() == 315) {
											request.setAttribute("directorFillNo", true);
										}
										if (menu.getId() == 316) {
											request.setAttribute("businessManage", true);
										}
										if (menu.getId() == 317) {
											request.setAttribute("accountManage", true);
										}
									}
							%>
							
							<ul class="fullScreenUl">
								<li class="width400Li"><label class="width4Lb">项目名称:</label>
									<input <s:if test="projectInfo.status!=0">disabled</s:if>
									class="width300Input" name="projectInfo.name"
									value="<s:property value='projectInfo.name'/>" />
									<textValidate field="projectInfo.name" lableText="<s:text name='项目名称' />" isValidate="true" min="0" max="100">
								</li>
								<li class="width400Li" <s:if test="projectInfo.status != 4 && projectInfo.status != 5">style="display: none"</s:if> <s:if test="#request.directorFillNo == true">disabled</s:if>><label class="width4Lb">项目编号:</label>
									<input class="width300Input" id="projectInfo.number" name="projectInfo.number" value="<s:property value='projectInfo.number'/>" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width4Lb">工程专业:</label>
									<select id="majorType" name="projectInfo.majorType" class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>>
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
								<li class="width200Li"><label class="width5Lb">计价模式:</label>
									<select id="valuationType" name="projectInfo.valuationType" class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>>
										<option value="清单">清单</option>
										<option value="2000定额">2000定额</option>
										<option value="其他">其他</option>
								</select> <s:if test="projectInfo.status!=0">
										<input type="hidden" name="projectInfo.valuationType"
											value="<s:property value='projectInfo.valuationType'/>">
									</s:if>
								</li>					
								<li class="width200Li"><label class="width4Lb">开始时间:</label>
									<input class="Wdate width100Input" name="projectInfo.startDate"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
									value="<s:date name='projectInfo.startDate' format='yyyy-MM-dd' />" />
								</li>			
								<li class="width200Li"><label class="width4Lb">质量要求:</label>
									<input class="width100Input" name="projectInfo.quality"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.quality' />" /></li>
							</ul>							
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width4Lb">项目经理:</label>
									<select id="projectInfo.manager.id" name="projectInfo.manager.id" class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>>
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
											<s:if test="id==projectInfo.manager.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
									</select>
								</li>
								<li class="width200Li"><label class="width5Lb">部门负责人:</label>
									<select id="projectInfo.owner.id" name="projectInfo.owner.id" class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>>
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.owner.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
									</select>
								</li>
								<li class="width200Li"><label class="width5Lb">编制人:</label>
									<select id="projectInfo.formater.id" name="projectInfo.formater.id" class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>>
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.formater.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
									</select>
								</li>
								<li class="width200Li"><label class="width5Lb">审核人:</label>
									<select id="projectInfo.verifier.id" name="projectInfo.verifier.id" class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>>
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.verifier.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
									</select>
								</li>
							</ul>
							<ul id="participantUL" class="fullScreenUl">
								<li class="width100Li">
									<label class="width5Lb">项目参与人:</label> 
								</li>
								<s:if test="projectInfo.participants != null && projectInfo.participants.size() > 0">
									<s:iterator value="projectInfo.participants" status="st">
										<li id="participantLI" class="width200Li"><select
											id="projectInfo.participant" name="projectInfo.participant"
											class="width100Input"
											<s:if test="projectInfo.status!=0">disabled</s:if>>
											<s:iterator value="userInfoList" status="st">
												<option value="<s:property value='id' />"
													<s:if test="id==participantID">selected</s:if>>
												<s:property value="realName" /></option>
											</s:iterator>
										</select>
										<input type="button" class="mediumLeftButton" <s:if test="projectInfo.status!=0">disabled</s:if> onclick="delParticipant(this)" value="删除"></li>
									</s:iterator>
								</s:if>
								<li class="width100Li">
									<input type="button" <s:if test="projectInfo.status!=0">disabled</s:if> class="mediumLeftButton" onclick="addParticipant(this)" value="新增参与人">
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width4Lb">合同编号:</label>
									<input <s:if test="projectInfo.status!=0">disabled</s:if> class="width100Input"
									name="projectInfo.contractNumber"
									value="<s:property value='projectInfo.contractNumber' />" />
								</li>
								<li class="width200Li"><label class="width5Lb">合同金额:</label>
									<input <s:if test="projectInfo.status!=0">disabled</s:if> class="width100Input"
									name="projectInfo.contractMoney"
									value="<s:property value='projectInfo.contractMoney' />" />
								</li>
								<li class="width200Li"><label class="width6Lb">部门流转单号:</label>
									<input <s:if test="projectInfo.status!=0">disabled</s:if>  class="width100Input" id="contractNumber"									
									name="projectInfo.deptTransferNumber"
									value="<s:property value='projectInfo.deptTransferNumber' />" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width800Li"><label class="width7Lb">合同摘要:</label><textarea style="height: 40px; width: 500px;" <s:if test="projectInfo.status!=0">disabled</s:if> name="projectInfo.contractAbstract"><s:property value='projectInfo.contractAbstract' /></textarea>
								</li>
								<li><br></li>
							</ul>							
							<ul class="fullScreenUl">
								<li class="width400Li"><label class="width7Lb">委托(建设)单位:</label>
									<input class="width300Input" name="projectInfo.customerCompany"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.customerCompany' />" />
								</li>
								<li class="width200Li"><label class="width4Lb">联系人:</label>
									<input class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									name="projectInfo.customerContactor"
									value="<s:property value='projectInfo.customerContactor' />" />
								</li>
								<li class="width200Li"><label class="width2Lb">电话:</label>
									<input class="width100Input" name="projectInfo.customerContact"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.customerContact' />" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width400Li"><label class="width7Lb">相关(关系)单位:</label>
									<input class="width300Input" name="projectInfo.mediatorCompany"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.mediatorCompany' />" />
								</li>
								<li class="width200Li"><label class="width4Lb">联系人:</label>
									<input class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									name="projectInfo.mediatorContactor"
									value="<s:property value='projectInfo.mediatorContactor' />" />
								</li>
								<li class="width200Li"><label class="width2Lb">电话:</label>
									<input class="width100Input" name="projectInfo.mediatorContact"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.mediatorContact' />" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width400Li"><label class="width7Lb">送审(施工)单位:</label>
									<input class="width300Input" name="projectInfo.vendorCompany"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.vendorCompany' />" /></li>
								<li class="width200Li"><label class="width4Lb">联系人:</label>
									<input class="width100Input" name="projectInfo.vendorContactor"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.vendorContactor' />" />
								</li>
								<li class="width200Li"><label class="width2Lb">电话:</label>
									<input class="width100Input" name="projectInfo.vendorContact"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.vendorContact' />" /></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width400Li"><label class="width7Lb">中标单位:</label>
									<input class="width300Input" name="projectInfo.biddingCompany"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.biddingCompany' />" /></li>
								<li class="width200Li"><label class="width4Lb">联系人:</label>
									<input class="width100Input"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									name="projectInfo.biddingContactor"
									value="<s:property value='projectInfo.biddingContactor' />" />
								</li>
								<li class="width200Li"><label class="width2Lb">电话:</label>
									<input class="width100Input" name="projectInfo.biddingContact"
									<s:if test="projectInfo.status!=0">disabled</s:if>
									value="<s:property value='projectInfo.biddingContact' />" /></li>
							</ul>
							
							<h4 class="title">项目业务信息</h4>
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width6Lb">项目性质:</label>
									<select id="projectType" name="projectInfo.projectType"
									onChange="changeProjectType();">
										<option value="预算审价">预算审价</option>
										<option value="决算审价">决算审价</option>
										<option value="招标代理">招标代理</option>
										<option value="政府采购">政府采购</option>
										<option value="投资监理">投资监理</option>
										<option value="财务监理">财务监理</option>
										<option value="工程咨询">工程咨询</option>
								</select>
								</li>
								<li class="width400Li"><label class="width6Lb">服务内容:</label><input
									class="width300Input" name="projectInfo.projectTypeComment"
									value="<s:property value='projectInfo.projectTypeComment'/>" />
								</li>
							</ul>
							<!-- 业务权限人员,查看项目业务信息  -->
							<s:if test="#request.businessManage == true">
							<div id="projectType1">
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">送审价:</label>
										<input class="width100Input" name="projectInfo.judgePrice1"
										value="<s:property value='projectInfo.judgePrice1'/>" /></li>
									<li class="width200Li"><label class="width6Lb">审定价:</label>
										<input class="width100Input" name="projectInfo.judgePrice2"
										value="<s:property value='projectInfo.judgePrice2' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">审定天数:</label>
										<input class="width100Input" name="projectInfo.judgeDays"
										value="<s:property value='projectInfo.judgeDays' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">报告日/文号:</label>
										<input class="Wdate width100Input"
										name="projectInfo.reportDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.reportDate' format='yyyy-MM-dd' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">核增额:</label>
										<input class="width100Input" name="projectInfo.plusPrice"
										value="<s:property value='projectInfo.plusPrice'/>" /></li>
									<li class="width200Li"><label class="width6Lb">核减额:</label>
										<input class="width100Input" name="projectInfo.minusPrice"
										value="<s:property value='projectInfo.minusPrice'/>" /></li>
									<li class="width200Li"><label class="width6Lb">征询日/评价:</label>
										<input class="width100Input" name="projectInfo.comments"
										value="<s:property value='projectInfo.comments'/>" /></li>
									<li class="width200Li"><label class="width6Lb">归档日期:</label>
										<input class="Wdate width100Input" name="projectInfo.achiveDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.achiveDate' format='yyyy-MM-dd' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">报告编号:</label>
										<input class="width100Input" name="projectInfo.reportNumber"
										value="<s:property value='projectInfo.reportNumber'/>" /></li>
									<li class="width200Li"><label class="width6Lb">总师审核:</label>
										<input class="width100Input"
										name="projectInfo.masterJudgeComments"
										value="<s:property value='projectInfo.masterJudgeComments'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">档案接收人:</label>
										<input class="width100Input" name="projectInfo.achiveReceiver"
										value="<s:property value='projectInfo.achiveReceiver'/>" /></li>
								</ul>
							</div>
							<div id="projectType2" style="display: none;">
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">总投资:</label>
										<input class="width100Input" name="projectInfo.proxyInvest"
										value="<s:property value='projectInfo.proxyInvest'/>" /></li>
									<li class="width200Li"><label class="width6Lb">建安量:</label>
										<input class="width100Input" name="projectInfo.proxyQuantity"
										value="<s:property value='projectInfo.proxyQuantity'/>" /></li>
									<li class="width200Li"><label class="width6Lb">中标金额:</label>
										<input class="width100Input"
										name="projectInfo.proxyBiddingAmount"
										value="<s:property value='projectInfo.proxyBiddingAmount'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">征询单日期:</label>
										<input class="Wdate width100Input"
										name="projectInfo.proxyConsult"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.proxyConsultPage' format='yyyy-MM-dd' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">代理开始日:</label>
										<input class="Wdate width100Input"
										name="projectInfo.proxyStartDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.proxyStartDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">开、评标日:</label>
										<input class="Wdate width100Input"
										name="projectInfo.proxyOpenEvalDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.proxyOpenEvalDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">评价:</label>
										<input class="width100Input" name="projectInfo.proxyEvaluate"
										value="<s:property value='projectInfo.proxyEvaluate'/>" /></li>
									<li class="width200Li"><label class="width6Lb">归档日期:</label>
										<input class="Wdate width100Input"
										name="projectInfo.proxyArchiveDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.proxyArchiveDate' format='yyyy-MM-dd' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">中标书编号:</label>
										<input class="width100Input"
										name="projectInfo.proxyBiddingIdentity"
										value="<s:property value='projectInfo.proxyBiddingIdentity'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">中标书发出:</label>
										<input class="width100Input"
										name="projectInfo.proxyBiddingSend"
										value="<s:property value='projectInfo.proxyBiddingSend'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">档案接收人:</label>
										<input class="width100Input"
										name="projectInfo.proxyArchiveRecipient"
										value="<s:property value='projectInfo.proxyArchiveRecipient'/>" />
									</li>
								</ul>
							</div>
							<div id="projectType3" style="display: none;">
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">总投资:</label>
										<input class="width100Input"
										name="projectInfo.supervisorInvest"
										value="<s:property value='projectInfo.supervisorInvest'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">建安量:</label>
										<input class="width100Input"
										name="projectInfo.supervisorQuantity"
										value="<s:property value='projectInfo.supervisorQuantity'/>" />
									</li>
									<li class="width400Li"><label class="width10Lb">投资监理大纲及成果:</label>
										<input class="width250Input"
										name="projectInfo.supervisorOutline"
										value="<s:property value='projectInfo.supervisorOutline'/>" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">开始日:</label>
										<input class="Wdate width100Input"
										name="projectInfo.supervisorStartDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.supervisorStartDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">实际完成日:</label>
										<input class="Wdate width100Input"
										name="projectInfo.supervisorFinishDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.supervisorFinishDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">归档日期:</label>
										<input class="Wdate width100Input"
										name="projectInfo.supervisorArchiveDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.supervisorArchiveDate' format='yyyy-MM-dd' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">征询评价1:</label>
										<input class="width100Input"
										name="projectInfo.supervisorConsultOne"
										value="<s:property value='projectInfo.supervisorConsultOne'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">征询评价2:</label>
										<input class="width100Input"
										name="projectInfo.supervisorConsultTwo"
										value="<s:property value='projectInfo.supervisorConsultTwo'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">档案接收人:</label>
										<input class="width100Input"
										name="projectInfo.supervisorArchiveRecipient"
										value="<s:property value='projectInfo.supervisorArchiveRecipient'/>" />
									</li>
								</ul>
							</div>
							<div id="projectType4" style="display: none;">
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">总投资:</label>
										<input class="width100Input" name="projectInfo.consultInvest"
										value="<s:property value='projectInfo.consultInvest'/>" /></li>
									<li class="width200Li"><label class="width6Lb">建安量:</label>
										<input class="width100Input"
										name="projectInfo.consultQuantity"
										value="<s:property value='projectInfo.consultQuantity'/>" />
									</li>
									<li class="width200Li"><label class="width9Lb">咨询成果主要内容:</label>
										<input class="width250Input"
										name="projectInfo.consultResultContent"
										value="<s:property value='projectInfo.consultResultContent'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">发布日:</label>
										<input class="Wdate width100Input"
										name="projectInfo.consultAnnounceDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.consultAnnounceDate' format='yyyy-MM-dd' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">咨询开始日:</label>
										<input class="Wdate width100Input"
										name="projectInfo.consultStartDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.consultStartDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">咨询完成日:</label>
										<input class="Wdate width100Input"
										name="projectInfo.consultFinishDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.consultFinishDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">归档日期:</label>
										<input class="Wdate width100Input"
										name="projectInfo.consultArchiveDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.consultArchiveDate' format='yyyy-MM-dd' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">评审日期:</label>
										<input class="Wdate width100Input"
										name="projectInfo.consultReviewDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="<s:date name='projectInfo.consultReviewDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">专家名单:</label>
										<input class="width100Input"
										name="projectInfo.consultExpertList"
										value="<s:property value='projectInfo.consultExpertList'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">档案接收人:</label>
										<input class="width100Input"
										name="projectInfo.consultArchiveRecipient"
										value="<s:property value='projectInfo.consultArchiveRecipient'/>" />
									</li>
								</ul>
							</div>
							<br>
							<br>
							<ul class="fullScreenUl">
								<li class="width500Li">业务档案校对时间: _______________________</li>
								<li class="width300Li">档案接收人书面签字: _______________________</li>
							</ul>
							</s:if>
							<!-- 财务权限人员,查看项目财务信息  -->
							<s:if test="#request.accountManage == true">
							<h4 class="title">项目财务信息</h4>
							<br>
							<ul class="fullScreenUl">
								<li class="width200Li"><h5 class="title">收入部分</h5></li>															
							</ul>
							<div id="earnestInPart" style="display: none">
							<fieldset><legend>保证金</legend>						 
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">开票人:</label>
										<select id="projectInfo.earnestInDrawer.id" name="projectInfo.earnestInDrawer.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.earnestInDrawer.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
									</select>
									</li>
									<li class="width200Li"><label class="width6Lb">开票日期:</label>
										<input class="Wdate width100Input" name="projectInfo.earnestInInvoiceDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.earnestInInvoiceDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">发票编号:</label>
										<input class="width100Input" name="projectInfo.earnestInNumber" value="<s:property value='projectInfo.earnestInNumber'/>" />
									</li>	
									<li class="width200Li"><label class="width6Lb">开票金额:</label>
										<input class="width100Input" name="projectInfo.earnestInPrice" value="<s:property value='projectInfo.earnestInPrice'/>" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">承办人:</label>
										<select id="projectInfo.earnestUndertaker.id" name="projectInfo.earnestUndertaker.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.earnestUndertaker.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
								</ul>							
							</fieldset>
							</div>
							<div id="tenderPart" style="display: none">
							<fieldset><legend>标书费</legend>						 
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">收款日期:</label>
										<input class="Wdate width100Input" name="projectInfo.tenderReceiveDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.tenderReceiveDate' format='yyyy-MM-dd' />" />
									</li>									
									<li class="width200Li"><label class="width6Lb">发票编号:</label>
										<input class="width100Input" name="projectInfo.tenderInvoiceNumber" value="<s:property value='projectInfo.tenderInvoiceNumber'/>" />
									</li>	
									<li class="width200Li"><label class="width6Lb">金额:</label>
										<input class="width100Input" name="projectInfo.tenderInvoicePrice" value="<s:property value='projectInfo.tenderInvoicePrice'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">承办人:</label>
										<select id="projectInfo.tenderUndertaker.id" name="projectInfo.tenderUndertaker.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.tenderUndertaker.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>									
								</ul>							
							</fieldset>
							</div>
							<div id="agentPart" style="display: none">
								<fieldset><legend>委托单位</legend>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">开票人:</label>
									<select id="projectInfo.agentInvoiceDrawer.id" name="projectInfo.agentInvoiceDrawer.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.agentInvoiceDrawer.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
									</select>
									</li>
									<li class="width200Li"><label class="width6Lb">开票日期:</label>
										<input class="Wdate width100Input" name="projectInfo.agentInvoiceDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.agentInvoiceDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">发票编号:</label>
										<input class="width100Input" name="projectInfo.agentInvoiceNumber" value="<s:property value='projectInfo.agentInvoiceNumber'/>" />
									</li>	
									<li class="width200Li"><label class="width6Lb">开票金额:</label>
										<input class="width100Input" name="projectInfo.agentInvoicePrice" value="<s:property value='projectInfo.agentInvoicePrice'/>" />
									</li>								
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">领票人:</label>
										<select id="projectInfo.agentInvoiceHolder.id" name="projectInfo.agentInvoiceHolder.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.agentInvoiceHolder.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
									<li class="width200Li"><label class="width6Lb">到款日期:</label>
										<input class="Wdate width100Input" name="projectInfo.agentReceiveDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.agentReceiveDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">到款金额:</label>
										<input class="width100Input" name="projectInfo.agentReceivePrice" value="<s:property value='projectInfo.agentReceivePrice'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">财务:</label>
										<input class="width100Input" name="projectInfo.agentAccount" value="<s:property value='projectInfo.agentAccount'/>" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">备注:</label>
										<input class="width100Input" name="projectInfo.agentComment" value="<s:property value='projectInfo.agentComment'/>" />
									</li>
								</ul>
								</fieldset>
							</div>
							<div id="vendorPart" style="display: none">
								<fieldset><legend>送审单位</legend>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">开票人:</label>
										<select id="projectInfo.vendorInvoiceDrawer.id" name="projectInfo.vendorInvoiceDrawer.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.vendorInvoiceDrawer.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
									<li class="width200Li"><label class="width6Lb">开票日期:</label>
										<input class="Wdate width100Input" name="projectInfo.vendorInvoiceDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.vendorInvoiceDate' format='yyyy-MM-dd' />" />
									</li>									
									<li class="width200Li"><label class="width6Lb">发票编号:</label>
										<input class="width100Input" name="projectInfo.vendorInvoiceNumber" value="<s:property value='projectInfo.vendorInvoiceNumber'/>" />
									</li>	
									<li class="width200Li"><label class="width6Lb">开票金额:</label>
										<input class="width100Input" name="projectInfo.vendorInvoicePrice" value="<s:property value='projectInfo.vendorInvoicePrice'/>" />
									</li>								
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">领票人:</label>
										<select id="projectInfo.vendorInvoiceHolder.id" name="projectInfo.vendorInvoiceHolder.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.vendorInvoiceHolder.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
									<li class="width200Li"><label class="width6Lb">到款日期:</label>
										<input class="Wdate width100Input" name="projectInfo.vendorReceiveDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.vendorReceiveDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">到款金额:</label>
										<input class="width100Input" name="projectInfo.vendorReceivePrice" value="<s:property value='projectInfo.vendorReceivePrice'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">财务:</label>
										<input class="width100Input" name="projectInfo.vendorAccount" value="<s:property value='projectInfo.vendorAccount'/>" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">备注:</label>
										<input class="width100Input" name="projectInfo.vendorComment" value="<s:property value='projectInfo.vendorComment'/>" />
									</li>
								</ul>
								</fieldset>
							</div>
							<br>
							<ul class="fullScreenUl">
								<li class="width200Li"><h5 class="title">支出部分</h5></li>														
							</ul>
							<div id="earnestOutPart" style="display: none">
							<fieldset><legend>保证金</legend>						 
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">退款人:</label>
										<select id="projectInfo.earnestOutRefunder.id" name="projectInfo.earnestOutRefunder.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.earnestOutRefunder.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
									<li class="width200Li"><label class="width6Lb">退款日期:</label>
										<input class="Wdate width100Input" name="projectInfo.earnestOutRefundDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.earnestOutRefundDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">支票\现金:</label>
										<input class="width100Input" name="projectInfo.earnestOutType" value="<s:property value='projectInfo.earnestOutType'/>" />
									</li>	
									<li class="width200Li"><label class="width6Lb">金额:</label>
										<input class="width100Input" name="projectInfo.earnestOutPrice"value="<s:property value='projectInfo.earnestOutPrice'/>" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">承办人:</label>
										<select id="projectInfo.earnestOutUndertaker.id" name="projectInfo.earnestOutUndertaker.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.earnestOutUndertaker.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
								</ul>							
							</fieldset>
							</div>
							<div id="meetingPlacePart" style="display: none">
							<fieldset><legend>会场费</legend>						 
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">支付人:</label>
										<select id="projectInfo.meetingPlacePayer.id" name="projectInfo.meetingPlacePayer.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.meetingPlacePayer.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
									<li class="width200Li"><label class="width6Lb">支付日期:</label>
										<input class="Wdate width100Input" name="projectInfo.meetingPlacePayDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.meetingPlacePayDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">金额:</label>
										<input class="width100Input" name="projectInfo.meetingPlacePrice" value="<s:property value='projectInfo.meetingPlacePrice'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">承办人:</label>
										<select id="projectInfo.meetingPlaceUndertaker.id" name="projectInfo.meetingPlaceUndertaker.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.meetingPlaceUndertaker.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">会场地址:</label>
										<input class="width100Input" name="projectInfo.meetingPlaceAddress" value="<s:property value='projectInfo.meetingPlaceAddress'/>" />
									</li>	
								</ul>							
							</fieldset>
							</div>
							<div id="expertPart" style="display: none">
							<fieldset><legend>专家费</legend>						 
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">支付人:</label>
										<select id="projectInfo.expertPayer.id" name="projectInfo.expertPayer.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.expertPayer.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
									<li class="width200Li"><label class="width6Lb">支付日期:</label>
										<input class="Wdate width100Input" name="projectInfo.expertPayDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='projectInfo.expertPayDate' format='yyyy-MM-dd' />" />
									</li>
									<li class="width200Li"><label class="width6Lb">金额:</label>
										<input class="width100Input" name="projectInfo.expertPrice" value="<s:property value='projectInfo.expertPrice'/>" />
									</li>
									<li class="width200Li"><label class="width6Lb">承办人:</label>
										<select id="projectInfo.expertUndertaker.id" name="projectInfo.expertUndertaker.id" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />"
												<s:if test="id==projectInfo.expertUndertaker.id">selected</s:if>>
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">人员情况:</label>
										<input class="width100Input" name="projectInfo.expertPerson" value="<s:property value='projectInfo.expertPerson'/>" />
									</li>	
								</ul>	
							</fieldset>
							</div>
							
							<div id="costPart" style="display: none">
								<s:if test="projectInfo.costs != null && projectInfo.costs.size() > 0">
									<s:iterator value="projectInfo.costs" status="st">
										<div>
											<fieldset><legend>成本报销</legend>											 
												<ul class="fullScreenUl">
													<li class="width200Li"><label class="width6Lb">领款人:</label>
														<select id="projectInfo.costRemittee" name="projectInfo.costRemittee" class="width100Input">
														<s:iterator value="userInfoList" status="st">
															<option value="<s:property value='id' />"
																<s:if test="id==remitteeID">selected</s:if>>
																<s:property value="realName" />
															</option>
														</s:iterator>
														</select>
													</li>
													<li class="width200Li"><label class="width6Lb">结算日期:</label>
														<input class="Wdate width100Input" name="projectInfo.costSettleDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
															value="<s:date name='settleDate' format='yyyy-MM-dd' />" />
													</li>
													<li class="width200Li"><label class="width6Lb">金额:</label>
														<input class="width100Input" name="projectInfo.costPrice" value="<s:property value='price' />" />
													</li>
													<li class="width200Li"><label class="width6Lb">财务:</label>
														<input class="width100Input" name="projectInfo.costAccount" value="<s:property value='account' />" />
													</li>
												</ul>
												<ul class="fullScreenUl">
													<li class="width200Li"><label class="width6Lb">备注:</label>
														<input class="width100Input" name="projectInfo.costComment" value="<s:property value='comment' />" />
													</li>
													<li>
														<input type="button" class="mediumLeftButton" onclick="delCost(this)" value="删除">
													</li>
												</ul>
											</fieldset>
										</div>
									</s:iterator>
								</s:if>
							</div>
							<br>
							<ul class="fullScreenUl">
								<li><input type="button" class="mediumLeftButton"
									onclick="addCost()" value="新增成本报销">
								</li>
							</ul>
							<br>
							<br>
							<ul class="fullScreenUl">
								<li class="width500Li">财务档案校对时间: _______________________</li>
								<li class="width300Li">财务总监书面签字: _______________________</li>
							</ul>
							</s:if>
							
							<h4 class="title">项目附件信息</h4>
							<div id="attachmentDIV">
								<s:if test="projectInfo.projectFiles != null && projectInfo.projectFiles.size() > 0">
									<s:iterator value="projectInfo.projectFiles" status="st">
										<ul class="fullScreenUl">
											<li class="width400Li"><a
												href="<s:property value='filePath' />"
												<s:if test="fileName.contains('.jpg') || fileName.contains('.JPG')">target="blank"</s:if>><s:property
														value='fileName' /> </a>
											</li>
											<li class="width200Li"><input type="hidden"
												id="projectInfo.oldFileName" name="projectInfo.oldFileName"
												value="<s:property value='fileName' />" />
											</li>
											<li><input type="button" class="mediumLeftButton"
												onclick="delAttachment(this)" value="删除">
											</li>
										</ul>
									</s:iterator>
								</s:if>
								<input type="hidden" id="projectInfo.filePath"
									name="projectInfo.filePath"
									value="<s:property value='projectInfo.filePath' />" />
							</div>
							<ul class="fullScreenUl">
								<li><input type="button" class="mediumLeftButton"
									onclick="addAttachment()" value="新增附件">
								</li>
							</ul>

							<h4 class="title">项目状态信息</h4>
							<ul class="fullScreenUl">
								<s:if test="projectInfo.status==0">
									<li><label class="width6Lb">项目状态:</label>未提交</li>
									<li><label class="width6Lb">保存时间:</label> <s:date
											name='projectInfo.updateTime' format='yyyy-MM-dd hh:mm:ss' />
								</s:if>
								<s:elseif test="projectInfo.status==1">
									<li><label class="width6Lb">项目状态:</label>已提交</li>
									<li><label class="width6Lb">提交时间:</label> <s:date
											name='projectInfo.submitTime' format='yyyy-MM-dd hh:mm:ss' />
									</li>
								</s:elseif>
								<s:elseif test="projectInfo.status==2">
									<li><label class="width6Lb">项目状态:</label>部门经理审批通过</li>
									<li><label class="width6Lb">审批时间:</label> <s:date
											name='projectInfo.deptApproveTime'
											format='yyyy-MM-dd hh:mm:ss' />
									</li>
								</s:elseif>
								<s:elseif test="projectInfo.status==3">
									<li><label class="width6Lb">项目状态:</label>总师审批通过</li>
									<li><label class="width6Lb">审批时间:</label> <s:date
											name='projectInfo.masterApproveTime'
											format='yyyy-MM-dd hh:mm:ss' />
									</li>
								</s:elseif>
								<s:elseif test="projectInfo.status==4">
									<li><label class="width6Lb">项目状态:</label>总经理审批通过</li>
									<li><label class="width6Lb">审批时间:</label> <s:date
											name='projectInfo.managerApproveTIme'
											format='yyyy-MM-dd hh:mm:ss' />
									</li>
								</s:elseif>
								<s:elseif test="projectInfo.status==5">
									<li><label class="width6Lb">项目状态:</label>项目编号已提供</li>
									<li><label class="width6Lb">提供时间:</label> <s:date
											name='projectInfo.updateTime'
											format='yyyy-MM-dd hh:mm:ss' />
									</li>
								</s:elseif>
								<s:elseif test="projectInfo.status==9">
									<li><label class="width6Lb">项目状态:</label>已结项</li>
									<li><label class="width6Lb">结项时间:</label> <s:date
											name='projectInfo.updateTime' format='yyyy-MM-dd hh:mm:ss' />
								</s:elseif>
							</ul>

							<ul class="fullScreenUl">
								<s:if
									test="projectInfo.status==0 && #request.submitProject == true && projectInfo.submitter.id==#request.userid">
									<li><input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('1')"
										value="提交项目"> <input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('0')"
										value="保存"></li>
								</s:if>				

								<s:if
									test="projectInfo.status==1 && #request.deptApprove == true">
									<li><input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('0')"
										value="审批不通过"> <input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('2')"
										value="审批通过"></li>
								</s:if>

								<s:if
									test="projectInfo.status==2 && #request.masterApprove == true">
									<li><input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('1')"
										value="审批不通过"> <input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('3')"
										value="审批通过"></li>
								</s:if>

								<s:if
									test="projectInfo.status==3 && #request.managerApprove == true">
									<li><input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('2')"
										value="审批不通过"> <input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('4')"
										value="审批通过"></li>
								</s:if>

								<s:if test="projectInfo.status==4 && #request.directorFillNo == true">
									<li><input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('5')"
										value="保存"></li>
								</s:if>
								
								<s:if test="projectInfo.status==5 && (#request.businessManage == true || #request.accountManage == true)">
									<li><input type="button" id="addProject"
										class="mediumRightButton" onclick="modProjectInfo('5')"
										value="保存"></li>
								</s:if>
								
								
								<li><input type="hidden" id="projectInfo.status"
									name="projectInfo.status"
									value="<s:property value='projectInfo.status'/>" /></li>
								<li><input type="hidden" id="projectInfo.submitTime"
									name="projectInfo.submitTime"
									value="<s:property value='projectInfo.submitTime'/>" /></li>
								<li><input type="hidden" id="projectInfo.deptApproveTime"
									name="projectInfo.deptApproveTime"
									value="<s:property value='projectInfo.deptApproveTime'/>" /></li>
								<li><input type="hidden" id="projectInfo.masterApproveTime"
									name="projectInfo.masterApproveTime"
									value="<s:property value='projectInfo.masterApproveTime'/>" />
								</li>
								<li><input type="hidden"
									id="projectInfo.managerApproveTIme"
									name="projectInfo.managerApproveTIme"
									value="<s:property value='projectInfo.managerApproveTIme'/>" />
								</li>
								<li><input type="hidden" id="status" name="status" /></li>
							</ul>
						</s:form>
						
						<ul style="display: none">
							<li id="participantLI" class="width200Li">
								<select id="projectInfo.participant" name="projectInfo.participant" class="width100Input">
									<s:iterator value="userInfoList" status="st">
										<option value="<s:property value='id' />">
											<s:property value="realName" />
										</option>
									</s:iterator>
								</select>
								<input type="button" class="mediumLeftButton" onclick="delParticipant(this)" value="删除">						
							</li>
						</ul>
						
						<div id="costDiv" style="display: none">
							<fieldset><legend>成本报销</legend>											 
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">领款人:</label>
										<select id="projectInfo.costRemittee" name="projectInfo.costRemittee" class="width100Input">
										<s:iterator value="userInfoList" status="st">
											<option value="<s:property value='id' />">
												<s:property value="realName" />
											</option>
										</s:iterator>
										</select>
									</li>
									<li class="width200Li"><label class="width6Lb">结算日期:</label>
										<input class="Wdate width100Input" name="projectInfo.costSettleDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
									<li class="width200Li"><label class="width6Lb">金额:</label>
										<input class="width100Input" name="projectInfo.costPrice" />
									</li>
									<li class="width200Li"><label class="width6Lb">财务:</label>
										<input class="width100Input" name="projectInfo.costAccount" value="<s:property value='account' />" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">备注:</label>
										<input class="width100Input" name="projectInfo.costComment" />
									</li>
									<li>
										<input type="button" class="mediumLeftButton" onclick="delCost(this)" value="删除">
									</li>	
								</ul>
							</fieldset>
						</div>
						
						<ul id="attachmentUL" class="fullScreenUl" style="display: none">
							<li class="width300Li"><s:file name="uploadFiles"
									id="uploadFiles" size="30" onchange="chooseFile(this)" /> <input
								type="hidden" name="projectInfo.fileName"
								id="projectInfo.fileName"></li>
							<li><input type="button" class="mediumLeftButton"
								onclick="delAttachment(this)" value="删除">
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
</html>