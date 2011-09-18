<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>企业账号列表</title>
<script type="text/javascript">
function clearPage(updateId){
	var ps = document.getElementById("ps");
	var pn = document.getElementById("pn");
	if(ps != null) {
		ps.options[1].selected = true;
	}
	if(pn != null) {
		pn.options[0].selected = true;
	}
}
</script>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">企业信息显示</h4>
					<div class="searchResult" id="searchResult">
						<ul class="fullScreenResultUl">
							<li class="width200Li">公司</li>
							<li class="width100Li">联系人姓名</li>
							<li class="width100Li">联系人手机</li>
							<li class="width200Li">邮箱</li>
							<li class="width100Li">业务主要地区</li>
							<li class="width100Li">用户信息</li>
							<li class="width50Li">操作</li>
						</ul>
						<s:iterator value="enterpriseInfos" status="st">
							<ul class="fullScreenResultUl">
								<li class="width200Li"><s:hidden name="id"/><s:property value="name" /></li>
								<li class="width100Li"><s:property value="principal" /></li>
								<li class="width100Li"><s:property value="phone" /></li>
								<li class="width200Li"><s:property value="email" /></li>
								<li class="width100Li"><s:property value="provinceCity.city" /></li>
								<li class="width100Li">
									<a href="listUser.do?eId=<s:property value="id"/>">进入</a>
								</li>
								<li class="width50Li">
									<a href="deleteEnterpriseInfo.do?id=<s:property value="id"/>">删除</a>
								</li>
							</ul>
						</s:iterator>
						<ul class="fullScreenResultUl">
							<s:form>
							<jsp:include page="../common/pagination.jsp" flush="true">
								<jsp:param name="action_page" value="admin/listEnterpriseInfo.do" />
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
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function displayResult(){
		document.getElementById("searchResult").style.display="block";
	}

</script>
</html>
