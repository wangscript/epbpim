DocFolderSharedForm=Ext.extend(Ext.Window,{formPanel:null,constructor:function(a){Ext.applyIf(this,a);this.initUI();DocFolderSharedForm.superclass.constructor.call(this,{title:"文件夹授权",iconCls:"menu-public-fol",width:620,height:420,modal:true,layout:"fit",scope:this,buttonAlign:"center",items:this.formPanel,buttons:this.buttons});},initUI:function(){this.formPanel=new Ext.FormPanel({items:[{xtype:"hidden",name:"privilegeId"},{xtype:"hidden",name:"folderId",value:this.folderId},{xtype:"fieldset",border:false,layout:"column",items:[{xtype:"label",text:"共享人员",width:100},{xtype:"hidden",name:"userIds",id:"userIds"},{xtype:"textarea",name:"userNames",id:"userNames",width:300},{xtype:"button",text:"选择",iconCls:"btn-select",width:80,handler:function(){UserSelector.getView(function(b,d){var a=Ext.getCmp("userIds");var e=Ext.getCmp("userNames");if(a.getValue()==""){a.setValue(b);e.setValue(d);return;}var f=a.getValue().split(",");var c=e.getValue().split(",");a.setValue(uniqueArray(f.concat(b.split(","))));e.setValue(uniqueArray(c.concat(d.split(","))));}).show();}},{xtype:"button",iconCls:"btn-clear",text:"清空",handler:function(){var a=Ext.getCmp("userIds");var b=Ext.getCmp("userNames");a.setValue("");b.setValue("");},width:80}]},{xtype:"fieldset",border:false,layout:"column",items:[{xtype:"label",text:"共享部门",width:100},{name:"depIds",id:"depIds",xtype:"hidden"},{name:"depNames",id:"depNames",xtype:"textarea",width:300},{xtype:"button",text:"选择",iconCls:"btn-select",width:80,handler:function(){DepSelector.getView(function(c,e){var b=Ext.getCmp("depIds");var d=Ext.getCmp("depNames");if(b.getValue()==""){b.setValue(c);d.setValue(e);return;}var f=b.getValue().split(",");var a=d.getValue().split(",");b.setValue(uniqueArray(f.concat(c.split(","))));d.setValue(uniqueArray(a.concat(e.split(","))));}).show();}},{xtype:"button",text:"清空",iconCls:"btn-clear",handler:function(){var a=Ext.getCmp("depIds");var b=Ext.getCmp("depNames");a.setValue("");b.setValue("");},width:80}]},{xtype:"fieldset",border:false,layout:"column",items:[{xtype:"label",text:"共享角色",width:100},{xtype:"hidden",id:"roleIds",name:"roleIds"},{name:"roleNames",id:"roleNames",xtype:"textarea",width:300},{xtype:"button",text:"选择",iconCls:"btn-select",width:80,handler:function(){RoleSelector.getView(function(d,e){var a=Ext.getCmp("roleIds");var b=Ext.getCmp("roleNames");if(a.getValue()==""){a.setValue(d);b.setValue(e);return;}var f=a.getValue().split(",");var c=b.getValue().split(",");a.setValue(uniqueArray(f.concat(d.split(","))));b.setValue(uniqueArray(c.concat(e.split(","))));}).show();}},{xtype:"button",text:"清空",iconCls:"btn-clear",handler:function(){var a=Ext.getCmp("roleIds");var b=Ext.getCmp("roleNames");a.setValue("");b.setValue("");},width:80}]},{xtype:"fieldset",border:false,layout:"column",items:[{xtype:"label",text:"权限选择：",width:100},{xtype:"checkbox",name:"rightR",id:"rightR"},{xtype:"label",text:"可读",width:60},{xtype:"checkbox",name:"rightU",id:"rightU",listeners:{"check":function(){var b=Ext.getCmp("rightU");var a=Ext.getCmp("rightD");var c=Ext.getCmp("rightR");if(b.getValue()){c.setValue(true);c.disable();}else{if(!a.getValue()){c.enable();}}}}},{xtype:"label",text:"可修改",width:60},{xtype:"checkbox",name:"rightD",id:"rightD",listeners:{"check":function(){var a=Ext.getCmp("rightD");var b=Ext.getCmp("rightU");var c=Ext.getCmp("rightR");if(a.getValue()){c.setValue(true);c.disable();}else{if(!b.getValue()){c.enable();}}}}},{xtype:"label",text:"可删除",width:60}]}]});this.buttons=[{xtype:"button",text:"共享",scope:this,iconCls:"btn-ok",handler:function(){var e=this;var g=Ext.getCmp("userIds").getValue();var d=Ext.getCmp("depIds").getValue();var f=Ext.getCmp("roleIds").getValue();var c=Ext.getCmp("rightR").getValue();if(g!=""||d!=""||f!=""){if(c==true){var a=Ext.getCmp("rightR");a.enable();var b=this.grid;this.formPanel.getForm().submit({url:__ctxPath+"/document/addDocPrivilege.do",method:"post",waitMsg:"正在提交...",success:function(h,i){Ext.ux.Toast.msg("提示","保存成功！");b.getStore().reload();e.close();},failure:function(h,i){Ext.ux.Toast.msg("出错","请与管理员联系！");}});}else{Ext.ux.Toast.msg("提示","读权限为基本权限！");}}else{Ext.ux.Toast.msg("提示","请选择！");}}},{xtype:"button",iconCls:"btn-cancel",text:"关闭",scope:this,handler:function(){this.close();}}];}});