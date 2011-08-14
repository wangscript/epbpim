var searchQuotaHelp = "选择所要查询定额的地区和专业种类，输入定额编号或定额名称，点击“查询“按钮，系统即可显示相应内容。";
var searchQuotaMenuHelp ="功能：查询上海地区2000定额";

function displayHelp(id,text){
	$(id).innerHTML = text;
	$(id).style.display = "block";
}

function unDisplayHelp(id){
	$(id).style.display = "none";
}

function displayMenuHelp(menuId,helpId,text,width){
	$(menuId).style.width = width;
	$(helpId).innerHTML = text;
	$(helpId+"Li").style.display = "block";
}

function unDisplayMenuHelp(menuId,helpId){
	$(menuId).style.width = "110px";
	$(helpId+"Li").style.display = "none";
}
