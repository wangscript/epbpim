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
					<h4 class="title">企业充值信息</h4>
					<div class="searchResult" id="searchResult">
						<ul class="fullScreenResultUl">
							<li class="width200Li">充值金额</li>
							<li class="width200Li">充值日期</li>
						</ul>
						<s:iterator value="balanceRecords" status="st">
							<ul class="fullScreenResultUl">
								<li class="width200Li"><s:property value="balance" /></li>
								<li class="width200Li"><s:date name="balanceDateTmp" format="yyyy-MM-dd" /><s:hidden name="balanceDate" /></li>
							</ul>
						</s:iterator>
						<ul class="fullScreenResultUl">
							<s:form>
							<s:hidden name="eId" />
							<jsp:include page="../common/pagination.jsp" flush="true">
								<jsp:param name="action_page" value="admin/listPrice.do" />
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
