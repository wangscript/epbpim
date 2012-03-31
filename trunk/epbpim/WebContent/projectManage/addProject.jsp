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
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">项目录入</h3>
					<div id="addProjectTable">
						<s:form id="addForm" action="addProject.do" enctype="multipart/form-data" method="post" onsubmit="return validate(this);">
						<h4 class="title">项目基本信息</h4>				
						<ul class="fullScreenUl">	
							<li class="width200Li"><label class="width4Lb">承接部门:</label>
								<select id="projectInfo.dept.id" name="projectInfo.dept.id" class="width100Input">
									<s:iterator value="adminDeptList" status="st">
										<option value="<s:property value='id' />">
											<s:property value="name" />
										</option>
									</s:iterator>
								</select>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width4Lb">项目名称:</label>
								<input  class="width300Input" name="projectInfo.name">
								<textValidate field="projectInfo.name" lableText="<s:text name='项目名称' />" isValidate="true" min="0" max="100">
							</li>
							<li class="width200Li" style="display: none"><label class="width4Lb">项目编号:</label>
								<input class="width100Input" name="projectInfo.number" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">工程专业:</label>
								<select id="majorType" name="projectInfo.majorType" class="width100Input">
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
								<select id="valuationType" name="projectInfo.valuationType" class="width100Input">
									<option value="清单">清单</option>
									<option value="2000定额">2000定额</option>
									<option value="其他">其他</option>
								</select>
							</li>					
							<li class="width200Li"><label class="width4Lb">开始时间:</label>
								<input class="Wdate width100Input" name="projectInfo.startDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
							</li>			
							<li class="width200Li"><label class="width4Lb">质量要求:</label>
								<input class="width100Input" name="projectInfo.quality"/></li>
						</ul>							
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">项目经理:</label>
								<select id="projectInfo.manager.id" name="projectInfo.manager.id" class="width100Input">
									<s:iterator value="userInfoList" status="st">
										<option value="<s:property value='id' />">
											<s:property value="realName" />
										</option>
									</s:iterator>
								</select>
							</li>
							<li class="width200Li"><label class="width5Lb">部门负责人:</label>
								<select id="projectInfo.owner.id" name="projectInfo.owner.id" class="width100Input">
									<s:iterator value="userInfoList" status="st">
										<option value="<s:property value='id' />">
											<s:property value="realName" />
										</option>
									</s:iterator>
								</select>
							</li>
							<li class="width200Li"><label class="width5Lb">编制人:</label>
								<select id="projectInfo.formater.id" name="projectInfo.formater.id" class="width100Input">
									<s:iterator value="userInfoList" status="st">
										<option value="<s:property value='id' />">
											<s:property value="realName" />
										</option>
									</s:iterator>
								</select>
							</li>
							<li class="width200Li"><label class="width5Lb">审核人:</label>
								<select id="projectInfo.verifier.id" name="projectInfo.verifier.id" class="width100Input">
									<s:iterator value="userInfoList" status="st">
										<option value="<s:property value='id' />">
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
							<li class="width100Li">
								<input type="button" class="mediumLeftButton" onclick="addParticipant(this)" value="新增参与人">
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">合同编号:</label>
								<input class="width100Input" name="projectInfo.contractNumber"/>
							</li>
							<li class="width200Li"><label class="width5Lb">合同金额:</label>
								<input class="width100Input" name="projectInfo.contractMoney"/>
							</li>
							<li class="width200Li"><label class="width6Lb">部门流转单号:</label>
								<input class="width100Input" id="contractNumber" name="projectInfo.deptTransferNumber"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width800Li"><label class="width7Lb">合同摘要:</label><textarea style="height: 40px; width: 500px;"  name="projectInfo.contractAbstract"></textarea>
							</li>
							<li><br></li>
						</ul>							
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width7Lb">委托(建设)单位:</label>
								<input class="width300Input" name="projectInfo.customerCompany" />
							</li>
							<li class="width200Li"><label class="width4Lb">联系人:</label>
								<input class="width100Input" name="projectInfo.customerContactor"/>
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label>
								<input class="width100Input" name="projectInfo.customerContact"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width7Lb">相关(关系)单位:</label>
								<input class="width300Input" name="projectInfo.mediatorCompany"/>
							</li>
							<li class="width200Li"><label class="width4Lb">联系人:</label>
								<input class="width100Input" name="projectInfo.mediatorContactor"/>
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label>
								<input class="width100Input" name="projectInfo.mediatorContact"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width7Lb">送审(施工)单位:</label>
								<input class="width300Input" name="projectInfo.vendorCompany"/></li>
							<li class="width200Li"><label class="width4Lb">联系人:</label>
								<input class="width100Input" name="projectInfo.vendorContactor" />
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label>
								<input class="width100Input" name="projectInfo.vendorContact"/>
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width400Li"><label class="width7Lb">中标单位:</label>
								<input class="width300Input" name="projectInfo.biddingCompany"/></li>
							<li class="width200Li"><label class="width4Lb">联系人:</label>
								<input class="width100Input" name="projectInfo.biddingContactor"/>
							</li>
							<li class="width200Li"><label class="width2Lb">电话:</label>
								<input class="width100Input" name="projectInfo.biddingContact"/></li>
						</ul>
						
						<h4 class="title">项目业务信息</h4>
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
						
						<h4 class="title">附件信息</h4>
						<div id="attachmentDIV">
							<ul class="fullScreenUl">
								<li class="width300Li">
									<s:file name="uploadFiles" id="uploadFiles" size="30" onchange="chooseFile(this)" />
									<input type="hidden" name="projectInfo.fileName" id="projectInfo.fileName">
								</li>
								<li><input type="button" class="mediumLeftButton" onclick="delAttachment(this)" value="删除"></li>
							</ul>
						</div>
						<ul class="fullScreenUl">
							<li><input type="button" class="mediumLeftButton" onclick="addAttachment()" value="新增附件"></li>
						</ul>
						
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
									<li class="width200Li"><label class="width6Lb">账务:</label>
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
							<li class="width300Li">
								<s:file name="uploadFiles" id="uploadFiles" size="30" onchange="chooseFile(this)" />
								<input type="hidden" name="projectInfo.fileName" id="projectInfo.fileName">
							</li>
							<li><input type="button" class="mediumLeftButton" onclick="delAttachment(this)" value="删除"></li>
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
