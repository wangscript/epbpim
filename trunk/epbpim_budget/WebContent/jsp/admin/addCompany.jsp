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
					<form action="addEnterpriseInfo.do" name="addCompanyForm"
						method="post" id="addCompanyForm"
						onsubmit="return validate(this);">
						<div>
							<ul class="fullScreenUl">
								<li class="width150Li">公司名称:</li>
								<li class="width200Li"><s:textfield
										cssClass="width150Input" name="enterpriseInfo.name" /> <textValidate
										field="enterpriseInfo.name" labelText="公司名称" isValidate="true"
										min="0" max="30">
								</li>
								<li class="width100Li">*必填</li>
								<li class="width200Li">请如实填写企业或部门名称</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width150Li">联系人姓名:</li>
								<li class="width200Li"><s:textfield
										cssClass="width150Input" name="enterpriseInfo.principal" /> <textValidate
										field="enterpriseInfo.principal" labelText="联系人姓名"
										isValidate="true" min="0" max="10" datatype="chinese">
								</li>
								<li class="width100Li">*必填</li>
								<li class="width200Li">您的真实姓名</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width150Li">邮箱:</li>
								<li class="width200Li"><s:textfield
										cssClass="width150Input" name="enterpriseInfo.email" /> <textValidate
										field="enterpriseInfo.email" labelText="邮箱" isValidate="true"
										min="0" max="40" datatype="email">
								</li>
								<li class="width100Li">*必填</li>
								<li class="width300Li">请如实填写，系统需要向您发送相关文件</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width150Li"><label class="width6Lb">联系人手机:</label>
								</li>
								<li class="width200Li"><s:textfield
										cssClass="width150Input" name="enterpriseInfo.phone" /> <textValidate
										field="enterpriseInfo.phone" labelText="联系人手机"
										isValidate="true" min="0" max="15" datatype="phone">
								</li>
								<li class="width100Li">*必填</li>
								<li class="width100Li">11位手机号</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width150Li">业务主要地区:</li>
								<li class="width200Li"><s:select cssClass="width150Select"
										name="enterpriseInfo.provinceCity.id" list="provinceCities"
										listKey="id" listValue="city" multiple="false" required="true"
										onchange="" headerKey="0" />
								</li>
								<li class="width100Li">*必选</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><input type="submit" class="button"
									onclick="" value="保存"></li>
							</ul>
						</div>

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
