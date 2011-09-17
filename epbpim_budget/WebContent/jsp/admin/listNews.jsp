<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>公告列表</title>
</head>
<body>
	<div id="main"><jsp:include page="adminHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar"></div>
				<div class="adminContent">
					<div class="entry">
						<ul class="fullScreenUl">
							<li class="width100Li"><s:form action="preAddNews.do">
									<input type="submit" class="mediumLeftButton" value="新增">
								</s:form></li>
						</ul>
						<ul class="fullScreenResultUl">
							<li class="width500Li">标题</li>
							<li class="width100Li">创建时间</li>
							<li class="width100Li">修改时间</li>
							<li class="width100Li">操作</li>
						</ul>
						<s:if test="newsAnnounces==null || newsAnnounces.size()==0">
						</s:if>
						<s:else>
							<s:iterator value="newsAnnounces" status="st">
								<ul class="fullScreenResultUl">
									<li class="width500Li"><s:hidden name="id" /><a
										href="showNews.do?id=<s:property value="id" />"><s:property
												value="newsTitle" /> </a></li>
									<li class="width100Li"><s:date name="addTime"
											format="yyyy-MM-dd" /></li>
									<li class="width100Li"><s:date name="addTimeTemp"
											format="yyyy-MM-dd" /></li>
									<li class="width100Li"><form action="deletenews.do"
											id='<s:property value='id'/>'>
											<s:hidden name="id" />
											<a href="deleteNews(<s:property value='id'/>);">删除</a>
										</form></li>
								</ul>
							</s:iterator>
						</s:else>
					</div>
				</div>
			</div>
			<!-- end #content -->
		</div>
	</div>
	<!-- end #page -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

	<!-- end #footer -->
</body>
<script type="text/javascript">
	function deleteNews(id){
		if(confirm("是否删除?")){
			document.getElementById(id).submit();
		}
	}
</script>
</html>