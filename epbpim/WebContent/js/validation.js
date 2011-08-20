var cannotBeBlank = '不能为空';
var cannotMoreThan = '不能超过';
var char = '个字';

var mustBeNumber = '只能是数字';

//正则
var numberExp=/^[0-9]+$/;


//判断是否为空
function checkInputBlank(obj, name) {
	if (obj.value.length == 0) {
		alert(name + cannotBeBlank);
		return false;
	}
	return true;
}

//判断是否超过最大字符限制
function checkInputMaxLength(obj, name) {
	var maxLength = obj.maxLength;
	if (obj.value.length > maxLength) {
		alert(name + cannotMoreThan + maxLength + char);
		return false;
	}
	return true;
}

//判断是否是数字
function checkInputIsNumber(obj, name){
	if (!numberExp.test(obj.value)) {
		alert(name + mustBeNumber);
		return false;
	}
	return true;
}

//判断数字是否超过最大值
function checkInputMaxValue(obj, name, max){
	if (obj.value > max) {
		alert(name + cannotMoreThan + max);
		return false;
	}
	return true;
}