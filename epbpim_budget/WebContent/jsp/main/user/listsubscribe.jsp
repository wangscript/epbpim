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
<title>订阅查询
</title>
</head>
<body>
	<div id="main"><jsp:include page="../mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
						<div id="addRoleTable">
							<h5>订阅列表	:</h5>
							<ul class="fullScreenUl">
								<li class="width100Li">应用</li>
								<li class="width100Li">价格</li>
								<li class="width100Li">登记时间</li>
								<li class="width100Li">过期时间</li>
							</ul>
							<s:iterator value="userInfo.menus" status="st1">
								<li class="width100Li"><s:property value="adminMenu.name" /></li>
								<li class="width100Li"><s:property value="adminMenu.price" /></li>
								<li class="width100Li"><s:date name="registerDate" format="yyyy-MM-dd" /></li>
								<li class="width100Li"><s:date name="expireDate" format="yyyy-MM-dd" /></li>
							</s:iterator>
							<ul class="fullScreenResultUl">
							<s:form>
							<s:hidden name="eId" />
							<jsp:include page="../../common/pagination.jsp" flush="true">
								<jsp:param name="action_page" value="main/listPrice.do" />
							</jsp:include>
							</s:form>
						</ul>
						</div>
						<div></div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../../common/footer.jsp" /></div>
</body>
<script language="JavaScript">

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

	function selectAllApps(parentId){//选中父节点，子节点全被选。也就是子节点随父节点状态而变
		var checked = $(parentId).checked;
		var apps = document.getElementsByTagName('input');
		for(var i = 0; i < apps.length;i++){
			if(!apps[i].disabled && apps[i].id.startWith(parentId+"area")){
				apps[i].checked = checked;
			}
		}
	}
	
	
</script>

</html>
