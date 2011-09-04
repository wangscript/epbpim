ProcessRunStart=Ext.extend(Ext.Panel,{constructor:function(a){this.useTemplate=false;this.assignTasks=new Array();this.assignUserIds=new Array();Ext.applyIf(this,a);this.buttonsArr=[{text:"提交并启动流程",iconCls:"btn-ok",scope:this,handler:this.saveAndStart},"-",{xtype:"checkbox",boxLabel:"发送邮件",scope:this,handler:function(b,c){if(c){this.sendMail=true;}else{this.sendMail=false;}}},{xtype:"checkbox",boxLabel:"发送短信",scope:this,handler:function(b,c){if(c){this.sendMsg=true;}else{this.sendMsg=false;}}},"-",{text:"流程示意图",iconCls:"btn-flow-chart",scope:this,handler:this.showFlowImage}];this.userJumpPanel=new Ext.form.FieldSet({title:"选择执行人",collapsed:true,autoHeight:true,collapsed:false,collapsible:true});this.jumpPanel=new Ext.Panel({bodyStyle:"padding:16px 4px 4px 20px",autoHeight:true,layout:"form",border:false,items:[this.userJumpPanel]});Ext.Ajax.request({url:__ctxPath+"/flow/startTransProcessActivity.do",params:{defId:this.defId},scope:this,success:function(f,c){var b=Ext.decode(f.responseText);var e=[];for(var d=0;d<b.data.length;d++){e.push({boxLabel:b.data[d].destination,name:"jumpPath_"+this.defId,inputValue:b.data[d].name,destType:b.data[d].destType,destName:b.data[d].destination,checked:d==0?true:false});}this.jumpRadioGroup=new Ext.form.RadioGroup({listeners:{scope:this,"change":this.jumpRadioCheck},fieldLabel:"执行路径",items:e});this.jumpPanel.insert(0,this.jumpRadioGroup);this.jumpPanel.doLayout();this.jumpRadioCheck.call(this);}});this.formPanel=new Ext.form.FormPanel({region:"center",border:false,bodyStyle:"padding:20px",autoScroll:true,autoLoad:{url:__ctxPath+"/flow/getProcessActivity.do?defId="+this.defId,nocache:true,scope:this,callback:this.convertHtml}});ProcessRunStart.superclass.constructor.call(this,{title:"流程启动-"+this.flowName,iconCls:"btn-flow-start",autoScroll:true,layout:"form",id:"ProcessRunStart"+this.defId,tbar:new Ext.Toolbar({height:26,items:this.buttonsArr}),layoutConfig:{padding:"5",pack:"center",align:"middle"},defaults:{margins:"0 5 10 0"},items:[this.jumpPanel,this.formPanel]});},jumpRadioCheck:function(){var a=this.jumpRadioGroup.getValue();this.getTaskUsers.call(this,a.destName,a.destType);},getTaskUsers:function(a,b){if("decision"==b||"fork"==b){this.userJumpPanel.removeAll();this.userJumpPanel.show();this.genForkDecUserAssign.call(this,a);}else{if(b.indexOf("end")!=-1){this.userJumpPanel.removeAll();this.userJumpPanel.hide();}else{this.userJumpPanel.removeAll();this.userJumpPanel.show();this.userJumpPanel.add(this.getSingleUserPanel.call(this,a));}}this.jumpPanel.doLayout();},getSingleUserPanel:function(a){this.flowAssignName=new Ext.form.TextArea({width:400,height:40,name:"flowAssignName"});var b=new Ext.form.CompositeField({xtype:"compositefield",fieldLabel:"执行人",anchor:"92%,92%",items:[this.flowAssignName,{xtype:"button",scope:this,text:"...",iconCls:"btn-users",handler:function(){var c=this.flowUserFieldPanel;UserSelector.getView({callback:function(e,d){this.flowAssignName.setValue(d);this.assignTasks=[a];this.assignUserIds=[e];},scope:this}).show();}}]});Ext.Ajax.request({url:__ctxPath+"/flow/usersProcessActivity.do",scope:this,params:{defId:this.defId,activityName:a},success:function(d,e){var c=Ext.decode(d.responseText);this.flowAssignName.setValue(c.userNames);this.assignTasks=[a];this.assignUserIds=[c.userIds];}});return b;},genForkDecUserAssign:function(a){Ext.Ajax.request({url:__ctxPath+"/flow/outerTransProcessActivity.do",params:{defId:this.defId,nodeName:a},scope:this,success:function(e,b){var d=Ext.decode(e.responseText);for(var c=0;c<d.length;c++){this.userJumpPanel.add(this.genUserFieldSel.call(this,d[c],c));}this.userJumpPanel.doLayout();}});},genUserFieldSel:function(d,b){var c=d[1];this.assignTasks[b]=c;this.assignUserIds[b]=d[3];var a=new Ext.form.TextArea({allowBlank:false,width:400,height:40,value:d[4]});var e=new Ext.form.CompositeField({border:false,fieldLabel:c,items:[a,{xtype:"button",text:"...",iconCls:"btn-users",scope:this,handler:function(){UserSelector.getView({scope:this,callback:function(f,j){a.setValue(j);var g=this.assignTasks.length;for(var h=g-1;h>=0;h--){if(this.assignTasks[h]==c){g=h;break;}}this.assignTasks[g]=c;this.assignUserIds[g]=f;}}).show();}}]});return e;},getFlowAssignId:function(){var a="";var d="";var c="";for(var b=0;b<this.assignTasks.length;b++){if(b>0){d+=":";c+=":";}d+=this.assignTasks[b];c+=this.assignUserIds[b];}if(d!=""){a=d+"|"+c;}return a;},convertHtml:function(){var formExt=document.getElementById("formExt"+this.defId);if(formExt!=null){this.useTemplate=true;var valExt=formExt.value;valExt=valExt.replace("Ext.form.FormPanel","Ext.Panel");this.formExtPanel=eval("new ("+valExt+")("+this.vmParams+");");this.formPanel.add(this.formExtPanel);this.formPanel.doLayout();return;}this.formPanel.doLayout();try{var json=document.getElementById("rightsdef_"+this.defId);if(json!=null){var callback=function(){var rightsJson=Ext.decode(json.value);$converDetail.call(this,null,rightsJson);};$ImportSimpleJs([__ctxPath+"/js/core/ntkoffice/NtkOfficePanel.js",__ctxPath+"/js/selector/SealSelector.js",__ctxPath+"/js/selector/PaintTemplateSelector.js"],callback,this);}}catch(e){}},saveAndStart:function(){var v=true;if(this.formExtPanel!=null&&this.formExtPanel.validate){v=this.formExtPanel.validate.call(this.formExtPanel,this);}else{v=$validForm.call(this);}if(!v){return;}var B=this.jumpRadioGroup.getValue().destName;var l=this.getFlowAssignId.call(this);var h=this.formPanel;var o="";var k=document.getElementById("defParams"+this.defId);if(k){o=k.value;}var p={useTemplate:this.useTemplate,defId:this.defId,startFlow:true,destName:B,sendMsg:this.sendMsg,sendMail:this.sendMail,flowAssignId:l,flowVars:"{"+o+"}"};if(this.detailGrids){var g=this.detailGrids.keys;for(var w=0;w<g.length;w++){var A=[];var s=this.detailGrids.get(g[w]);var m=s.getStore();for(var x=0;x<m.getCount();x++){var b=m.getAt(x);var D=HT.encode(b.data);A.push(D);}p[g[w]+"details"]=Ext.encode(A);}}var f=this.officePanel;if(f){var r=null;if(this.fileId!=""&&this.fileId!=undefined){r=f.saveDoc({docName:"ProcessDocument",fileId:this.fileId,doctype:"doc"});}else{r=f.saveDoc({docName:"ProcessDocument",doctype:"doc"});}if(r&&r.success){var F=r.fileId;this.hiddenF.setValue(F);}}var y=h.getForm().getEl().dom;var e=y.getElementsByTagName("form");var t=[];var q=new Ext.util.MixedCollection();for(var x=0;x<e.length;x++){var c=e[x].getAttribute("belongName");var G=e[x].getAttribute("pkName");var z=e[x].getAttribute("pkValue");var C=Ext.Ajax.serializeForm(e[x]);var u=Ext.urlDecode(C);if(G&&z){u[G]=z;}var E=HT.encode(u);var a=q.get(c);if(!a){var A=[];A.push(E);q.add(c,A);}else{a.push(E);}}for(var x=0;x<q.keys.length;x++){var n=q.keys[x];p[n+"details"]=Ext.encode(q.get(n));}if(h.getForm().isValid()){h.getForm().submit({url:__ctxPath+"/flow/saveProcessActivity.do",waitMsg:"正在提交流程表单信息...",scope:this,params:p,success:function(d,i){Ext.ux.Toast.msg("操作信息","成功保存信息！");if(f){f.closeDoc();}AppUtil.removeTab(this.getId());}});}},reset:function(){this.formPanel.getForm().reset();},showFlowImage:function(){var a=new Ext.Window({autoScroll:true,iconCls:"btn-flow-chart",bodyStyle:"background-color:white",maximizable:true,title:"流程示意图",width:600,height:500,modal:true,html:'<img src="'+__ctxPath+"/jbpmImage?defId="+this.defId+"&rand="+Math.random()+'"/>'});a.show();}});