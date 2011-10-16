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
						<s:form action="deleteGuideData.do" method="post" id="deleteGuideDataForm">
							<ul class="fullScreenUl">
								<li class="width100Li">省份：</li>
								<li class="width200Li">
									<s:select cssClass="width150Select" id="guideData.provinceCity.id" name="guideData.provinceCity.id"
										list="provinceCities" listKey="id" listValue="city" multiple="false" required="true" onchange="" headerKey="0" />
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width300Li">分类：
									<select id="guideData.guideDataType" name="guideData.guideDataType style="width: 150px;">
										<option value="">--请选择--</option>
										<option value="土建">土建</option>
										<option value="市政">市政</option>
										<option value="公用">公用</option>
										<option value="水利">水利</option>
										<option value="人防">人防</option>
										<option value="房修">房修</option>
									</select>							  
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="lb">时间：</label>
									<input class="Wdate width100Input" id="guideData.guideDataDatePage" name="guideData.guideDataDatePage" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
								</li>
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