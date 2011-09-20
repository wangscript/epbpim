<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>用户列表</title>
<script language="javascript">
function update(updateId){
	var obj = document.getElementById(updateId);
	var id = obj.children[0].childNodes[0].value;
	var servicePlanId = obj.children[6].childNodes[0].value;
	var data = {id:id, servicePlanId:servicePlanId};
	UserInfoService.update(data,callback);
}
function updatePassword(updateId){
	var obj = document.getElementById(updateId);
	var id = obj.children[0].childNodes[0].value;
	var data = {id:id};
	UserInfoService.updatePassword(data,callbackpass);
}
function insertRepenseRecord(updateId){
	var obj = document.getElementById(updateId);
	var servicePlanId = obj.children[6].childNodes[0].value;
	if(servicePlanId > 0) {
		var id = obj.children[0].childNodes[0].value;
		var data = {id:id, servicePlanId:servicePlanId};
		ExpenseRecordService.insertRepenseRecord(data,callbackexpense);
	} else {
		alert("请先选择充值套餐");
	}
}
function callbackexpense(msg){
	if(msg) {
		alert("充值成功");
	} else {
		alert("充值失败");
	}
    //dwr.util.setValue('result',msg);
}

function callbackpass(msg){
	if(msg) {
		alert("更新成功, 您的新密码是:"+msg);
	} else {
		alert("更新失败");
	}
    //dwr.util.setValue('result',msg);
}
function callback(msg){
	if(msg) {
		alert("更新成功");
	} else {
		alert("更新失败");
	}
    //dwr.util.setValue('result',msg);
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
}
</script>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">用户列表</h4>
					<ul class="fullScreenResultUl">
						<li>
							<ul class="fullScreenResultUl">
								<li class="width200Li">
									<form action="newUser.do" method="post">
										<input type="submit" class="button"
											onclick='updatePassword(<s:property value="#st.index+1"/>);'
											value="批量创建用户"><s:hidden name="eId"/>
									</form></li>
								<li class="width200Li">
									<form action="" method="post">
										<s:textfield cssClass="width100Input"
											name="enterpriseInfo.principal" />
										<input type="button" class="button"
											onclick='updatePassword(<s:property value="#st.index+1"/>);'
											value="企业充值"><s:hidden name="eId"/>
									</form></li>
							</ul></li>
					</ul>
					<div class="searchResult">
								<ul class="fullScreenResultUl">
									<li class="width100Li">姓名<s:hidden name="eId"/></li>
									<li class="width100Li">注册时间</li>
									<li class="width100Li">编号</li>
									<li class="width100Li">手机</li>
									<li class="width150Li">邮箱</li>
									<li class="width100Li">是否可用</li>
									<li class="width100Li">选择应用</li>
									<li class="width50Li">操作</li>
									<li class="width50Li">操作</li>
								</ul>
								<s:if test="userInfos==null || userInfos.size()==0">
									<ul>
										<li>
											<h4>没数据</h4></li>
									</ul>
								</s:if>
								<s:else>
									<s:iterator value="userInfos" status="st">
										<ul id="<s:property value='#st.index+1'/>">
											<li class="width100Li"><s:hidden name="id" /> <s:property value="realName" />
											</li>
											<li class="width100Li"><s:date name="registerDate" format="yyyy-MM-dd" />
												<s:hidden name="registerDate" />
											</li>
											<li class="width100Li"><s:property value="identifier" />
											</li>
											<li class="width100Li"><s:property value="mobilePhone" />
											</li>
											<li class="width100Li"><s:if test="enable==1}">是</s:if><s:else>否</s:else>
											</li>
										</ul>
									</s:iterator>
								</s:else>
					</div>
					<!-- end #adminContent -->
					<div style="clear: both;">&nbsp;</div>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="../common/footer.jsp"></jsp:include>

	</div>
	<!-- end #footer -->
</body>
</html>
