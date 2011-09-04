ArchFlowConfView=Ext.extend(Ext.Panel,{formPanel:null,gridPanel:null,store:null,topbar:null,constructor:function(a){Ext.applyIf(this,a);this.initUIComponents();ArchFlowConfView.superclass.constructor.call(this,{id:"ArchFlowConfView",title:"公文流程配置",iconCls:"menu-archive-setting",region:"center",layout:"form",items:[this.formPanel]});},initUIComponents:function(){this.formPanel=new Ext.FormPanel({layout:"form",bodyStyle:"padding:10px 10px 10px 10px",border:false,url:__ctxPath+"/archive/saveArchFlowConf.do",id:"ArchFlowConfForm",defaults:{anchor:"98%,98%"},defaultType:"textfield",items:[{xtype:"fieldset",title:"公文流程配置",items:[{xtype:"container",layout:"column",items:[{xtype:"label",text:"发文流程:",width:101},{xtype:"textfield",name:"sendProcessName",id:"sendProcessName",width:200},{xtype:"hidden",name:"sendProcessId",id:"sendProcessId"},{xtype:"button",iconCls:"menu-flow",text:"选择流程",handler:this.settingFlow.createCallback(this,"send")}]},{xtype:"container",style:"padding-top:3px;",layout:"column",items:[{xtype:"label",text:"收文流程:",width:101},{xtype:"textfield",name:"recProcessName",id:"recProcessName",width:200},{xtype:"hidden",name:"recProcessId",id:"recProcessId"},{xtype:"button",text:"选择流程",iconCls:"menu-flow",handler:this.settingFlow.createCallback(this,"rec")}]}]}]});Ext.Ajax.request({url:__ctxPath+"/archive/getArchFlowConf.do",success:function(a,b){var c=Ext.util.JSON.decode(a.responseText).data;Ext.getCmp("sendProcessId").setValue(c.sendProcessId);Ext.getCmp("sendProcessName").setValue(c.sendProcessName);Ext.getCmp("recProcessId").setValue(c.recProcessId);Ext.getCmp("recProcessName").setValue(c.recProcessName);}});},settingFlow:function(b,a){FlowSelector.getView(function(d,c){if(a=="send"){b.getCmpByName("sendProcessId").setValue(d);b.getCmpByName("sendProcessName").setValue(c);}else{b.getCmpByName("recProcessId").setValue(d);b.getCmpByName("recProcessName").setValue(c);}Ext.Ajax.request({url:__ctxPath+"/archive/settingArchFlowConf.do",method:"POST",params:{defId:d,settingType:a},success:function(e,f){Ext.ux.Toast.msg("操作信息","公文设置成功.");}});},true).show();}});