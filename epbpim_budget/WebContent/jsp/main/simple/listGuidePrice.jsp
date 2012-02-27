<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>指导价查询</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../js/common.js'></script>
<script type="text/javascript">
	function setSearchValue() {
		var guidePriceType = "<s:property value="guidePrice.guidePriceType"/>";
		changeSuperClass(guidePriceType);
		if(guidePriceType != "")
		{
			var superClassNumObj=document.getElementById("guidePrice.guidePriceType");
			for(var i=0;i<superClassNumObj.options.length;i++)
			{
				if(guidePriceType == superClassNumObj.options[i].value)
				{
					superClassNumObj.options[i].selected=true;
					break;
				}				
			}
		}
		var guidePriceClass = "<s:property value="guidePrice.guidePriceClass"/>";
		if(guidePriceClass != "")
		{
			var classNumObj=document.getElementById("guidePrice.guidePriceClass");
			for(var i=0;i<classNumObj.options.length;i++)
			{
				if(guidePriceClass == classNumObj.options[i].value)
				{
					classNumObj.options[i].selected=true;
					break;
				}				
			}
		}
		
		var name = "<s:property value="guidePrice.name"/>";
		if(name != "")
		{
			document.getElementById("guidePrice.name").value=name;
		}
		
		var  guidePriceDatePage = "<s:property value="guidePrice.guidePriceDatePage"/>";
		if(guidePriceDatePage != "")
		{
			document.getElementById("guidePrice.guidePriceDatePage").value=guidePriceDatePage;
		}	
	}
	
	var onecount = 0;

	subcat = new Array();

	subcat[0] = new Array("市政人工", "市政", "市政人工");
	subcat[1] = new Array("市政材料", "市政", "市政材料");
	subcat[2] = new Array("市政机械", "市政", "市政机械");
	subcat[3] = new Array("安拆费", "市政", "安拆费");
	subcat[4] = new Array("场外运输", "市政", "场外运输");
	subcat[5] = new Array("泥土外运", "市政", "泥土外运");

	subcat[6] = new Array("公路人工", "公路", "公路人工");
	subcat[7] = new Array("公路材料", "公路", "公路材料");
	subcat[8] = new Array("公路机械", "公路", "公路机械");
	subcat[9] = new Array("市郊地材", "公路", "市郊地材");
	subcat[10] = new Array("崇明地材", "公路", "崇明地材");

	onecount = 11;

	function changeSuperClass(superClassID) {
		var subClassObj = document.getElementById("guidePrice.guidePriceClass");
		subClassObj.length = 0;
		subClassObj.options[subClassObj.length] = new Option("不限", "");
		for ( var i = 0; i < onecount; i++) {
			if (subcat[i][1] == superClassID || !superClassID) {
				subClassObj.options[subClassObj.length] = new Option(subcat[i][0], subcat[i][2]);
			}
		}
	}
	
</script>
</head>
<body onload="setSearchValue()">

<div id="main"><jsp:include page="../mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<h3 class="title">指导价查询：</h3>
<s:form id="searchGuidePriceForm" action="searchGuidePrice.do" method="post">
	<div id="searchCondition">
		<input type="hidden" name="guidePrice.provinceCity.id" value="<s:property value='guidePrice.provinceCity.id'/>">
		<ul class="fullScreenUl">
			<!-- 
				<li class="width200Li">专业：
					<select class="width150Select" id="guidePrice.guidePriceType" name="guidePrice.guidePriceType" onchange="changeSuperClass(this.options[this.selectedIndex].value)">
						<option value="">不限</option>
						<option value="2">市政</option>
						<option value="9">公路</option>
					</select>						  
				</li>
			 -->
			<li class="width200Li">分类：
				<select class="width150Select" id="guidePrice.guidePriceClass" name="guidePrice.guidePriceClass">
				</select>						  
			</li>
			<li class="width200Li"><label class="lb">名称：</label>
				<input type="text" id="guidePrice.name" name="guidePrice.name" />
			</li>
			<li class="width200Li"><label class="lb">时间：</label>
				<input class="Wdate width100Input" id="guidePrice.guidePriceDatePage" name="guidePrice.guidePriceDatePage" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
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
				<li class="width250Li"><s:text name="名称规格" /></li>	
				<li class="width100Li"><s:text name="单位" /></li>		
				<li class="width100Li"><s:text name="价格（元）" /></li>
				<li class="width300Li"><s:text name="价格说明" /></li>
				<li class="width100Li"><s:text name="时间" /></li>
			</ul>
			<s:iterator value="datas" status="st">
				<ul class="fullScreenResultUl"> 
					<li class="width250Li"><s:property value="name" /></li>
					<li class="width100Li"><s:property value="unint" /></li>				
					<li class="width100Li"><s:property value="price" /></li>
					<li class="width300Li"><s:property value="priceComment" /></li>
					<li class="width100Li"><s:date name="guidePriceDate" format="yyyy-MM" /></li>
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
