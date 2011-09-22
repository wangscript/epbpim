<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.util.cache.CacheMap"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="AdminRole.AddRole" />
</title>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<s:form action="batchUser.do" method="post"
						onsubmit="return validate(this);">
						<h3 class="title">
							<!--<s:text name="AdminRole.AddRole" />-->
							新增用户
						</h3>
						<div id="addRoleTable">
							<ul class="fullScreenUl">
								<li class="width200Li">
									<label class="width6Lb">地区:</label>
									<s:select cssClass="width100Select" onchange="changeRegion();"
										name="enterpriseInfo.provinceCity.id" list="provinceCities"
										listKey="id" listValue="city" multiple="false"
										required="true" headerKey="0" headerValue="全选"/><s:hidden name="eId"/>
								</li>
								<li class="width300Li"><label class="width9Lb">创建人数:</label>
								<s:textfield cssClass="width150Input" name="userCount" />
								<textValidate
										field="userCount"
										lableText="<s:text name='userCount' />"
										isValidate="true" min="0" max="3" maxValue="100"
										dataType="int">
								</li>
							</ul>
							<h4>应用列表	:</h4>
								<s:iterator value="modules" status="st">
									<ul class="fullScreenUlNoHeight" id="<s:property value="region.id"/>">
										<li class="width200Li"><h4>
												<input type="checkbox"
													name="listCheck" value="<s:property value="id"/>"
													id="<s:property value="region.id"/>" />
												<s:property value="title" /><br/>
												<s:property value="description" />
											</h4>
										</li>
									</ul>
								</s:iterator>
							<ul class="fullScreenUl">
								<li><input type="submit" id="addProject"
									class="mediumLeftButton" value="<s:text name="Common.Save" />">
								</li>
							</ul>
						</div>
						<div></div>
					</s:form>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script language="JavaScript">
var checkBoxList = document.getElementsByName("listCheck");//取得页面checkBox集合，全局通用

var currentStatus;//当前状态。例如：原来为false,被选中后此状态值为true
var currentId = "-1";//当前选中checkbox本身menu ID
var currentParentMenuId;//当前选中checkbox 父节点menu ID
var parentCheckBoxChecked;//当前选中checkbox 父节点状态

var commaIndex = "-1";//逗号的位置
var subMenuId = "-1";//迭代中checkbox的本身menu ID
var parentMenuId = "-1";//迭代中checkbox 父节点menu ID
var checkBox;//迭代中checkbox对象


	function changeRegion() {
		var reginList = document.getElementById("batchUser_enterpriseInfo_provinceCity_id");
		var moduleList = document.getElementsByTagName("ul");
		for(var i = 0; i < reginList.length;i++){
			if(reginList[i].selected) {
				for(var j=3; j<moduleList.length-1;j++) {
					if(reginList[i].value == 0) {
						moduleList[j].style.display = "block";
					} else if(moduleList[j].id != reginList[i].value) {
						moduleList[j].style.display = "none";
					} else {
						moduleList[j].style.display = "block";
					}
				}
			}
		}
	}

	function checkAllSub(parentId){//选中父节点，子节点全被选。也就是子节点随父节点状态而变
		currentStatus = $(parentId).checked;//取得当前父节点状态
		commaIndex = parentId.indexOf(",");//
		currentId = parentId.substring(0, commaIndex);//取得父节点menu ID
		for(var i = 0; i < checkBoxList.length;i++){
			checkBox = checkBoxList[i];
			fillLogicValue(checkBox);
			if(parentMenuId == currentId){//迭代找到父节点相关子节点
				checkBox.checked = currentStatus;//选中
			}
		}
	}
	
	function checkSelfAndParent(id){//操作子节点。父节点下面子节点有一个是选中，父节点为选中，一个都没选中，父节点不选中
		currentStatus = $(id).checked;//取得当前子节点状态
		commaIndex = id.indexOf(",");
		currentParentMenuId = id.substring(commaIndex + 1,//取得父节点menu ID
				id.length);
		parentCheckBoxChecked = false;//初始化父节点应为false
		for(var i = 0; i < checkBoxList.length;i++){
			checkBox = checkBoxList[i];
			fillLogicValue(checkBox);
			if(parentMenuId == currentParentMenuId){
				if(checkBox.checked){//迭代节点，找到子节点，如果有一个子节点是选中,则父节点应是选中。如果一个都没选中，parentCheckBoxChecked是false
					parentCheckBoxChecked = true;
				}
			}
		}
		$(currentParentMenuId+",0").checked = parentCheckBoxChecked;//把父节点应有状态赋值给父节点
	}
	
	function fillLogicValue(checkBox){
		checkBoxValue = checkBox.id;
		commaIndex = checkBoxValue.indexOf(",");
		subMenuId = checkBoxValue.substring(0, commaIndex);
		parentMenuId = checkBoxValue.substring(commaIndex + 1,
				checkBoxValue.length);
	}
	
	
</script>

</html>
