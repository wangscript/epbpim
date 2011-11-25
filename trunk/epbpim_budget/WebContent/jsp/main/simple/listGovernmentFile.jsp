<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type="text/javascript">
	function setSearchValue() {
		var provice = "<s:property value="condition.provice"/>";
		if(provice!="")
		document.getElementById("provice").value=provice;
		var fileType = "<s:property value="condition.fileType"/>";
		if(fileType!="")
		document.getElementById("fileType").value=fileType;
		var fileSubType = "<s:property value="condition.fileSubType"/>";
		if(fileSubType!="")
		document.getElementById("fileSubType").value=fileSubType;
		var filePublishDatePage = "<s:property value="condition.filePublishDatePage"/>";
		if(filePublishDatePage!="")
		document.getElementById("filePublishDatePage").value=filePublishDatePage;
		var fileEffectiveDatePage = "<s:property value="condition.fileEffectiveDatePage"/>";
		if(fileEffectiveDatePage!="")
		document.getElementById("fileEffectiveDatePage").value=fileEffectiveDatePage;
		var fileName = "<s:property value="condition.fileName"/>";
		if(fileName!="")
		document.getElementById("fileName").value=fileName;
		var keyword = "<s:property value="condition.keyword"/>";
		if(keyword!="")
		document.getElementById("keyword").value= keyword;
		if(document.getElementById("fileType").value=="各类文件"){
			document.getElementById("fileSubTypeLi").style.display="BLOCK"; 
		}
		else if(document.getElementById("fileType").value=="地方性法规和规章"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("fileSubTypeLi").style.display="NONE";
			document.getElementById("proviceLi").style.display="NONE";
		}
		if(document.getElementById("fileSubType").value=="市建交委及相关部门"||document.getElementById("fileSubType").value=="市政府"||document.getElementById("fileSubType").value=="市建筑建材业管理部门"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("proviceLi").style.display="NONE";
		}
	}
	
	function clearPage(updateId){
		var ps = document.getElementById("ps");
		var pn = document.getElementById("pn");
		if(ps != null) {
			ps.options[1].selected = true;
		}
		if(pn != null) {
			pn.options[0].selected = true;
		}
		document.getElementById("searchGovernmentQuotaForm").submit();
	}
</script>
</head>
<title>文件查询</title>
</head>
<body onload="setSearchValue()">
<div id="main"><jsp:include page="../mainHeader.jsp" />
<div class="content">
<div class="content_resize"><s:form
	action="searchGovernmentFile.do" method="post"
	name="searchGovernmentFileForm" id="searchGovernmentFileForm">
	<div class="mainbar">
	<h3 class="title">文件查询</h3>
	<div id="searchCondition">
	<ul class="fullScreenUl">
		<li class="width200Li"><label class="lb">发布时间：</label>
			<input class="Wdate width100Input" id="filePublishDatePage" name="condition.filePublishDatePage" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
		</li>
		<li class="width200Li"><label class="lb">生效时间：</label>
			<input class="Wdate width100Input" id="fileEffectiveDatePage" name="condition.fileEffectiveDatePage" onclick="WdatePicker({dateFmt:'yyyy-MM'})" />
		</li>
		<li class="width200Li">文件类别：<select id="fileType" name="condition.fileType" class="width100Select" onchange="changeType();">
			<option value="0">--全部--</option>
			<option value="法律">法律</option>
			<option value="行政法规">行政法规</option>
			<option value="地方性法规和规章">地方性法规和规章</option>
			<option value="部门规章">部门规章</option>
			<option value="各类文件">各类文件</option>
		</select></li> 
		<li class="width200Li"><label class="lb">关键字：</label><input class="width100Input" name="condition.keyword" id="keyword"></li>
		<li class="width50Li"><input name="searchButton" type="button" id="searchButton"
			onclick="searchGovernmentFile()" class="button" value="查询"></li>
	</ul>
	<ul class="fullScreenUl">
		<li class="width200Li" style="display: none" id="fileSubTypeLi">文件小类：
			<select id="fileSubType" name="condition.fileSubType" class="width100Select" onchange="changeSubType()">
				<option value="0">--全部--</option>
				<option value="国务院">国务院</option>
				<option value="部委">部委</option>
				<option value="市政府">市政府</option>
				<option value="市建交委及相关部门">市建交委及相关部门</option>
				<option value="市建筑建材业管理部门">市建筑建材业管理部门</option>
			</select>
		</li>

		<li class="width200Li" style="display: none" id="proviceLi"><label class="lb">省份：</label>
			<s:select cssClass="width150Select" id="condition.provinceCity.id" name="condition.provinceCity.id"
				list="provinceCities" listKey="id" listValue="city" multiple="false" required="true" onchange="" headerKey="0" />
		</li>
