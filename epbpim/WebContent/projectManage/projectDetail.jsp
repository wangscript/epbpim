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
<script type="text/javascript">
	function setSelectValue()
	{
		changeProjectType();
	}
	function changeProjectType() {
 		var type = document.getElementById("projectType").innerHTML;
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
<body onload="changeProjectType()">
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="content_resize">
				<div class="mainbar">
					<!--startprint-->
					
					<h3 class="title">项目详情</h3>
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
							<li class="width200Li"><label class="width4Lb">项目经理:</label><s:property value='projectInfo.manager.realName' />
							</li>
						</ul>
						
						<ul class="fullScreenUl" id="addNewMember">
							<li class="width200Li"><label class="width6Lb">项目性质:</label><label id="projectType"><s:property value='projectInfo.projectType'/></label>
							</li>
							<li class="width400Li"><label class="width6Lb">服务内容:</label><s:property value='projectInfo.projectTypeComment' />
							</li>
						</ul>
						<div id="projectType1">
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
						</ul></div>
						<div id="projectType2" style="display:none;">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">总投资:</label><s:property value='projectInfo.proxyInvest' />
							</li>
							<li class="width200Li"><label class="width6Lb">建安量:</label><s:property value='projectInfo.proxyQuantity' />
							</li>
							<li class="width200Li"><label class="width6Lb">中标金额:</label><s:property value='projectInfo.proxyBiddingAmount' />
							</li>
							<li class="width200Li"><label class="width6Lb">征询单日期:</label><s:date name='projectInfo.proxyConsult' format='yyyy-MM-dd' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">代理开始日:</label><s:date name='projectInfo.proxyStartDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">开、评标日:</label><s:date name='projectInfo.proxyOpenEvalDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">评价:</label><s:property value='projectInfo.proxyEvaluate' />
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label><s:date name='projectInfo.proxyArchiveDate' format='yyyy-MM-dd' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">中标书编号:</label><s:property value='projectInfo.proxyBiddingIdentity' /> 
							</li>
							<li class="width200Li"><label class="width6Lb">中标书发出:</label><s:property value='projectInfo.proxyBiddingSend' />
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label><s:property value='projectInfo.proxyArchiveRecipient' />
							</li>
						</ul></div>
						<div id="projectType3" style="display:none;">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">总投资:</label><s:property value='projectInfo.supervisorInvest' />
							</li>
							<li class="width200Li"><label class="width6Lb">建安量:</label><s:property value='projectInfo.supervisorQuantity' />
							</li>
							<li class="width200Li"><label class="width10Lb">投资监理大纲及成果:</label><s:property value='projectInfo.supervisorOutline' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">开始日:</label><s:date name='projectInfo.supervisorStartDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">实际完成日:</label><s:date name='projectInfo.supervisorFinishDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label><s:date name='projectInfo.supervisorArchiveDate' format='yyyy-MM-dd' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">征询评价1:</label><s:property value='projectInfo.supervisorConsultOne' />
							</li>
							<li class="width200Li"><label class="width6Lb">征询评价2:</label><s:property value='projectInfo.supervisorConsultTwo' />
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label><s:property value='projectInfo.supervisorArchiveRecipient' />
							</li>
						</ul></div>
						<div id="projectType4" style="display:none;">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">总投资:</label><s:property value='projectInfo.consultInvest' />
							</li>
							<li class="width200Li"><label class="width6Lb">建安量:</label><s:property value='projectInfo.consultQuantity' />
							</li>
							<li class="width200Li"><label class="width9Lb">咨询成果主要内容:</label><s:property value='projectInfo.consultResultContent' />
							</li>
							<li class="width200Li"><label class="width6Lb">发布日:</label><s:date name='projectInfo.consultAnnounceDate' format='yyyy-MM-dd' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">咨询开始日:</label><s:date name='projectInfo.consultStartDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">咨询完成日:</label><s:date name='projectInfo.consultFinishDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">归档日期:</label><s:date name='projectInfo.consultArchiveDate' format='yyyy-MM-dd' />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">评审日期:</label><s:date name='projectInfo.consultReviewDate' format='yyyy-MM-dd' />
							</li>
							<li class="width200Li"><label class="width6Lb">专家名单:</label><s:property value='projectInfo.consultExpertList' />
							</li>
							<li class="width200Li"><label class="width6Lb">档案接收人:</label><s:property value='projectInfo.consultArchiveRecipient' />
							</li>
						</ul></div>
						<h4 class="title">附件信息</h4>
						<div id="attachmentDIV">
							<s:if test="projectInfo.projectFiles != null && projectInfo.projectFiles.size() > 0">
								<s:iterator value="projectInfo.projectFiles" status="st">
									<ul class="fullScreenUl">
										<li class="width200Li"><a href="<s:property value='filePath' />"><s:property value='fileName' /></a></li>
									</ul>
								</s:iterator>
							</s:if>
						</div>		
						
						<!--endprint-->
						<ul class="fullScreenUl">
							<li>
								<input 	type="button" class="mediumRightButton"value="打印项目详情" onClick="doPrint()">
							</li>
						</ul>
						<%
							String userid = String.valueOf((Long)session.getAttribute(Constants.LOGIN_USER_ID));
							List<AdminMenu> menus = (List)CacheMap.getInstance().getCache(Constants.MENU_CACHE+Constants.LOGIN_USER_ID+userid);
							for(AdminMenu menu:menus){
								if(menu.getId() == 305){
									request.setAttribute("addCost", true);
								}
								if(menu.getId() == 306){
									request.setAttribute("qryCost", true);
								}
								if(menu.getId() == 307){
									request.setAttribute("delCost", true);
								}
								
								if(menu.getId() == 308){
									request.setAttribute("addBonus", true);
								}
								if(menu.getId() == 309){
									request.setAttribute("qryBonus", true);
								}
								if(menu.getId() == 310){
									request.setAttribute("delBonus", true);
								}
								
								if(menu.getId() == 311){
									request.setAttribute("closeProject", true);
								}
							}
							
						%>
						<s:if test="projectInfo.status != 2">
							<s:if test="#request.addCost == true">
						<h4 class="title">合同信息</h4>
						<s:form id="modForm" action="modProjectContractAndInvoices.do" method="post" >
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width6Lb">合同编号:</label> <input
								class="width100Input"
								name="projectInfo.contractNumber" value="<s:property value='projectInfo.contractNumber' />"/>
							</li>
							<li class="width200Li"><label class="width6Lb">合同金额:</label> <input
								class="width100Input"
								name="projectInfo.contractMoney" value="<s:property value='projectInfo.contractMoney' />"/>
							</li>
							<li class="width400Li"><label class="width6Lb">合同摘要:</label> <input
								class="width300Input"
								name="projectInfo.contractAbstract" value="<s:property value='projectInfo.contractAbstract' />"/>
							</li>
						</ul>
						<div id="invoiceDIV">
							<s:if test="projectInfo.projectInvoices != null && projectInfo.projectInvoices.size() > 0">
								<s:iterator value="projectInfo.projectInvoices" status="st">
									<ul class="fullScreenUl">
										<li class="width200Li"><label class="width6Lb">开票日期:</label> <input
											class="Wdate width100Input" name="projectInfo.invoiceDate"
											onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<s:date name='invoiceDate' format='yyyy-MM-dd' />"/>
										</li>
										<li class="width200Li"><label class="width6Lb">开票金额:</label> <input
											class="width100Input"
											name="projectInfo.invoicePrice" value="<s:property value='invoicePrice' />"/>
										</li>
										<li class="width250Li"><label class="width6Lb">发票单号:</label> <input
											class="width150Input"
											name="projectInfo.invoiceNumber" value="<s:property value='invoiceNumber' />"/>
										</li>
										<li class="width150Li"><label class="width6Lb">是否到账:</label> 
											<select name="projectInfo.invoiceMoneyArrival" >
											<s:if test="invoiceMoneyArrival!= 1&&invoiceMoneyArrival!= 0"><option value=" " selected="selected">请选择</option><option value="1">是</option>
												<option value="0">否</option></s:if>
											<s:if test="invoiceMoneyArrival==1"><option value="" >请选择</option><option value="1" selected="selected">是</option>
												<option value="0">否</option></s:if>
											<s:if test="invoiceMoneyArrival==0"><option value="" >请选择</option><option value="1">是</option>
												<option value="0" selected="selected">否</option></s:if>
												
											</select></li>
										<li><input type="button" class="mediumLeftButton" onclick="delInvoice(this)" value="删除"></li>
									</ul>
								</s:iterator>
							</s:if>
						</div>
						<ul class="fullScreenUl">
							<li><input type="button" class="mediumLeftButton" onclick="addInvoice()" value="新增发票"></li>
						</ul>
						<ul id="invoiceUL" class="fullScreenUl" style="display: none">
							<li class="width200Li"><label class="width6Lb">开票日期:</label> <input
								class="Wdate width100Input" name="projectInfo.invoiceDate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
							</li>
							<li class="width200Li"><label class="width6Lb">开票金额:</label> <input
								class="width100Input"
								name="projectInfo.invoicePrice"/>
							</li>
							<li class="width250Li"><label class="width6Lb">发票单号:</label> <input
								class="width150Input"
								name="projectInfo.invoiceNumber"/>
							</li>
							<li class="width150Li"><label class="width6Lb">是否到账:</label> 
								<select name="projectInfo.invoiceMoneyArrival" >
									<option value=" " >请选择</option>
									<option value="1">是</option>
									<option value="0">否</option>
								</select></li>
							<li><input type="button" class="mediumLeftButton" onclick="delInvoice(this)" value="删除"></li>
						</ul>
						<ul class="fullScreenUl">
							<li>
								<input type="hidden" name="projectInfo.id" value="<s:property value='projectInfo.id'/>" />
								<input type="submit" class="mediumRightButton"value="保存" >
							</li>
						</ul>
						</s:form>
						
						</s:if>
						</s:if>
						<s:if test="projectInfo.projectStreams != null && projectInfo.projectStreams.size() > 0">
							<h4 class="title">成本/奖金信息</h4>
							<div class="searchResult" id="searchResult">
								<ul class="fullScreenUl">
									<li class="width200Li"><label>成本/奖金</label></li>
									<li class="width200Li"><label>金额</label></li>
									<li class="width200Li"><label>时间</label></li>
									<li class="width200Li"><label>备注</label></li>
									<s:if test=" #request.delCost == true || #request.delBonus == true">
										<li class="width50Li"><label><s:text name="Common.Delete" /></label></li>
									</s:if>
								</ul>
								<s:iterator value="projectInfo.projectStreams" status="st">
									<s:if test="(#request.qryCost == true && type == 1) || (#request.qryBonus == true && type == 2)">
										<ul class="fullScreenUl">
											<s:if test="type == 1">
												<li class="width200Li"><label>成本</label></li>
											</s:if>
											<s:else>
												<li class="width200Li"><label>奖金</label></li>
											</s:else>
											<li class="width200Li"><s:property value="money" /></li>
											<li class="width200Li"><s:date name='streamDate' format='yyyy-MM-dd' /></li>
											<li class="width200Li"><s:property value="comments" /></li>
											<s:if test="(#request.delCost == true && type == 1) || (#request.delBonus == true && type == 2)">
												<li class="width50Li">
													<form action="delProjectStream.do" method="post" id='delProjectStream<s:property value="id" />'>											
														<input type="hidden" name="projectStream.id" value='<s:property value="id" />' />
														<input type="hidden" name="projectStream.projectID" value="<s:property value='projectInfo.id'/>" />
														<input type="button" <s:if test="projectInfo.status == 2">disabled</s:if> onclick='delProjectStream("delProjectStream"+<s:property value="id" />);' class="mediumRightButton" class="button" value="<s:text name="Common.Delete" />">
													</form>
												</li>
											</s:if>
										</ul>
									</s:if>
								</s:iterator>
							</div>
						</s:if>
						
						<s:if test="projectInfo.status != 2">
							<s:if test="#request.addCost == true">
								<h4 class="title">增加成本</h4>
								<form action="addProjectStream.do" method="post">
									<input type="hidden" name="projectStream.projectID" value="<s:property value='projectInfo.id'/>" />
									<input type="hidden" name="projectStream.type" value="1" />
									<ul class="fullScreenUl">
										<li class="width200Li"><label class="width6Lb">成本:</label>
											<input class="width100Input" name="projectStream.money" id="projectStream.money"/>
										</li>
										<li class="width200Li"><label class="width6Lb">时间:</label>
											<input class="Wdate width100Input" name="projectStream.streamDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
										</li>
										<li class="width400Li"><label class="width6Lb">备注:</label>
											<input class="width300Input" name="projectStream.comments""/>
										</li>
										<li class="width100Li">
											<input type="submit" class="mediumRightButton" value="增加成本">
										</li>
									</ul>
								</form>
							</s:if>
							
							<s:if test="#request.addBonus == true">
								<h4 class="title">增加奖金</h4>
								<form action="addProjectStream.do" method="post">
									<input type="hidden" name="projectStream.projectID" value="<s:property value='projectInfo.id'/>" />
									<input type="hidden" name="projectStream.type" value="2" />
									<ul class="fullScreenUl">
										<li class="width200Li"><label class="width6Lb">奖金:</label>
											<input class="width100Input" name="projectStream.money" id="projectStream.money"/>
										</li>
										<li class="width200Li"><label class="width6Lb">时间:</label>
											<input class="Wdate width100Input" name="projectStream.streamDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
										</li>
										<li class="width400Li"><label class="width6Lb">备注:</label>
											<input class="width300Input" name="projectStream.comments""/>
										</li>
										<li class="width100Li">
											<input type="submit" class="mediumRightButton" value="增加奖金">
										</li>
									</ul>
								</form>
							</s:if>
							
							<s:if test="#request.closeProject = true">
								<form action="closeProject.do" method="post">
									<input type="hidden" name="projectInfo.id" value="<s:property value='projectInfo.id'/>" />
									<ul class="fullScreenUl">								
										<li><input type="submit" id="closeProject" class="mediumRightButton" value="结项"></li>
									</ul>
								</form>
							</s:if>
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
 	function delProjectStream(id){
		if(confirm('<s:text name="AdminRole.IfDelete" />')){
			document.getElementById(id).submit();
		}
	}

 	function addInvoice()
 	{
 		var invoiceULObj=document.getElementById("invoiceUL").cloneNode(true);
 		invoiceULObj.id="";
 		invoiceULObj.style.display="inline";
 		document.getElementById("invoiceDIV").appendChild(invoiceULObj);
 	}
 	function delInvoice(obj)
 	{
 		var invoiceULObj=obj.parentNode.parentNode;
 		invoiceULObj.parentNode.removeChild(invoiceULObj);
 	}
 	function doPrint() { 
 		bdhtml=window.document.body.innerHTML; 
 		currentHtml = bdhtml;
 		sprnstr="<!--startprint-->"; 
 		eprnstr="<!--endprint-->"; 
 		prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
 		prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
 		window.document.body.innerHTML=prnhtml; 
 		window.print(); 
 		setTimeout("window.document.body.innerHTML=currentHtml",3000);
 	}

</script>
</html>
