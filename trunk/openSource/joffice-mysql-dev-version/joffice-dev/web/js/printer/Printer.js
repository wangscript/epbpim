Ext.ns("Ext.ux.plugins");Ext.ux.plugins.Print={printGrid:function(c){var d=this.component;var b=d.getStore();if((!c||c.browserEvent)&&b.lastOptions&&b.lastOptions.params&&b.lastOptions.params.limit&&b.lastOptions.params.limit!=0){var a=Math.min(100,b.getTotalCount());var f=b.lastOptions.params;var g=Ext.applyIf({limit:a},f);b.load({params:g,callback:function(){this.printGrid({params:f});},scope:this});return;}var e=d.getColumnModel().getTotalWidth();var g={id:d.el.id,width:e};window.open(__ctxPath+"/js/printer/Preview.jsp?"+Ext.urlEncode(g)+"&rand="+Math.random(),"printPreview");if(c&&c.params){b.load.defer(1000,b,[{params:c.params}]);}},printForm:function(){var a=this.component;var b={id:a.body.id,type:"form",title:a.title||a.ownerCt.title};window.open(__ctxPath+"/js/printer/Preview.jsp?"+Ext.urlEncode(b)+"&rand="+Math.random(),"printPreview");},init:function(g){var f=g.xtype||g.getXType();switch(f){case"htgrid":this.component=g;if(!g.tools){g.tools=[];}g.tools.push({id:"print",handler:this.printGrid,scope:this});break;case"form":this.component=g;if(g.tools){g.tools.push({id:"print",handler:this.printForm,scope:this});}else{var e=g.getTopToolbar();if(e){var d=false;for(var c=0,a=e.length;c<a;c++){if(e[c].text=="Print"){var b=e[c];if(!b.handler){Ext.apply(b,{handler:this.printForm,scope:g});d=true;}break;}}if(!d){e.push({iconCls:"print",handler:this.printForm,scope:this});}}}break;}}};Ext.ux.PrintSetup=function(){this.init();};Ext.ux.PrintSetup=Ext.extend(Ext.ux.PrintSetup,{setupGrid:function(){var a=this.params.width;if(!isNaN(a)){a=parseInt(a)+"px";}else{a=undefined;}var b={height:null,width:a};this.applyStyles("div[class*='x-grid3-hd-inner']",{"padding-right":null});this.applyStyles("div[class*='x-grid3-header-inner']",{"width":null});this.applyStyles("div[class='x-grid3-scroller']",b);this.applyStyles("div[class='x-panel-body']",b);this.applyStyles("div[class='x-grid3']",b);this.setTitle();},applyStyles:function(b,d){var f=Ext.DomQuery.select(b);if(f){var e=Ext.DomHelper;for(var c=0,a=f.length;c<a;c++){e.applyStyles(f[c],d);}}},setTitle:function(a){if(!a){a="x-panel-header-text";}var b=Ext.DomQuery.select("span[class='"+a+"']");if(b&&b.length>0){document.title=b[0].innerHTML;}},setupForm:function(){document.title=this.params.title;},init:function(){var a=window.opener;if(a){var b=Ext.urlDecode(location.href.substring(location.href.indexOf("?")+1));this.params=b;if(b.id){window.document.body.innerHTML=a.document.getElementById(b.id).innerHTML;Ext.applyIf(b,{type:"grid"});alert(b.type);switch(b.type){case"htgrid":this.setupGrid();break;case"form":this.setupForm();}}}}});