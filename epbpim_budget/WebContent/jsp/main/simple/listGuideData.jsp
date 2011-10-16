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
		var code = "<s:property value="guideData.code"/>".substring(0,2);
		if(code != "")
		{
			var codeObj=document.getElementById("guideData.code");
			for(var i=0;i<codeObj.options.length;i++)
			{
				if(code == codeObj.options[i].value)
				{
					codeObj.options[i].selected=true;
					break;
				}				
			}
		}
		
		var name = "<s:property value="guideData.name"/>";
		if(name != "")
		{
			document.getElementById("guideData.name").value=name;
		}
		
		var  guideDataDate='<s:property value="guideData.guideDataDatePage"/>';
		if(guideDataDate != "")
		{
			document.getElementById("guideData.guideDataDatePage").value=guideDataDate;
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
<s:form id="searchguideDataForm" action="searchguideData.do" method="post">
<div id="searchCondition">
		<ul class="fullScreenUl">
			<!-- 
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
			 -->
			<li><label class="lb">工料机类别：</label>
				<select id="guideData.guideDataClass" name="guideData.guideDataClass">
					<option value="">--请选择--</option>
					<option value="材料">材料</option>
					<option value="人工">人工</option>
					<option value="机械">机械</option>
				</select>
			</li>
			<li style="margin-left: 40px;"><label class="lb">编号：</label>
				<input style="width: 60px" class="inputText" name="guideData.num" id="guideData.num">
			</li>
			<li style="margin-left: 40px;"><label class="lb">名称：</label>
				<input style="width: 120px" class="inputText" name="guideData.name" id="guideData.name">
			</li>
			<li style="margin-left: 40px;"><label class="lb">单位：</label>
				<input style="width: 40px" class="inputText" name="guideData.recordUnit" id="guideData.recordUnit">
			</li>
			<li class="width200Li"><label class="lb">时间：</label>
				<input class="Wdate width100Input" id="guideData.guideDataDatePage" name="guideData.guideDataDatePage" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
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
			<li class="width150Li"><s:text name="专业" /></li>
			<li class="width400Li"><s:text name="类型" /></li>			
			<li class="width150Li"><s:text name="名称" /></li>
			<li class="width150Li"><s:text name="单价" /></li>
			<li class="width150Li"><s:text name="单位" /></li>
			<li class="width150Li"><s:text name="时间" /></li>
		</ul>
		<s:iterator value="datas" status="st">
			<ul class="fullScreenResultUl"> 
				<li class="width150Li"><s:property value="guideDataType" /></li>
				<li class="width300Li"><s:property value="guideDataClass" /></li>				
				<li class="width150Li"><s:property value="name" /></li>
				<li class="width150Li"><s:property value="price" /></li>
				<li class="width150Li"><s:property value="unit" /></li>
				<li class="width150Li"><s:date name="guideDataDate" format="yyyy-MM" /></li>
			</ul>
		</s:iterator>
		<ul class="fullScreenResultUl">
			<jsp:include page="../../common/pagination.jsp" flush="true">
				<jsp:param name="action_page" value="main/searchguideData.do"/>
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