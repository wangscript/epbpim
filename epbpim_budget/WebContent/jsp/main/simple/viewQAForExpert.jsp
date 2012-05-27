<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>回答问题</title>
</head>
<body>
		<div id="main"><jsp:include page="../mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<s:form action="updateQuestion.do" name="updateQuestionForm" method="post"
						id="updateQuestionForm">
						<ul class="fullScreenUl">
							<li class="width50Li"><s:hidden name="questionAnswer.id" />
							<s:hidden name="questionAnswer.question" />
							<s:hidden name="questionAnswer.questionUser.id" />
							
							<label>问题:</label>
							</li>
							<li class="width350Li"><s:property
												value="questionAnswer.question" /></li>
						</ul>
						<ul class="fullScreenUl">
							<li class="width50Li"><label>回答:</label></li>
							<li class="width350Li"><s:textarea name="questionAnswer.answer" />
							</li>
							<li></li>
						</ul>
						<ul class="fullScreenUl">
							<li></li>
							<li><s:submit cssClass="button" value="更新" /></li>
							<li><input type="button" class="button"
								onclick ="javascript:history.go(-1);" value="返回">
							</li>
						</ul>
					</s:form>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>
