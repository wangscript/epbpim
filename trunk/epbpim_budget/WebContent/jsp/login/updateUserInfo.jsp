<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="../js/common.js"></script>
<script type='text/javascript' src='../js/validation.js'></script>
<title>补全用户信息</title>
</head>
<body>
	<div id="main"><jsp:include page="shortHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">请补全用户信息</h4>
					<form action="updateUserInfo.do" name="modifyUserInfoForm"
						method="post" id="modifyUserInfoForm"
						onsubmit="return checkForm(this);">
						<ul class="fullScreenUl">
							<li class="width150Li">真实姓名:</li>
							<li class="width200Li"><s:textfield cssClass="width150Input"
									name="userInfo.realName" /> <textValidate
									field="userInfo.realName" labelText="真实姓名" isValidate="true"
									min="0" max="5" datatype="chinese">
							<input type="hidden" name="userInfo.id" value="<s:property value="userInfo.id" />"/>
							</li>
							<li class="width100Li">*必填</li>
							<li class="width400Li">请如实填写姓名,必须是汉字</li>
						</ul>

						<ul class="fullScreenUl">
							<li class="width150Li">密码:</li>
							<li class="width200Li"><s:password  cssClass="width150Input"
									id="password" name="userInfo.password" /> <textValidate
									field="userInfo.password" labelText="密码" isValidate="true"
									min="6" max="10">
							</li>
							<li class="width100Li">*必填</li>
							<li class="width400Li">将初始化密码改掉成6-10位密码，可以由任意字符组成</li>
						</ul>

						<ul class="fullScreenUl">
							<li class="width150Li">密码确认:</li>
							<li class="width200Li"><s:password cssClass="width150Input"
									id="passwordConfirm" name="userInfo.passwordConfirm" />
								<textValidate field="userInfo.passwordConfirm" labelText="密码确认"
									isValidate="true" min="6" max="10">
							</li>
							<li class="width100Li">*必填</li>
							<li class="width400Li">6-10位密码，可以由任意字符组成。必须和上面密码相同</li>
						</ul>

						<ul class="fullScreenUl">
							<li class="width150Li">邮箱:</li>
							<li class="width200Li"><s:textfield cssClass="width150Input"
									name="userInfo.email" />
								<textValidate field="userInfo.email" labelText="邮箱"
									isValidate="true" min="0" max="40" datatype="email">
							</li>
							<li class="width100Li">*必填</li>
							<li class="width400Li">您的常用邮箱。请如实填写</li>
						</ul>

						<ul class="fullScreenUl">
							<li class="width150Li">手机:</li>
							<li class="width200Li"><s:textfield cssClass="width150Input"
									name="userInfo.mobilePhone" />
								<textValidate field="userInfo.phone" labelText="联系人手机"
									isValidate="true" min="0" max="15" datatype="phone">
							</li>
							<li class="width100Li">*必填</li>
							<li class="width400Li">11位手机号。请如实填写</li>
						</ul>

						<ul class="fullScreenUl">
							<li class="width200Li"><input type="submit"
								 class="button" value="确定">
							</li>
						</ul>
					</form>
				</div>
				<!-- end #content -->
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" />
	</div>

</body>
<script type="text/javascript">
	function checkForm(form) {
		var password = $('password').value;
		var passwordConfirm = $('passwordConfirm').value;
		if (password != passwordConfirm) {
			alert('2次密码不一致');
			return false;
		}
		if (validate(form)) {
			return true;
		} else {
			return false;
		}
	}

	
</script>
</html>
