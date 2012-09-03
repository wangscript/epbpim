INSERT INTO [EAMENU] VALUES ('01', 'G4Studio系统集成与开发平台', '0', NULL, '0', NULL, '0', '1', NULL, NULL, '1');
GO
INSERT INTO [EAMENU] VALUES ('0101', '系统管理', '01', 'folder_wrenchIcon', '0', NULL, '0', '1', NULL, NULL, '1');
GO
INSERT INTO [EAMENU] VALUES ('010102', '权限管理', '0101', NULL, '1', NULL, '0', '1', NULL, NULL, '1');
GO
INSERT INTO [EAMENU] VALUES ('01010201', '组织机构管理', '010102', 'chart_organisationIcon', '0', 'organization.ered?reqCode=departmentInit', '1', '1', NULL, 'chart_organisation.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010202', '人员管理与授权', '010102', 'group_linkIcon', '0', 'user.ered?reqCode=userInit', '1', '3', NULL, 'group_link.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010204', '角色管理与授权', '010102', 'award_star_silver_3Icon', '0', 'role.ered?reqCode=roleInit', '1', '2', NULL, 'award_star_silver_3.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010205', '菜单资源管理', '010102', 'arrow_switchIcon', '0', 'resource.ered?reqCode=menuResourceInit', '1', '4', NULL, 'arrow_switch.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010206', 'UI元素托管', '010102', 'app_boxesIcon', '0', 'part.ered?reqCode=init', '1', '5', NULL, 'app_boxes.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010207', 'UI元素角色授权', '010102', 'app_leftIcon', '0', 'rolePart.ered?reqCode=init', '1', '6', NULL, 'app_left.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010208', 'UI元素人员授权', '010102', 'app_rightIcon', '0', 'userPart.ered?reqCode=init', '1', '7', NULL, 'app_right.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('010103', '基础数据维护', '0101', NULL, '1', NULL, '0', '2', NULL, NULL, '1');
GO
INSERT INTO [EAMENU] VALUES ('01010301', '字典维护', '010103', 'application_view_listIcon', '0', 'resource.ered?reqCode=codeTableInit', '1', '1', NULL, 'application_view_list.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010303', '全局参数表维护', '010103', 'configIcon', '0', 'param.ered?reqCode=init', '1', '2', NULL, 'config.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('010104', '运行监控', '0101', NULL, '1', NULL, '0', '3', NULL, NULL, '1');
GO
INSERT INTO [EAMENU] VALUES ('01010401', 'Session会话监控', '010104', 'user_commentIcon', '0', 'sessionMonitor.ered?reqCode=init', '1', '2', NULL, 'user_comment.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010403', 'Requst请求跟踪', '010104', 'bugIcon', '0', 'eventTrack.ered?reqCode=init', '1', '1', NULL, 'bug.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010405', 'JDBC执行监控', '010104', 'database_refreshIcon', '0', 'jdbcMonitor.ered?reqCode=jdbcInit', '1', '3', NULL, 'database_refresh.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010406', '系统异常监控', '010104', 'disconnectIcon', '0', 'beanMonitor.ered?reqCode=init', '1', '4', NULL, 'disconnect.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('01010407', '服务器信息', '010104', 'server_connectIcon', '0', 'serverInfo.ered?reqCode=init', '1', '5', NULL, 'server_connect.png', '1');
GO
INSERT INTO [EAMENU] VALUES ('0102', '标准范例子系统', '01', 'folder_cameraIcon', '0', NULL, '0', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010208', '表单及表单元素', '0102', NULL, '0', NULL, '0', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020801', '基本输入(属性配置)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=basicInput4PropertyInit', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020802', '基本输入(方法行为)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=basicInput4MethodInit', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020803', '日历选择框(日期、时间)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=dataTimeInputInit', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020804', '下拉选择框(本地数据源)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=selectInputBasedLocalDataSourceInit', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020805', '下拉选择框(字典数据源)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=selectInputBasedCodeTableDataSourceInit', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020806', '下拉选择框(远程数据源)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=selectInputBasedRemoteDataSourceInit', '1', '6', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020807', '下拉选择框(N级联动)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=selectInputBasedMultilevelInit', '1', '7', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020808', '单选框、复选框', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=radioCheckBoxInit', '1', '8', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020809', '表单异步交互(提交、数据填充)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=formSubmitInit', '1', '9', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020810', '表单同步提交', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=formSynSubmitInit', '1', '10', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020813', '工具栏、菜单栏', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=toobarDemo1Init', '1', '11', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020814', '消息对话框', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=msgDemo1Init', '1', '12', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020815', '富文本输入框', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=htmlEditorInit', '1', '13', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020816', '富文本输入框(扩展)', '010208', NULL, '0', 'demo/formDemo.ered?reqCode=htmlEditor2Init', '1', '14', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010209', '窗口及面板', '0102', NULL, '0', NULL, '0', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020901', '面板范例一', '010209', NULL, '0', 'demo/commonUiDemo.ered?reqCode=panelDemo1Init', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020902', '窗口范例一', '010209', NULL, '0', 'demo/commonUiDemo.ered?reqCode=windowDemo1Init', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01020903', 'Tab标签卡范例一', '010209', NULL, '0', 'demo/commonUiDemo.ered?reqCode=tabPanelDemo1Init', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010210', '表格', '0102', NULL, '0', NULL, '0', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021001', '表格范例一(基本特性)', '010210', NULL, '0', 'demo/gridDemo.ered?reqCode=gridDemo1Init', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021002', '表格范例二(行级展开)', '010210', NULL, '0', 'demo/gridDemo.ered?reqCode=gridDemo2Init', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021003', '表格范例三(可编辑表格)', '010210', NULL, '0', 'demo/gridDemo.ered?reqCode=gridDemo3Init', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021004', '表格范例四(列锁定)', '010210', NULL, '0', 'demo/gridDemo.ered?reqCode=gridDemo4Init', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021005', '表格范例五(缓冲表格)', '010210', NULL, '0', 'demo/gridDemo.ered?reqCode=gridDemo5Init', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021006', '表格范例六(合计表格)', '010210', NULL, '0', 'demo/gridDemo.ered?reqCode=gridDemo6Init', '1', '6', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021007', '表格范例七(表头分组)', '010210', NULL, '0', 'demo/gridDemo.ered?reqCode=gridDemo7Init', '1', '7', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010211', '树', '0102', NULL, '0', NULL, '0', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021101', '树范例一(普通树)', '010211', NULL, '0', 'demo/treeDemo.ered?reqCode=treeDemo1Init', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021102', '树范例二(异步树)', '010211', NULL, '0', 'demo/treeDemo.ered?reqCode=treeDemo2Init', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021103', '树范例三(复选树)', '010211', NULL, '0', 'demo/treeDemo.ered?reqCode=treeDemo3Init', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021104', '树范例四(级联复选树)', '010211', NULL, '0', 'demo/treeDemo.ered?reqCode=treeDemo4Init', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021105', '树范例五(下拉树)', '010211', NULL, '0', 'demo/treeDemo.ered?reqCode=treeDemo5Init', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021106', '树范例六(异步表格树)', '010211', NULL, '0', 'demo/treeDemo.ered?reqCode=treeDemo6Init', '1', '6', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021107', '树范例七(下拉树2)', '010211', NULL, '0', 'demo/treeDemo.ered?reqCode=treeDemo8Init', '1', '7', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010212', '报表', '0102', NULL, '0', NULL, '0', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021201', 'Applet报表', '010212', NULL, '0', 'demo/jasperReportDemo.ered?reqCode=appletInit', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021202', 'PDF报表', '010212', NULL, '0', 'demo/jasperReportDemo.ered?reqCode=pdfInit', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021203', 'Excel报表', '010212', NULL, '0', 'demo/excelReportDemo.ered?reqCode=exportInit', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010213', '图表', '0102', NULL, '0', NULL, '0', '6', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021301', '2D柱状图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf2DColumnInit', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021302', '3D柱状图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf3DColumnInit', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021303', '2D饼图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf2DPieInit', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021304', '3D饼图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf3DPieInit', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021305', '2D柱状组合图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf2DColumnMsInit', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021306', '3D柱状组合图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf3DColumnMsInit', '1', '6', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021307', '折线图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcfLineInit', '1', '7', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021308', '折线组合图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcfLineMsInit', '1', '8', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021309', '面积图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcfAreaInit', '1', '9', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021310', '面积组合图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcfAreaMsInit', '1', '10', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021311', '环状图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcfCircularityInit', '1', '11', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021312', '3D折线柱状交叉图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf3DLineColumnInit', '1', '12', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021313', '2D栏位图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf2DBarInit', '1', '13', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021314', '2D栏位组合图', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcf2DBarMsInit', '1', '14', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021315', '交互图(JS调用|下钻[超链接])', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcfAdvancedInit', '1', '15', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021316', '图表综合范例一(动态数据源)', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=integrateFlashReport1Init', '1', '16', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021317', '图表综合范例二(动态数据源)', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=integrateFlashReport2Init', '1', '17', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021318', '拆线组合图（双Y轴）', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=fcfLineMs2YInit', '1', '19', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021319', '动态切换图表类型', '010213', NULL, '0', 'demo/flashReportDemo.ered?reqCode=integrateFlashReport3Init', '1', '18', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010214', '页面布局', '0102', NULL, '0', NULL, '0', '7', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021401', 'Form布局', '010214', NULL, '0', 'demo/formDemo.ered?reqCode=formLayoutInit', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021402', 'Column布局', '010214', NULL, '0', 'demo/formDemo.ered?reqCode=columnLayoutInit', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021403', '表单综合布局1', '010214', NULL, '0', 'demo/formDemo.ered?reqCode=complexLayoutInit', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021404', '表单综合布局2', '010214', NULL, '0', 'demo/formDemo.ered?reqCode=complexLayout2Init', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021405', 'Viewport布局', '010214', NULL, '0', 'demo/commonUiDemo.ered?reqCode=viewportLayoutInit', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021406', 'Viewport嵌套布局', '010214', NULL, '0', 'demo/commonUiDemo.ered?reqCode=viewportComplexLayoutInit', '1', '6', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010215', '综合', '0102', NULL, '0', NULL, '0', '8', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021501', '综合实例1', '010215', NULL, '0', 'demo/integrateDemo.ered?reqCode=queryDemo1Init', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021502', '综合实例2', '010215', NULL, '0', 'demo/integrateDemo.ered?reqCode=queryDemo2Init', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021503', '综合实例3', '010215', NULL, '0', 'demo/integrateDemo.ered?reqCode=collectDataInit', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021504', '综合实例4', '010215', NULL, '0', 'demo/integrateDemo.ered?reqCode=collectDataByWindowInit', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021505', '综合实例5', '010215', NULL, '0', 'demo/integrateDemo.ered?reqCode=manageDataInit', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021506', '综合实例6', '010215', NULL, '0', 'demo/integrateDemo.ered?reqCode=manageData4In1Init', '1', '6', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010216', '其它', '0102', NULL, '0', NULL, '0', '9', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021601', '存储过程调用', '010216', NULL, '0', 'demo/integrateDemo.ered?reqCode=callPrcInit', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021602', '文件管理(上传下载)', '010216', NULL, '0', 'demo/otherDemo.ered?reqCode=uploadInit', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021603', '演示UI元素授权', '010216', NULL, '0', 'demo/integrateDemo.ered?reqCode=manageData4In1Init', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021604', '导入Excel文件(xls格式)', '010216', NULL, '0', 'demo/excelReportDemo.ered?reqCode=importInit', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01021605', '客户端请求异常处理', '010216', NULL, '0', 'demo/otherDemo.ered?reqCode=exceptionInit', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('0103', '开发人员工具箱', '01', 'configIcon', '0', NULL, '0', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010301', '其它', '0103', NULL, '0', NULL, '0', '8', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030101', '系统预置图标', '010301', 'imagesIcon', '0', 'resource.ered?reqCode=iconInit', '1', '1', NULL, 'images.png', '0');
GO
INSERT INTO [EAMENU] VALUES ('01030102', '调色板', '010301', 'theme2Icon', '0', 'resource.ered?reqCode=colorPaletteInit', '1', '2', NULL, 'theme2.png', '0');
GO
INSERT INTO [EAMENU] VALUES ('010302', '调试', '0103', NULL, '0', NULL, '0', '9', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030201', '调试页面1', '010302', NULL, '0', 'demo/test.ered?reqCode=test1Init', '1', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030202', '调试页面2', '010302', NULL, '0', 'demo/test.ered?reqCode=test2Init', '1', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030203', '调试页面3', '010302', NULL, '0', 'demo/test.ered?reqCode=test3Init', '1', '3', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030204', '调试页面4', '010302', NULL, '0', 'demo/test.ered?reqCode=test4Init', '1', '4', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030205', '调试页面5', '010302', NULL, '0', 'demo/test.ered?reqCode=test5Initt', '1', '5', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010303', '代码生成', '0103', NULL, '0', NULL, '0', '1', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030301', '菜单1', '010303', NULL, '0', NULL, '1', '0', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('010304', '数据管理', '0103', NULL, '0', NULL, '0', '2', NULL, NULL, '0');
GO
INSERT INTO [EAMENU] VALUES ('01030401', '菜单1', '010304', NULL, '0', NULL, '1', '1', NULL, NULL, '0');
GO
