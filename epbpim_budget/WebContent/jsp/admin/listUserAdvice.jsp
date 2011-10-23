<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>用户反馈列表</title>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<s:form>
			<div class="content">
				<div class="content_resize">
					<div class="mainbar">
						<h4 class="title">意见反馈:</h4>
						<div id="searchCondition">
							<ul class="fullScreenUl">
								<li class="width200Li"><s:select name="condition.dataType"
										cssClass="width150Select"
										list="#{'1':'过去一周','2':'过去一个月','3':'过去全部'}" listKey="key"
										listValue="value" multiple="false" onchange="" />
								</li>
								<li class="width100Li"><input name="searchUserButton"
									type="submit" id="searchUserButton" class="button" value="查询">
								</li>
							</ul>
						</div>
						<!-- end #sidebar -->

						<div id="adminContent">
							<div class="searchResult">
								<div class="entry">
									<ul class="fullScreenResultUl">
										<li class="width150Li">用户名</li>
										<li class="width500Li">反馈内容</li>
										<li class="width100Li">反馈时间</li>
									</ul>
									<s:if test="datas==null || datas.size()==0">
									</s:if>
									<s:else>
										<s:iterator value="datas" status="st">
											<ul class="fullScreenResultUl">
												<li class="width150Li"><s:property value="userID" /></li>
												<li class="width500Li"><s:property value="adviceContent" /></li>
												<li class="width100Li"><s:date name="adviceDate" format="yyyy-MM-dd" /> <s:hidden
														name="adviceDate" /></li>
											</ul>
										</s:iterator>
										<jsp:include page="../common/pagination.jsp" flush="true">
											<jsp:param name="action_page" value="admin/listua.do" />
										</jsp:include>
									</s:else>
								</div>
							</div>
							<div style="clear: both;">&nbsp;</div>
						</div>
						<!-- end #content -->
					</div>
				</div>
			</div>
		</s:form>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp"></jsp:include>

	</div>
	<!-- end #footer -->
</body>
</html>