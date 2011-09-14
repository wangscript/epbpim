<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>企业账号查询</title>
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script type='text/javascript' src='../dwr/interface/UserInfoService.js'></script>
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
					<h3 class="title">企业信息显示</h3>
					<div class="searchResult" id="searchResult">
						<ul class="fullScreenUl">
							<li class="width200Li"><label>公司</label></li>
							<li class="width100Li"><label>联系人姓名</label></li>
							<li class="width150Li"><label>联系人手机</label></li>
							<li class="width200Li"><label>邮箱</label></li>
							<li class="width100Li"><label>业务主要地区</label></li>
							<li class="width50Li"><label>用户信息</label></li>
							<li class="width50Li"><label>修改</label></li>
							<li class="width50Li"><label>删除</label></li>
						</ul>
						<s:iterator value="enterpriseInfos" status="st">
							<ul class="fullScreenUl">
								<li class="width200Li"><label><s:hidden name="id"/><s:property value="name" /></label></li>
								<li class="width100Li"><label><s:property value="principal" /></label></li>
								<li class="width150Li"><label><s:property value="phone" /></label></li>
								<li class="width200Li"><label><s:property value="email" /></label></li>
								<li class="width100Li"><label><s:property value="favorite" /></label></li>
								<li class="width50Li">
									<form action="showUser.do" id='showUser<s:property value="id"/>' method="post">
										<input type="submit" id="searchProject" class="mediumRightButton" class="button" value="进入"><s:hidden name="id" />
									</form>
								</li>
								<li class="width50Li">
									<form action="showEnterpriseInfo.do" id='showEnterpriseInfo<s:property value="id"/>' method="post">
										<input type="submit" id="showButton<s:property value="id"/>" class="mediumRightButton" class="button" value="修改"><s:hidden name="id" />
									</form>
								</li>
								<li class="width50Li">
									<form action="deleteEnterpriseInfo.do" id='deleteEnterpriseInfo<s:property value="id"/>' method="post">
										<input type="submit" id="deleteButton<s:property value="id"/>" class="mediumRightButton" class="button" value="删除"><s:hidden name="id" />
									</form>
								</li>
							</ul>
						</s:iterator>
						<ul class="fullScreenUl">
							<jsp:include page="../common/pagination.jsp" flush="true">
								<jsp:param name="action_page" value="admin/listEnterpriseInfo.do" />
							</jsp:include>
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
