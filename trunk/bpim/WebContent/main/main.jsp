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
						<h3 class="title">最新公告</h3>
						<s:iterator value="newsAnnounces" status="st">
							<ul>
								<li ><s:hidden name="id" />
									<h4>
										<s:property value="newsTitle" />
										(<s:date name="addTimeTemp"
										format="yyyy-MM-dd" /> <s:hidden name="addTime" />)
									</h4>
								</li>
							</ul>
							<ul>
								<li ><s:property
										value="content" />
								</li>
							</ul>
						</s:iterator>
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