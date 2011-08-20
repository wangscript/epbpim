function validate(frm){  
    var textValidate=frm.getElementsByTagName("textValidate");  
    for(var i=0;i<textValidate.length;i++){  
        var isValidate=textValidate[i].getAttribute("isValidate");  
        if(isValidate=="false") {  
            continue;  
        }  
        var lable=textValidate[i].getAttribute("lableText");  
        var min=textValidate[i].getAttribute("min");  
        var max=textValidate[i].getAttribute("max");  
        var maxValue = textValidate[i].getAttribute("maxValue");  
        var datatype=textValidate[i].getAttribute("dataType");  
        var alt=textValidate[i].getAttribute("altText");  
        var field=document.getElementsByName(textValidate[i].getAttribute("field"))[0]; 
        if(min && min == 0 && field.value.length == min){  
            if(alt && alt.length>0){  
                alert(alt);  
            }else{  
            	alert(lable+"不能为空"); 
            }  
            if(field.select)field.select();  
            field.focus();  
            return false;  
        } 
        if(min && min.length>0 && field.value.length<min){  
            if(alt && alt.length>0){  
                alert(alt);  
            }else{  
                alert(lable+"不能小于"+min+"位！");  
            }  
            if(field.select)field.select();  
            field.focus();  
            return false;  
        }  
        if(max && max.length>0 && field.value.replace(/[^x00-xff]/g,"aa").length>max){  
            if(alt && alt.length>0){  
                alert(alt);  
            }else{  
                alert(lable+"不能大于"+max+"位！");  
            }  
            if(field.select)field.select();  
            field.focus();  
            return false;  
        }  
        if(datatype && datatype.length>0){  
            if(datatype=="int"){  
                if(!/^[0-9]+$/g.test(field.value)){  
                    if(field.select)field.select();  
                    field.focus();  
                    if(alt && alt.length>0){  
                        alert(alt);  
                    }else{  
                        alert(lable+"只能输入整数！");  
                    }  
                    return false;  
                }
                if(maxValue && field.value > maxValue){
                	  field.focus();  
                      if(alt && alt.length>0){  
                          alert(alt);  
                      }else{  
                    	  alert(lable+"只能小于等于" + maxValue +"！");  
                      }  
                	 return false;  
                }
            }else if(datatype=="account"){  
                if(!/^[a-zA-Z0-9_]+$/g.test(field.value)){  
                    if(field.select)field.select();  
                    field.focus();  
                    if(alt && alt.length>0){  
                        alert(alt);  
                    }else{  
                        alert(lable+"只能是数字，字母和下划线！");  
                    }  
                    return false;  
                }  
            }else if(datatype=="phone"){  
                if(!/^d{3}-d{8}|d{4}-d{7}$/g.test(field.value)){  
                    if(field.select)field.select();  
                    field.focus();  
                    if(alt && alt.length>0){  
                        alert(alt);  
                    }else{  
                        alert("电话号码格式不正确，正确格式：0511-4405222 或 021-87888822");  
                    }  
                    return false;  
                }  
            }else if(datatype=="postcode"){  
                if(!/^[1-9]d{5}(?!d)$/g.test(field.value)){  
                    if(field.select)field.select();  
                    field.focus();  
                    if(alt && alt.length>0){  
                        alert(alt);  
                    }else{  
                        alert("邮政编码不正确");  
                    }  
                    return false;  
                }  
            }else if(datatype=="code"){  
                if(!/^d{15}|d{18}$/g.test(field.value)){  
                    if(field.select)field.select();  
                    field.focus();  
                    if(alt && alt.length>0){  
                        alert(alt);  
                    }else{  
                        alert("身份证号码不正确");  
                    }  
                    return false;  
                }  
            }else{  
                if(!new RegExp(datatype,"g").test(field.value)){  
                    if(field.select)field.select();  
                    field.focus();  
                    if(alt && alt.length>0){  
                        alert(alt);  
                    }else{  
                        alert(lable+"输入格式不正确！");  
                    }  
                    return false;  
                }  
            }  
        }  
    }  
    var radioValidate=frm.getElementsByTagName("radioValidate");  
    for(var i=0;i<radioValidate.length;i++){  
        var isValidate=radioValidate[i].getAttribute("isValidate");  
        if(isValidate=="false") {  
            continue;  
        }  
        var lable=radioValidate[i].getAttribute("lableText");  
        var alt=textValidate[i].getAttribute("altText");  
        var field=document.getElementsByName(radioValidate[i].getAttribute("field"));  
        var flag=true;  
        for(var j=0;j<field.length;j++){  
            if(field[j].checked){  
                flag=false;  
                break;  
            }  
        }  
        if(flag){  
            if(alt && alt.length>0){  
                alert(alt);  
            }else{  
                alert(lable+"为必选项！");  
            }  
            return false;  
        }  
    }  
    var selectValidate=frm.getElementsByTagName("selectValidate");  
    for(var i=0;i<selectValidate.length;i++){  
        var isValidate=selectValidate[i].getAttribute("isValidate");  
        if(isValidate=="false") {  
            continue;  
        }  
        var lable=selectValidate[i].getAttribute("lableText");  
        var alt=textValidate[i].getAttribute("altText");  
        var noValue=selectValidate[i].getAttribute("noValue");  
        var field=document.getElementsByName(selectValidate[i].getAttribute("field"))[0];  
        if(field.value==noValue){  
            if(alt && alt.length>0){  
                alert(alt);  
            }else{  
                alert(lable+"为必选项！");  
            }  
            return false;  
        }  
    }  
    return true;  
}  





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