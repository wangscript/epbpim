var ProcessRunDetail=function(d,a,c,b){this.runId=d;this.defId=a;this.piId=c;this.name=b;return this.setup();};ProcessRunDetail.prototype.setup=function(){var d=this.piId;var a=this.defId;var c=new Ext.Panel({title:"流程示意图",width:500,autoScroll:true,height:800,split:true,collapsible:true,region:"west",margin:"5 5 5 5",html:'<img src="'+__ctxPath+"/jbpmImage?piId="+d+"&defId="+a+"&runId="+this.runId+"&rand="+Math.random()+'"/>'});var e=this.getRightPanel(this.piId,this.runId,this.defId);var f=new Ext.Toolbar({height:28,items:[{text:"刷新",iconCls:"btn-refresh",handler:function(){c.body.update('<img src="'+__ctxPath+"/jbpmImage?piId="+d+"&defId="+a+"&rand="+Math.random()+'"/>');e.doLayout(true);}},"-",{text:"打印表单",id:"formTablePrintButton",iconCls:"btn-print",scope:this,handler:function(){var g=this.formPanel.body;var i=g.dom.innerHTML;var h=window.open("","newwindow");h.document.write("<HEAD>");h.document.write("<TITLE>打印表单</TITLE>");h.document.write('<link rel="stylesheet" type="text/css" href="'+__ctxPath+'/css/admin.css"/>');h.document.write("</HEAD>");h.document.write("<BODY BGCOLOR=#ffffff>");h.document.write(i);h.document.write("</BODY>");h.document.write("</HTML>");h.document.close();}}]});var b=new Ext.Panel({id:"ProcessRunDetail"+this.runId,title:"流程详细－"+this.name,iconCls:"menu-flowEnd",layout:"border",tbar:f,autoScroll:true,items:[c,e]});return b;};ProcessRunDetail.prototype.getFormHtmlCallback=function(){var l=document.getElementById("entity_"+this.runId);var g=Ext.getCmp("formTablePrintButton");if(!l||(l!=null&&!l.value)){this.formPanel.hide();g.hide();return;}else{this.formPanel.show();g.show();}this.formPanel.doLayout();var d=this.formPanel;var b=this.formPanel.getForm().getEl().dom;var c=b.elements||(document.forms[b]||Ext.getDom(b)).elements;try{var a,i,j,f;var k=function(){var e=null;if(l!=null&&l.value){e=Ext.decode(l.value);}$converDetailToRead.call(this,e);};$ImportSimpleJs([__ctxPath+"/js/core/ntkoffice/NtkOfficePanel.js",__ctxPath+"/js/selector/SealSelector.js",__ctxPath+"/js/selector/PaintTemplateSelector.js"],k,this);}catch(h){}};ProcessRunDetail.prototype.getRightPanel=function(d,c,a){this.formPanel=new Ext.FormPanel({title:"流程表单信息",width:400,autoScroll:true,height:300,autoLoad:{url:__ctxPath+"/flow/getFormProcessActivity.do",nocache:true,params:{piId:d,runId:c,defId:a},scope:this,callback:this.getFormHtmlCallback}});var b=new Ext.Panel({title:"流程审批信息",region:"center",width:400,autoScroll:true,autoLoad:{url:__ctxPath+"/flow/processRunDetail.do?piId="+d+"&runId="+c,nocache:true}});var e=new Ext.Panel({region:"center",width:400,autoScroll:true,border:false,layout:"form",defaults:{anchor:"100% 100%"},items:[this.formPanel,b]});return e;};