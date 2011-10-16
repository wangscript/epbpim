<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>信息价删除</title>
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type="text/javascript">
	function checkError() 
	{
		var msg = "<s:property value='msg'/>";
		if (msg) {
			if("true"==msg)
			{
				alert("删除成功！");
			}
			else if("false"==msg)
			{
				alert("出错了，请重试！");
			}
		}
	}
</script>
<style>
.WithBreaks {
	word-wrap: break-word;
}
</style>
</head>
<body onload="checkError();">
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">信息价删除:</h4>
					<div class="entry">
						<s:form action="deleteGuidePrice.do" method="post" id="deleteGuidePriceForm">
							<ul class="fullScreenUl">
								<li class="width100Li">省份：</li>
								<li class="width200Li">
									<s:select cssClass="width150Select" id="guidePrice.guidePriceProvice" name="guidePrice.guidePriceProvice"
										list="provinceCities" listKey="id" listValue="city" multiple="false" required="true" onchange="" headerKey="0" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">专业：</li>
								<li class="width200Li"><select
									id="guidePrice.guidePriceType"
									name="guidePrice.guidePriceType" class="width150Select">
										<option value="1">市政</option>
										<option value="2">园林</option>
								</select></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width100Li">时间：</li>
								<li class="width100Li"><input class="Wdate width100Input"
									id="guidePrice.guidePriceDatePage"
									name="guidePrice.guidePriceDatePage"
									onclick="WdatePicker({dateFmt:'yyyy-MM'})" /></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><input type="submit" class="button" value="删除">
								</li>
							</ul>

						</s:form>
					</div>
					<div class="clr"></div>
				</div>
			</div>
			<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
</html>