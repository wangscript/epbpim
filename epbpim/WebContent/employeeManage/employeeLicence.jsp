<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<ul class="fullScreenUl">
		<li class="width200Li"><label class="width4Lb">资质:</label> <select
			id="projectType" name="projectBean.majorType">
				<option value="0">------请选择------</option>
				<option value="咨询1部">造价工程师</option>
				<option value="咨询1部">造价员</option>
				<option value="咨询1部">招标工程师</option>
				<option value="咨询1部">一级建造师</option>
				<option value="咨询1部">咨询(投资)工程师</option>
		</select>
		</li>
		<li class="width250Li"><label class="width4Lb">证书编号:</label><input
			class="width150Input" name="projectBean.number" id="projectNum" /></li>
		<li class="width200Li"><label class="width4Lb">专业:</label><input
			class="width100Input" name="projectBean.number" id="projectNum" /></li>
		<li class="width200Li"><label class="width4Lb">有效期:</label><input
			class="Wdate width100Input" name="projectBean.startDate"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
	</ul>
</body>
</html>