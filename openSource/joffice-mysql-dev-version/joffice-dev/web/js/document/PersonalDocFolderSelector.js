var PersonalDocFolderSelector={getView:function(e){var b;var a=function(f){if(f!=null){if(!f.disabled){b=f;return b;}}};var d=new Ext.tree.TreePanel({id:"docFolderTreePanel",title:"目录列表 ",loader:new Ext.tree.TreeLoader({url:__ctxPath+"/document/listDocFolder.do"}),root:new Ext.tree.AsyncTreeNode({expanded:true}),rootVisible:false,listeners:{"click":a}});var c=new Ext.Window({title:"请选择目录",iconCls:"menu-mail_folder",width:440,height:420,layout:"fit",items:[d],modal:true,buttonAlign:"center",buttons:[{text:"确认",iconCls:"btn-ok",scope:"true",handler:function(){if(b!=null){if(e!=null){e.call(this,b.id,b.text);}c.close();}else{Ext.ux.Toast.msg("提示","你无权插文档入该目录！");}}},{text:"关闭",iconCls:"btn-cancel",handler:function(){c.close();}}]});return c;}};