<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type="text/javascript">
	function setSearchValue() {
		var projectClassLevel1Num = "<s:property value="condition.projectClassLevel1Num"/>";
		changeSuperClass(projectClassLevel1Num);
		if(projectClassLevel1Num != "")
		{
			var superClassNumObj=document.getElementById("projectClassLevel1Num");
			for(var i=0;i<superClassNumObj.options.length;i++)
			{
				if(projectClassLevel1Num == superClassNumObj.options[i].value)
				{
					superClassNumObj.options[i].selected=true;
					break;
				}				
			}
		}
		var projectClassLevel2Num = "<s:property value="condition.projectClassLevel2Num"/>";
		if(projectClassLevel2Num != "")
		{
			var classNumObj=document.getElementById("projectClassLevel2Num");
			for(var i=0;i<classNumObj.options.length;i++)
			{
				if(projectClassLevel2Num == classNumObj.options[i].value)
				{
					classNumObj.options[i].selected=true;
					break;
				}				
			}
		}
		var projectNum = "<s:property value="condition.projectNum"/>";
		if(projectNum != "")
		{
			document.getElementById("projectNum").value=projectNum;
		}		
		var projectName = "<s:property value="condition.projectName"/>";
		if(projectName != "")
		{
			document.getElementById("projectName").value=projectName;
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
		document.getElementById("searchGovernmentInventoryForm").submit();
	}
	
	var onecount=0;
	
    subcat = new Array();
   
    subcat[0] = new Array("土石方工程(0101)","01","0101");
   
    subcat[1] = new Array("地基与桩基础工程(0102)","01","0102");
   
    subcat[2] = new Array("砌筑工程(0103)","01","0103");
   
    subcat[3] = new Array("混凝土及钢筋混凝土工程(0104)","01","0104");
   
    subcat[4] = new Array("厂库房大门、特种门、木结构工程(0105)","01","0105");
   
    subcat[5] = new Array("金属结构工程(0106)","01","0106");
   
    subcat[6] = new Array("屋面及防水工程(0107)","01","0107");
   
    subcat[7] = new Array("防腐、隔热、保温工程(0108)","01","0108");
   
    subcat[8] = new Array("楼地面工程(0201)","02","0201");
   
    subcat[9] = new Array("墙柱面工程(0202)","02","0202");
   
    subcat[10] = new Array("天棚工程(0203)","02","0203");
   
    subcat[11] = new Array("门窗工程(0204)","02","0204");
   
    subcat[12] = new Array("油漆、涂料、裱糊工程(0205)","02","0205");
   
    subcat[13] = new Array("其他装饰工程(0206)","02","0206");
   
    subcat[14] = new Array("机械设备安装工程(0301)","03","0301");
   
    subcat[15] = new Array("电气设备安装工程(0302)","03","0302");
   
    subcat[16] = new Array("热力设备安装工程(0303)","03","0303");
   
    subcat[17] = new Array("炉窑砌筑工程(0304)","03","0304");
   
    subcat[18] = new Array("静置设备与工艺金属结构制作安装工程(0305)","03","0305");
   
    subcat[19] = new Array("工业管道工程(0306)","03","0306");
   
    subcat[20] = new Array("消防工程(0307)","03","0307");
   
    subcat[21] = new Array("给排水、采暖、燃气工程(0308)","03","0308");
   
    subcat[22] = new Array("通风空调工程(0309)","03","0309");
   
    subcat[23] = new Array("自动化控制仪表安装工程(0310)","03","0310");
   
    subcat[24] = new Array("通信设备及线路工程(0311)","03","0311");
   
    subcat[25] = new Array("建筑智能化系统设备安装工程(0312)","03","0312");
   
    subcat[26] = new Array("长距离输送管道工程(0313)","03","0313");
   
    subcat[27] = new Array("土石方工程(0401)","04","0401");
   
    subcat[28] = new Array("道路工程(0402)","04","0402");
   
    subcat[29] = new Array("桥涵护岸工程(0403)","04","0403");
   
    subcat[30] = new Array("隧道工程(0404)","04","0404");
   
    subcat[31] = new Array("市政管网工程(0405)","04","0405");
   
    subcat[32] = new Array("地铁工程(0406)","04","0406");
   
    subcat[33] = new Array("绿化工程(0501)","05","0501");
   
    subcat[34] = new Array("园路、园桥、假山工程(0502)","05","0502");
   
    subcat[35] = new Array("园林景观工程(0503)","05","0503");   
    
    subcat[36] = new Array("FA人防","人防","FA人防"); 
    
    subcat[37] = new Array("FC装饰","人防","FC装饰"); 
    
    subcat[38] = new Array("y1冶金","冶金","y1冶金"); 
    
    subcat[39] = new Array("y2冶金","冶金","y2冶金"); 
    
    subcat[40] = new Array("y3冶金","冶金","y3冶金"); 
    
    subcat[41] = new Array("y4冶金","冶金","y4冶金"); 
    
    subcat[42] = new Array("y5冶金","冶金","y5冶金"); 
    
    subcat[43] = new Array("y6冶金","冶金","y6冶金"); 
		 
    onecount=44;

    function changeSuperClass(superClassID)
    {
    	var subClassObj=document.getElementById("projectClassLevel2Num");
    	subClassObj.length = 0;      
    	subClassObj.options[subClassObj.length] = new Option("不限", "");
		for (var i = 0; i < onecount; i++)
		{
			if (subcat[i][1] == superClassID || !superClassID)
			{ 
				subClassObj.options[subClassObj.length] = new Option(subcat[i][0], subcat[i][2]);
			}        
		}
	}	
</script>
</head>
<title>清单查询</title>
</head>
<body onload="setSearchValue()">
<div id="main"><jsp:include page="../mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<s:form	action="searchGovernmentInventory.do" method="post" name="searchGovernmentInventoryForm" id="searchGovernmentInventoryForm">
<div class="mainbar">
<h3 class="title">清单查询</h3>
<div id="searchCondition">
    <input type="hidden" name="condition.governmentInventoryType" value="2003">
	<ul class="fullScreenUl">
		<li class="width200Li">项目大类：
			<select id="projectClassLevel1Num" name="condition.projectClassLevel1Num" class="width100Select" onchange="changeSuperClass(this.options[this.selectedIndex].value)"> 
				<option value="">不限</option>
				<option value="01">建筑工程(01)</option>
				<option value="02">装饰装修工程(02)</option>
				<option value="03">安装工程(03)</option>
				<option value="04">市政工程(04)</option>
				<option value="05">园林绿化工程(05)</option>
				<option value="人防">人防</option>
				<option value="冶金">冶金</option>
			</select>
		</li>
		<li class="width200Li">项目小类：
			<select id="projectClassLevel2Num" name="condition.projectClassLevel2Num" class="width100Select"></select>
		</li>
		<li class="width200Li">
			<label class="lb">项目编号：</label><input class="width100Input" name="condition.projectNum" id="projectNum">
		</li>
		<li class="width200Li">
			<label class="lb">项目名称：</label><input class="width100Input" name="condition.projectName" id="projectName">
		</li>
		<li class="width50Li">
			<input type="submit" name="searchButton" id="searchButton" class="button" value="查询">
		</li>
	</ul>
</div>

<div class="searchResult" id="searchResult" style="margin-top:15px;">
<ul class="fullScreenResultUl">
	<li class="width100Li">项目编码</li>
	<li class="width100Li">项目名称</li>
	<li class="width50Li">单位</li>
	<li class="width300Li">项目特征</li>	
	<li class="width300Li">工程内容</li>	
</ul>
<s:if test="datas==null || datas.size()==0">
</s:if> 
<s:else>
	<s:iterator value="datas" status="st">
		<ul class="fullScreenResultUl" id="<s:property value='id'/>">
			<li class="width100Li"><s:property value="projectNum" /></li>
			<li class="width100Li">
				<s:if test="%{null!=projectName&&projectName.length()>12}">
					<s:property value="projectName.substring(0, 11)+'...'" />
				</s:if>
				<s:else>
					<s:property value="projectName" />
				</s:else>
			</li>
			<li class="width50Li"><s:property value="unit" /></li>
			<li class="width300Li"><s:property value="projectNameFeature" /></li>
			<li class="width300Li"><s:property value="detail"/></li>
		</ul>
	</s:iterator>
	<ul class="fullScreenResultUl">
		<jsp:include page="../../common/pagination.jsp" flush="true">
			<jsp:param name="action_page" value="main/searchGovernmentInventory.do"/>
		</jsp:include>
	</ul>
</s:else></div>
</div>
</s:form>

 <!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> 
<jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>