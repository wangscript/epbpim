<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="noindex, nofollow" name="robots">
<script src="../../../editor/dialog/common/fck_dialog_common.js"
	type="text/javascript"></script>
<%
	String basePath=request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/ext3/ux/css/ux-all.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/admin.css"/>
<title>Department Properties</title>
<script type="text/javascript"><!--

var dialog	= window.parent ;
var oEditor	= dialog.InnerDialogLoaded() ;

// Gets the document DOM
var oDOM = oEditor.FCK.EditorDocument ;
var oActiveEl = dialog.Selection.GetSelectedElement() ;

window.onload = function()
{    
	// First of all, translate the dialog box texts
	oEditor.FCKLanguageManager.TranslatePage(document) ;
   
	if ( oActiveEl && oActiveEl.tagName.toUpperCase() == "BUTTON" )
	{ 
		GetE('valueIdField').value=oActiveEl.getAttribute('valueIdField');
		GetE('valueNameField').value=oActiveEl.getAttribute('valueNameField');
		var isSingle=oActiveEl.getAttribute('isSingle');
		if('true'==isSingle){
			GetE('isSingle').checked=true;
	    }
		//GetE('txtName').value	= oActiveEl.name ;
		GetE('txtValue').value	= oActiveEl.value ;
	}
	else
		oActiveEl = null ;

	dialog.SetOkButton( true ) ;
	dialog.SetAutoSize( true ) ;
	SelectField( 'valueIdField' ) ;
};

function Ok()
{
	oEditor.FCKUndo.SaveUndoStep() ;

    

    var checked=GetE('isSingle').checked;
	
	oActiveEl = CreateNamedElement( oEditor, oActiveEl, 'BUTTON', {
		//name: GetE('txtName').value, 
		type: 'button',
		style:'margin-left:5px;margin-right:5px;margin-top:5px;width:auto;height:25px;background:pray;FONT-SIZE: 12px; CURSOR: hand; COLOR: black;BORDER: pray 1px solid;padding-top:2px;',
		onClick:'DepSelector.getView('+
			'function(id,name){'+
				'var nameEl=document.getElementsByName("'+GetE("valueNameField").value+'");'+
			    'if(nameEl&&nameEl[0]){nameEl[0].value=name;}'+
			    'var idsEl=document.getElementsByName("'+GetE("valueIdField").value+'");if(idsEl&&idsEl[0]){idsEl[0].value=id;}},'+checked+').show();',
		department:'true',
		isSingle:checked,
		valueIdField:GetE('valueIdField').value,
		valueNameField:GetE('valueNameField').value
	}) ;

	oActiveEl.innerHTML=GetE('txtValue').value;
	//oActiveEl.innerHTML='<span class="btn-users001" style="padding-left:20px;height:23px;">'+GetE('txtValue').value+'</span>';
	SetAttribute( oActiveEl, 'value', GetE('txtValue').value ) ;

	return true ;
}
</script>
</head>
<body style="overflow: hidden">
	<table width="100%" style="height: 100%">
		<tr>
			<td align="center">
				<table border="0" cellpadding="0" cellspacing="0" width="80%">
				    <tr>
						<td colspan="">
							<span fcklang="valueIdField">Id</span><br />
							<input type="text" size="20" id="valueIdField" style="width: 100%" />
						</td>
					</tr>
					<tr>
						<td colspan="">
							<span fcklang="valueNameField">Name</span><br />
							<input type="text" size="20" id="valueNameField" style="width: 100%" />
						</td>
					</tr>
					<tr>
						<td colspan="">
							<span fcklang="ButtonValue">Value</span><br />
							<input type="text" size="20" id="txtValue" style="width: 100%" />
						</td>
					</tr>
					<tr>
						<td>
							<span fcklang="isSingle">Type</span><br />
							<input type="checkbox" id="isSingle" style="float:left;"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>