</ul>
	</div>

	<div class="searchResult" id="searchResult" style="margin-top: 15px;">
	<ul class="fullScreenResultUl">
		<li class="width150Li">文件类别</li>
		<li class="width150Li">小类</li>
		<li class="width50Li">地区</li>
		<li class="width300Li">文件名</li>

		<li class="width100Li">发布时间</li>
		<li class="width100Li">生效时间</li>
		<li class="width50Li">查看</li>
	</ul>
	<s:if test="datas==null || datas.size()==0">
	</s:if> <s:else>
		<s:iterator value="datas" status="st">
			<ul class="fullScreenResultUl" id="<s:property value='id'/>">
				<li class="width150Li"><s:property value="fileType" /></li>
				<li class="width150Li"><s:property value="fileSubType" /></li>
				<li class="width50Li"><s:property value="provinceCity.city" /></li>
				<li class="width300Li">
				<s:if
				test="%{null!=fileTitle&&fileTitle.length()>20}">
				<s:property value="fileTitle.substring(0, 19)+'...'" />
			</s:if> <s:else>
				<s:property value="fileTitle" />
			</s:else>
			</li>
 
				<li class="width100Li"><s:date name="filePublishDate"
					format="yyyy-MM-dd" /></li>
				<li class="width100Li"><s:date name="fileEffectiveDate"
					format="yyyy-MM-dd" /></li>
				<li class="width50Li"><a target="blank" onclick="viewDetail(<s:property value="id" />)">查看</a></li>
			</ul>
		</s:iterator>
		<ul class="fullScreenResultUl">
		<jsp:include page="../../common/pagination.jsp" flush="true">
			<jsp:param name="action_page" value="main/searchGovernmentFile.do" />
		</jsp:include>
		</ul>
	</s:else></div>
	</div>
</s:form>  <!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../../common/footer.jsp" /></div>

</body>

<script type="text/javascript">
	function changeType(){
		if(document.getElementById("fileType").value=="各类文件"){
			document.getElementById("fileSubTypeLi").style.display="BLOCK"; 
		}
		else if(document.getElementById("fileType").value=="地方性法规和规章"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("fileSubTypeLi").style.display="NONE";
			document.getElementById("proviceLi").style.display="NONE";
		}
	}
	
	function changeSubType(){
		if(document.getElementById("fileSubType").value=="市建交委及相关部门"||document.getElementById("fileSubType").value=="市政府"){
			document.getElementById("proviceLi").style.display="BLOCK";
		}else{
			document.getElementById("proviceLi").style.display="NONE";
		}
	}
	function searchGovernmentFile(){
		
		document.getElementById("searchGovernmentFileForm").submit();
	}
	function getUniCodes(strDes){ 
		var res = ""; 
		for(var i = 0; i< strDes.length; i++){ 
		res += "\5" + strDes.charCodeAt(i) + ";"; 
		} 
		return res; 
		} 
	function viewDetail(id){
		var keyword = "<s:property value="condition.keyword"/>";
		keyword = getUniCodes(keyword);
		window.open("viewGovernmentFile.do?id="+id+"&keyword="+keyword);
	}
</script>
</html>