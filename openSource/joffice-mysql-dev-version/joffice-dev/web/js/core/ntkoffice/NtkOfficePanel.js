NtkOfficePanel=function(h){var g=false;h.doctype=h.doctype?h.doctype:"doc";var e=h.fileId?h.fileId:"";var c=h.usetemplate?h.usetemplate:0;var b=h.deftemplatekey?h.deftemplatekey:"";var i=document.createElement("object");var d=document.createElement("param");d.setAttribute("name","Caption");d.setAttribute("value","广州宏天软件有限公司在线Office文档");i.appendChild(d);d=document.createElement("param");d.setAttribute("name","MakerCaption");d.setAttribute("value","广州宏天软件有限公司");i.appendChild(d);d=document.createElement("param");d.setAttribute("name","MakerKey");d.setAttribute("value","4FEB21F0AE739C7004A114D9B689C9BF5DC465B4");i.appendChild(d);d=document.createElement("param");d.setAttribute("name","ProductCaption");d.setAttribute("value","广州宏天软件有限公司");i.appendChild(d);d=document.createElement("param");d.setAttribute("name","TitlebarColor");d.setAttribute("value","14402205");i.appendChild(d);d=document.createElement("param");d.setAttribute("name","ProductKey");d.setAttribute("value","E48B828D3049F90D44E801C202224CAEF84423A3");i.appendChild(d);i.width="100%";i.height="100%";i.classid="clsid:A39F1330-3322-4a1d-9BF0-0BA2BB90E970";i.codebase=__ctxPath+"/js/core/ntkoffice/OfficeControl.cab#version=5,0,1,0";var f={border:false,layout:"fit"};var k=function(m){e=m.fileId?m.fileId:"";var o=m.docName?m.docName:"未命名";i.IsUseUTF8URL=true;i.IsUseUTF8Data=true;var l=i.SaveToURL(__fullPath+"/file-upload","uploadDocument","fileId="+e+"&&file_cat=uploadDocument",o+"."+h.doctype,0);var n=Ext.util.JSON.decode(l);if(n&&n.success){e=n.fileId;}else{n={success:false};}return n;};if(h.unshowMenuBar){i.Menubar=false;i.IsShowEditMenu=false;i.FileNew=false;i.FileOpen=false;i.FileSave=false;i.FileSaveAs=false;}if(h.showToolbar){var j=[];if(h.doctype=="doc"){j.push({text:"保留修改痕迹",iconCls:"btn-archive-save-trace",handler:function(){if(g){i.ActiveDocument.Application.UserName=curUserInfo.fullname;i.ActiveDocument.TrackRevisions=true;}}});j.push("-");}if(h.doctype=="doc"){j.push({text:"取消保留痕迹",iconCls:"btn-archive-cancel-trace",handler:function(){if(g){i.ActiveDocument.TrackRevisions=false;}}});j.push("-");}if(h.doctype=="doc"){j.push({text:"清除痕迹",iconCls:"btn-archive-eraser",handler:function(){if(g){i.ActiveDocument.AcceptAllRevisions();}}});j.push("-");}if(h.doctype=="doc"){j.push({text:"模板套红",iconCls:"",scope:this,handler:function(){if(g){new PaintTemplateSelector({callback:function(l,o){this.close();if(o!=""){var m=__ctxPath+"/attachFiles/"+o;if(i.doctype!=1){return;}try{i.ActiveDocument.Application.Selection.HomeKey(6,0);i.addtemplatefromurl(m);}catch(n){}}}}).show();}}});j.push("-");}if(e==null||e==""){j.push({text:"选择Office模板",scope:this,handler:function(){new PaintTemplateSelector({callback:function(l,o){this.close();if(o!=""){var m=__ctxPath+"/attachFiles/"+o;if(i.doctype!=1){return;}try{i.ActiveDocument.Application.Selection.HomeKey(6,0);i.OpenFromURL(m);}catch(n){alert("err:"+n);}}}}).show();}});}if(h.doctype=="doc"||h.doctype=="xls"){j.push({text:"手写签名",iconCls:"",scope:this,handler:function(){if(g){try{i.DoHandSign2("ntko","ntko",0,0,1,100);}catch(l){}}}});j.push("-");}if(h.doctype=="doc"||h.doctype=="xls"){j.push({text:"盖章",iconCls:"",scope:this,handler:function(){new SealSelector({callback:function(o,p,n){this.close();if(p!=""){var l=__ctxPath+"/attachFiles/"+p;if(i.doctype==1||i.doctype==2){try{i.AddSecSignFromURL(curUserInfo.fullname,l,0,0,"ntko",1,100,1);}catch(m){}}}}}).show();}});j.push("-");}f.tbar=new Ext.Toolbar({items:j});}Ext.applyIf(f,h);var a=new Ext.Panel(f);a.on("afterrender",function(){a.body.appendChild(i);if(e){i.OpenFromURL(__ctxPath+"/file-download?fileId="+e);g=true;}else{if(c==1&&b!=""){Ext.Ajax.request({url:__ctxPath+"/document/getByKeyPaintTemplate.do",params:{method:"post",templateKey:b},success:function(o,p){var n=Ext.decode(o.responseText);if(n.data){var q=__ctxPath+"/attachFiles/"+n.data.path;i.OpenFromURL(q);g=true;}else{i.CreateNew(l);g=true;}}});}else{var l="";switch(h.doctype){case"doc":l="Word.Document";fileTypeSimple="wrod";break;case"xls":l="Excel.Sheet";fileTypeSimple="excel";break;case"ppt":l="PowerPoint.Show";fileTypeSimple="ppt";break;case 4:l="Visio.Drawing";break;case 5:l="MSProject.Project";break;case 6:l="WPS Doc";break;case 7:l="Kingsoft Sheet";break;default:l="Word.Document";}try{i.CreateNew(l);g=true;}catch(m){}}}a.doLayout();});return{panel:a,officeObj:i,openDoc:function(l){e=l;i.OpenFromURL(__ctxPath+"/file-download?fileId="+e);},setReadOnly:function(){i.SetReadOnly(true,"");},openDoc2:function(m,l){m=m;try{i.OpenFromURL(__ctxPath+"/attachFiles/"+l);g=true;}catch(n){g=false;}},saveDoc:function(l){return k(l);},closeDoc:function(){g=false;i.Close();}};};