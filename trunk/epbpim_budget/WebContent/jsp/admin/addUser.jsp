<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.util.cache.CacheMap"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ryxx.bpim.common.Constants"%>
<%@ page import="com.ryxx.bpim.user.entity.AdminMenu"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="AdminRole.AddRole" /></title>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/common.js'></script>
<script type='text/javascript' src='../js/validation.js'></script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<s:form action="saveRole.do" method="post" onsubmit="return validate(this);">
						<h3 class="title"><s:text name="AdminRole.AddRole" /></h3>
						<div id="addRoleTable">
							<ul class="fullScreenUl">
								<li class="width200Li"><label class="width4Lb"><s:text name="AdminRole.RoleName" />:</label>
								<input class="width100Input" name="name" id="name" maxlength="100"/>
								<textValidate field="name" lableText="<s:text name='AdminRole.RoleName' />" isValidate="true" min="0" max="100">  </li>
								<li class="width300Li"><label class="width9Lb"><s:text name="AdminRole.RoleCount" />:</label>
								<input class="width150Input" name="roleCount" id="roleCount" />
								<textValidate field="roleCount" lableText="<s:text name='AdminRole.RoleCount' />" isValidate="true" min="0" max="3" maxValue="100" dataType="int"></li>
								<li class="width400Li"><label class="width4Lb"><s:text name="AdminRole.Remark" />:</label>
									<input class="width300Input" name="remark" id="remark" maxlength="255"/>
									<textValidate field="remark" lableText="<s:text name='AdminRole.Remark' />" isValidate="true" max="255"></li>
							</ul>
							<h4><s:text name="AdminRole.RoleList" />:</h4>
							<%
										List<AdminMenu> menus = (List<AdminMenu>)CacheMap.getInstance().getCache(Constants.MENU_CACHE);
										request.setAttribute("menus", menus);
									%>
							<s:if test="#request.menus!=null && #request.menus.size()>0">
								<s:iterator value="#request.menus" status="st">
									<s:if test="subMenus !=null && subMenus.size()>0">
										<ul class="fullScreenUlNoHeight">
											<li class="width200Li"><h4>
													<input type="checkbox"
														onclick="checkAllSub('<s:property value='id'/>,<s:property value='parentId'/>');"
														name="listCheck" value="<s:property value="id"/>"
														id="<s:property value="id"/>,<s:property value="parentId"/>" />
													<s:property value="name" />
												</h4></li>
										</ul>
										<ul class="fullScreenUlNoHeight">
											<s:iterator value="subMenus" status="st1">
												<li class="width200Li"><input type="checkbox"
													onclick="checkSelfAndParent('<s:property value='id'/>,<s:property value='parentId'/>');"
													name="listCheck" value="<s:property value="id"/>"
													id="<s:property value="id"/>,<s:property value="parentId"/>" />
													<s:property value="name" /></li>
											</s:iterator>
										</ul>
									</s:if>
								</s:iterator>
							</s:if>
							<ul class="fullScreenUl">
							</ul>
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
var checkBoxValue;//迭代中checkbox value


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
