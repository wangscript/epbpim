<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/index.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../images/logo.ico" rel="SHORTCUT ICON" />
</head>
<body>
<div class="header">
    <div class="header_resize">
      <div class="nav_menu">
        <ul>
        	<li><a href="../login/index.jsp">首页</a></li>
			<li><a href="javascript: setHomepage()">设为首页</a></li>
			<li><a href="javascript: addFavorite()">添加收藏</a></li>
			<li><a href="../login/contactUs.do">联系我们</a></li>
        </ul>
      </div>
      <div class="clr"></div>
      <div class="logo"><h1>建筑行业造价平台<small>本软件系统由上海任远信息技术有限公司和上海建惠建设咨询有限公司共同研发</small><small>合作单位：上海市土木工程学会、上海燃气行业协会</small></h1></div>
    </div>
  </div>
</body>
<script type="text/javascript">
function setHomepage(){
	var url=window.location.href;
	  if (document.all){  
	  document.body.style.behavior = 'url(#default#homepage)';
	  document.body.setHomePage(url);  
	  }else if (window.sidebar){  
	  if (window.netscape){  
	  try {  
	  netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");  
	  }catch (e) {  
	  alert("该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true");  
	  }  
	  }  
	  var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);  
	  prefs.setCharPref('browser.startup.homepage', url);  
	  }  
	} 
	function addFavorite()//添加收藏  
	{  
	  var sURL=window.location.href;
	  var sTitle="建设工程综合信息管理系统";
	  try { 
	  window.external.addFavorite(sURL, sTitle); 
	  } 
	  catch (e) 
	  { 
	  try 
	  { 
	  window.sidebar.addPanel(sTitle, sURL, ""); 
	  } 
	  catch (e) 
	  { 
	  alert("加入收藏失败,请手动添加."); 
	  } 
	  }  
	} 
</script>
</html>