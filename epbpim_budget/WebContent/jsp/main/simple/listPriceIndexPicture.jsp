<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>价格指数</title>
<script type="text/javascript">
	function downloadFile(id) {
		document.getElementById(id).submit();
	}
</script>
</head>
<body>
	<div id="main"><jsp:include page="../mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">价格指数</h3>
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
								<li class="width400Li"><s:text name="名称" /></li>
								<li class="width200Li"><s:text name="专业" /></li>
								<li class="width200Li"><s:text name="时间" /></li>
								<li class="width50Li"><s:text name="查看" /></li>
							</ul>
							<s:iterator value="datas" status="st">
								<ul class="fullScreenResultUl">
									<li class="width400Li"><s:property value="realName" /></li>
									<li class="width200Li"><s:property value="major.name" />
									</li>
									<li class="width200Li"><s:date name="priceIndexDate"
											format="yyyy-MM" /></li>
									<li class="width50Li"><a target="blank"
										href="viewPriceIndexPicture.do?priceIndexPictureFileName=<s:property value="fileName" />">预览</a>
									</li>
								</ul>
							</s:iterator>
							<ul class="fullScreenResultUl">
								<s:form id="paginationForm">
									<input type="hidden" name="priceIndexPicture.major.id"
										value="<s:property value='priceIndexPicture.major.id'/>">
									<input type="hidden" name="priceIndexPicture.provinceCity.id"
										value="<s:property value='priceIndexPicture.provinceCity.id'/>">
									<jsp:include page="../../common/pagination.jsp" flush="true">
										<jsp:param name="action_page"
											value="main/searchPriceIndexPicture.do" />
									</jsp:include>
								</s:form>
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
