Ext.ns("DutySystemView");var DutySystemView=function(){return new Ext.Panel({id:"DutySystemView",title:"班制定义列表",iconCls:"menu-dutySystem",layout:"border",region:"center",autoScroll:true,items:[new Ext.FormPanel({id:"DutySystemSearchForm",region:"north",height:40,frame:false,border:false,layout:"hbox",layoutConfig:{padding:"5",align:"middle"},defaults:{xtype:"label",margins:{top:0,right:4,bottom:4,left:4}},items:[{text:"请输入查询条件:"},{text:"班制名称"},{xtype:"textfield",name:"Q_systemName_S_LK"},{text:"班次"},{xtype:"textfield",name:"Q_systemSetting_S_LK"},{text:"班次描述"},{xtype:"textfield",name:"Q_systemDesc_S_LK"},{xtype:"button",text:"查询",iconCls:"search",handler:function(){var a=Ext.getCmp("DutySystemSearchForm");var b=Ext.getCmp("DutySystemGrid");if(a.getForm().isValid()){$search({searchPanel:a,gridPanel:b});}}}]}),this.setup()]});};DutySystemView.prototype.setup=function(){return this.grid();};DutySystemView.prototype.grid=function(){var d=new Ext.grid.CheckboxSelectionModel();var a=new Ext.grid.ColumnModel({columns:[d,new Ext.grid.RowNumberer(),{header:"systemId",dataIndex:"systemId",hidden:true},{header:"班制名称",width:100,dataIndex:"systemName"},{header:"班次描述",dataIndex:"systemDesc",width:500},{header:"缺省",dataIndex:"isDefault",renderer:function(e){if(e==1){return"是";}else{return"否";}}},{header:"管理",dataIndex:"systemId",width:100,sortable:false,renderer:function(h,g,e,k,f){var j=e.data.systemId;var i="";if(isGranted("_DutySystemDel")){i='<button title="删除" value=" " class="btn-del" onclick="DutySystemView.remove('+j+')">&nbsp;&nbsp;</button>';}if(isGranted("_DutySystemEdit")){i+='&nbsp;<button title="编辑" value=" " class="btn-edit" onclick="DutySystemView.edit('+j+')">&nbsp;&nbsp;</button>';}return i;}}],defaults:{sortable:true,menuDisabled:false,width:100}});var b=this.store();b.load({params:{start:0,limit:25}});var c=new Ext.grid.GridPanel({id:"DutySystemGrid",tbar:this.topbar(),store:b,trackMouseOver:true,disableSelection:false,loadMask:true,region:"center",cm:a,sm:d,viewConfig:{forceFit:true,enableRowBody:false,showPreview:false},bbar:new HT.PagingBar({store:b})});c.addListener("rowdblclick",function(g,f,h){g.getSelectionModel().each(function(e){if(isGranted("_DutySystemEdit")){DutySystemView.edit(e.data.systemId);}});});return c;};DutySystemView.prototype.store=function(){var a=new Ext.data.Store({proxy:new Ext.data.HttpProxy({url:__ctxPath+"/personal/listDutySystem.do"}),reader:new Ext.data.JsonReader({root:"result",totalProperty:"totalCounts",id:"id",fields:[{name:"systemId",type:"int"},"systemName","systemSetting","systemDesc","isDefault"]}),remoteSort:true});a.setDefaultSort("systemId","desc");return a;};DutySystemView.prototype.topbar=function(){var a=new Ext.Toolbar({id:"DutySystemFootBar",height:30,bodyStyle:"text-align:left",items:[]});if(isGranted("_DutySystemAdd")){a.add(new Ext.Button({iconCls:"btn-add",text:"添加班制定义",handler:function(){new DutySystemForm();}}));}if(isGranted("_DutySystemDel")){a.add(new Ext.Button({iconCls:"btn-del",text:"删除班制定义",handler:function(){var d=Ext.getCmp("DutySystemGrid");var b=d.getSelectionModel().getSelections();if(b.length==0){Ext.ux.Toast.msg("信息","请选择要删除的记录！");return;}var e=Array();for(var c=0;c<b.length;c++){e.push(b[c].data.systemId);}DutySystemView.remove(e);}}));}return a;};DutySystemView.remove=function(b){var a=Ext.getCmp("DutySystemGrid");Ext.Msg.confirm("信息确认","您确认要删除该记录吗？",function(c){if(c=="yes"){Ext.Ajax.request({url:__ctxPath+"/personal/multiDelDutySystem.do",params:{ids:b},method:"post",success:function(){Ext.ux.Toast.msg("信息提示","成功删除所选记录！");a.getStore().reload({params:{start:0,limit:25}});}});}});};DutySystemView.edit=function(a){new DutySystemForm(a);};