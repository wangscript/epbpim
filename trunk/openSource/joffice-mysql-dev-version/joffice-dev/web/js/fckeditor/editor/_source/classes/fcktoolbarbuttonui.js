var FCKToolbarButtonUI=function(b,a,f,e,c,d){this.Name=b;this.Label=a||b;this.Tooltip=f||this.Label;this.Style=c||FCK_TOOLBARITEM_ONLYICON;this.State=d||FCK_TRISTATE_OFF;this.Icon=new FCKIcon(e);if(FCK.IECleanup){FCK.IECleanup.AddItem(this,FCKToolbarButtonUI_Cleanup);}};FCKToolbarButtonUI.prototype._CreatePaddingElement=function(a){var b=a.createElement("IMG");b.className="TB_Button_Padding";b.src=FCK_SPACER_PATH;return b;};FCKToolbarButtonUI.prototype.Create=function(b){var a=FCKTools.GetElementDocument(b);var g=this.MainElement=a.createElement("DIV");g.title=this.Tooltip;if(FCKBrowserInfo.IsGecko){g.onmousedown=FCKTools.CancelEvent;}FCKTools.AddEventListenerEx(g,"mouseover",FCKToolbarButtonUI_OnMouseOver,this);FCKTools.AddEventListenerEx(g,"mouseout",FCKToolbarButtonUI_OnMouseOut,this);FCKTools.AddEventListenerEx(g,"click",FCKToolbarButtonUI_OnClick,this);this.ChangeState(this.State,true);if(this.Style==FCK_TOOLBARITEM_ONLYICON&&!this.ShowArrow){g.appendChild(this.Icon.CreateIconElement(a));}else{var d=g.appendChild(a.createElement("TABLE"));d.cellPadding=0;d.cellSpacing=0;var c=d.insertRow(-1);var f=c.insertCell(-1);if(this.Style==FCK_TOOLBARITEM_ONLYICON||this.Style==FCK_TOOLBARITEM_ICONTEXT){f.appendChild(this.Icon.CreateIconElement(a));}else{f.appendChild(this._CreatePaddingElement(a));}if(this.Style==FCK_TOOLBARITEM_ONLYTEXT||this.Style==FCK_TOOLBARITEM_ICONTEXT){f=c.insertCell(-1);f.className="TB_Button_Text";f.noWrap=true;f.appendChild(a.createTextNode(this.Label));}if(this.ShowArrow){if(this.Style!=FCK_TOOLBARITEM_ONLYICON){c.insertCell(-1).appendChild(this._CreatePaddingElement(a));}f=c.insertCell(-1);var e=f.appendChild(a.createElement("IMG"));e.src=FCKConfig.SkinPath+"images/toolbar.buttonarrow.gif";e.width=5;e.height=3;}f=c.insertCell(-1);f.appendChild(this._CreatePaddingElement(a));}b.appendChild(g);};FCKToolbarButtonUI.prototype.ChangeState=function(c,a){if(!a&&this.State==c){return;}var b=this.MainElement;if(!b){return;}switch(parseInt(c,10)){case FCK_TRISTATE_OFF:b.className="TB_Button_Off";break;case FCK_TRISTATE_ON:b.className="TB_Button_On";break;case FCK_TRISTATE_DISABLED:b.className="TB_Button_Disabled";break;}this.State=c;};function FCKToolbarButtonUI_OnMouseOver(b,a){if(a.State==FCK_TRISTATE_OFF){this.className="TB_Button_Off_Over";}else{if(a.State==FCK_TRISTATE_ON){this.className="TB_Button_On_Over";}}}function FCKToolbarButtonUI_OnMouseOut(b,a){if(a.State==FCK_TRISTATE_OFF){this.className="TB_Button_Off";}else{if(a.State==FCK_TRISTATE_ON){this.className="TB_Button_On";}}}function FCKToolbarButtonUI_OnClick(b,a){if(a.OnClick&&a.State!=FCK_TRISTATE_DISABLED){a.OnClick(a);}}function FCKToolbarButtonUI_Cleanup(){this.MainElement=null;}