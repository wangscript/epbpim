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
	function clearPage(updateId){
		var ps = document.getElementById("ps");
		var pn = document.getElementById("pn");
		if(ps != null) {
			ps.options[1].selected = true;
		}
		if(pn != null) {
			pn.options[0].selected = true;
		}
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
						<s:form action="expertAnswer.do" method="post" name="searchQAForm"
							id="searchQAForm">
							<ul class="fullScreenResultUl">
								<li class="width200Li"><label class="lb">类型：</label> <select
									id="questionAnswerType" name="questionAnswer.type">
										<option value="2"
											<s:if test="questionAnswer.type==2">selected="selected"</s:if>>未回答的问题</option>
										<option value="3"
											<s:if test="questionAnswer.type==3">selected="selected"</s:if>>全部问题</option>
								</select>
								</li>
								<li class="width200Li"><label class="lb">问题关键字：</label><input
									class="width100Input" name="questionAnswer.keyword"
									value="<s:property
											value="questionAnswer.keyword" />"
									id="keyword">
								</li>
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
									<li class="width100Li"><h3>问题</h3>
									<li class="width600Li"><h3>
											<a
												onclick="displayOrNotDisplay(answer<s:property
											value="id" />)"><s:property
													value="question" /> </a>
										</h3>
									</li>
									<li class="width50Li"><input type="button" class="button"
										value="编辑" onclick="viewQuestion(<s:property value="id"/>)">
									</li>
									<li class="width50Li"><input type="button" class="button"
										value="删除" onclick="delQuestion(<s:property value="id"/>)">
									</li>
								</ul>
								<ul class="fullScreenResultUl"
									id="answer<s:property
												value="id" />"
									style="display: none">
									<li class="width100Li"><h3>回答</h3>
									<li class="width600Li"><s:if test="answer==null">
											<h3>暂无答案</h3>

										</s:if> <s:if test="answer!=null">
											<h3>
												<s:property value="answer" />
											</h3>
										</s:if>
									</li>
								</ul>
							</s:iterator>
							<ul class="fullScreenResultUl">
								<jsp:include page="../../common/pagination.jsp" flush="true">
									<jsp:param name="action_page" value="main/expertAnswer.do" />
								</jsp:include>
							</ul>
						</div>
					</s:else>
				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../../common/footer.jsp" /></div>
</body>

<script type="text/javascript">
	function delQuestion(id){
		if(window.confirm("是否删除?")){
			var type = $("questionAnswerType").value;
		}
			
		window.location.href = "delQuestion.do?questionAnswer.id="+id+"&questionAnswer.type="+type;
	}	
	function viewQuestion(id){
		var type= $("questionAnswerType").value;
		window.location.href="viewQuestion.do?questionAnswer.id="+id+"&questionAnswer.type="+type;
	}
	
	</script>
</html>
