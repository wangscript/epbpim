<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>指导价分析</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../js/common.js'></script>
<script type="text/javascript">
	function setSearchValue() {

	}
</script>
</head>
<body onload="setSearchValue()">

	<div id="main"><jsp:include page="../mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">指导价分析：</h3>
					<s:form id="analyseGuidePriceForm" action="analyseGuidePrice.do"
						method="post" onsubmit="return validate(this);">
						<div id="searchCondition">
							<input type="hidden" name="guidePrice.major.id"
								value="<s:property value='guidePrice.major.id'/>">
							<ul class="fullScreenUl">
								<li class="width300Li"><label class="lb">名称：</label> <input
									value="<s:property value='guidePrice.name'/>" type="text"
									id="guidePrice.name" name="guidePrice.name" /> <textValidate
										field="guidePrice.name" labelText="名称" isValidate="true"
										min="0" max="30">
								</li>
								<li class="width200Li"><label class="lb">时间起点：</label> <input
									value="<s:property value='guidePrice.guidePriceDateFromPage'/>"
									class="Wdate width100Input"
									id="guidePrice.guidePriceDateFromPage"
									name="guidePrice.guidePriceDateFromPage"
									onclick="WdatePicker({dateFmt:'yyyy-MM'})" /> <textValidate
										field="guidePrice.guidePriceDateFromPage" labelText="时间起点"
										isValidate="true" min="0" max="30">
								</li>
								<li class="width200Li"><label class="lb">时间终点：</label> <input
									value="<s:property value='guidePrice.guidePriceDateToPage'/>"
									class="Wdate width100Input"
									id="guidePrice.guidePriceDateToPage"
									name="guidePrice.guidePriceDateToPage"
									onclick="WdatePicker({dateFmt:'yyyy-MM'})" /> <textValidate
										field="guidePrice.guidePriceDateToPage" labelText="时间终点"
										isValidate="true" min="0" max="30">
								</li>
								<li><input type="submit" class="mediumButton"
									style="float: right" class="button" value="查询">
								</li>
							</ul>
						</div>
						<ul class="fullScreenUl">
						</ul>
						<div class="searchResult" id="searchResult">
							<s:if test="hasData=='false'">
								<tr>
									<td>
										<h3>
											<s:text name="Common.Nodata" />
										</h3>
									</td>
								</tr>
							</s:if>
							<s:else>
								<img src="<s:property value='fileUrl'/>" width=900 height=400
									border=0 usemap="<s:property value='fileName'/>">
							</s:else>
						</div>

					</s:form>
					<div></div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>
