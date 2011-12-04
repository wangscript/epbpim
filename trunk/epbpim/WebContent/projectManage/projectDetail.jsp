<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.util.cache.CacheMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ryxx.bpim.common.Constants" %>
<%@ page import="com.ryxx.bpim.user.entity.AdminMenu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>项目详情</title>
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
							<li class="width200Li"><label class="width4Lb">负责人:</label><s:property value='projectInfo.owner.realName' />
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
						<%
							String userid = String.valueOf((Long)session.getAttribute(Constants.LOGIN_USER_ID));
							List<AdminMenu> menus = (List)CacheMap.getInstance().getCache(Constants.MENU_CACHE+Constants.LOGIN_USER_ID+userid);
							for(AdminMenu menu:menus){
								if(menu.getId() == 34){
									request.setAttribute("addCost", true);
								}
								if(menu.getId() == 35){
									request.setAttribute("delCost", true);
								}
								if(menu.getId() == 36){
									request.setAttribute("addBonus", true);
								}
								if(menu.getId() == 37){
									request.setAttribute("addBonus", true);
								}
								if(menu.getId() == 38){
									request.setAttribute("closeProject", true);
								}
							}
							
						%>
						<s:if test="#request.addCost == true">
						<h4 class="title">增加成本</h4>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">成本:</label> <input
								class="width100Input"
								name="cost" id="cost"/>
							</li>
							<li class="width200Li"><label class="width6Lb">时间:</label> <input
								class="Wdate width100Input" name="projectInfo.reportDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="costDate"/>
							</li>
							<li class="width400Li"><label class="width6Lb">备注:</label> <input
								class="width300Input"
								name="cost" id="costComments"/>
							</li>
							<li class="width100Li"><input type="button" id="addCost"
								class="mediumRightButton" 
								onclick="addCost();" 
								value="增加成本">
							</li>
						</ul>
						</s:if>
						
						<s:if test="#request.addBonus == true">
						<h4 class="title">增加奖金</h4>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">奖金:</label> <input
								class="width100Input"
								name="bonus" id="bonus"/>
							</li>
							<li class="width200Li"><label class="width6Lb">时间:</label> <input
								class="Wdate width100Input" name="projectInfo.reportDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="bonusDate"/>
							</li>
							<li class="width400Li"><label class="width6Lb">备注:</label> <input
								class="width300Input"
								name="bonusComments" id="bonusComments"/>
							</li>
							<li class="width100Li"><input type="button" id="addBonus"
								class="mediumRightButton" 
								onclick="addBonus();" 
								value="增加奖金">
							</li>
						</ul>
						</s:if>
						
						<s:if test="#request.closeProject = true">
						<ul class="fullScreenUl">
							<li><input type="button" id="closeProject"
								class="mediumRightButton" 
								onclick="closeProject();" 
								value="结项">
							</li>
						</ul>
						</s:if>
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
