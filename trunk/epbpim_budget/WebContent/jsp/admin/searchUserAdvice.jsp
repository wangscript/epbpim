<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员管理界面</title>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<s:form>
			<div class="content">
				<div class="content_resize">
					<div class="mainbar">
						<div id="searchCondition">
							<ul>
								<li>
									<ul>
										<li><s:select name="condition.dataType"
												list="#{'1':'过去一周','2':'过去一个月','3':'过去全部'}" listKey="key"
												listValue="value" multiple="false" onchange="" /></li>
										<li><input name="searchUserButton" type="submit"
											maxlength="10" id="searchUserButton" class="button"
											value="查询"></li>
									</ul></li>
							</ul>
						</div>
						<!-- end #sidebar -->

						<div id="adminContent">
							<div class="searchResult">
								<h2 class="title">查询结果:</h2>
								<div class="entry">
									<table>
										<tr>
											<td style="width: 180px;">用户名</td>
											<td style="width: 540px">反馈内容</td>
											<td style="width: 180px">反馈时间</td>
										</tr>
										<s:if test="datas==null || datas.size()==0">
											<h2>没数据</h2>
										</s:if>
										<s:else>
											<s:iterator value="datas" status="st">
												<tr>
													<td><s:property value="userName" />
													</td>
													<td><s:property value="adviceContent" />
													</td>
													<td><s:date name="adviceDate" format="yyyy-MM-dd" />
														<s:hidden name="adviceDate" />
													</td>
												</tr>
											</s:iterator>
											<jsp:include page="../common/pagination.jsp" flush="true">
												<jsp:param name="action_page" value="admin/listua.do" />
											</jsp:include>
										</s:else>
									</table>
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