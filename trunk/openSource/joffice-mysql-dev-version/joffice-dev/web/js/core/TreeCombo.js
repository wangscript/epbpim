Ext.ns("Ext.ux.form");Ext.ux.form.CheckTreeCombo=Ext.extend(Ext.form.TriggerField,{filterChars:3,getValueMethod:"getCheckedIds",handleHeight:6,listAlign:"tl-bl?",listClass:"",listHeight:200,minListWidth:70,resizable:false,selectOnFocus:true,shadow:"sides",treeConfig:{rootVisible:false,border:false,autoScroll:true,deepestOnly:true,loaded:false,root:{nodeType:"async",expanded:true,uiProvider:false},loader:{url:"request.php",preloadChildren:true}},value:[],clearFilter:function(){if(this.tree&&this.tree.filter){this.tree.filter.clear();}},collapse:function(){if(!this.isExpanded()){return;}this.list.hide();Ext.getDoc().un("mousedown",this.collapseIf,this);this.fireEvent("collapse",this);},collapseIf:function(a){if(!a.within(this.wrap)&&!a.within(this.list)){this.collapse();}},expand:function(){if(this.isExpanded()){return;}this.list.alignTo(this.wrap,this.listAlign);this.list.show();Ext.getDoc().on("mousedown",this.collapseIf,this);this.fireEvent("expand",this);},getCheckedIds:function(){if(this.tree){return this.tree.getValue();}else{return this.value;}},getEditor:function(c){var b=c.editor;Ext.apply(b,{});var a=new Ext.grid.GridEditor(new Ext.ux.form.CheckTreeCombo(b),{updateEl:false});a.on({startedit:{fn:function(d,e){if(this.field.tree){this.field.tree.filter.clear();Ext.each(this.field.tree.getRootNode().childNodes,function(f){f.collapse(true,false);});}this.field.setValue(this.record.get(this.field.idName));this.field.expand();}},complete:{fn:function(e,f,d){this.record.set(this.field.idName,this.field.getCheckedIds());}}});return a;},getValue:function(){return this[this.getValueMethod]();},getText:function(){if(this.tree){return this.tree.getText();}else{return this.value;}},initComponent:function(){if(this.loaderBaseParams){Ext.apply(this.treeConfig.loader,{baseParams:this.loaderBaseParams});}var a={tree:new Ext.ux.tree.CheckTreePanel(this.treeConfig)};a.tree.loader.on({load:{scope:this,fn:function(b,c){this.tree.loaded=true;this.setValue(this.value);}}});a.tree.on({checkchange:{scope:this,delay:20,fn:this.onCheckChange}});Ext.apply(this,Ext.apply(this.initialConfig,a));Ext.ux.form.CheckTreeCombo.superclass.initComponent.apply(this,arguments);this.addEvents("expand","collapse");},initList:function(){if(this.list){return;}var a="x-combo-list";this.list=new Ext.Layer({shadow:this.shadow,cls:[a,this.listClass].join(" "),constrain:false});var b=this.listWidth||Math.max(this.wrap.getWidth(),this.minListWidth);this.innerList=this.list.createChild({cls:a+"-inner"});this.setListSize(b,this.listHeight);if(this.resizable){this.resizer=new Ext.Resizable(this.list,{pinned:true,handles:"se"});this.resizer.on("resize",function(e,c,d){this.setListSize(c,d);},this);}},isExpanded:function(){return this.list&&this.list.isVisible();},onCheckChange:function(b,a){this.el.focus();this.el.dom.select();return;},onDestroy:function(){if(this.tree){this.tree.destroy();}if(this.list){this.list.destroy();}},onKeyUp:function(c,b){var d=this.getRawValue();if(c.ESC===c.getKey()||!d){this.clearFilter();this.setRawValue();}else{if(this.tree.filter){this.clearFilter();this.expand();var a=new RegExp(".*"+d+".*","i");this.tree.filter.filter(a,"text");}}},onRender:function(){Ext.ux.form.CheckTreeCombo.superclass.onRender.apply(this,arguments);(function(){this.initList();if(!this.tree.rendered){this.tree.render(this.innerList);this.tree.setHeight(this.innerList.getHeight()-this.list.getFrameWidth("tb"));}}.defer(1,this));this.el.on("keyup",this.onKeyUp,this,{buffer:180});},onTriggerClick:function(){if(this.disabled){return;}if(this.isExpanded()){this.collapse();this.el.focus();}else{this.expand();}},setListSize:function(a,c){var b=this.resizable?this.handleHeight:0;this.list.setSize(a,c);this.innerList.setSize(a-b-this.list.getFrameWidth("lr"),c-b);if(this.tree){this.tree.setHeight(c-this.list.getFrameWidth("tb")-b);}},setValue:function(){if(this.tree.loaded){this.value=this.tree.setValue.apply(this.tree,arguments);}else{this.value=this.tree.convertValue.apply(this.tree,arguments);}this.setRawValue();return this.value;},setRawValue:function(){if(this.el){var a=this.getText();Ext.ux.form.CheckTreeCombo.superclass.setRawValue.call(this,a);this.el.set({qtip:a});}},validateBlur:function(){return !this.list||!this.list.isVisible();}});