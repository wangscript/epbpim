<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建设工程综合信息管理系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
</head>
<body>
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
	<div class="mainbar">
		<div class="entry">			
			<s:if test="newsAnnounces==null || newsAnnounces.size()==0">
			</s:if>
			<s:else>
				<ul class="fullScreenUl">
				<li class="width100Li">公告信息</li>
				</ul>
				<ul class="fullScreenResultUl">
					<li class="width500Li">标题</li>
					<li class="width100Li">创建时间</li>
				</ul>				
				<s:iterator value="newsAnnounces" status="st">
					<ul class="fullScreenResultUl">
						<li class="width500Li"><s:hidden name="id" /><a href="showNews.do?id=<s:property value="id" />"><s:property value="newsTitle" /> </a></li>
						<li class="width100Li"><s:date name="addTime" format="yyyy-MM-dd" /></li>
					</ul>
				</s:iterator>
			</s:else>
		</div>
	</div>
</div>
<!-- end #content -->


<div class="clr"></div>
</div>

<!-- end #page --> <jsp:include page="../common/footer.jsp" /></div>

</body>
</html>