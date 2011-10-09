<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>信息价查询</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../js/common.js'></script>
<script type="text/javascript">
	function setSearchValue() {
		var code = "<s:property value="guidePrice.code"/>".substring(0,2);
		if(code != "")
		{
			var codeObj=document.getElementById("guidePrice.code");
			for(var i=0;i<codeObj.options.length;i++)
			{
				if(code == codeObj.options[i].value)
				{
					codeObj.options[i].selected=true;
					break;
				}				
			}
		}
		
		var name = "<s:property value="guidePrice.name"/>";
		if(name != "")
		{
			document.getElementById("guidePrice.name").value=name;
		}		
	}
</script>
</head>
<body onload="setSearchValue()">

<div id="main"><jsp:include page="../mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">信息价查询：</h3>
<s:form id="searchGuidePriceForm" action="searchGuidePrice.do" method="post">
<div id="searchCondition">
	
		<input type="hidden" id="guidePrice.guidePriceType" name="guidePrice.guidePriceType" value="1"/>
		<ul class="fullScreenUl">
			<li class="width300Li">分类：
				<select id="guidePrice.code" name="guidePrice.code" style="width: 150px;">
					<option value="">--请选择--</option>
					<option value="10">人工</option>
					<option value="20">材料</option>
					<option value="30">机械</option>
					<option value="ZJC">台班费</option>
					<option value="ZTF">运输费</option>
				</select>							  
			</li>
			<li class="width300Li">名称：
				<input type="text" id="guidePrice.name" name="guidePrice.name" />
			</li>
			<li>
				<input type="submit" class="mediumButton" style="float: right" class="button" value="查询">
			</li>
		</ul>
	
</div>

<s:if test="datas==null || datas.size()==0">
	<tr>
		<td>
		<h3><s:text name="Common.Nodata" /></h3>
		</td>
	</tr>
</s:if>
<s:else>
	<div class="searchResult" id="searchResult">
		<ul class="fullScreenResultUl">
			<li class="width150Li"><s:text name="编号" /></li>
			<li class="width400Li"><s:text name="名称" /></li>			
			<li class="width150Li"><s:text name="价格" /></li>
			<li class="width150Li"><s:text name="单位" /></li>
			<!-- 
			<li class="width200Li"><s:text name="省份" /></li>
			<li class="width200Li"><s:text name="专业" /></li>			
			<li class="width200Li"><s:text name="时间" /></li>
			-->
		</ul>
		<s:iterator value="datas" status="st">
			<ul class="fullScreenResultUl"> 
				<li class="width150Li"><s:property value="code" /></li>
				<li class="width400Li"><s:property value="name" /></li>				
				<li class="width150Li"><s:property value="price" /></li>
				<li class="width150Li"><s:property value="unit" /></li>
				<!-- 
				<li class="width200Li"><s:property value="guidePriceProvice" /></li>
				<li class="width200Li"><s:property value="guidePriceType" /></li>
				<li class="width200Li"><s:date name="guidePriceDate" format="yyyy-MM" /></li>
				 -->
			</ul>
		</s:iterator>
		<ul class="fullScreenResultUl">
			<jsp:include page="../../common/pagination.jsp" flush="true">
				<jsp:param name="action_page" value="main/searchGuidePrice.do"/>
			</jsp:include>
		</ul>
	</div>
</s:else>
</s:form>
<div>
</div>
</div>
<div class="clr"></div>
</div>
</div>
 <jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>
