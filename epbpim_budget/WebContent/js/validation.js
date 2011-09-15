//常规名称
var textValidateName = "textValidate";
var radioValidateName = "radioValidate";
var selectValidateName = "selectValidate";
var isValidateName = "isValidate";
var labelName = "labelText";
var minName = "min";
var maxName = "max";
var maxValueName = "maxValue";
var datatypeName = "dataType";
var altName = "altText";
var fieldName ="field";
var falseName = "false";
var noValueName = "noValue";

// 常规类型
var intType = "int";
var accountType = "account";
var phoneType = "phone";
var postcodeType = "postcode";
var codeType = "code";
var chineseType = "chinese";
var emailType = "email";
	

// 常规属性变量
var isValidate;
var label;
var min;
var max;
var maxValue;
var datatype;
var alt;
var field;
var noValue;

// 正则

// 提示信息
var exclamation = "！";
var char = '位！';
var cannotBeBlank = '不能为空';
var cannotLessThan = '不能少于';
var cannotMoreThan = '不能超过';
var mustLessThan = '只能小于等于';
var mustBeNumber = '只能是数字';
var mustBeAccount = '只能是数字，字母和下划线！';
var mustBePhone = "手机号码格式不正确";
var mustBePostcode = "邮政编码不正确";
var mustBeCode = "身份证号码不正确";
var mustBeOther = "输入格式不正确！";
var mustRequird = "为必选项！";
var mustBeChinese = "必须是中文！";
var mustBeEmail = "不符合邮件地址格式";

function validate(frm) {
	var textValidate = frm.getElementsByTagName(textValidateName);
	for ( var i = 0; i < textValidate.length; i++) {
		isValidate = textValidate[i].getAttribute(isValidateName);
		if (isValidate == falseName) {
			continue;
		}
		label = textValidate[i].getAttribute(labelName);
		min = textValidate[i].getAttribute(minName);
		max = textValidate[i].getAttribute(maxName);
		maxValue = textValidate[i].getAttribute(maxValueName);
		datatype = textValidate[i].getAttribute(datatypeName);
		alt = textValidate[i].getAttribute(altName);
		field = document.getElementsByName(textValidate[i]
				.getAttribute(fieldName))[0];
		if (min && min == 0 && field.value.length == min) {
			return alertAndFocus(label+cannotBeBlank);
		}
		if (min && min.length > 0 && field.value.length <= min) {
			return alertAndFocus(label+ cannotLessThan + min + char);
		}
		if (max && max.length > 0
				&& field.value.replace(/[^x00-xff]/g, "aa").length > max) {
			return alertAndFocus(label + cannotMoreThan + max + char);
		}
		if (datatype && datatype.length > 0) {
			if (datatype == intType) {
				if (!/^[0-9]+$/g.test(field.value)) {
					return alertAndFocus(label + mustBeNumber);
				}
				if (maxValue && Number(field.value) > Number(maxValue)) {
					return alertAndFocus(label + mustLessThan + maxValue + exclamation );
				}
			} else if (datatype == accountType) {
				if (!/^[a-zA-Z0-9_]+$/g.test(field.value)) {
					return alertAndFocus(label + mustBeAccount);
				}
			} else if (datatype == phoneType) {
				if (field.value.length != 11) {
					return alertAndFocus(label +mustBePhone);
				}
			} else if (datatype == postcodeType) {
				if (!/^[1-9]d{5}(?!d)$/g.test(field.value)) {
					return alertAndFocus(label +mustBePostcode);
				}
			} else if (datatype == codeType) {
				if (!/^d{15}|d{18}$/g.test(field.value)) {
					return alertAndFocus(label +mustBeCode);
				}
			} else if (datatype == chineseType) {
				if (!/^[\u4e00-\u9fa5]+$/g.test(field.value)) {
					return alertAndFocuslabel +(mustBeChinese);
				}
			} else if (datatype == emailType) {
				if (!/^([a-zA-Z0-9]|[._])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/.test(field.value)) {
					return alertAndFocus(label +mustBeEmail);
				}
			} else {
				if (!new RegExp(datatype, "g").test(field.value)) {
					return alertAndFocus(label + mustBeOther);
				}
			}
		}
	}
	var radioValidate = frm.getElementsByTagName(radioValidateName);
	for ( var i = 0; i < radioValidate.length; i++) {
		isValidate = radioValidate[i].getAttribute(isValidateName);
		if (isValidate == falseName) {
			continue;
		}
		label = radioValidate[i].getAttribute(labelName);
		alt = textValidate[i].getAttribute(altName);
		field = document.getElementsByName(radioValidate[i]
				.getAttribute(fieldName));
		flag = true;
		for ( var j = 0; j < field.length; j++) {
			if (field[j].checked) {
				flag = false;
				break;
			}
		}
		if (flag) {
			return alertAndFocus(label + mustRequird);
		}
	}
	var selectValidate = frm.getElementsByTagName(selectValidateName);
	for ( var i = 0; i < selectValidate.length; i++) {
		isValidate = selectValidate[i].getAttribute(isValidateName);
		if (isValidate == falseName) {
			continue;
		}
		label = selectValidate[i].getAttribute(labelName);
		alt = textValidate[i].getAttribute(altName);
		noValue = selectValidate[i].getAttribute(noValueName);
		field = document.getElementsByName(selectValidate[i]
				.getAttribute(fieldName))[0];
		if (field.value == noValue) {
			return alertAndFocus(label + mustRequird);
		}
	}
	return true;
}

function alertAndFocus(alertContent){
	if (alt && alt.length > 0) {
		alert(alt);
	} else {
		alert(alertContent);
	}
	if (field.select){
		field.select();
	}
	field.focus();
	return false;
}
