DocumentForm=Ext.extend(Ext.Window,{formPanel:null,constructor:function(a){Ext.applyIf(this,a);this.initUI();DocumentForm.superclass.constructor.call(this,{id:"DocumentFormWin",title:"文档详细信息",iconCls:"menu-personal-doc",width:700,height:500,modal:true,maximizable:true,layout:"fit",items:this.formPanel,buttonAlign:"center",buttons:this.buttons});},initUI:function(){var a=__ctxPath+"/document/listDocFolder.do?method=1";var b=new TreeSelector("folderSelect",a,"文件夹*","folderId");this.formPanel=new HT.FormPanel({url:__ctxPath+"/document/saveDocument.do",id:"DocumentForm",formId:"DocumentFormId",defaults:{anchor:"98%,98%",margins:{top:4,right:4,bottom:4,left:4}},items:[{name:"folderId",id:"DocumentForm.folderId",xtype:"hidden"},{name:"document.docId",xtype:"hidden",value:this.docId==null?"":this.docId},b,{xtype:"textfield",fieldLabel:"文档名称",name:"document.docName",anchor:"98%",allowBlank:false},{height:280,anchor:"98%",xtype:"fckeditor",fieldLabel:"内容",name:"document.content",allowBlank:false},{xtype:"hidden",name:"document.docType",value:"文档"},{xtype:"container",layout:"column",border:false,defaults:{border:false},items:[{columnWidth:0.7,layout:"form",border:false,items:[{fieldLabel:"附件",xtype:"panel",id:"personFilePanel",frame:false,border:true,bodyStyle:"padding:4px 4px 4px 4px",height:80,autoScroll:true,html:""}]},{columnWidth:0.3,items:[{border:false,xtype:"button",text:"添加附件",iconCls:"menu-attachment",handler:function(){var c=App.createUploadDialog({file_cat:"document/privateDocument",callback:function(g){var d=Ext.getCmp("DocumentForm.fileIds");var f=Ext.getCmp("personFilePanel");for(var e=0;e<g.length;e++){if(d.getValue()!=""){d.setValue(d.getValue()+",");}d.setValue(d.getValue()+g[e].fileId);Ext.DomHelper.append(f.body,'<span><a href="#" onclick="FileAttachDetail.show('+g[e].fileId+')">'+g[e].fileName+'</a> <img class="img-delete" src="'+__ctxPath+'/images/system/delete.gif" onclick="removeFile(this,'+g[e].fileId+')"/>&nbsp;|&nbsp;</span>');}}});c.show(this);}},{xtype:"button",text:"清除附件",iconCls:"reset",handler:function(){var d=Ext.getCmp("DocumentForm.fileIds");var c=Ext.getCmp("personFilePanel");c.body.update("");d.setValue("");}},{xtype:"hidden",id:"DocumentForm.fileIds",name:"fileIds"}]}]}]});if(this.folderId!=null&&this.folderId!=undefined&&this.folderName!=null&&this.folderName!=undefined){Ext.getCmp("DocumentForm.folderId").setValue(this.folderId);Ext.getCmp("folderSelect").setValue(this.folderName);}if(this.docId!=null&&this.docId!="undefined"){this.formPanel.loadData({url:__ctxPath+"/document/getDocument.do?docId="+this.docId,waitMsg:"正在载入数据...",preName:"document",root:"data",success:function(e,l){var h=Ext.util.JSON.decode(e.responseText).data;var c=h.docFolder.folderId;var d=h.docFolder.folderName;Ext.getCmp("DocumentForm.folderId").setValue(c);Ext.getCmp("folderSelect").setValue(d);var j=h.attachFiles;var g=Ext.getCmp("personFilePanel");var k=Ext.getCmp("DocumentForm.fileIds");for(var f=0;f<j.length;f++){if(k.getValue()!=""){k.setValue(k.getValue()+",");}k.setValue(k.getValue()+j[f].fileId);Ext.DomHelper.append(g.body,'<span><a href="#" onclick="FileAttachDetail.show('+j[f].fileId+')">'+j[f].fileName+'</a><img class="img-delete" src="'+__ctxPath+'/images/system/delete.gif" onclick="removeFile(this,'+j[f].fileId+')"/>&nbsp;|&nbsp;</span>');}},failure:function(c,d){Ext.MessageBox.show({title:"操作信息",msg:"载入信息失败，请联系管理员！",buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});}});}this.buttons=[{xtype:"button",text:"保存",iconCls:"btn-save",handler:this.saveRecord,scope:this},{xtype:"button",text:"关闭",iconCls:"btn-cancel",scope:this,handler:function(){this.close();}},{text:"测试",handler:function(){window.open(__ctxPath+"/js/fileupload/jq.jsp");}}];},saveRecord:function(){var a=this.formPanel;var c=this;var b=Ext.getCmp("folderSelect").getValue();if(b!=null&&b!=""&&b!="undefined"){if(a.getForm().isValid()){a.getForm().submit({method:"post",waitMsg:"正在提交数据...",success:function(e,g){Ext.ux.Toast.msg("操作信息","成功信息保存！");var f=Ext.getCmp("DocumentGrid");if(f!=null&&f!=undefined){f.getStore().reload();}var d=Ext.getCmp("PrivateDocumentView");if(d!=null){d.dataView.getStore().reload();}c.close();},failure:function(d,e){Ext.MessageBox.show({title:"操作信息",msg:"信息保存出错，请联系管理员！",buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});c.close();}});}}else{Ext.MessageBox.show({title:"操作信息",msg:"请选择文件夹！",buttons:Ext.MessageBox.OK,icon:"ext-mb-error"});}}});function removeFile(e,a){var b=Ext.getCmp("DocumentForm.fileIds");var d=b.getValue();if(d.indexOf(",")<0){b.setValue("");}else{d=d.replace(","+a,"").replace(a+",","");b.setValue(d);}var c=Ext.get(e.parentNode);c.remove();}