<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>专业书籍查询</title>
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
					<h3 class="title">专业书籍查询：</h3>
					<s:form action="searchBook.do" method="post" name="searchBookForm"
						id="searchBookForm">
						<ul class="fullScreenResultUl">
							<li class="width200Li" id="proviceLi"><label
								class="lb">省份：</label> <s:select cssClass="width100Select"
									id="book.provinceCity.id" name="book.provinceCity.id"
									list="provinceCities" listKey="city" listValue="city"
									multiple="false" required="true" onchange="" headerKey="0">
								</s:select></li>
							<li class="width200Li"><label class="lb">关键字：</label><input
								class="width100Input" name="book.bookRealName" id="keyword">
							</li>
							<li class="width50Li"><input name="searchButton"
								type="submit" id="searchButton" class="button" value="查询">
							</li>
						</ul>
					</s:form>
					<s:if test="datas==null || datas.size()==0">
						<tr>
							<td>
								<h3>
									<s:text name="Common.Nodata" />
								</h3>
							</td>
						</tr>
					</s:if>
					<s:else>
						<div class="searchResult" id="searchResult">
							<ul class="fullScreenResultUl">
								<li class="width100Li"><s:text name="地区" /></li>
								<li class="width600Li"><s:text name="书籍名称" /></li>
								<li class="width50Li"><s:text name="浏览" /></li>
							</ul>
							<s:iterator value="datas" status="st">
								<ul class="fullScreenResultUl">
									<li class="width100Li"><s:property
											value="provinceCity.city" /></li>
									<li class="width600Li"><s:property value="bookRealName" />
									</li>
									<li class="width50Li"><a target="blank"
										href="viewBook.do?bookFileName=<s:property value="fileName" />">预览</a>
									</li>
								</ul>
							</s:iterator>
							<ul class="fullScreenResultUl">
								<jsp:include page="../../common/pagination.jsp" flush="true">
									<jsp:param name="action_page" value="main/searchBook.do" />
								</jsp:include>
							</ul>
						</div>
					</s:else>
					<div></div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../../common/footer.jsp" /></div>
</body>
</html>
