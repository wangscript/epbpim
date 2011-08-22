<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>新增员工</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/delgadoTabs.css" rel="stylesheet" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="../js/My97DatePicker/skin/default/datepicker.css" type="text/css"></link>
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type='text/javascript' src='../js/My97DatePicker/WdatePicker.js'></script>
<script type='text/javascript' src='../js/common.js'></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/delgado.pack.js"></script>
<script type="text/javascript">
	$(function() {
		$("dl").KandyTabs({
			action : "slide",
			trigger : "click"
		});
	})
</script>
</head>
<body>
	<div id="main"><jsp:include page="../main/mainHeader.jsp" />
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<h3 class="title">新增员工</h3>
					<div id="addProjectTable">
						<dl>
							<dt>
								<h4 class="title">员工基本信息</h4>
							</dt>
							<dd>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">姓名:</label>
										<input class="width100Input" name="projectBean.name"
										id="projectName" />*</li>
									<li class="width250Li"><label class="width4Lb">编号:</label>
										<input class="width150Input" name="projectBean.number"
										id="projectNum" />
									</li>
									<li class="width200Li"><label class="width4Lb">用户名:</label>
										<input class="width100Input" name="projectBean.name"
										id="projectName" />
									</li>
									<li class="width200Li"><label class="width4Lb">性别:</label><select
										id="projectType" name="projectBean.majorType">
											<option value="人防">--------男--------</option>
											<option value="房修">--------女--------</option>
									</select>
									</li>

								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">出生年月:</label><input
										class="Wdate width100Input" name="projectBean.startDate"
										onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
									<li class="width250Li"><label class="width4Lb">身份证:</label><input
										class="width150Input" name="projectBean.number"
										id="projectNum" />
									</li>
									<li class="width200Li"><label class="width4Lb">人事档案:</label><input
										class="width100Input" name="projectBean.number"
										id="projectNum" />
									</li>
									<li class="width200Li"><label class="width4Lb">党派:</label><input
										class="width100Input" name="projectBean.number"
										id="projectNum" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width450Li"><label class="width4Lb">家庭住址:</label><input
										class="width350Input" name="projectBean.number"
										id="projectNum" />
									</li>
									<li class="width200Li"><label class="width4Lb">电话:</label><input
										class="width100Input" name="projectBean.number"
										id="projectNum" />
									</li>
									<li class="width200Li"><label class="width4Lb">手机:</label><input
										class="width100Input" name="projectBean.number"
										id="projectNum" />
									</li>

								</ul>
							</dd>
							<dt>
								<h4 class="title">教育程度信息</h4>
							</dt>
							<dd>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">学历:</label>
										<select id="projectType" name="projectBean.majorType">
											<option value="0">-----请选择-----</option>
											<option value="咨询1部">初中</option>
											<option value="咨询1部">技校</option>
											<option value="咨询1部">中专</option>
											<option value="咨询1部">高中</option>
											<option value="咨询1部">大专</option>
											<option value="咨询1部">本科</option>
											<option value="咨询1部">硕士</option>
											<option value="咨询1部">博士</option>
											<option value="咨询1部">博士后</option>
									</select></li>
									<li class="width250Li"><label class="width4Lb">学校名称:</label><input
										class="width150Input" name="projectBean.number"
										id="projectNum" /></li>
									<li class="width200Li"><label class="width4Lb">专业:</label><input
										class="width100Input" name="projectBean.number"
										id="projectNum" /></li>
									<li class="width200Li"><label class="width4Lb">毕业日期:</label><input
										class="Wdate width100Input" name="projectBean.startDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">继续教育情况:</label>
										<select id="projectType" name="projectBean.majorType">
											<option value="0">---请选择---</option>
											<option value="咨询1部">通过</option>
											<option value="咨询1部">不通过</option>
									</select></li>
								</ul>
							</dd>
							<dt>
								<h4 class="title">
									<h4 class="title">工作信息</h4>
								</h4>
							</dt>
							<dd>
								<ul class="fullScreenUl" id="dept">
									<li class="width200Li"><label class="width4Lb">所属部门:</label>
										<select id="projectType" name="projectBean.majorType">
											<option value="0">-----请选择-----</option>
											<option value="咨询1部">咨询1部</option>
											<option value="咨询1部">咨询2部</option>
											<option value="咨询1部">咨询3部</option>
									</select></li>
									<li class="width200Li"><label class="width4Lb">职称:</label>
										<select id="projectType" name="projectBean.majorType">
											<option value="0">-----请选择-----</option>
											<option value="咨询1部">正高工</option>
											<option value="咨询1部">副高工</option>
											<option value="咨询1部">工程师</option>
											<option value="咨询1部">助理工程师</option>
											<option value="咨询1部">技术员</option>
											<option value="咨询1部">高级经济师</option>
											<option value="咨询1部">经济师</option>
											<option value="咨询1部">高级会计师</option>
											<option value="咨询1部">中级会计师</option>
											<option value="咨询1部">会计师</option>
									</select></li>
								</ul>
								<ul class="fullScreenUl">
									<li><input type="button" class="mediumLeftButton"
										onclick="addDept();" value="新增所属部门">
									</li>
								</ul>
								<ul class="fullScreenUl" id="role">
									<li class="width200Li"><label class="width4Lb">职务:</label>
										<select name="projectBean.majorType">
											<option value="0">-----请选择-----</option>
											<option value="无">总经理</option>
											<option value="咨询1部">部门经理</option>
											<option value="咨询1部">普通员工</option>
									</select>
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li><input type="button" class="mediumLeftButton"
										onclick="addRole();" value="新增所处职务">
									</li>
								</ul>
								<ul class="fullScreenUl">
									</li>
									<li class="width200Li"><label class="width4Lb">入职日期:</label><input
										class="Wdate width100Input" name="projectBean.startDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
									<li class="width200Li"><label class="width4Lb">离职日期:</label><input
										class="Wdate width100Input" name="projectBean.startDate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>

								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">关联人:</label>
										<input class="width100Input" name="projectBean.number"
										id="projectNum" />
									</li>
									<li class="width250Li"><label class="width4Lb">状态:</label>
										<select id="projectType" name="projectBean.majorType">
											<option value="0">-----请选择-----</option>
											<option value="无">在职</option>
											<option value="咨询1部">离职</option>
											<option value="咨询1部">返聘</option>
											<option value="咨询1部">实习</option>
									</select>
									</li>

									<li class="width200Li"><label class="width4Lb">缴纳保险:</label>
										<select name="projectBean.majorType">
											<option value="0">-----请选择-----</option>
											<option value="无">城保</option>
											<option value="咨询1部">镇保</option>
											<option value="咨询1部">综保</option>
									</select>
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width450Li"><label class="width4Lb">备注:</label><input
										class="width350Input" name="projectBean.number"
										id="projectNum" /></li>
								</ul>
							</dd>
							<dt>
								<h4 class="title">
									<h4 class="title">执业资格信息</h4>
								</h4>
							</dt>
							<dd>
								<div id="employeeLicences">
									<ul class="fullScreenUl" id="1">
										<li class="width200Li"><label class="width4Lb">执业资格:</label>
											<select id="projectType" name="projectBean.majorType">
												<option value="0">------请选择------</option>
												<option value="咨询1部">造价工程师</option>
												<option value="咨询1部">造价员</option>
												<option value="咨询1部">招标工程师</option>
												<option value="咨询1部">一级建造师</option>
												<option value="咨询1部">咨询(投资)工程师</option>
										</select>
										</li>
										<li class="width250Li"><label class="width4Lb">证书编号:</label><input
											class="width150Input" name="projectBean.number"
											id="projectNum" /></li>
										<li class="width200Li"><label class="width4Lb">专业:</label><input
											class="width100Input" name="projectBean.number"
											id="projectNum" /></li>
										<li class="width200Li"><label class="width4Lb">有效期:</label><input
											class="Wdate width100Input" name="projectBean.startDate"
											onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
										<li class="width50Li"><input type="button"
											class="mediumLeftButton" onclick="deleteLicense(1);"
											value="删除"></li>
									</ul>
								</div>
								<ul class="fullScreenUl">
									<li><input type="button" class="mediumLeftButton"
										onclick="addLicense();" value="新增执业资格">
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width450Li"><label class="width4Lb">备注:</label><input
										class="width350Input" name="projectBean.number"
										id="projectNum" /></li>
								</ul>
							</dd>
						</dl>
						<ul class="fullScreenUl">
							<li><input type="button" id="addProject"
								class="mediumLeftButton"
								onclick="window.location.href='../main/main.jsp'" value="保存">
							</li>
						</ul>
					</div>

					<div></div>


				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	function addLicense() {
		var employeeLicences = document.getElementById("employeeLicences");
		var ul = document.createElement("ul");
		ul.className = "fullScreenUl";
		var li1 = document.createElement("li");
		li1.innerHTML = "<label class='width4Lb'>资质:</label>"
				+ "<select id='projectType' name='projectBean.majorType'>"
				+ "<option value='0'>------请选择------</option>"
				+ "<option value='咨询1部'>造价工程师</option>"
				+ "<option value='咨询1部'>造价员</option>"
				+ "<option value='咨询1部'>招标工程师</option>"
				+ "<option value='咨询1部'>一级建造师</option>"
				+ "<option value='咨询1部'>咨询(投资)工程师</option></select>";
		var li2 = document.createElement("li");
		li2.innerHTML = "<label class='width4Lb'>证书编号:</label><input class='width150Input' name='projectBean.number' id='projectNum' />";
		var li3 = document.createElement("li");
		li3.innerHTML = "<label class='width4Lb'>专业:</label><input class='width100Input' name='projectBean.number' id='projectNum' />";
		var li4 = document.createElement("li");
		li4.innerHTML = "<label class='width4Lb'>有效期:</label><input class='Wdate width100Input' name='projectBean.startDate' onfocus=WdatePicker({dateFmt:'yyyy-MM-dd'}) />";
		var li5 = document.createElement("li");
		var t = employeeLicences.children.length;
		var id = "licence" + (t + 1);
		li5.innerHTML = "<input type='button' class='mediumLeftButton' onclick='deleteLicense("
				+ id + ")' value='删除'>";
		li1.className = "width200Li";
		li2.className = "width250Li";
		li3.className = "width200Li";
		li4.className = "width200Li";
		li5.className = "width50Li";
		ul.appendChild(li1);
		ul.appendChild(li2);
		ul.appendChild(li3);
		ul.appendChild(li4);
		ul.appendChild(li5);
		ul.setAttribute("id", id);
		employeeLicences.appendChild(ul);
	}

	function deleteLicense(id) {
		if (confirm("确定删除该职业资质？")) {
			var employeeLicences = document.getElementById("employeeLicences");
			employeeLicences.removeChild(id);
		}
	}

	function addDept() {
		var ul = document.getElementById("dept");
		var li = document.createElement("li");
		var t = ul.childNodes.length;
		var id = "dept" + (t + 1);
		li.innerHTML = "<select id='projectType' name='projectBean.majorType'><option >----请选择----</option><option >咨询1部</option><option >咨询2部</option><option >咨询3部</option></select><input type='button' class='mediumRightButton' onclick='deleteDeptItem("
				+ id + ")' value='删除'>";
		li.className = "width150Li";
		li.setAttribute("id", id);
		ul.appendChild(li);
	}

	function addRole() {
		var ul = document.getElementById("role");
		var li = document.createElement("li");
		var t = ul.childNodes.length;
		var id = "role" + (t + 1);
		li.innerHTML = "<select id='projectType' name='projectBean.majorType'><option >----请选择----</option><option >咨询1部</option><option >咨询2部</option><option >咨询3部</option></select><input type='button' class='mediumRightButton' onclick='deleteRoleItem("
				+ id + ")' value='删除'>";
		li.className = "width150Li";
		li.setAttribute("id", id);
		ul.appendChild(li);
	}

	function deleteDeptItem(id) {
		if (confirm("确定删除该部门归属？")) {
			var ul = document.getElementById("dept");
			ul.removeChild(id);
		}
	}

	function deleteRoleItem(id) {
		if (confirm("确定删除该职务归属？")) {
			var ul = $("role");
			ul.removeChild(id);
		}
	}
</script>


</html>
