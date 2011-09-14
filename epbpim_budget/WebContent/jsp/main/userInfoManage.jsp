<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>用户信息修改</title>
</head>
<body onload="createCode(); changeTitleBackground(); checkError()">
	<div id="main"><jsp:include page="mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">用户信息修改</h3>
					<form action="modifyUserInfo.do" name="modifyUserInfoForm"
						method="post" id="modifyUserInfoForm">
						<div id="userInfoTable">
							<ul>
								<li><label class="lb">用户名:</label>
								</li>
								<li><label class="lb"><s:property
											value="userInfo.userName" />
								</label>
								</li>
								<li><input type="hidden" name="userName" id="userName"
									value="<s:property value='userInfo.userName'/>" />
								</li>
							</ul>

							<ul>
								<li><label class="lb">姓名:</label>
								</li>
								<li><input name="userName" id="userName" />
								</li>
							</ul>

							<ul>
								<li><label class="lb">密码:</label>
								</li>
								<li><input name="password" id="password" />
								</li>
							</ul>

							<ul>
								<li><label class="lb">密码确认:</label>
								</li>
								<li><input name="password" id="password" />
								</li>
							</ul>

							<ul>
								<li><label class="lb">邮箱:</label>
								</li>
								<li><input name="mailAddress" id="mailAddress"
									value="<s:property value='userInfo.email'/>" />
								</li>
							</ul>

							<ul>
								<li><label class="lb">手机:</label>
								</li>
								<li><input name="mobile" id="mobile"
									value="<s:property value='userInfo.phone'/>" />
								</li>
							</ul>



							<ul>
								<li><input type="button" onclick="modifyUserInfo()"
									class="button" value="确定" style="width: 100px;"></li>
							</ul>
						</div>

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

</html>
