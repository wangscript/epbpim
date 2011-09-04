DaiKaiConferenceView=Ext.extend(Ext.Panel,{searchPanel:null,gridPanel:null,store:null,topbar:null,constructor:function(a){Ext.applyIf(this,a);this.initUIComponents();DaiKaiConferenceView.superclass.constructor.call(this,{id:"DaiKaiConferenceView",title:"待开会议查询",iconCls:"menu-conference_daikai",region:"center",layout:"border",items:[this.searchPanel,this.gridPanel]});},initUIComponents:function(){this.searchPanel=new Ext.FormPanel({layout:"form",region:"north",width:"100%",height:80,keys:{key:Ext.EventObject.ENTER,fn:this.search.createCallback(this),scope:this},items:[{border:false,layout:"column",layoutConfig:{padding:"5",align:"middle"},defaults:{xtype:"label"},items:[{columnWidth:0.3,style:"margin-top:8px;",xtype:"container",layout:"form",items:[{anchor:"99%",xtype:"textfield",fieldLabel:"会议标题",name:"Q_confTopic_S_LK",maxLength:256},{anchor:"99%",xtype:"textfield",fieldLabel:"会议室名称",name:"Q_roomName_S_LK",maxLength:156}]},{columnWidth:0.3,style:"margin-top:8px;",xtype:"container",layout:"form",items:[{anchor:"99%",xtype:"combo",name:"Q_confProperty_S_LK",fieldLabel:"会议类型",valueField:"typeId",displayField:"typeName",mode:"local",editable:false,triggerAction:"all",forceSelection:true,store:new Ext.data.SimpleStore({url:__ctxPath+"/admin/getTypeAllConference.do",autoLoad:true,fields:["typeId","typeName"]})},{anchor:"99%",xtype:"combo",hiddenName:"Q_roomId_L_EQ",fieldLabel:"会议室类型",valueField:"roomId",displayField:"roomName",mode:"local",editable:false,triggerAction:"all",forceSelection:true,store:new Ext.data.SimpleStore({url:__ctxPath+"/admin/getBoardrooConference.do",autoLoad:true,fields:["roomId","roomName"]})}]},{columnWidth:0.3,style:"margin-top:8px;",xtype:"container",layout:"form",items:[{anchor:"99%",fieldLabel:"会议内容",xtype:"textfield",name:"Q_confContent_S_LK",maxLength:4000},{xtype:"container",layout:"column",fieldLabel:"会议时间",items:[{columnWidth:0.49,xtype:"datefield",name:"Q_startTime_D_GE",format:"Y-m-d"},{xtype:"label",style:"margin-top:3px;",text:" 至 "},{columnWidth:0.49,anchor:"99%",xtype:"datefield",name:"Q_endTime_D_LE",format:"Y-m-d"}]}]},{columnWidth:0.1,style:"margin-top:8px;margin-left:5px;",layout:"form",xtype:"container",defaultType:"button",items:[{iconCls:"search",text:"搜索",handler:this.search.createCallback(this)},{iconCls:"reset",style:"margin-top:5px;",text:"清空",handler:this.reset.createCallback(this)}]}]}]});this.store=new Ext.data.JsonStore({url:__ctxPath+"/admin/daiKaiConference.do",root:"result",totalProperty:"totalCounts",remoteSort:true,fields:[{name:"confId",type:"int"},"confTopic","compereName","roomName","roomLocation","attendUsersName","feeBudget","checkName","startTime","endTime","status"]});this.store.setDefaultSort("confId","desc");this.store.load({params:{start:0,limit:25}});this.rowActions=new Ext.ux.grid.RowActions({header:"管理",width:80,actions:[{iconCls:"btn-showDetail",qtip:"查看",style:"margin:0 3px 0 3px"}]});var b=new Ext.grid.CheckboxSelectionModel();var a=new Ext.grid.ColumnModel({columns:[b,new Ext.grid.RowNumberer(),{header:"confId",dataIndex:"confId",hidden:true},{header:"会议议题",dataIndex:"confTopic"},{header:"主持人",dataIndex:"compereName"},{header:"与会人员",dataIndex:"attendUsersName"},{header:"经费(元)",dataIndex:"feeBudget"},{header:"开始时间",dataIndex:"startTime"},{header:"结束时间",dataIndex:"endTime"},{header:"会议室名称",dataIndex:"roomName"},{header:"会议地址",dataIndex:"roomLocation"},this.rowActions],defaults:{sortable:true,menuDisabled:true,width:100}});this.topbar=new Ext.Toolbar({height:30,bodyStyle:"text-align:left",items:[]});this.gridPanel=new Ext.grid.GridPanel({id:"DaiKaiConferenceGrid",region:"center",stripeRows:true,tbar:this.topbar,store:this.store,trackMouseOver:true,disableSelection:false,loadMask:true,autoHeight:true,cm:a,sm:b,plugins:this.rowActions,viewConfig:{forceFit:true,autoFill:true},bbar:new Ext.PagingToolbar({pageSize:25,store:this.store,displayInfo:true,displayMsg:"当前页记录索引{0}-{1}， 共{2}条记录",emptyMsg:"当前没有记录"})});this.gridPanel.addListener("rowdblclick",function(d,c,f){d.getSelectionModel().each(function(e){ConferenceDetailForm.show(e.data.confId);});});this.rowActions.on("action",this.onRowAction,this);},search:function(a){if(a.searchPanel.getForm().isValid()){$search({searchPanel:a.searchPanel,gridPanel:a.gridPanel});}},reset:function(a){a.searchPanel.getForm().reset();},createRecord:function(){new ConferenceForm().show();},delRecords:function(){var c=Ext.getCmp("DaiKaiConferenceGrid");var a=c.getSelectionModel().getSelections();if(a.length==0){Ext.ux.Toast.msg("信息","请选择要删除的记录！");return;}var d=Array();for(var b=0;b<a.length;b++){d.push(a[b].data.confId);}this.delByIds(d);},showDetail:function(a){ConferenceDetailForm.show(a);},onRowAction:function(c,a,d,e,b){switch(d){case"btn-showDetail":this.showDetail(a.data.confId);break;}}});