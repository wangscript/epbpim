<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>更新企业账号</title>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h4 class="title">更新企业账号</h4>
					<form action="updateEnterpriseInfo.do" name="addCompanyForm"
						method="post" id="addCompanyForm">
						<div>
							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">公司名称:</label>
								</li>
								<li class="width200Li"><s:textfield
										name="enterpriseInfo.name" /><s:hidden name="enterpriseInfo.id" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
								<li class="width200Li"><label class="comments">由6-10位字母数字组成</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">联系人姓名:</label>
								</li>
								<li class="width200Li"><s:textfield
										name="enterpriseInfo.principal" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">邮箱:</label>
								</li>
								<li class="width200Li"><s:textfield
										name="enterpriseInfo.email" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
							</ul>
							
							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">余额:</label>
								</li>
								<li class="width200Li"><s:textfield	name="enterpriseInfo.email" />
								</li>
								<li class="width100Li"><s:text name="{0,number,###.00}"><s:param value="enterpriseInfo.balance"/></s:text></li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width5Lb">联系人手机:</label>
								</li>
								<li class="width200Li"><s:textfield
										name="enterpriseInfo.phone" />
								</li>
								<li class="width100Li"><label class="required width5Lb">*必填</label>
								</li>
								<li class="width100Li"><label class="comments width5Lb">11位手机号</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><label class="width6Lb">业务主要地区:</label>
								</li>
								<li class="width200Li"><s:select
										name="enterpriseInfo.favorite" list="provinceCities"
										listKey="city" listValue="city" multiple="false"
										required="true" onchange="" headerKey="0"
										headerValue="--请选择--" /></li>
								<li class="width100Li"><label class="required width5Lb">*必选</label>
								</li>
							</ul>

							<ul class="fullScreenUl">
								<li class="width100Li"><input type="submit"
									class="mediumLeftButton" onclick="validateCommit();" value="保存">
								</li>
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