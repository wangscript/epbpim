<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>在线问答</title>
<script type="text/javascript">
	function searchFile(id) {
		document.getElementById(id).submit();
	}
</script>
</head>
<body>
	<div id="main"><jsp:include page="../mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">问题查询：</h3>
					<div id="searchCondition">
						<s:form action="listQA.do" method="post" name="searchQAForm"
							id="searchQAForm">
							<ul class="fullScreenResultUl">
								<li class="width200Li"><label class="lb">类型：</label> <select
									id="type" name="questionAnswer.type">
										<option value="0" <s:if test="questionAnswer.type==0">selected="selected"</s:if>>全部问题</option>
										<option value="1" <s:if test="questionAnswer.type==1">selected="selected"</s:if>>我的问题</option>
								</select></li>
								<li class="width200Li"><label class="lb">问题关键字：</label><input
									class="width100Input" name="questionAnswer.keyword" value="<s:property
											value="questionAnswer.keyword" />"
									id="keyword"></li>
								<li class="width50Li"><input name="searchButton"
									type="submit" id="searchButton" class="button" value="查询">
								</li>
							</ul>
						</s:form>
					</div>
					<s:if test="datas==null || datas.size()==0">
						<ul class="fullScreenResultUl">
							<li class="width200Li">
								<h3>
									<s:text name="Common.Nodata" />
								</h3></li>
						</ul>
					</s:if>
					<s:else>
						<div class="searchResult" id="searchResult">
							<s:iterator value="datas" status="st">
									<ul class="fullScreenResultUl">
										<li class="width100Li"><h3>问题</h3><li class="width700Li"><h3><a onclick="displayOrNotDisplay(answer<s:property
											value="id" />)"  ><s:property
												value="question" /></a></h3>
										</li>
									</ul>
									<ul class="fullScreenResultUl" id="answer<s:property
												value="id" />" style="display:none">
										<li class="width100Li"><h3>回答</h3><li class="width700Li"><h3><s:property
												value="answer" /></h3>
										</li>
									</ul>
							</s:iterator>
							<ul class="fullScreenResultUl">
								<jsp:include page="../../common/pagination.jsp" flush="true">
									<jsp:param name="action_page" value="main/searchQA.do" />
								</jsp:include>
							</ul>
						</div>
					</s:else>
					<div>
						<s:form action="addQuestion.do" method="post"
							onsubmit="alert('提交成功，专家回答后，您的问题会出现在列表之中。感谢您的参与！')"
							name="addQuestionForm" id="addQuestionForm">
							<ul class="fullScreenUl">
							<li>提交一个新问题
								</li>
							</ul>
							<ul class="fullScreenUl">
								
								<li><textarea class="adviceTextArea"
										name="questionAnswer.question"></textarea></li>
							</ul>
							<ul class="fullScreenUl">
								<li><input type="submit" class="leftButton" value="提交">
								</li>
							</ul>
							<!-- end #content -->
						</s:form>
					</div>
				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>
