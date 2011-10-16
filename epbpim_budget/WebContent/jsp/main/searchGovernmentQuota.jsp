<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />

<script type="text/javascript">
	function setSearchValue() {
		var provice = "<s:property value="condition.provice"/>";
		if (provice != "")
			document.getElementById("provice").value = provice;
		var quotaNum = "<s:property value="condition.quotaNum"/>";
		if (quotaNum != "")
			document.getElementById("quotaNum").value = quotaNum;
		var quotaName = "<s:property value="condition.quotaName"/>";
		if (quotaName != "")
			document.getElementById("quotaName").value = quotaName;
		var quotaClass = "<s:property value="condition.quotaClass"/>";
		if (quotaClass != "")
			document.getElementById("quotaClass").value = quotaClass;
	}
	function clearPage(updateId) {
		var ps = document.getElementById("ps");
		var pn = document.getElementById("pn");
		if (ps != null) {
			ps.options[1].selected = true;
		}
		if (pn != null) {
			pn.options[0].selected = true;
		}
		document.getElementById("searchGovernmentQuotaForm").submit();
	}
</script>
</head>
<title>定额查询</title>
</head>
<body onload="setSearchValue();changeTitleBackground();">
	<div id="main"><jsp:include page="mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<s:form action="searchGovernmentQuota.do" method="post"
					name="searchGovernmentQuota" id="searchGovernmentQuotaForm">
					<div class="mainbar">
						<h3 class="title">
							定额查询
						</h3>

						<div id="searchCondition">
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="lb">省：</label><select
									id="provice" name="condition.provice" class="width100Select">
										<option value="上海市" selected="selected">上海市</option>
								</select>
								</li>

								<li class="width200Li">定额类别：<select id="quotaClass"
									name="condition.quotaClass" class="width100Select">
										<option value="0">--请选择--</option>
										<option value="2000土建装饰">土建</option>
										<option value="2000园林">园林</option>
										<option value="2000市政">市政</option>
										<option value="2000安装">安装</option>
										<option value="2000公用">公用</option>
										<option value="2000水利">水利</option>
										<option value="2000人防">人防</option>
										<option value="2000房修">房修</option>
								</select>
								</li>

								<li class="width200Li"><label class="lb">编号：</label><input class="width100Input" name="condition.quotaNum" id="quotaNum">
								</li>
								<li class="width200Li"><label class="lb">名称：</label><input
									class="width100Input"
									name="condition.quotaName" id="quotaName">
								</li>
								<li class="width50Li"><input name="searchButton" onclick="clearPage()"
									type="button" id="searchButton" class="button" value="查询">
								</li>
							</ul>
						</div>

							<div class="searchResult" id="searchResult"
							>
							<ul class="fullScreenResultUl">
								<li class="width100Li">定额大类</li>
								<li class="width100Li">分部工程名称</li>
								<li class="width100Li">编号</li>
								<li class="width350Li">名称</li>
								<li class="width50Li">规格</li>
								<li class="width50Li">单位</li>
								<li class="width50Li">数量</li>
								<li class="width100Li">查看详情</li>
							</ul>
							<s:if test="datas==null || datas.size()==0">
							</s:if>
							<s:else>
								<s:iterator value="datas" status="st">
									<ul class="fullScreenResultUl" id="<s:property value='id'/>">
										<li class="width100Li"><s:property
												value="governmentQuotaClass" />
										</li>
										<li class="width100Li"><s:property
												value="governmentQuotaType" />
										</li>
										<li class="width100Li"><s:property
												value="governmentQuotaNum" />
										</li>
										<li class="width350Li"><s:if
												test="%{null!=governmentQuotaName&&governmentQuotaName.length()>24}">
												<s:property
													value="governmentQuotaName.substring(0, 23)+'...'" />
											</s:if> <s:else>
												<s:property value="governmentQuotaName" />
											</s:else>
										</li>
										<li class="width50Li"><s:property
												value="governmentQuotaModel" />
										</li>
										<li class="width50Li"><s:property
												value="governmentQuotaUnit" />
										</li>
										<li class="width50Li"><s:property
												value='governmentQuotaAmount' />
										</li>
										<li class="width100Li"><a target="blank"
											href="viewGovernmentQuotaDetail.do?id=<s:property value='id'/>">查看</a>
										</li>
									</ul>
								</s:iterator>
								<ul class="fullScreenResultUl">
									<jsp:include page="../common/pagination.jsp" flush="true">
										<jsp:param name="action_page"
											value="main/searchGovernmentQuota.do" />
									</jsp:include>
								</ul>
							</s:else>
						</div>
					</div> 
				</s:form> 

				<!-- end #content -->


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>

</body>
</html>