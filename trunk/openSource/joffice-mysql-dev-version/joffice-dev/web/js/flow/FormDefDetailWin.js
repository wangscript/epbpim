FormDefDetailWin=Ext.extend(Ext.Window,{constructor:function(a){Ext.applyIf(this,a);this.initUI();FormDefDetailWin.superclass.constructor.call(this,{layout:"border",items:this.detailForm,modal:true,height:400,iconCls:"menu-form",width:500,maximizable:true,title:"表单定义的详细信息",buttonAlign:"center",buttons:[{text:"关闭",iconCls:"btn-cancel",scope:this,handler:this.cancel}]});},initUI:function(){this.store=new Ext.data.JsonStore({fields:[{name:"tableId",type:"int"},"formDefId","tableName","tableKey","formFields"]});this.rowActions=new Ext.ux.grid.RowActions({header:"管理",width:40,actions:[{iconCls:"btn-detail",qtip:"查看表的字段",style:"margin:0 3px 0 3px"}],listeners:{scope:this,"action":this.onRowAction}});var a=new Ext.grid.ColumnModel({columns:[new Ext.grid.RowNumberer(),{header:"tableId",dataIndex:"tableId",hidden:true},{header:"表名",dataIndex:"tableName"},{header:"表KEY",dataIndex:"tableKey"},this.rowActions],defaults:{sortable:false,menuDisabled:false,width:100}});this.tableGrid=new Ext.grid.GridPanel({shim:true,trackMouseOver:true,disableSelection:false,loadMask:true,stripeRows:true,autoScroll:true,cm:a,plugins:this.rowActions,store:this.store,viewConfig:{forceFit:true,enableRowBody:false,showPreview:false}});this.detailForm=new Ext.FormPanel({layout:"form",region:"center",border:false,defaults:{padding:"5",anchor:"98%,98%"},items:[{xtype:"fieldset",title:"表单信息",layout:"form",defaultType:"displayfield",defaults:{anchor:"98%,98%"},items:[{name:"formDef.formTitle",fieldLabel:"表单名称"},{name:"formDef.formDesp",fieldLabel:"表单描述"}]},{xtype:"fieldset",anchor:"98% -100",title:"数据库表",layout:"fit",items:[this.tableGrid]}]});if(this.formDefId!=null&&this.formDefId!="undefined"){this.detailForm.loadData({url:__ctxPath+"/flow/getFormDef.do?formDefId="+this.formDefId,root:"data",preName:"formDef",scope:this,success:function(b,c){var e=Ext.util.JSON.decode(b.responseText).data;var d=e.formTables;this.store.loadData(d);}});}},cancel:function(){this.close();},detail:function(a){new TableDetailWin({tableName:a.data.tableName,tableKey:a.data.tableKey,formFields:a.data.formFields}).show();},onRowAction:function(c,a,d,e,b){switch(d){case"btn-detail":this.detail.call(this,a);break;default:break;}}});TableDetailWin=Ext.extend(Ext.Window,{constructor:function(a){Ext.applyIf(this,a);this.initUI();TableDetailWin.superclass.constructor.call(this,{layout:"fit",items:this.detailForm,modal:true,height:400,iconCls:"menu-form",width:700,maximizable:true,title:"数据库表信息",buttonAlign:"center",buttons:[{text:"关闭",iconCls:"btn-cancel",scope:this,handler:this.cancel}]});},initUI:function(){this.store=new Ext.data.JsonStore({fields:[{name:"fieldId",type:"int"},"tableId","fieldName","fieldLabel","fieldType","isRequired","fieldSize","fieldDscp","isPrimary","foreignKey","foreignTable","isList","isQuery","isFlowTitle","showFormat"],remoteSort:false});this.store.setDefaultSort("isPrimary","desc");var a=new Ext.grid.ColumnModel({columns:[new Ext.grid.RowNumberer(),{header:"fieldId",dataIndex:"fieldId",hidden:true},{header:"字段KEY",dataIndex:"fieldName"},{header:"字段标签",dataIndex:"fieldLabel"},{header:"字段长度",dataIndex:"fieldSize"},{header:"字段类型",dataIndex:"fieldType"},{header:"显示格式",dataIndex:"showFormat"},{header:"是否为节点标题",dataIndex:"isFlowTitle",xtype:"templatecolumn",tpl:new Ext.XTemplate('<p><input type="checkbox" <tpl if="isFlowTitle ==1">checked="checked"</tpl> onclick="return false;" class="x-form-checkbox x-form-field"/></p>')},{header:"是否主键",dataIndex:"isPrimary",xtype:"templatecolumn",tpl:new Ext.XTemplate('<p><input type="checkbox" <tpl if="isPrimary ==1">checked="checked"</tpl> onclick="return false;" class="x-form-checkbox x-form-field"/></p>')},{header:"是否必填",dataIndex:"isRequired",xtype:"templatecolumn",tpl:new Ext.XTemplate('<p><input type="checkbox" <tpl if="isRequired ==1">checked="checked"</tpl> onclick="return false;" class="x-form-checkbox x-form-field"/></p>')},{header:"是否显示",dataIndex:"isList",xtype:"templatecolumn",tpl:new Ext.XTemplate('<p><input type="checkbox" <tpl if="isList ==1">checked="checked"</tpl> onclick="return false;" class="x-form-checkbox x-form-field"/></p>')},{header:"是否查询",dataIndex:"isQuery",xtype:"templatecolumn",tpl:new Ext.XTemplate('<p><input type="checkbox" <tpl if="isQuery ==1">checked="checked"</tpl> onclick="return false;" class="x-form-checkbox x-form-field"/></p>')},{header:"外键字段",dataIndex:"foreignKey"},{header:"关联表",dataIndex:"foreignTable"}],defaults:{sortable:false,menuDisabled:false,width:100}});this.fieldGrid=new Ext.grid.GridPanel({flex:1,shim:true,trackMouseOver:true,disableSelection:false,loadMask:true,stripeRows:true,region:"center",cm:a,store:this.store,viewConfig:{forceFit:true,enableRowBody:false,showPreview:false}});this.detailForm=new Ext.FormPanel({layout:"form",region:"north",border:false,defaults:{padding:"5",anchor:"98%,98%"},items:[{xtype:"fieldset",title:"数据库表信息",layout:"form",defaultType:"displayfield",defaults:{anchor:"98%,98%"},items:[{name:"formTable.tableName",fieldLabel:"表名",value:this.tableName},{name:"formTable.tableKey",fieldLabel:"表KEY",value:this.tableKey}]},{xtype:"fieldset",anchor:"98% -100",title:"表字段列表",layout:"hbox",layoutConfig:{align:"stretch"},items:[this.fieldGrid]}]});if(this.formFields){this.store.loadData(this.formFields);}},cancel:function(){this.close();},detail:function(a){},onRowAction:function(c,a,d,e,b){switch(d){case"btn-detail":this.detail.call(this,a);break;default:break;}}});