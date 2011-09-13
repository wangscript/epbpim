<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增企业账号</title>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">新增企业账号</h4>
					<form action="addCompany.do" name="addCompanyForm" method="post"
						id="addCompanyForm">
						<div>
							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">公司名称:</label>
								</li>
								<li class="width200Li"><input name="userName"
									maxlength="10" id="userName" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
								<li class="width200Li"><label class="comments">由6-10位字母数字组成</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">联系人姓名:</label>
								</li>
								<li class="width200Li"><input name="contacter"
									maxlength="100" id="contacter" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">邮箱:</label>
								</li>
								<li class="width200Li"><input name="mailAddress"
									maxlength="100" id="mailAddress" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">联系人手机:</label>
								</li>
								<li class="width200Li"><input name="mobile" maxlength="20"
									id="mobile" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
								<li class="width100Li"><label class="comments width5Lb">11位手机号</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li><input type="button" id="register-submit"
									class="mediumLeftButton" onclick="validateCommit();"
									class="button" value="保存">
								</li>
								<li></li>
							</ul>
						</div>

						<div></div>

					</form>
				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>
