MailDetail = Ext.extend(Ext.Panel, {
			constructor : function(a) {
				Ext.applyIf(this, a);
				this.initUI();
				MailDetail.superclass.constructor.call(this, {
							id : "MailDetail",
							title : "我的邮件",
							iconCls : "menu-mail",
							border : false,
							tbar : this.toolbar,
							autoLoad : {
								url : __ctxPath + "/communicate/getMail.do?",
								params : {
									mailId : this.mailId,
									boxId : this.boxId
								},
								method : "Post"
							}
						});
			},
			initUI : function() {
				var a = this.mailId;
				var b = this.boxId;
				this.toolbar = new Ext.Toolbar({
							height : 30,
							defaultType : "button",
							bodyStyle : "text-align:left",
							items : [{
										iconCls : "btn-mail_reply",
										text : "回复",
										handler : function() {
											var c = Ext
													.getCmp("centerTabPanel");
											var d = Ext.getCmp("MailForm");
											if (d == null) {
												d = new MailForm(a, b, "reply");
												c.add(d);
												c.activate(d);
											} else {
												c.remove(d);
												d = new MailForm(a, b, "reply");
												c.add(d);
												c.activate(d);
											}
										}
									}, {
										iconCls : "btn-mail_resend",
										text : "转发",
										handler : function() {
											var c = Ext
													.getCmp("centerTabPanel");
											var d = Ext.getCmp("MailForm");
											if (d == null) {
												d = new MailForm(a, b,
														"forward");
												c.add(d);
												c.activate(d);
											} else {
												c.remove(d);
												d = new MailForm(a, b,
														"forward");
												c.add(d);
												c.activate(d);
											}
										}
									}]
						});
			}
		});