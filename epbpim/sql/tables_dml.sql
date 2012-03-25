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
VALUES(101,'营业执照','../publicInfo/businessLicense.jsp',1,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(102,'税务登记执照','../publicInfo/taxLicense.jsp',1,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(103,'ISO文件查询','../publicInfo/schIsoList.do',1,1,3);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(104,'典型工程查询','../publicInfo/queryHistoryProject.jsp',1,1,4);

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(201,'文件上传','../businessFile/uploadBusinessFile.jsp',2,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(202,'文件查询','../businessFile/schBusinessFileList.do',2,1,2);
 
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(301,'录入项目','../projectManage/preAddProject.do',3,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(302,'查询自己项目','../projectManage/schProjectList.do?projectInfo.queryType=1',3,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(303,'查询部门项目','../projectManage/schProjectList.do?projectInfo.queryType=2',3,1,3);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(304,'查询全部项目','../projectManage/schProjectList.do?projectInfo.queryType=3',3,1,4);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(305,'填写部门成本','',3,1,5);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(306,'显示部门成本','',3,1,6);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(307,'删除部门成本','',3,1,7);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(308,'填写部门奖金','',3,1,8);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(309,'显示部门奖金','',3,1,9);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(310,'删除部门奖金','',3,1,10);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(311,'结束项目','',3,1,11);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(312,'部门经理审批','',3,1,12);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(313,'总师审批','',3,1,13);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(314,'总经理审批','',3,1,14);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(315,'合同操作','',3,1,15);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(316,'项目性质操作','',3,1,16);


INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(401,'新增员工','../employeeManage/newUserInfo.do',4,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(402,'查询员工','../employeeManage/listUserInfo.do',4,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(403,'新增职务','../employeeManage/addRole.jsp',4,1,3);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(404,'查询职务','../employeeManage/listRole.do',4,1,4);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(405,'新增部门','../department/addDepartment.jsp',4,1,5);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(406,'查询部门','../department/schAdminDeptList.do',4,1,6);

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(501,'ISO文件上传','../systemManage/listNews.do',5,1,1);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(502,'发布通知','../systemManage/publishMessage.jsp',5,1,2);
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_INDEX)
VALUES(503,'日志查询','../systemManage/queryLog.jsp',5,1,3);

insert into ADMIN_ROLE (ROLE_ID, ROLE_NAME, ROLE_COUNT, ROLE_REMARK) values('1','董事长','1','董事长专用');

insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','1');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','101');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','102');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','103');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','104');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','2');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','201');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','202');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','3');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','301');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','302');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','303');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','304');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','305');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','306');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','307');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','308');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','309');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','310');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','311');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','4');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','401');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','402');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','403');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','404');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','405');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','406');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','5');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','501');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','502');
insert into ROLE_MENU_RESTRACTION (`ROLE_ID`, `MENU_ID`) values('1','503');

insert into USER_INFO (`USER_ID`, `USER_REAL_NAME`, `USER_IDENTIFIER`, `USER_NAME`, `USER_SEX`, `USER_IDCARD`, `HUMEN_FILES`, `USER_BIRTHDAY`, `FAMILY_ADDRESS`, `PHONE`, `MOBILE_PHONE`, `PARTY`, `EDU_BACKGROUND`, `SCHOOL`, `MAJOR`, `EDU_COUNTINU`, `GRADUATE_DATE`, `ONBOARD_DATE`, `LEAVE_DATE`, `USER_RELATION`, `USER_STATUS`, `INSURANCE_TYPE`, `USER_REMARK`, `USER_PASSWORD`, `REGISTER_DATE`, `EMAIL`, `ROLE_ID`, `DEPT_ID`, `CERTIFICATION_ID`, `USER_TITLE`) values('1','','','chairman','0','','','0000-00-00 00:00:00','','','','','0','','','0','0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','','0','0','','e10adc3949ba59abbe56e057f20f883e','0000-00-00 00:00:00',NULL,1,NULL,NULL,'0');

insert into ROLE_USER_RESTRACTION (ROLE_ID, USER_ID) values('1','1');