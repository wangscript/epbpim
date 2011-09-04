ProInstanceMgr=Ext.extend(Ext.Panel,{constructor:function(a){Ext.applyIf(this,a);this.initUIComponents();ProInstanceMgr.superclass.constructor.call(this,{id:"ProInstanceMgr",iconCls:"menu-instance",title:"流程实例管理",region:"center",layout:"border",items:[this.searchPanel,this.gridPanel]});},initUIComponents:function(){this.searchPanel=new HT.SearchPanel({layout:"form",region:"north",colNums:3,items:[{fieldLabel:"流程名称",name:"proDefinition.name",flex:1,xtype:"textfield"}],buttons:[{text:"查询",scope:this,iconCls:"btn-search",handler:this.search},{text:"重置",scope:this,iconCls:"btn-reset",handler:this.reset}]});this.topbar=new Ext.Toolbar({items:[{iconCls:"btn-refresh",text:"刷新",xtype:"button",scope:this,handler:this.refreshRs},{iconCls:"btn-detail",text:"查看",xtype:"button",scope:this,handler:this.detailRsM}]});this.gridPanel=new HT.GridPanel({region:"center",tbar:this.topbar,rowActions:true,url:__ctxPath+"/flow/inListProDefinition.do",fields:[{name:"defId",type:"int"},"typeName","name","subTotal","createtime","deployId","status"],columns:[{header:"defId",dataIndex:"defId",hidden:true},{header:"分类名称",dataIndex:"typeName",renderer:function(a){if(a!=null&&a!=""){return a;}else{return"<font color='red'>未定义</font>";}}},{header:"流程名称",dataIndex:"name"},{header:"正在运行的实例数目",dataIndex:"subTotal",renderer:function(a){return'<font color="red">'+a+"</font>";}},{header:"创建时间",dataIndex:"createtime"},new Ext.ux.grid.RowActions({header:"管理",width:32,fixed:true,resizable:false,actions:[{iconCls:"btn-detail",qtip:"查看",style:"margin:0 3px 0 3px"}],listeners:{scope:this,"action":this.onRowAction}})]});this.gridPanel.addListener("rowdblclick",this.rowClick);},reset:function(){this.searchPanel.getForm().reset();},search:function(){$search({searchPanel:this.searchPanel,gridPanel:this.gridPanel});},rowClick:function(b,a,c){b.getSelectionModel().each(function(e){var d=e.data.defId;var g=e.data.name;var h=App.getContentPanel();var f=h.getItem("ProcessRunList"+d);if(f==null){f=new ProInstanceView({id:"ProcessRunList"+d,defId:d,flowName:g});h.add(f);}h.activate(f);});},refreshRs:function(){this.gridPanel.getStore().reload();},detailRsM:function(){var a=this.gridPanel.getSelectionModel().getSelections();if(a.length==0){Ext.ux.Toast.msg("操作信息","请选择记录！");return;}if(a.length>1){Ext.ux.Toast.msg("操作信息","只能选择一条记录！");return;}this.detailRs(a[0]);},detailRs:function(b){var a=b.data.defId;var d=b.data.name;var e=App.getContentPanel();var c=e.getItem("ProcessRunList"+a);if(c==null){c=new ProInstanceView({id:"ProcessRunList"+a,defId:a,flowName:d});e.add(c);}e.activate(c);},onRowAction:function(c,a,d,e,b){switch(d){case"btn-detail":this.detailRs.call(this,a);break;default:break;}}});