<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>公告信息</title>
</head>
<body>
	<div id="main"><jsp:include page="../admin/adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<s:form action="addNews.do" name="addNewsForm" method="post"
						id="addNewsForm">
						<div>
							<ul class="fullScreenUl">
								<li class="width50Li">标题:</li>
								<li class="width300Li"><s:textfield name="title"
										cssClass="width300Input" maxLength="100" />
								</li>
								<li class="width200Li"><label class="comments">输入在100个字符以内</label>
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width50Li"><label>内容:</label>
								</li>
								<li class="width300Li"><s:textarea name="content" />
								</li>
								<li></li>
							</ul>
							<ul class="fullScreenUl">
								<li class="width50Li"><s:submit cssClass="mediumLeftButton"
										value="新增" />
								</li>
								<li class="width50Li"><input type="button"
									class="mediumLeftButton" value="返回"
									onclick="window.location.href = 'listNews.do'">
								</li>
							</ul>
						</div>
					</s:form>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
</html>
