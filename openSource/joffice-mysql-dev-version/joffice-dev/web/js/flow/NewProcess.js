var NewProcess=function(){return this.getView();};NewProcess.prototype.getView=function(){var d;var b=new ProDefinitionView(false);var c=new Ext.Panel({layout:"fit",region:"west",collapsible:true,split:true,width:200,title:"流程分类树",items:[new htsoft.ux.TreePanelEditor({id:"FlowProTypeTree",border:false,autoScroll:true,url:__ctxPath+"/system/flowTreeGlobalType.do?catKey=FLOW",onclick:function(f){b.setTypeId(f.id);var e=Ext.getCmp("ProDefinitionGrid0");e.getStore().proxy.conn.url=__ctxPath+"/flow/listProDefinition.do?typeId="+f.id;e.getStore().load({params:{start:0,limit:25}});}})]});var a=new Ext.Panel({title:"新建流程",layout:"border",iconCls:"menu-flowNew",id:"NewProcess",height:800,items:[c,b.getView()]});return a;};