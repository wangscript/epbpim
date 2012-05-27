<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.util.cache.CacheMap"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<%@ page import="com.ryxx.bpim.user.entity.AdminMenu"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>项目打印</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style type="text/css">
		.tblr {
			border-top: 1px solid black;
			border-bottom: 1px solid black;
			border-left: 1px solid black;
			border-right: 1px solid black;
		}
		.blr {
			border-bottom: 1px solid black;
			border-left: 1px solid black;
			border-right: 1px solid black;
		}
		.tbr {
			border-top: 1px solid black;
			border-bottom: 1px solid black;
			border-right: 1px solid black;
		}
		.br {
			border-bottom: 1px solid black;
			border-right: 1px solid black;
		}
		.b {
			border-bottom: 1px solid black;
		}
		.r {
			border-right: 1px solid black;
		}
		td {
			text-align: left;
		}
		
		.mediumRightButton {
			cursor: pointer;
			height: 25px;
			margin-right: 4px;
			display: block;
			float: right;
			text-align: center;
			background: url(../images/a_bg.gif) repeat-x center center;
			text-decoration: none;
			color: #5F5F5F;
		}		
	</style>
	<%
		String userid = String.valueOf((Long) session
				.getAttribute(Constants.LOGIN_USER_ID));
		List<AdminMenu> menus = (List) CacheMap.getInstance().getCache(
				Constants.MENU_CACHE + Constants.LOGIN_USER_ID + userid);
		boolean businessManage=false;
		boolean accountManage=false;
		for (AdminMenu menu : menus) {											
			if (menu.getId() == 316) {
				request.setAttribute("businessManage", true);
				businessManage=true;
			}
			if (menu.getId() == 317) {
				request.setAttribute("accountManage", true);
				accountManage=true;
			}
		}
	%>
	<script type="text/javascript">	
		function initInfo()
		{
			document.getElementById("businessTable").style.display="none";
			document.getElementById("accountTable").style.display="none";
			document.getElementById("businessDiv").style.display="none";
			document.getElementById("accountDiv").style.display="none";
			var businessManage=<%=businessManage%>;
			var accountManage=<%=accountManage%>;
			if(businessManage)
			{
				document.getElementById("businessTable").style.display="";
				document.getElementById("businessDiv").style.display="";
			}
			if(accountManage)
			{
				document.getElementById("accountTable").style.display="";
				document.getElementById("accountDiv").style.display="";
			}
		}
		
		function doPrint(printType)
		{
			document.getElementById("businessTable").style.display="none";
			document.getElementById("accountTable").style.display="none";
			document.getElementById("businessDiv").style.display="none";
			document.getElementById("accountDiv").style.display="none";
			if("business"==printType)
			{
				document.getElementById("businessTable").style.display="";	
				document.getElementById("businessDiv").style.display="";
			}
			else if("account"==printType)
			{
				document.getElementById("accountTable").style.display="";
				document.getElementById("accountDiv").style.display="";
			}
			document.getElementById("printDiv").style.display="none";
			window.print();
		}
		
	</script>
