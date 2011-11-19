<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ryxx.bpim.common.Constants" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String username = (String) session.getAttribute(Constants.LOGIN_USER_NAME);
	if(StringUtils.isEmpty(username)) {
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
%>
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>用户信息修改</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/main.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
<script type="text/javascript">
function checkError(){
	var msg = "<s:property value='msg'/>";
	if(msg!=null && msg!=""){
		alert(msg);
	}
}
</script>
</head>
<body onload="createCode(); changeTitleBackground(); checkError()">
<div id="main"><jsp:include page="mainHeader.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
					<s:form action="updateUser.do" method="post" onsubmit="return validate(this);">
					<h3 class="title">员工基本信息</h3>
					<div id="addProjectTable">
						<ul class="fullScreenUl">
							<li class="width200Li"><label class="width4Lb">姓名:</label>
								<s:textfield cssClass="width100Input" name="userInfo.realName" /><s:hidden name="id" />*
							</li>
							<textValidate field="userInfo.realName" lableText="<s:text name='姓名' />" isValidate="true" min="0" max="100">
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
						<ul class="fullScreenUl">
							<li class="width450Li"><label class="width4Lb">密码修改:</label>
								<s:textfield cssClass="width150Input" name="newPassword" />
							</li>
							<li class="width200Li"><label class="width4Lb">密码确认:</label>
								<s:textfield cssClass="width150Input" name="confirmPassword" />
							</li>
						</ul>
						<ul class="fullScreenUl">
							<li><input type="submit" id="addProject" class="mediumLeftButton" value="保存">
							</li>
						</ul>
					</div>

					<div></div>

				</s:form>
				</div>
<!-- end #content -->


<div class="clr"></div>
</div>
</div>
<!-- end #page --> <jsp:include page="../common/footer.jsp" />
</div>

</body>
<script type="text/javascript">
var code ; //在全局 定义验证码  
function createCode()  
{   
  code = "";  
  var codeLength = 4;//验证码的长度  
  var checkCode = document.getElementById("checkCode");  
  var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的     
  for(var i=0;i<codeLength;i++)  
  {  
   var charIndex = Math.floor(Math.random()*36);  
   code +=selectChar[charIndex];  
  }   
  if(checkCode)  
  {  
    checkCode.className="code";  
    checkCode.value = code;
    checkCode.blur();  
  }       
}    
function validate ()   {  
	  var inputCode = document.getElementById("validateCode").value;  
	  if(inputCode.length <=0)  
	  {  
	      alert("请输入验证码！");  
	  }  
	  else if(inputCode.toUpperCase() != code )  
	  {  
	     alert("验证码输入错误！");  
	     createCode();//刷新验证码  
	  }  
	  else  
	  {  
		  return true; 
	  }  
	}   

function displayProtocal(){
	var displayProtocal = document.getElementById("displayProtocal");
	displayProtocal.style.display = "block";
}

function modifyUserInfo(){
/*	if(!validate()){
		return false;
	}*/
	var mobileRegExp=/^[0-9]+$/;
	var mailAddress = document.getElementById("mailAddress").value;
	if(mailAddress.indexOf("@")<0){
		alert("邮箱格式不对");
		return false;
	}
	var mobile = document.getElementById("mobile").value;
	if(!mobileRegExp.test(mobile)){
		alert("电话号码只能包括数字");
		return false;
	}
	var question = document.getElementById("question").value;
	if(question==null){
		alert("问题不能为空");
		return false;
	}
	if(question.length>20){
		alert("问题不能超过20个字");
		return false;
	}
	var answer = document.getElementById("answer").value;
	if(answer==null){
		alert("答案不能为空");
		return false;
	}
	if(question.length>20){
		alert("答案不能超过20个字");
		return false;
	}
	document.getElementById("modifyUserInfoForm").submit();
}
</script>
</html>
