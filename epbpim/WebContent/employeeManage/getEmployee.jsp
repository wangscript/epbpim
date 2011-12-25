<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ryxx.bpim.user.enums.EduBackgroundEnum"%>
<%@ page import="com.ryxx.bpim.user.enums.UserTitleEnum"%>
<%@ page import="com.ryxx.bpim.user.enums.UserStatusEnum"%>
<%@ page import="com.ryxx.bpim.user.enums.InsuranceTypeEnum"%>
<%@ page import="com.ryxx.bpim.user.enums.CertificationTypeEnum"%>
<%@ page import="com.ryxx.bpim.user.entity.UserCertification"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>修改员工</title>
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
<script type='text/javascript' src='../js/validation.js'></script>
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
					<s:form action="updateUser.do" method="post" onsubmit="return validate(this);">
					<h3 class="title">修改员工</h3>
					<div id="addProjectTable">
						<dl>
							<dt>
								<h4 class="title">员工基本信息</h4>
							</dt>
							<dd>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">姓名:</label>
										<s:textfield cssClass="width100Input" name="userInfo.realName" /><s:hidden name="id" />
									*</li>
									<textValidate field="userInfo.realName" lableText="<s:text name='姓名' />" isValidate="true" min="0" max="100">
									<li class="width250Li"><label class="width4Lb">编号:</label>
										<s:textfield cssClass="width150Input" name="userInfo.identity" />
									</li>
									<li class="width200Li"><label class="width4Lb">用户名:</label>
										<s:textfield cssClass="width100Input" name="userInfo.userName" />
									</li>
									<textValidate field="userInfo.userName" lableText="<s:text name='用户名' />" isValidate="true" min="0" max="100">
									<li class="width200Li"><label class="width4Lb">性别:</label>
										<s:select name="userInfo.sex"
									       list="#{'0':'男','1':'女'}"
									       listKey="key"
									       listValue="value"
									       multiple="false"
					       				onchange=""/>
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">出生年月:</label>
										<s:textfield cssClass="Wdate width100Input" name="userInfo.birthdayTmp" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
									<li class="width250Li"><label class="width4Lb">身份证:</label>
										<s:textfield cssClass="width150Input" name="userInfo.idCard" />
									</li>
									<textValidate field="roleCount" lableText="<s:text name='userInfo.idCard' />" isValidate="true" dataType="codeType">
									<li class="width200Li"><label class="width4Lb">人事档案:</label>
										<s:textfield cssClass="width100Input" name="userInfo.humenFile" />
									</li>
									<li class="width200Li"><label class="width4Lb">党派:</label>
										<s:textfield cssClass="width100Input" name="userInfo.party" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width450Li"><label class="width4Lb">家庭住址:</label>
										<s:textfield cssClass="width350Input" name="userInfo.familyAddress" />
									</li>
									<li class="width200Li"><label class="width4Lb">电话:</label>
										<s:textfield cssClass="width100Input" name="userInfo.phone" />
									</li>
									<li class="width200Li"><label class="width4Lb">手机:</label>
										<s:textfield cssClass="width100Input" name="userInfo.mobilePhone" />
									</li>
								</ul>
							</dd>
							<dt>
								<h4 class="title">教育程度信息</h4>
							</dt>
							<dd>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">学历:</label>
									<%
										EduBackgroundEnum[] ebk = EduBackgroundEnum.values();
										request.setAttribute("ebk", ebk);
									%>				
									<s:select name="eduBackGround"
									       list="#request.ebk"
									       listKey="key"
									       listValue="value"
									       multiple="false"
					       				   onchange=""/>
									</li>
									<li class="width250Li"><label class="width4Lb">学校名称:</label>
										<s:textfield cssClass="width150Input" name="userInfo.school" />
									</li>
									<li class="width200Li"><label class="width4Lb">专业:</label>
										<s:textfield cssClass="width100Input" name="userInfo.major" />
									</li>
									<li class="width200Li"><label class="width4Lb">毕业日期:</label>
										<s:textfield cssClass="Wdate width100Input" name="userInfo.graduateDateTmp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width6Lb">继续教育情况:</label>
										<s:select name="userInfo.eduCountinue"
									       list="#{'0':'---请选择---','1':'通过','2':'不通过'}"
									       listKey="key"
									       listValue="value"
									       multiple="false"
					       				   onchange=""/>
									</li>
								</ul>
							</dd>
							<dt>
								<h4 class="title">
									<h4 class="title">工作经历</h4>
								</h4>
							</dt>
							<dd>
								<div id="experiencesLicences">
									<s:if test="experiences.size() == 0">
										<ul class="fullScreenUl" id="working1">
											<li class="width250Li">
												<label class="width4Lb">所在单位:</label>
												<input class="width150Input" name="experiences[0].company" id="experiences[0].company" />
											</li>
											<li class="width200Li">
												<label class="width2Lb">职务:</label>
												<input class="width150Input" name="experiences[0].title" id="experiences[0].title" />
											</li>
											<li class="width300Li">
												<label class='width2Lb'>时间:</label>
												<input class='Wdate width100Input' name='experiences[0].startDateTemp' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
												<label class='width1OLb'>到</label>
												<input class='Wdate width100Input' name='experiences[0].endDateTemp' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
											</li>
											<li class="width50Li"><input type="button"
												class="mediumLeftButton" onclick="deleteWorkingLicense('working1');"
												value="删除">
											</li>
										</ul>
									</s:if>
									<s:else>
										<s:iterator value="experiences" status="st">
											<ul class="fullScreenUl" id="working<s:property value="#st.index+1"/>">
												<li class="width250Li">
													<label class="width4Lb">所在单位:</label>
													<s:textfield cssClass="width150Input" name="experiences[%{#st.index}].company" />
												</li>
												<li class="width200Li">
													<label class="width2Lb">职务:</label>
													<s:textfield cssClass="width150Input" name="experiences[%{#st.index}].title" />
												</li>
												<li class="width300Li">
													<label class='width2Lb'>时间:</label>
													<s:textfield cssClass="Wdate width100Input" name="experiences[%{#st.index}].startDateTemp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
													<label class='width1OLb'>到</label>
													<s:textfield cssClass="Wdate width100Input" name="experiences[%{#st.index}].endDateTemp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
												</li>
												<li class="width50Li"><input type="button"
													class="mediumLeftButton" onclick="deleteWorkingLicense('working<s:property value="#st.index+1"/>');"
													value="删除">
												</li>
											</ul>
										</s:iterator>
									</s:else>
								</div>
								<ul class="fullScreenUl">
									<li><input type="button" class="mediumLeftButton"
										onclick="addWorkingLicense();" value="新增工作经历"></li>
								</ul>
							</dd>
							<dt>
								<h4 class="title">
									<h4 class="title">工作信息</h4>
								</h4>
							</dt>
							<dd>
								<ul class="fullScreenUlNoHeight">
									<li class="width100Li"><label class="width4Lb">所属部门:</label>
									</li>
									<li><ul class="width800UlNoHeight">
									<s:checkboxlist list="allDepts" name="deptGroup" listKey="id"
											listValue="name" />
									</ul></li>
									
								</ul>
								<ul class="fullScreenUlNoHeight" id="role">
									<li class="width100Li"><label class="width4Lb">职务:</label></li>
									<s:checkboxlist list="allRoles" name="roleGroup" listKey="id"
											listValue="name" />
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">职称:</label>
									<%
									UserTitleEnum[] userTitles = UserTitleEnum.values();
										request.setAttribute("userTitles", userTitles);
									%>
									<s:select name="title"
									       list="#request.userTitles"
									       listKey="key"
									       listValue="value"
									       multiple="false"
					       				   onchange=""/>
									</li>
									<li class="width200Li"><label class="width4Lb">入职日期:</label>
										<s:textfield cssClass="Wdate width100Input" name="userInfo.onboardDateTmp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
									<li class="width200Li"><label class="width4Lb">离职日期:</label>
										<s:textfield cssClass="Wdate width100Input" name="userInfo.leaveDateTmp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width200Li"><label class="width4Lb">关联人:</label>
										<s:textfield cssClass="width100Input" name="userInfo.relation" />
									</li>
									<li class="width200Li"><label class="width4Lb">状态:</label>
									<%
										UserStatusEnum[] userStatus = UserStatusEnum.values();
										request.setAttribute("userStatus", userStatus);
									%>
									<s:select name="status"
									       list="#request.userStatus"
									       listKey="key"
									       listValue="value"
									       multiple="false"
					       				   onchange=""/>
									</li>

									<li class="width200Li"><label class="width4Lb">缴纳保险:</label>
									<%
										InsuranceTypeEnum[] insuranceTypes = InsuranceTypeEnum.values();
										request.setAttribute("insuranceTypes", insuranceTypes);
									%>
									<s:select name="type"
									       list="#request.insuranceTypes"
									       listKey="key"
									       listValue="value"
									       multiple="false"
					       				   onchange=""/>
									</li>
								</ul>
								<ul class="fullScreenUl">
									<li class="width450Li"><label class="width4Lb">备注:</label>
										<s:textfield cssClass="width350Input" name="userInfo.remark" />
									</li>
								</ul>
							</dd>
							<dt>
								<h4 class="title">
									<h4 class="title">执业资格信息</h4>
								</h4>
							</dt>
							<dd>
								<div id="employeeLicences">
									<%
										CertificationTypeEnum[] certifiTypes = CertificationTypeEnum.values();
										request.setAttribute("certifiTypes", certifiTypes);
									%>
									<s:if test="certifies.size() == 0">
										<ul class="fullScreenUl" id="licence1">
											<li class="width250Li"><label class="width4Lb">执业资格:</label>
											<s:select name="certifies[0].selectId"
										       list="#request.certifiTypes"
										       listKey="key"
										       listValue="value"
										       multiple="false"
						       				   onchange=""/>
											</li>
											<li class="width250Li"><label class="width4Lb">证书编号:</label><input
												class="width150Input" name="certifies[0].identity"
												id="certifies[0].identity" />
											</li>
											<li class="width200Li">
												<label class='width3Lb'>有效期:</label>
												<input class='Wdate width100Input' name='certifies[0].expireDateFromPage' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
											</li>
											<li class="width150Li"><label class="width2Lb">备注:</label><input
												class="width100Input" name="certifies[0].remark"
												id="certifies[0].remark" />
											</li>
											<li class="width50Li"><input type="button"
												class="mediumLeftButton" onclick="deleteLicense('licence1');"
												value="删除">
											</li>
										</ul>
									</s:if>
									<s:else>
										<s:iterator value="certifies" status="st">
											<ul class="fullScreenUl" id="licence<s:property value="#st.index+1"/>">
												<li class="width250Li"><label class="width4Lb">执业资格:</label>
												<s:select name="certifies[%{#st.index}].selectId"
											       list="#request.certifiTypes"
											       listKey="key"
											       listValue="value"
											       multiple="false"
							       				   onchange=""/>
												</li>
												<li class="width250Li"><label class="width4Lb">证书编号:</label>
													<s:textfield cssClass="width150Input" name="certifies[%{#st.index}].identity" />
												</li>
												<li class="width200Li"><label class='width3Lb'>有效期:</label>
													<s:textfield cssClass="Wdate width100Input" name="certifies[%{#st.index}].expireDateFromPage" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
												</li>
												<li class="width150Li"><label class="width2Lb">备注:</label>
													<s:textfield cssClass="width100Input" name="certifies[%{#st.index}].remark" />
												</li>
												<li class="width50Li"><input type="button"
													class="mediumLeftButton" onclick="deleteLicense('licence<s:property value="#st.index+1"/>');"
													value="删除">
												</li>
											</ul>
										</s:iterator>
									</s:else>
								</div>
								<ul class="fullScreenUl">
									<li><input type="button" class="mediumLeftButton"
										onclick="addLicense();" value="新增执业资格"></li>
								</ul>
							</dd>
						</dl>
						<ul class="fullScreenUl">
							<li><input type="submit" id="addProject" class="mediumLeftButton" value="保存">
							</li>
						</ul>
					</div>

					<div></div>

				</s:form>
				</div>


				<div class="clr"></div>
			</div>
		</div>
		<!-- end #page -->
		<jsp:include page="../common/footer.jsp" /></div>
