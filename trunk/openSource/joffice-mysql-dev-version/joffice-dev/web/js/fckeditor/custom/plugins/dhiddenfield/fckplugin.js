FCKCommands.RegisterCommand("dhiddenfield",new FCKDialogCommand("dhiddenfield",FCKLang.HiddenFieldProp,FCKPlugins.Items["dhiddenfield"].Path+"fck_dhiddenfield.html",340,160));var oSItem=new FCKToolbarButton("dhiddenfield",FCKLang.HiddenFieldProp,null,null,null,true,56);FCKToolbarItems.RegisterItem("dhiddenfield",oSItem);FCK.ContextMenu.RegisterListener({AddItems:function(c,a,b){if(b=="IMG"&&a.getAttribute("FCK__InputHidden")){c.RemoveAllItems();c.AddItem("Cut",FCKLang.Cut,7,FCKCommands.GetCommand("Cut").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("Copy",FCKLang.Copy,8,FCKCommands.GetCommand("Copy").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("Paste",FCKLang.Paste,9,FCKCommands.GetCommand("Paste").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("dhiddenfield",FCKLang.HiddenFieldProp,56);}}});