</head>
<body onload="initInfo()">
	<div id="printDiv" align="right">
		<s:if test="#request.accountManage == true">
			<input type="button" class="mediumRightButton" value="打印财务信息" onClick="doPrint('account')">	
		</s:if>
		<s:if test="#request.businessManage == true">
			<input type="button" class="mediumRightButton" value="打印业务信息" onClick="doPrint('business')">	
		</s:if>
		<br><br>
	</div>
	<div align="center"><h1>上海建惠建设咨询有限公司</h1></div>
	<div align="center" id="businessDiv"><font size="1">预决算、审价项目计划任务书（业务流转单）</font></div>
	<div align="center" id="accountDiv"><font size="1">预决算、审价项目计划任务书（财务流转单）</font></div>
	<div align="center">
	<table width="98%">
		<tr>
			<td >承接部门：<font style="text-decoration:underline"><s:property value='projectInfo.dept.name' /></font></td>
			<td style="text-align: right">项目编号：<font style="text-decoration:underline"><s:property value='projectInfo.number' /></font></td>
		</tr>
	</table>
	<!-- 项目基本信息表格 -->	
	<table width="98%" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="3" class="tblr">项目名称：<s:property value='projectInfo.name' /></td>
		</tr>
		<tr>
			<td colspan="3" class="blr">工程专业：<s:property value='projectInfo.majorType' /></td>
		</tr>
		<tr>
			<td class="blr">项目经理：<s:property value='projectInfo.manager.realName' /></td>
			<td class="br">
				部门负责人：<s:property value='projectInfo.owner.realName' /><br>
				审批时间&nbsp;&nbsp;：<s:date name='projectInfo.deptApproveTime' format='yyyy-MM-dd hh:mm:ss' />
			</td>
			<td class="br">
				公司批准人：<s:if test="projectInfo.status==4 || projectInfo.status==5 || projectInfo.status==9">周家俅</s:if><br>
				审批时间&nbsp;&nbsp;：<s:date name='projectInfo.managerApproveTIme' format='yyyy-MM-dd hh:mm:ss' /></td>
		</tr>
		<tr>
			<td colspan="3" class="blr">项目参与人：
				<s:if test="projectInfo.participants != null && projectInfo.participants.size() > 0">
					<s:iterator value="projectInfo.participants" status="st">
						<li id="participantLI" class="width100Li">
							<s:property value="participantName" />
						</li>
					</s:iterator>
				</s:if>
			</td>
		</tr>
		<tr>
			<td class="blr">合同编号：<s:property value='projectInfo.contractNumber' /></td>
			<td colspan="2" class="br">合同金额：<s:property value='projectInfo.contractMoney' /></td>
		</tr>
		<tr>
			<td colspan="3" class="blr">合同内容概要：<s:property value='projectInfo.contractAbstract' /></td>
		</tr>
		<tr>
			<td width="33%" style="text-align: center" class="blr">委托（建设）单位</td>
			<td width="33%" style="text-align: center" class="br">相关（关系）单位</td>
			<td width="34%" style="text-align: center" class="br">送审（施工）单位</td>
		</tr>
		<tr>
			<td class="blr">
				<table width="100%">
					<tr>
						<td colspan="2">名称：<s:property value='projectInfo.customerCompany' /></td>
					</tr>
					<tr>
						<td>联系人：<s:property value='projectInfo.customerContactor' /> </td>
					</tr>
					<tr>
						<td>电话：<s:property value='projectInfo.customerContact' /></td>
					</tr>
				</table>
			</td>
			<td class="br">
				<table width="100%">
					<tr>
						<td colspan="2">名称：<s:property value='projectInfo.mediatorCompany' /></td>
					</tr>
					<tr>
						<td>联系人： <s:property value='projectInfo.mediatorContactor' /></td>
					</tr>
					<tr>
						<td>电话：<s:property value='projectInfo.mediatorContact' /></td>
					</tr>
				</table>
			</td>
			<td class="br">
				<table width="100%">
					<tr>
						<td colspan="2">名称：<s:property value='projectInfo.vendorCompany' /></td>
					</tr>
					<tr>
						<td>联系人：<s:property value='projectInfo.vendorContactor' /> </td>
					</tr>
					<tr>
						<td>电话：<s:property value='projectInfo.vendorContact' /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- 项目业务信息表格 -->	
	<table id="businessTable" width="98%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="text-align: center" class="tblr">送审价</td>
			<td style="text-align: center" class="tbr">审定价</td>
			<td style="text-align: center" class="tbr">核增额/率</td>
			<td style="text-align: center" class="tbr">核减额/率</td>
			<td style="text-align: center" class="tbr">审核人</td>
			<td style="text-align: center" class="tbr">档案接收人</td>			
		</tr>
		<tr>
			<td style="text-align: center" class="blr"><br><s:property value='projectInfo.judgePrice1' /><br><br></td>
			<td style="text-align: center" class="br"><br><s:property value='projectInfo.judgePrice1' /><br><br></td>
			<td style="text-align: center" class="br"><br><s:property value='projectInfo.plusPrice' />/<s:property value='projectInfo.plusPriceRate' /><br><br></td>
			<td style="text-align: center" class="br"><br><s:property value='projectInfo.minusPrice' />/<s:property value='projectInfo.minusPriceRate' /><br><br></td>
			<td style="text-align: center" class="br"><br><br><br></td>
			<td style="text-align: center" class="br"><s:property value='projectInfo.achiveReceiver' /><br><br></td>			
		</tr>
		<tr>
			<td style="text-align: center" class="blr">审定天数</td>
			<td style="text-align: center" class="br">报告日</td>
			<td style="text-align: center" class="br">报告文号</td>
			<td style="text-align: center" class="br">征询日/评价</td>
			<td style="text-align: center" class="br">归档日期</td>
			<td style="text-align: center" class="br">档案接收日期</td>			
		</tr>
		<tr>
			<td style="text-align: center" class="blr"><br><s:property value='projectInfo.judgeDays' /><br><br></td>
			<td style="text-align: center" class="br"><br><s:date name='projectInfo.reportDate' format='yyyy-MM-dd' /><br><br></td>
			<td style="text-align: center" class="blr"><br><s:property value='projectInfo.reportReferNumber' /><br><br></td>
			<td style="text-align: center" class="br"><br><s:property value='projectInfo.comments' /><br></td>
			<td style="text-align: center" class="br"><br><s:date name='projectInfo.achiveDate' format='yyyy-MM-dd' /><br><br></td>
			<td style="text-align: center" class="br"><s:date name='projectInfo.achiveReceiveDate' format='yyyy-MM-dd' /><br><br></td>			
		</tr>
		<tr>
			<td colspan="6" class="blr">
				<table width="100%">
					<tr>
						<td colspan="3">总师审核意见：</td>
					</tr>
					<tr>
						<td colspan="3"><s:property value='projectInfo.masterJudgeComments' /></td>
					</tr>
					<tr>
						<td colspan="3"><br></td>
					</tr>
					<tr>
						<td width="60%"></td>
						<td>联系人： </td>
						<td>电话：</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="6" class="blr">
				<table width="100%">
					<tr>
						<td colspan="3">整改情况：</td>
					</tr>
					<tr>
						<td colspan="3"><s:property value='projectInfo.corrective' /></td>
					</tr>
					<tr>
						<td colspan="3"><br></td>
					</tr>
					<tr>
						<td width="60%"></td>
						<td>整改人： </td>
						<td>整改日期：</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="6" class="blr">
				<table width="100%">
					<tr>
						<td colspan="3">备注：</td>
					</tr>
					<tr>
						<td colspan="3"><br></td>
					</tr>
					<tr>
						<td colspan="3"><br></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- 项目财务信息表格 -->		
	<table id="accountTable" width="98%" cellpadding="0" cellspacing="0">
		<tr>
			<td style="text-align: center" class="tblr">收    入</td>
			<td style="text-align: center" class="tbr">支    出</td>
		</tr>
		<tr>
			<td width="50%" class="blr">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="7" class="r" rowspan="10">委托单位</td>
					</tr>
					<tr>
						<td class="b">开票人：<s:property value='projectInfo.agentInvoiceDrawer.realName' /></td>
					</tr>
					<tr>
						<td class="b">开票日期：<s:date name='projectInfo.agentInvoiceDate' format='yyyy-MM-dd' /></td>
					</tr>
					<tr>
						<td class="b">发票编号：<s:property value='projectInfo.agentInvoiceNumber'/></td>
					</tr>
					<tr>
						<td class="b">金额：<s:property value='projectInfo.agentInvoicePrice'/></td>
					</tr>
					<tr>
						<td class="b">领票人：<s:property value='projectInfo.agentInvoiceHolder.realName' /></td>
					</tr>
					<tr>
						<td class="b">到款日期：<s:date name='projectInfo.agentReceiveDate' format='yyyy-MM-dd' /></td>
					</tr>
					<tr>
						<td class="b">到款金额：<s:property value='projectInfo.agentReceivePrice'/></td>
					</tr>
					<tr>
						<td class="b">财务：<s:property value='projectInfo.agentAccount'/></td>
					</tr>
					<tr>
						<td>备注：<s:property value='projectInfo.agentComment'/></td>
					</tr>
				</table>
			</td>
			<td width="50%" class="br">
				<s:if test="projectInfo.costs != null && projectInfo.costs.size() > 0">
					<s:iterator value="projectInfo.costs" status="st">
						<s:if test="#st.index==0">
						<table width="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td width="7" class="r" rowspan="10">成本报销</td>
							</tr>
							<tr>
								<td class="b">结算日期：<s:date name='settleDate' format='yyyy-MM-dd' /></td>
							</tr>
							<tr>
								<td class="b">金额：<s:property value='price' /></td>
							</tr>
							<tr>
								<td class="b">领款人：<s:property value="remitteeName" /></td>
							</tr>
							<tr>
								<td class="b">财务：<s:property value='account' /></td>
							</tr>
							<tr>
								<td class="b">说明：<s:property value='comment' /></td>
							</tr>
							<tr>
								<td>总经理书面签字处</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
						</table>
						</s:if>
					</s:iterator>
				</s:if>
				<s:else>
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td width="7" class="r" rowspan="10">成本报销</td>
						</tr>
						<tr>
							<td class="b">结算日期：</td>
						</tr>
						<tr>
							<td class="b">金额：</td>
						</tr>
						<tr>
							<td class="b">领款人：</td>
						</tr>
						<tr>
							<td class="b">财务：</td>
						</tr>
						<tr>
							<td class="b">说明：</td>
						</tr>
						<tr>
							<td>总经理书面签字处</td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
					</table>
				</s:else>
			</td>
		</tr>
		<tr>
			<td width="50%" class="blr">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="7" class="r" rowspan="10">送审单位</td>
					</tr>
					<tr>
						<td class="b">开票人：<s:property value='projectInfo.vendorInvoiceDrawer.realName' /></td>
					</tr>
					<tr>
						<td class="b">开票日期：<s:date name='projectInfo.vendorInvoiceDate' format='yyyy-MM-dd' /></td>
					</tr>
					<tr>
						<td class="b">发票编号：<s:property value='projectInfo.vendorInvoiceNumber'/></td>
					</tr>
					<tr>
						<td class="b">金额：<s:property value='projectInfo.vendorInvoicePrice'/></td>
					</tr>
					<tr>
						<td class="b">领票人：<s:property value='projectInfo.vendorInvoiceHolder.realName' /></td>
					</tr>
					<tr>
						<td class="b">到款日期：<s:date name='projectInfo.vendorReceiveDate' format='yyyy-MM-dd' /></td>
					</tr>
					<tr>
						<td class="b">到款金额：<s:property value='projectInfo.vendorReceivePrice'/></td>
					</tr>
					<tr>
						<td class="b">财务：<s:property value='projectInfo.vendorAccount'/></td>
					</tr>
					<tr>
						<td>备注：<s:property value='projectInfo.vendorComment'/></td>
					</tr>
				</table>
			</td>
			<td width="50%" class="br">
				<s:if test="projectInfo.costs != null && projectInfo.costs.size() > 1">
					<s:iterator value="projectInfo.costs" status="st">
						<s:if test="#st.index==1">
						<table width="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td width="7" class="r" rowspan="10">成本报销</td>
							</tr>
							<tr>
								<td class="b">结算日期：<s:date name='settleDate' format='yyyy-MM-dd' /></td>
							</tr>
							<tr>
								<td class="b">金额：<s:property value='price' /></td>
							</tr>
							<tr>
								<td class="b">领款人：<s:property value="remitteeName" /></td>
							</tr>
							<tr>
								<td class="b">财务：<s:property value='account' /></td>
							</tr>
							<tr>
								<td class="b">说明：<s:property value='comment' /></td>
							</tr>
							<tr>
								<td>总经理书面签字处</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
						</table>
						</s:if>
					</s:iterator>
				</s:if>
				<s:else>&nbsp;</s:else>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="blr">
				<table width="100%">
					<tr>
						<td colspan="3">备注：</td>
					</tr>
					<tr>
						<td colspan="3"><br></td>
					</tr>
					<tr>
						<td colspan="3"><br></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</div>	
</body>
</html>
