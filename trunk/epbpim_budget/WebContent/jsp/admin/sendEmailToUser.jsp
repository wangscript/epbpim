<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>发送邮件</title>
<script type="text/javascript">
	function checkError(){
		var msg = "<s:property value='msg'/>";
		if (msg) {
			if("true"==msg)
			{
				alert("发送成功！");
			}
			else if("false"==msg)
			{
				alert("出错了，请重试！");
			}
		}
	}
</script>
</head>
<body onload="checkError();">
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">发送邮件:</h4>
						<s:form id="sendEmailToUserForm" action="sendEmailToUser.do" method="post"> 
							<ul class="fullScreenUl">
								<li class="width400Li"><label class="width4Lb">邮件标题:</label><s:textfield cssClass="width150Input"
									name="mailTitle" id="mailTitle" /> <textValidate
										field="mailTitle" labelText="邮件标题" isValidate="true"
										min="0" max="50"> </textValidate></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width400Li"><label class="width4Lb">测试邮箱:</label><s:textfield cssClass="width150Input"
									name="testMailAddress" id="testMailAddress" /></li>
							</ul>
							<ul class="fullScreenUlNoHeight">
							<label class="width4Lb">邮件内容:</label><textarea name="mailBody">尊敬的用户：<br>内容 <br><br><br><br><br><br>任远信息技术有限公司<br>地址：上海市黄浦区汉口路193号309室<br>传真：021-63291301<br>售前，售后咨询电话：<br>高先生：18918129883<br>陈先生：15900810167<br>杨先生：18621908001<br>应先生：13361951583<br>任远官方QQ：1987971333</textarea>
							<textValidate
										field="mailBody" labelText="邮件内容" isValidate="true"
										min="0" max="500"> </textValidate>
							</ul>
							<ul class="fullScreenUl">
								<li class="width200Li"><input type="button" class="button"
									onclick="testSend()" value="测试发送"></li>
								<li class="width200Li"><input type="button" class="button"
									onclick="send()" value="正式发送"></li>
							</ul>

						</s:form>
					<div class="clr"></div>
				</div>
			</div>
			<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function testSend() {
		if ($("testMailAddress") == null || $("testMailAddress").value == null
				|| $("testMailAddress").value.length == 0) {
			alert("请填写测试邮箱");
		} else if(validate($("sendEmailToUserForm"))){
			$("sendEmailToUserForm").submit();
		}
	}
	
	function send() {
		if ($("testMailAddress") == null || $("testMailAddress").value == null
				|| $("testMailAddress").value.length == 0) {
			if(validate($("sendEmailToUserForm"))){
				$("sendEmailToUserForm").submit();
			}
		} else {
			alert("正式发送不需要测试邮箱，请保持测试邮箱为空");
		}
	}
	
</script>
</html>