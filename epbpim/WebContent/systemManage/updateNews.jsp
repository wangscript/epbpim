<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>修改公告信息</title>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<s:form action="updateNews.do" name="updateNewsForm" method="post"
						id="updateNewsForm">
						<ul class="fullScreenUl">
							<li class="width50Li"><s:hidden name="id" /><label>标题:</label>
							</li>
							<li class="width350Li"><s:textfield name="title"
									cssClass="width300Input" maxLength="100" /></li>
							<li><label class="comments">输入在100个字符以内</label></li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width50Li"><label>内容:</label></li>
							<li class="width350Li"><s:textarea name="content" />
							</li>
							<li></li>
						</ul>
						<ul class="fullScreenUl">
							<li></li>
							<li class="width50Li"><s:submit cssClass="button" value="更新" /></li>
							<li class="width50Li"><input type="button" class="button"
								onclick="window.location.href = 'listNews.do'" value="返回">
							</li>
						</ul>
					</s:form>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
</html>
