FCKCommands.RegisterCommand("dfileattach",new FCKDialogCommand("dfileattach",FCKLang.FileAttachDlgTitle,FCKPlugins.Items["dfileattach"].Path+"fck_dfileattach.html",380,210));var oSItem=new FCKToolbarButton("dfileattach",FCKLang.FileAttachBtn);oSItem.IconPath=FCKPlugins.Items["dfileattach"].Path+"file.png";FCKToolbarItems.RegisterItem("dfileattach",oSItem);FCK.ContextMenu.RegisterListener({AddItems:function(c,a,b){if(b=="INPUT"&&a.getAttribute("isfileattach")){c.RemoveAllItems();c.AddItem("Cut",FCKLang.Cut,7,FCKCommands.GetCommand("Cut").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("Copy",FCKLang.Copy,8,FCKCommands.GetCommand("Copy").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("Paste",FCKLang.Paste,9,FCKCommands.GetCommand("Paste").GetState()==FCK_TRISTATE_DISABLED);c.AddItem("dfileattach",FCKLang.FileAttachDlgTitle,FCKToolbarItems.GetItem("dfileattach").IconPath);}}});