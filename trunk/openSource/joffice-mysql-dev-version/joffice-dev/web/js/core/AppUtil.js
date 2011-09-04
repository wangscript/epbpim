Ext.ns("App");Ext.ns("AppUtil");var jsCache=new Array();function strToDom(a){if(window.ActiveXObject){var b=new ActiveXObject("Microsoft.XMLDOM");b.async="false";b.loadXML(a);return b;}else{if(document.implementation&&document.implementation.createDocument){var c=new DOMParser();var b=c.parseFromString(a,"text/xml");return b;}}}function newView(viewName,params){var str="new "+viewName;if(params!=null){str+="(params);";}else{str+="();";}return eval(str);}function $ImportJs(viewName,callback,params){var b=jsCache[viewName];if(b!=null){var view=newView(viewName,params);callback.call(this,view);}else{var jsArr=eval("App.importJs."+viewName);if(jsArr==undefined||jsArr.length==0){try{var view=newView(viewName,params);callback.call(this,view);}catch(e){}return;}ScriptMgr.load({scripts:jsArr,callback:function(){jsCache[viewName]=0;var view=newView(viewName,params);callback.call(this,view);}});}}function $ImportSimpleJs(a,c,b){ScriptMgr.load({scripts:a,scope:b,callback:function(){if(c){c.call(this);}}});}function $parseDate(b){if(typeof b=="string"){var a=b.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) *$/);if(a&&a.length>3){return new Date(parseInt(a[1]),parseInt(a[2])-1,parseInt(a[3]));}a=b.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2}) *$/);if(a&&a.length>6){return new Date(parseInt(a[1]),parseInt(a[2])-1,parseInt(a[3]),parseInt(a[4]),parseInt(a[5]),parseInt(a[6]));}a=b.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2})\.(\d{1,9}) *$/);if(a&&a.length>7){return new Date(parseInt(a[1]),parseInt(a[2])-1,parseInt(a[3]),parseInt(a[4]),parseInt(a[5]),parseInt(a[6]),parseInt(a[7]));}}return null;}function $formatDate(b){if(typeof b=="string"){b=parseDate(b);}if(b instanceof Date){var k=b.getFullYear();var a=b.getMonth()+1;var j=b.getDate();var g=b.getHours();var e=b.getMinutes();var f=b.getSeconds();var c=b.getMilliseconds();if(a<10){a="0"+a;}if(j<10){j="0"+j;}if(g<10){g="0"+g;}if(e<10){e="0"+e;}if(f<10){f="0"+f;}if(c>0){return k+"-"+a+"-"+j+" "+g+":"+e+":"+f+"."+c;}if(g>0||e>0||f>0){return k+"-"+a+"-"+j+" "+g+":"+e+":"+f;}return k+"-"+a+"-"+j;}return"";}function $convertTableToMap(r){if(r.rows.length!=2){return[];}var l=[];var p=r.rows[0];var o=r.rows[1];for(var g=0;g<p.cells.length;g++){var b={};var q=o.cells[g];var f;for(var e=0;e<q.childNodes.length;e++){if(q.childNodes[e].getAttribute&&q.childNodes[e].getAttribute("name")){f=q.childNodes[e];break;}}var a=f.getAttribute("name");var k=p.cells[g].innerHTML;var c=f.getAttribute("xtype");var n=f.getAttribute("dateformat");var d=f.getAttribute("txtitemname");var m=f.getAttribute("txtisnotnull");var h=f.getAttribute("issingle");b.name=a;b.header=k;b.xtype=c;if(n){b.format=n;}if(d){b.itemsName=d;}if(h){b.issingle=h;}b.isnotnull=m;l.push(b);}return l;}function $getTableInputCmpName(h){var f=[];for(var e=0;e<h.rows.length;e++){var l=h.rows[e];for(var c=0;c<l.cells.length;c++){var g=l.cells[c];var d;for(var b=0;b<g.childNodes.length;b++){if(g.childNodes[b].getAttribute&&g.childNodes[b].getAttribute("name")){d=g.childNodes[b];if(d){var a=d.getAttribute("name");f.push(a);}}}}}return f;}App.getContentPanel=function(){var a=Ext.getCmp("centerTabPanel");return a;};App.createUploadDialog=function(b){var a={file_cat:"others",url:__ctxPath+"/file-upload",reset_on_hide:false,upload_autostart:false,modal:true};Ext.apply(a,b);var c=new FileUploadManager(a);return c;};App.createUploadDialog2=function(b){var a={file_cat:"others",url:__ctxPath+"/file-upload",reset_on_hide:false,upload_autostart:false,modal:true};Ext.apply(a,b);var c=new Ext.ux.UploadDialog.Dialog(a);return c;};function uniqueArray(e){e=e||[];var b={};for(var d=0;d<e.length;d++){var c=e[d];if(typeof(b[c])=="undefined"){b[c]=1;}}e.length=0;for(var d in b){e[e.length]=d;}return e;}function setCookie(b,d,a,f,c,e){document.cookie=b+"="+escape(d)+((a)?"; expires="+a.toGMTString():"")+((f)?"; path="+f:"")+((c)?"; domain="+c:"")+((e)?"; secure":"");}function getCookie(b){var d=b+"=";var e=document.cookie.indexOf(d);if(e==-1){return null;}var a=document.cookie.indexOf(";",e+d.length);if(a==-1){a=document.cookie.length;}var c=document.cookie.substring(e+d.length,a);return unescape(c);}function deleteCookie(a,c,b){if(getCookie(a)){document.cookie=a+"="+((c)?"; path="+c:"")+((b)?"; domain="+b:"")+"; expires=Thu, 01-Jan-70 00:00:01 GMT";}}String.prototype.trim=function(){return(this.replace(/^[\s\xA0]+/,"").replace(/[\s\xA0]+$/,""));};function $request(a){Ext.Ajax.request({url:a.url,params:a.params,method:a.method==null?"POST":a.method,success:function(b,c){if(a.success!=null){a.success.call(this,b,c);}},failure:function(b,c){Ext.ux.Toast.msg("操作信息","操作出错，请联系管理员！");if(a.success!=null){a.failure.call(this,b,c);}}});}function asynReq(){var a=Ext.Ajax.getConnectionObject().conn;a.open("GET",url,false);a.send(null);}AppUtil.removeTab=function(a){var b=App.getContentPanel();var c=b.getItem(a);if(c!=null){b.remove(c,true);}};AppUtil.activateTab=function(a){var b=App.getContentPanel();b.activate(a);};function $converCmp(c,n,j,l,o){var m="on";var f=this.formPanel;var a=new Ext.util.MixedCollection();var b=new Array();var d=[];Ext.each(c,function(t,x){var R,u,J,v,G;var N=null;if(!t){return;}R=t.name;u=t.type;if(j&&j[R]){N=j[R];}if(u=="button"||u=="hidden"){return;}if(t.style.display=="none"){return;}v=t.getAttribute("xtype");if(n&&n[R]){if(u=="radio"||u=="checkbox"){var J=n[R];if(t.value){var s=t.value+"|",q=J+"|";var O=q.indexOf(s)>-1;if(t.value==J||O){t.checked=true;}else{t.checked=false;}}return;}t.value=n[R];}var A=t.parentNode;var I=t.getAttribute("width");var z=t.getAttribute("txtisnotnull");if(!I){I=A.offsetWidth;}if(I<300&&A.offsetWidth>300){I=300;}if(o||(N&&(N==0||N==1)&&(v!="officeeditor"||(v=="officeeditor"&&N==0)))){m="un";t.style.display="none";var H=document.createElement("span");H.setAttribute("style","width:"+I+"px;");var B="";if(N==0&&!o){B='<font color="red">无权限</font>';}else{if(t.value){B=t.value;}else{B="";}}H.innerHTML=B;A.appendChild(H);return;}if(v=="datefield"){var L=t.getAttribute("dateformat");var w=t.getAttribute("txtistoday");var K=document.createElement("div");var D={parentNode:A,oldEl:t,newEl:K};d.push(D);var F=document.createElement("div");F.setAttribute("style","width:"+I+"px");K.appendChild(F);try{var C;if(L=="yyyy-MM-dd HH:mm:ss"){C=new Cls.form.DateTimeField({name:R,width:200,autoWidth:false,boxMaxWidth:200,format:"Y-m-d H:i:s",value:w==1?new Date():"",allowBlank:z==1?false:true});}else{C=new Ext.form.DateField({name:R,height:21,width:100,boxMaxWidth:100,autoWidth:false,format:"Y-m-d",value:w==1?new Date():"",allowBlank:z==1?false:true});}b.push("datefield"+x);a.add("datefield"+x,K);a.add("datefield"+x+"-cmp",C);if(t.value){C.setValue($parseDate(t.value));}}catch(M){}}else{if(v=="diccombo"){try{var E=t.getAttribute("txtitemname");var K=document.createElement("span");var D={parentNode:A,oldEl:t,newEl:K};d.push(D);var F=document.createElement("div");K.appendChild(F);var C=new DicCombo({name:R,itemName:E,displayField:"itemName",valueField:"itemName",width:I,allowBlank:z==1?false:true});b.push("diccombo"+x);a.add("diccombo"+x,K);a.add("diccombo"+x+"-cmp",C);if(t.value){C.setValue(t.value);}}catch(M){}}else{if(v=="fckeditor"){G=A.offsetHeight;var K=document.createElement("div");var D={parentNode:A,oldEl:t,newEl:K};d.push(D);var F=document.createElement("div");K.appendChild(F);var C=new Ext.ux.form.FCKeditor({name:R,height:G,allowBlank:false});b.push("fckeditor"+x);a.add("fckeditor"+x,K);a.add("fckeditor"+x+"-cmp",C);if(t.value){C.setValue(t.value);}}else{if(v=="officeeditor"){try{var K=document.createElement("div");G=A.offsetHeight;this.hiddenF=new Ext.form.Hidden({name:R});this.hiddenF.render(K);var D={parentNode:A,oldEl:t,newEl:K};d.push(D);var Q=t.getAttribute("usetemplate");var g=t.getAttribute("deftemplatekey");Ext.useShims=true;var C={isOfficePanel:true,right:N,showToolbar:N==1?false:true,width:I,height:G,fileId:t.value,doctype:"doc",usetemplate:Q,deftemplatekey:g,unshowMenuBar:false};b.push("officeeditor"+x);a.add("officeeditor"+x,K);a.add("officeeditor"+x+"-cmp",C);if(t.value){this.hiddenF.setValue(t.value);this.fileId=t.value;}}catch(M){}}else{if(v=="userselector"){try{var K=document.createElement("div");var r=new Ext.form.Hidden({value:curUserInfo.userId,name:R+"ids"});r.render(K);var D={parentNode:A,oldEl:t,newEl:K};d.push(D);var y=t.getAttribute("issingle");var P=new Ext.form.TextField({name:R,height:21,readOnly:true,value:curUserInfo.fullname,allowBlank:z==1?false:true,width:I?(I-90>0?I-90:I):I});if(y==0){P=new Ext.form.TextArea({name:R,readOnly:true,allowBlank:z==1?false:true,value:curUserInfo.fullname,width:I?(I-90>0?I-90:I):I});}var C=new Ext.form.CompositeField({width:I,items:[P,{xtype:"button",width:78,border:false,text:"选择人员",iconCls:"btn-sel",handler:function(){UserSelector.getView(function(e,p){P.setValue(p);},y==1?true:false).show();}}]});b.push("userselector"+x);a.add("userselector"+x,K);a.add("userselector"+x+"-cmp",C);if(t.value){P.setValue(t.value);}}catch(M){}}else{if(v=="depselector"){try{var K=document.createElement("div");var r=new Ext.form.Hidden({value:curUserInfo.depId,name:R+"ids"});r.render(K);var D={parentNode:A,oldEl:t,newEl:K};d.push(D);var y=t.getAttribute("issingle");var P=new Ext.form.TextField({name:R,readOnly:true,value:curUserInfo.depName,height:21,allowBlank:z==1?false:true,width:I?(I-90>0?I-90:I):I});if(y==0){P=new Ext.form.TextArea({name:R,readOnly:true,value:curUserInfo.depName,allowBlank:z==1?false:true,width:I?(I-90>0?I-90:I):I});}var C=new Ext.form.CompositeField({width:I,items:[P,{xtype:"button",border:false,width:78,text:"选择部门",iconCls:"btn-users",handler:function(){DepSelector.getView(function(e,p){P.setValue(p);},y==1?true:false).show();}}]});b.push("depselector"+x);a.add("depselector"+x,K);a.add("depselector"+x+"-cmp",C);if(t.value){P.setValue(t.value);}}catch(M){}}else{if(v=="fileattach"){try{var K=document.createElement("div");var r=new Ext.form.Hidden({name:R});r.render(K);var D={parentNode:A,oldEl:t,newEl:K};d.push(D);var P=new Ext.Panel({width:I?(I-90>0?I-90:I):I,height:60,autoScroll:true,html:""});var C=new Ext.form.CompositeField({width:I,items:[P,{xtype:"button",width:78,text:"选择附件",iconCls:"menu-attachment",handler:function(){var e=App.createUploadDialog({file_cat:"flow",callback:function(S){for(var p=0;p<S.length;p++){if(r.getValue()!=""){r.setValue(r.getValue()+",");}r.setValue(r.getValue()+S[p].fileId+"|"+S[p].fileName);Ext.DomHelper.append(P.body,'<span><a href="#" onclick="FileAttachDetail.show('+S[p].fileId+')">'+S[p].fileName+'</a> <img class="img-delete" src="'+__ctxPath+'/images/system/delete.gif" onclick="AppUtil.removeFile(this,'+S[p].fileId+')"/>&nbsp;|&nbsp;</span>');}}});e.show(this);}}]});b.push("fileattach"+x);a.add("fileattach"+x,K);a.add("fileattach"+x+"-cmp",C);AppUtil.removeFile=function(U,e,V){var p=r;var T=p.getValue();if(T.indexOf(",")<0){p.setValue("");}else{T=T.replace(","+e+"|"+V,"").replace(e+"|"+V+",","");p.setValue(T);}var S=Ext.get(U.parentNode);S.remove();};C.on("render",function(){if(t.value){r.setValue(t.value);var S=t.value.split(",");for(var U=0;U<S.length;U++){var T=S[U];var p=T.split("|");var e=p[0];var V=p[1];Ext.DomHelper.append(P.body,'<span><a href="#" onclick="FileAttachDetail.show('+e+')">'+V+'</a> <img class="img-delete" src="'+__ctxPath+'/images/system/delete.gif" onclick="AppUtil.removeFile(this,'+e+",'"+V+"')\"/>&nbsp;|&nbsp;</span>");}}},this);}catch(M){}}}}}}}}t.onblur=function(){$validField.call(this,t);};},this);for(var i=0;i<d.length;i++){var h=d[i];try{h.parentNode.replaceChild(h.newEl,h.oldEl);}catch(k){alert(k);}}if(b.length>0&&a.length>0){Ext.each(b,function(p,g){var t=a.get(p+"-cmp");var s=a.get(p);if(t.isOfficePanel){var v=new NtkOfficePanel(t);if(t.right==1){v.setReadOnly();}v.panel.render(s);this.officePanel=v;}else{try{var r=document.createElement("div");var q=document.createElement("div");r.appendChild(q);t.render(q);s.appendChild(r);if(l!=true){f.add(t);}}catch(u){alert(u);}}},this);}return m;}function $converDetail(x,B){var D=this.formPanel.getForm().getEl().dom;var J=D.getElementsByTagName("table");this.detailGrids=new Ext.util.MixedCollection();var E=[];var m=[];this.formValidCmp=new Array();for(var K=0;K<J.length;K++){var q=J[K].getAttribute("isdetail");var r=J[K].getAttribute("isgrid");var n=J[K].getAttribute("txtname");if(q!=null&&"true"==r){var h=J[K].parentNode;var t=$convertTableToMap(J[K]);var b=[];var j=[];if(this.taskId){var z=document.getElementById("WF_"+n+"_"+this.taskId);var y=z.value;b.push(y);j.push({dataIndex:y,header:y,hidden:true});}var A=0;for(var M=0;M<t.length;M++){var I=null;if(B&&B[t[M].name]){I=B[t[M].name];}if(I!=0){if(t[M].xtype!="datefield"){b.push(t[M].name);}if(I==1){A--;if(t[M].xtype=="datefield"){b.push({type:"date",name:t[M].name,dateFormat:t[M].format=="yyyy-MM-dd"?"Y-m-d":"Y-m-d H:i:s"});j.push({dataIndex:t[M].name,header:t[M].header,xtype:"datecolumn",format:t[M].format});}else{j.push({dataIndex:t[M].name,header:t[M].header});}}else{A++;var a=new Ext.form.TextField();if(t[M].xtype=="datefield"){if(t[M].format=="yyyy-MM-dd"){b.push({type:"date",name:t[M].name,dateFormat:"Y-m-d"});a=new Ext.form.DateField({format:"Y-m-d",value:new Date(),allowBlank:false});j.push({dataIndex:t[M].name,header:t[M].header,xtype:"datecolumn",format:"Y-m-d",editor:a});}else{b.push({type:"date",name:t[M].name,dateFormat:"Y-m-d H:i:s"});a=new Cls.form.DateTimeField({format:"Y-m-d H:i:s",value:new Date(),allowBlank:false});j.push({dataIndex:t[M].name,header:t[M].header,xtype:"datecolumn",format:"Y-m-d H:i:s",editor:a});}}else{if(t[M].xtype=="diccombo"){j.push({dataIndex:t[M].name,header:t[M].header,editor:new DicCombo({itemName:t[M].itemsName,isDisplayItemName:true})});}else{if(t[M].xtype=="userselector"){var s=t[M].issingle;var H=true;if(s==1){H=false;}var v=this;var k=t[M].name;var R=new Ext.form.TriggerField({triggerClass:"x-form-browse-trigger",gridName:n,isSingle:s,dataIndexName:k,onTriggerClick:function(w){var f=v.detailGrids.get(this.gridName);var i=this.dataIndexName;UserSelector.getView(function(U,V){var T=f.getStore();var e=T.getAt(f.clickRow);e.set(i,V);},this.isingle).show();f.stopEditing();}});j.push({dataIndex:t[M].name,header:t[M].header,editor:R});}else{if(t[M].xtype=="depselector"){var s=t[M].issingle;var H=true;if(s==1){H=false;}var v=this;var k=t[M].name;var l=new Ext.form.TriggerField({triggerClass:"x-form-browse-trigger",gridName:n,isSingle:s,dataIndexName:k,onTriggerClick:function(w){var f=v.detailGrids.get(this.gridName);var i=this.dataIndexName;DepSelector.getView(function(U,V){var T=f.getStore();var e=T.getAt(f.clickRow);e.set(i,V);},this.isingle).show();f.stopEditing();}});j.push({dataIndex:t[M].name,header:t[M].header,editor:l});}else{j.push({dataIndex:t[M].name,header:t[M].header,editor:a});}}}}}}else{A--;}}var L=document.createElement("div");h.appendChild(L);var G=new HT.EditorGridPanel({renderTo:L,tbar:new Ext.Toolbar({hidden:t.length==A?false:true,frame:true,items:[{text:"添加记录",iconCls:"btn-add",scope:this,gridName:n,handler:function(f){var e=this.detailGrids.get(f.gridName);var i=e.getStore().recordType;e.getStore().add(new i());}},{text:"删除记录",iconCls:"btn-del",scope:this,gridName:n,handler:function(w){var f=this.detailGrids.get(w.gridName);var e=w.gridName;var i=this.taskId;Ext.Msg.confirm("信息确认","您确认要删除所选记录吗？",function(U){if(U=="yes"){var X=null;if(i){X=document.getElementById(e+"_"+i).value;}var ac=f.getStore();var aa=f.getSelectionModel().getSelections();var T=[];var V=[];var W=document.getElementById("WF_"+e+"_"+i);var ab;if(W){ab=W.value;}for(var Z=0;Z<aa.length;Z++){if(aa[Z].data!=null){if(ab){var Y=aa[Z].data[ab];if(Y){T.push(Y);}}V.push(aa[Z]);}}if(T.length){Ext.Ajax.request({url:__ctxPath+"/flow/delItemsProcessActivity.do",params:{tableId:X,ids:T},method:"POST",success:function(ad,ae){Ext.ux.Toast.msg("操作信息","成功删除该记录！");ac.remove(V);},failure:function(ad,ae){Ext.ux.Toast.msg("操作信息","操作出错，请联系管理员！");}});}else{ac.remove(V);}}});}}]}),clicksToEdit:1,width:J[K].offsetWidth,showPaging:false,autoHeight:true,fields:b,columns:j,listeners:{"rowclick":function(i,f,w){this.clickRow=f;}}});this.detailGrids.add(n,G);if(x){var Q=x["WF_"+n+"s"];if(Q){G.getStore().loadData({result:Q});}}m.push(J[K]);}else{if(q!=null&&"false"==r){try{var N=$getTableInputCmpName(J[K]);var g;var C;if(this.taskId){var o=document.getElementById("WF_"+n+"_"+this.taskId);var S=o.value;if(x){g=x["WF_"+n+"s"];C=S;if(false&&g){var c=Q[0];var A=false;var P=c[S];for(var F=0;F<N.length;F++){if(N[F]==S){A=true;}x[N[F]]=c[N[F]];}}}}var h=J[K].parentNode;var u=h.innerHTML;var c={innerhtml:u,parentNode:h,gridName:n,elsName:N,jsonDatas:g,pkName:C,rightJson:B};E.push(c);m.push(J[K]);}catch(O){alert(O);}}}}for(var K=0;K<m.length;K++){var p=m[K];var h=p.parentNode;h.removeChild(p);}var d=D.elements||(document.forms[D]||Ext.getDom(D)).elements;$converCmp.call(this,d,x,B);$converFormDetail.call(this,E);}function $converForm(d,l){var f=d.innerhtml;var c=d.parentNode;var p=d.gridName;var g=d.rightJson;var t=document.createElement("div");c.appendChild(t);var q=d.jsonDatas;var u=d.pkName;var m=true;if(q&&u){for(var n=0;n<q.length;n++){var b=document.createElement("div");t.appendChild(b);b.setAttribute("class","tipDiv");var h=document.createElement("form");h.setAttribute("belongName",p);h.setAttribute("pkName",u);h.setAttribute("pkValue",q[n][u]);if(!l){b.appendChild($addDelButton(t,b,p,this.taskId,q[n][u]));}b.appendChild(h);var s=document.createElement("div");s.innerHTML=f;h.appendChild(s);try{var k=$converCmp.call(this,h.elements,q[n],g,true,l);if(k=="un"){m=false;}}catch(o){alert(o);}}}else{var b=document.createElement("div");t.appendChild(b);var h=document.createElement("form");h.setAttribute("belongName",p);if(!l){b.appendChild($addDelButton(t,b,p,this.taskId,null));}var s=document.createElement("div");s.innerHTML=f;h.appendChild(s);try{var k=$converCmp.call(this,h.elements,null,g,true);if(k=="un"){m=false;}else{b.appendChild(h);}}catch(o){}}if(m){var j=document.createElement("div");t.appendChild(j);var a=new Ext.Button({renderTo:j,text:"添加",tableHtml:f,gridName:p,addButtonDiv:j,parentNode:t,iconCls:"btn-add",scope:this,handler:function(r){var w=document.createElement("div");r.parentNode.insertBefore(w,r.addButtonDiv);var i=document.createElement("div");var v=document.createElement("form");v.setAttribute("belongName",p);w.appendChild(i);i.appendChild($addDelButton(w,i,p,null,null));i.appendChild(v);var e=document.createElement("div");e.innerHTML=f;v.appendChild(e);$converCmp.call(this,v.elements,null,null,true);}});}}function $converFormDetail(a,c){for(var b=0;b<a.length;b++){$converForm.call(this,a[b],c);}}function $addDelButton(c,b,a,e,d){var f=document.createElement("span");f.setAttribute("style"," float:right;height:20px;");var g=document.createElement("button");g.setAttribute("class","x-btn-text btn-del");g.setAttribute("style","float:right;");g.qtip="删除";g.owerDiv=c;g.removeDiv=b;g.gridName=a;g.taskId=e;g.pkValue=d;g.onclick=function(){try{var i=this.owerDiv;var l=this.removeDiv;var h=this.gridName;var k=this.taskId;var j=this.pkValue;Ext.Msg.confirm("信息确认","您确认要删除所选记录吗？",function(n){if(n=="yes"){if(j){var o=null;if(k){o=document.getElementById(h+"_"+k).value;}Ext.Ajax.request({url:__ctxPath+"/flow/delItemsProcessActivity.do",params:{tableId:o,ids:j},method:"POST",success:function(p,q){Ext.ux.Toast.msg("操作信息","成功删除该记录！");i.removeChild(l);},failure:function(p,q){Ext.ux.Toast.msg("操作信息","操作出错，请联系管理员！");}});}else{i.removeChild(l);}}});}catch(m){alert(m);}};f.appendChild(g);return f;}function $converDetailToRead(g){var d=this.formPanel.getForm().getEl().dom;var l=d.getElementsByTagName("table");this.detailGrids=new Ext.util.MixedCollection();var B=[];var h=[];for(var t=0;t<l.length;t++){var C=l[t].getAttribute("isdetail");var v=l[t].getAttribute("isgrid");var z=l[t].getAttribute("txtname");if(C!=null&&"true"==v){var m=l[t].parentNode;var D=$convertTableToMap(l[t]);var r=[];var c=[];if(this.runId){var w=document.getElementById("WF_"+z+"_"+this.runId);var E=w.value;r.push(E);c.push({dataIndex:E,header:E,hidden:true});}var s=0;for(var u=0;u<D.length;u++){r.push(D[u].name);c.push({dataIndex:D[u].name,header:D[u].header});}var q=document.createElement("div");m.appendChild(q);this.detailPanel=new HT.EditorGridPanel({renderTo:q,clicksToEdit:1,width:l[t].offsetWidth,showPaging:false,autoHeight:true,fields:r,columns:c});if(g){var F=g["WF_"+z+"s"];if(F){this.detailPanel.getStore().loadData({result:F});}}h.push(l[t]);}else{if(C!=null&&"false"==v){try{var p=$getTableInputCmpName(l[t]);var A;var G;if(this.runId){var k=document.getElementById("WF_"+z+"_"+this.runId);var b=k.value;if(g){A=g["WF_"+z+"s"];G=b;}}var m=l[t].parentNode;var n=m.innerHTML;var o={innerhtml:n,parentNode:m,gridName:z,elsName:p,jsonDatas:A,pkName:G,rightJson:null};B.push(o);h.push(l[t]);}catch(y){alert(y);}for(var t=0;t<h.length;t++){var x=h[t];var m=x.parentNode;m.removeChild(x);}}}}var a=d.elements||(document.forms[d]||Ext.getDom(d)).elements;var j=this.formPanel;$converCmp.call(this,a,g,null,false,true);$converFormDetail.call(this,B,true);return;Ext.each(a,function(H,K){var ab,I,S,J,O;var X=null;if(!H){return;}ab=H.name;I=H.type;if(I=="button"||I=="hidden"){return;}if(H.id=="entity_"+this.runId){return;}J=H.getAttribute("xtype");if(g&&g[ab]){H.value=g[ab];}var L=H.parentNode;var R=H.getAttribute("width");if(!R){R=L.offsetWidth;}if(R<300&&L.offsetWidth>300){R=300;}if(J=="officeeditor"){var U=document.createElement("span");O=L.offsetHeight;this.hiddenF=new Ext.form.Hidden({name:ab});this.hiddenF.render(U);try{L.replaceChild(U,H);}catch(W){alert(ab+"   error !!");}Ext.useShims=true;var M=new NtkOfficePanel({showToolbar:false,width:R,height:O,doctype:"doc",unshowMenuBar:false});M.setReadOnly();M.panel.render(U);if(H.value){this.hiddenF.setValue(H.value);M.openDoc(H.value);this.fileId=H.value;}this.officePanel=M;j.add(M);}else{if(J=="fileattach"){var U=document.createElement("span");var f=new Ext.form.Hidden({name:ab});f.render(U);try{L.replaceChild(U,H);}catch(W){alert(ab+"   error !!");}var aa=new Ext.Panel({width:R?(R-90>0?R-90:R):R,height:60,autoScroll:true,html:""});var M=new Ext.form.CompositeField({renderTo:U,width:R,items:[aa]});if(H.value){f.setValue(H.value);var Q=H.value.split(",");for(var V=0;V<Q.length;V++){var T=Q[V];var N=T.split("|");var Y=N[0];var Z=N[1];Ext.DomHelper.append(aa.body,'<span><a href="#" onclick="FileAttachDetail.show('+Y+')">'+Z+"</a>&nbsp;|&nbsp;</span>");}}}else{O=L.offsetHeight;H.style.display="none";try{var P=document.createElement("span");P.setAttribute("style","width:"+R+"px; height:"+O+"px;");P.innerHTML=H.value?H.value:"";L.appendChild(P);}catch(W){}}}},this);}function $validField(e){if(e.style.display=="none"){return true;}var l=e.getAttribute("txtisnotnull");var d=e.getAttribute("xtype");var k=e.getAttribute("txtsize");var g=e.getAttribute("dataformat");var n=true;var c;if(l==1){if(e.value==""){c="此选项为必填项";n=false;}}if(n&&k&&e.value.toString().length>k){c="此项内容不得超过"+k;n=false;}if(false&&n){var m=e.value;if(m!=""){var j=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;n=j.test(m);c="此项内容为邮件格式：XXX@XX.com";}}if(g&&n){var m=e.value;if(m!=""){var b=new RegExp(g);n=b.test(m);c="此项内容的格式不正确";}}if(d=="numberfield"&&n){var m=e.value;var a=e.getAttribute("txtvaluetype");if(m!=""){if(a=="int"||a=="bigint"||a=="smallint"){var i=/^[-\+]?\d+$/;n=i.test(m);c="此项内容应为整数";}else{var h=/^-?\d+\.?\d*$/;n=h.test(m);c="此项内容应为数字";}}}var o=" x-form-invalid";var f=e.getAttribute("class");if(!n){if(f){if(f.indexOf(o)==-1){f=f+o;}}else{f=o;}e.setAttribute("class",f);e.qtip=c;e.qclass="x-form-invalid-tip";return false;}else{if(f){e.setAttribute("class",f.replace(o,""));}e.qtip="";e.qclass="";return true;}}function $validForm(){var e=this.formPanel.getForm().getEl().dom;var d=e.elements||(document.forms[e]||Ext.getDom(e)).elements;var h=true;Ext.each(d,function(i,f){h=h&&$validField.call(this,i);});var a=e.getElementsByTagName("form");for(var c=0;c<a.length;c++){var g=a[c];var b=g.elements;Ext.each(b,function(i,f){h=h&&$validField.call(this,i);});}if(h){return true;}else{return false;}}