var FCKCommands=FCK.Commands=new Object();FCKCommands.LoadedCommands=new Object();FCKCommands.RegisterCommand=function(a,b){this.LoadedCommands[a]=b;};FCKCommands.GetCommand=function(a){var b=FCKCommands.LoadedCommands[a];if(b){return b;}switch(a){case"Bold":case"Italic":case"Underline":case"StrikeThrough":case"Subscript":case"Superscript":b=new FCKCoreStyleCommand(a);break;case"RemoveFormat":b=new FCKRemoveFormatCommand();break;case"DocProps":b=new FCKDialogCommand("DocProps",FCKLang.DocProps,"dialog/fck_docprops.html",400,380,FCKCommands.GetFullPageState);break;case"Templates":b=new FCKDialogCommand("Templates",FCKLang.DlgTemplatesTitle,"dialog/fck_template.html",380,450);break;case"Link":b=new FCKDialogCommand("Link",FCKLang.DlgLnkWindowTitle,"dialog/fck_link.html",400,300);break;case"Unlink":b=new FCKUnlinkCommand();break;case"VisitLink":b=new FCKVisitLinkCommand();break;case"Anchor":b=new FCKDialogCommand("Anchor",FCKLang.DlgAnchorTitle,"dialog/fck_anchor.html",370,160);break;case"AnchorDelete":b=new FCKAnchorDeleteCommand();break;case"BulletedList":b=new FCKDialogCommand("BulletedList",FCKLang.BulletedListProp,"dialog/fck_listprop.html?UL",370,160);break;case"NumberedList":b=new FCKDialogCommand("NumberedList",FCKLang.NumberedListProp,"dialog/fck_listprop.html?OL",370,160);break;case"About":b=new FCKDialogCommand("About",FCKLang.About,"dialog/fck_about.html",420,330,function(){return FCK_TRISTATE_OFF;});break;case"Find":b=new FCKDialogCommand("Find",FCKLang.DlgFindAndReplaceTitle,"dialog/fck_replace.html",340,230,null,null,"Find");break;case"Replace":b=new FCKDialogCommand("Replace",FCKLang.DlgFindAndReplaceTitle,"dialog/fck_replace.html",340,230,null,null,"Replace");break;case"Image":b=new FCKDialogCommand("Image",FCKLang.DlgImgTitle,"dialog/fck_image.html",450,390);break;case"Flash":b=new FCKDialogCommand("Flash",FCKLang.DlgFlashTitle,"dialog/fck_flash.html",450,390);break;case"SpecialChar":b=new FCKDialogCommand("SpecialChar",FCKLang.DlgSpecialCharTitle,"dialog/fck_specialchar.html",400,290);break;case"Smiley":b=new FCKDialogCommand("Smiley",FCKLang.DlgSmileyTitle,"dialog/fck_smiley.html",FCKConfig.SmileyWindowWidth,FCKConfig.SmileyWindowHeight);break;case"Table":b=new FCKDialogCommand("Table",FCKLang.DlgTableTitle,"dialog/fck_table.html",480,250);break;case"TableProp":b=new FCKDialogCommand("Table",FCKLang.DlgTableTitle,"dialog/fck_table.html?Parent",480,250);break;case"TableCellProp":b=new FCKDialogCommand("TableCell",FCKLang.DlgCellTitle,"dialog/fck_tablecell.html",550,240);break;case"Style":b=new FCKStyleCommand();break;case"FontName":b=new FCKFontNameCommand();break;case"FontSize":b=new FCKFontSizeCommand();break;case"FontFormat":b=new FCKFormatBlockCommand();break;case"Source":b=new FCKSourceCommand();break;case"Preview":b=new FCKPreviewCommand();break;case"Save":b=new FCKSaveCommand();break;case"NewPage":b=new FCKNewPageCommand();break;case"PageBreak":b=new FCKPageBreakCommand();break;case"Rule":b=new FCKRuleCommand();break;case"Nbsp":b=new FCKNbsp();break;case"TextColor":b=new FCKTextColorCommand("ForeColor");break;case"BGColor":b=new FCKTextColorCommand("BackColor");break;case"Paste":b=new FCKPasteCommand();break;case"PasteText":b=new FCKPastePlainTextCommand();break;case"PasteWord":b=new FCKPasteWordCommand();break;case"JustifyLeft":b=new FCKJustifyCommand("left");break;case"JustifyCenter":b=new FCKJustifyCommand("center");break;case"JustifyRight":b=new FCKJustifyCommand("right");break;case"JustifyFull":b=new FCKJustifyCommand("justify");break;case"Indent":b=new FCKIndentCommand("indent",FCKConfig.IndentLength);break;case"Outdent":b=new FCKIndentCommand("outdent",FCKConfig.IndentLength*-1);break;case"Blockquote":b=new FCKBlockQuoteCommand();break;case"CreateDiv":b=new FCKDialogCommand("CreateDiv",FCKLang.CreateDiv,"dialog/fck_div.html",380,210,null,null,true);break;case"EditDiv":b=new FCKDialogCommand("EditDiv",FCKLang.EditDiv,"dialog/fck_div.html",380,210,null,null,false);break;case"DeleteDiv":b=new FCKDeleteDivCommand();break;case"TableInsertRowAfter":b=new FCKTableCommand("TableInsertRowAfter");break;case"TableInsertRowBefore":b=new FCKTableCommand("TableInsertRowBefore");break;case"TableDeleteRows":b=new FCKTableCommand("TableDeleteRows");break;case"TableInsertColumnAfter":b=new FCKTableCommand("TableInsertColumnAfter");break;case"TableInsertColumnBefore":b=new FCKTableCommand("TableInsertColumnBefore");break;case"TableDeleteColumns":b=new FCKTableCommand("TableDeleteColumns");break;case"TableInsertCellAfter":b=new FCKTableCommand("TableInsertCellAfter");break;case"TableInsertCellBefore":b=new FCKTableCommand("TableInsertCellBefore");break;case"TableDeleteCells":b=new FCKTableCommand("TableDeleteCells");break;case"TableMergeCells":b=new FCKTableCommand("TableMergeCells");break;case"TableMergeRight":b=new FCKTableCommand("TableMergeRight");break;case"TableMergeDown":b=new FCKTableCommand("TableMergeDown");break;case"TableHorizontalSplitCell":b=new FCKTableCommand("TableHorizontalSplitCell");break;case"TableVerticalSplitCell":b=new FCKTableCommand("TableVerticalSplitCell");break;case"TableDelete":b=new FCKTableCommand("TableDelete");break;case"Form":b=new FCKDialogCommand("Form",FCKLang.Form,"dialog/fck_form.html",380,210);break;case"Checkbox":b=new FCKDialogCommand("Checkbox",FCKLang.Checkbox,"dialog/fck_checkbox.html",380,200);break;case"Radio":b=new FCKDialogCommand("Radio",FCKLang.RadioButton,"dialog/fck_radiobutton.html",380,200);break;case"TextField":b=new FCKDialogCommand("TextField",FCKLang.TextField,"dialog/fck_textfield.html",380,210);break;case"Textarea":b=new FCKDialogCommand("Textarea",FCKLang.Textarea,"dialog/fck_textarea.html",380,210);break;case"HiddenField":b=new FCKDialogCommand("HiddenField",FCKLang.HiddenField,"dialog/fck_hiddenfield.html",380,190);break;case"Button":b=new FCKDialogCommand("Button",FCKLang.Button,"dialog/fck_button.html",380,210);break;case"Select":b=new FCKDialogCommand("Select",FCKLang.SelectionField,"dialog/fck_select.html",400,340);break;case"ImageButton":b=new FCKDialogCommand("ImageButton",FCKLang.ImageButton,"dialog/fck_image.html?ImageButton",450,390);break;case"SpellCheck":b=new FCKSpellCheckCommand();break;case"FitWindow":b=new FCKFitWindow();break;case"Undo":b=new FCKUndoCommand();break;case"Redo":b=new FCKRedoCommand();break;case"Copy":b=new FCKCutCopyCommand(false);break;case"Cut":b=new FCKCutCopyCommand(true);break;case"SelectAll":b=new FCKSelectAllCommand();break;case"InsertOrderedList":b=new FCKListCommand("insertorderedlist","ol");break;case"InsertUnorderedList":b=new FCKListCommand("insertunorderedlist","ul");break;case"ShowBlocks":b=new FCKShowBlockCommand("ShowBlocks",FCKConfig.StartupShowBlocks?FCK_TRISTATE_ON:FCK_TRISTATE_OFF);break;case"Undefined":b=new FCKUndefinedCommand();break;case"Scayt":b=FCKScayt.CreateCommand();break;case"ScaytContext":b=FCKScayt.CreateContextCommand();break;default:if(FCKRegexLib.NamedCommands.test(a)){b=new FCKNamedCommand(a);}else{alert(FCKLang.UnknownCommand.replace(/%1/g,a));return null;}}FCKCommands.LoadedCommands[a]=b;return b;};FCKCommands.GetFullPageState=function(){return FCKConfig.FullPage?FCK_TRISTATE_OFF:FCK_TRISTATE_DISABLED;};FCKCommands.GetBooleanState=function(a){return a?FCK_TRISTATE_DISABLED:FCK_TRISTATE_OFF;};