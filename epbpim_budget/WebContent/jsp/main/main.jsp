<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>建设工程综合信息管理系统</title>
</head>
<body>
	<div id="main"><jsp:include page="mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<div class="entry">
						<s:if test="newsAnnounces==null || newsAnnounces.size()==0"></s:if>
						<s:else>
							<h3 class="title">最新公告</h3>
							<s:iterator value="newsAnnounces" status="st">
								<ul class="fullScreenUl">
									<li>
										<h4>
											<s:property value="newsTitle" />
											(
											<s:date name="addTime" format="yyyy-MM-dd" />
											)
										</h4></li>
								</ul>
								<ul class="fullScreenUl">
									<li>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="content" />
									</li>
								</ul>

							</s:iterator>
						</s:else>
						<h3>意见反馈</h3>
						<s:form action="addUserAdvice.do" method="post"
							onsubmit="alert('提交成功，感谢您的参与！')" name="addUserAdviceForm"
							id="addUserAdviceForm">
							<ul class="fullScreenUl">
								<li><textarea class="adviceTextArea"
										name="userAdvice.adviceContent"></textarea>
								</li>
							</ul>
							<ul class="fullScreenUl">
								<li><input type="submit" class="leftButton" value="提交">
								</li>
							</ul>

							<!-- end #content -->
						</s:form>
					</div>
				</div>
			</div>
			<!-- end #content -->


			<div class="clr"></div>
		</div>

		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>

</body>
</html>