</body>
<script type="text/javascript">
	var certifisCount = 0;
	function addLicense() {
		++certifisCount;
		var employeeLicences = document.getElementById("employeeLicences");
		var ul = document.createElement("ul");
		ul.className = "fullScreenUl";
		var li1 = document.createElement("li");
		li1.innerHTML = "<label class='width4Lb'>执业资格:</label>"
				+ '<select id="certifies['+certifisCount+'].selectId" name="certifies['+certifisCount+'].selectId" class="width150Select">'
				+ '<s:iterator value="#request.certifiTypes" status="st">'
				+ '<option value="<s:property value='key'/>"><s:property value='value'/></option>'
				+ '</s:iterator>'
				+ '</select>';
		var li2 = document.createElement("li");
		li2.innerHTML = "<label class='width4Lb'>证书编号:</label><input class='width150Input' name='certifies["+certifisCount+"].identity' id='certifies["+certifisCount+"].identity' />";
		var li3 = document.createElement("li");
		li3.innerHTML = "<label class='width3Lb'>有效期:</label><input class='Wdate width100Input' name='certifies["+certifisCount+"].expireDateFromPage' onfocus=WdatePicker({dateFmt:'yyyy-MM-dd'}) />";
		var li4 = document.createElement("li");
		li4.innerHTML = "<label class='width2Lb'>备注:</label><input class='width100Input' name='certifies["+certifisCount+"].remark'	 id='certifies["+certifisCount+"].remark' />";
		var li5 = document.createElement("li");
		var t = employeeLicences.children.length;
		var id = "licence" + (t + 1);
		li5.innerHTML = "<input type='button' class='mediumLeftButton' onclick='deleteLicense(\""
				+ id + "\")' value='删除'>";
		li1.className = "width250Li";
		li2.className = "width250Li";
		li3.className = "width200Li";
		li4.className = "width150Li";
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
			var employeeLicences = document.getElementById(id);
			employeeLicences.parentNode.removeChild(employeeLicences);
		}
	}
	
	var experiencesCount = 0;
	function addWorkingLicense() {
		++experiencesCount;
		var experiencesLicences = document.getElementById("experiencesLicences");
		var ul = document.createElement("ul");
		ul.className = "fullScreenUl";
		var li1 = document.createElement("li");
		li1.innerHTML = "<label class='width4Lb'>所在单位:</label>"
				+ '<input class="width150Input" name="experiences['+experiencesCount+'].company" id="experiences['+experiencesCount+'].company" />';
		var li2 = document.createElement("li");
		li2.innerHTML = "<label class='width2Lb'>职务:</label><input class='width150Input' name='experiences["+experiencesCount+"].title' id='experiences["+experiencesCount+"].title' />";
		var li3 = document.createElement("li");
		li3.innerHTML = "<label class='width2Lb'>时间:</label><input class='Wdate width100Input' name='experiences["+experiencesCount+"].startDateTemp' onfocus=WdatePicker({dateFmt:'yyyy-MM-dd'}) />"
			          + "<label class='width1OLb'>到</label><input class='Wdate width100Input' name='experiences["+experiencesCount+"].endDateTemp' onfocus=WdatePicker({dateFmt:'yyyy-MM-dd'}) />";
		var li4 = document.createElement("li");
		var t = experiencesLicences.children.length;
		var id = "working" + (t + 1);
		li4.innerHTML = "<input type='button' class='mediumLeftButton' onclick='deleteWorkingLicense(\""
				+ id + "\")' value='删除'>";
		li1.className = "width250Li";
		li2.className = "width200Li";
		li3.className = "width300Li";
		li4.className = "width50Li";
		ul.appendChild(li1);
		ul.appendChild(li2);
		ul.appendChild(li3);
		ul.appendChild(li4);
		ul.setAttribute("id", id);
		experiencesLicences.appendChild(ul);
	}

	function deleteWorkingLicense(id) {
		if (confirm("确定删除该工作经历？")) {
			var experiencesLicences = document.getElementById(id);
			experiencesLicences.parentNode.removeChild(experiencesLicences);
		}
	}
</script>


</html>
