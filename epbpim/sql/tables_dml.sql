INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(1,'公共信息平台','',0,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(2,'文件管理','',0,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(3,'工程项目管理','',0,1,3);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(4,'人力资源管理','',0,1,4);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(5,'系统管理','',0,1,5);


INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(10,'营业执照','../publicInfo/businessLicense.jsp',1,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(11,'税务登记执照','../publicInfo/taxLicense.jsp',1,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(12,'ISO文件查询','../publicInfo/schIsoList.do',1,1,3);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(13,'典型工程查询','../publicInfo/queryHistoryProject.jsp',1,1,4);

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(20,'文件上传','../businessFile/uploadBusinessFile.jsp',2,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(21,'文件查询','../businessFile/schBusinessFileList.do',2,1,2);

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(30,'录入项目','../projectManage/addProject.do',3,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(31,'查询自己项目','../projectManage/queryProject.do?1',3,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(32,'查询部门项目','../projectManage/queryProject.do?2',3,1,3);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(33,'查询全部项目','../projectManage/queryProject.do?3',3,1,4);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(34,'填写部门支出','',3,1,5);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(35,'修改部门支出','',3,1,6);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(36,'增加部门收入','',3,1,7);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(37,'修改部门收入','',3,1,8);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(38,'结束项目','',3,1,9);


INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(40,'新增员工','../employeeManage/newUserInfo.do',4,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(41,'查询员工','../employeeManage/listUserInfo.do',4,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(42,'新增职务','../employeeManage/addRole.jsp',4,1,3);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(43,'查询职务','../employeeManage/listRole.do',4,1,4);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(44,'新增部门','../department/addDepartment.jsp',4,1,5);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(45,'查询部门','../department/schAdminDeptList.do',4,1,6);

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(51,'ISO文件上传','../systemManage/uploadIsoFile.jsp',5,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(52,'发布通知','../systemManage/publishMessage.jsp',5,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(53,'日志查询','../systemManage/queryLog.jsp',5,1,3);