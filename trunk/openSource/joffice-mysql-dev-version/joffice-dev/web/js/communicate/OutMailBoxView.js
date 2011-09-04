Ext.ns("OutMailFolder");var OutMailBoxView=function(){var f;var i=new OutMailView();var d=new Ext.tree.TreePanel({id:"leftOutMailBoxTree",border:false,region:"center",split:true,layout:"fit",tbar:new Ext.Toolbar({items:[{xtype:"button",iconCls:"btn-refresh",text:"刷新",handler:function(){d.root.reload();}},{xtype:"button",text:"展开",iconCls:"btn-expand",handler:function(){d.expandAll();}},{xtype:"button",text:"收起",iconCls:"btn-collapse",handler:function(){d.collapseAll();}}]}),loader:new Ext.tree.TreeLoader({url:__ctxPath+"/communicate/listOutMailFolder_.do"}),root:new Ext.tree.AsyncTreeNode({expanded:true}),rootVisible:false,listeners:{"click":function(p){if(p!=null){i.setFolderId(p.id);var o=Ext.getCmp("OutMailCenterView");var m=Ext.getCmp("OutMailView");m.folderId=p.id;Ext.getCmp("OutMailSearchForm").getForm().findField("Q_outMailFolder.folderId_L_EQ").setValue(p.id);var n=Ext.getCmp("ShowOutMailDetail");if(n!=null){o.remove("ShowOutMailDetail");m.show();o.doLayout();}if(p.id!=0){Ext.getCmp("OutMailView").setTitle("["+p.text+"]");var q=Ext.getCmp("OutMailGrid");var l=q.getStore();l.url=__ctxPath+"/communicate/listOutMail_.do";l.baseParams={folderId:p.id};l.reload({params:{start:0,limit:25}});}}}}});function c(l,m){f=new Ext.tree.TreeNode({id:l.id,text:l.text});g.showAt(m.getXY());}d.on("contextmenu",c,d);var g=new Ext.menu.Menu({id:"OutMailFolderTreeMenu",items:[{text:"新建目录",scope:this,iconCls:"btn-add",handler:k},{text:"修改目录",scope:this,iconCls:"btn-edit",handler:h},{text:"删除目录",scope:this,iconCls:"btn-delete",handler:e}]});function k(l){var m=f.id;new OutMailFolderForm(null,m);}function h(){var l=f.id;if(l>4){new OutMailFolderForm(l);}}function e(){var l=f.id;if(l>4){Ext.Ajax.request({url:__ctxPath+"/communicate/countOutMailFolder_.do",params:{folderId:l},method:"post",success:function(m,o){var n=Ext.util.JSON.decode(m.responseText);if(n.count==0){Ext.Ajax.request({url:__ctxPath+"/communicate/removeOutMailFolder_.do",params:{folderId:l},method:"post",success:function(p,q){Ext.ux.Toast.msg("操作信息","成功删除目录！");d.root.reload();},failure:function(p,q){Ext.MessageBox.show({title:"操作信息",msg:"信息保存出错，请联系管理员！",buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});}});}else{Ext.Msg.confirm("警告信息","该文件夹及其子目录下还有"+n.count+"封邮件,确定要删除吗?",function(p){if(p=="yes"){Ext.Ajax.request({url:__ctxPath+"/communicate/removeOutMailFolder_.do",params:{folderId:l,count:n.count},method:"post",success:function(q,r){Ext.ux.Toast.msg("操作信息","成功删除目录！");d.root.reload();},failure:function(q,r){Ext.MessageBox.show({title:"操作信息",msg:"信息保存出错，请联系管理员！",buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});}});}});}},failure:function(m,n){Ext.MessageBox.show({title:"操作信息",msg:"信息保存出错，请联系管理员！",buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});}});}}var b=new Ext.Panel({collapsible:true,region:"west",layout:"border",title:"外部邮箱目录",width:160,autoScroll:false,split:true,items:[new Ext.Container({region:"north",layout:"table",height:23,layoutConfig:{columns:2},items:[new Ext.Button({width:78,text:"收邮件",iconCls:"btn-mail_receive",handler:function(){Ext.MessageBox.show({msg:"邮件收取中，请稍后...",width:300,wait:true,progress:true,closable:true,waitConfig:{interval:200},icon:Ext.Msg.INFO});Ext.Ajax.request({url:__ctxPath+"/communicate/fetchOutMail_.do?sid="+new Date(),timeout:12000000,success:function(m,n){Ext.MessageBox.hide();i.setFolderId(1);Ext.getCmp("OutMailView").setTitle("[收件箱]");var o=Ext.getCmp("OutMailGrid");var l=o.getStore();l.url=__ctxPath+"/communicate/listOutMail_.do";l.baseParams={folderId:1,isFetch:"Y"};l.reload({params:{start:0,limit:25}});},failure:function(l,m){Ext.MessageBox.updateText("邮件收取出错!!!...");Ext.MessageBox.hide();}});}}),new Ext.Button({width:79,text:"发邮件",iconCls:"btn-mail_send",handler:function(){var m=Ext.getCmp("centerTabPanel");var l=Ext.getCmp("OutMailForm");if(l==null){l=new OutMailForm("","","");m.add(l);m.activate(l);}else{m.remove(l);l=new OutMailForm("","","");m.add(l);m.activate(l);}}})]}),d]});var j=new Ext.Panel({id:"OutMailCenterView",region:"center",autoScroll:true,layout:"fit",items:[i.getView()]});var a=new Ext.Panel({title:"外部邮箱",iconCls:"menu-mail_box",layout:"border",id:"OutMailBoxView",autoScroll:false,items:[b,j]});return a;};