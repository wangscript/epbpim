INSERT INTO ADMIN_USER (ADMIN_USER_ID,ADMIN_USER_REAL_NAME,ADMIN_USER_NAME,ADMIN_MOBILE_PHONE,
						ADMIN_USER_REMARK,ADMIN_USER_PASSWORD,ADMIN_REGISTER_DATE)
VALUES(1,'关琛','xxg2guan','13564793256','超级超级管理员',MD5('guan0078'),NOW());
INSERT INTO ADMIN_USER (ADMIN_USER_ID,ADMIN_USER_REAL_NAME,ADMIN_USER_NAME,ADMIN_MOBILE_PHONE,
						ADMIN_USER_REMARK,ADMIN_USER_PASSWORD,ADMIN_REGISTER_DATE)
VALUES(2,'丁宜人','123456','15064793256','超级超级管理员',MD5('123456'),NOW());
INSERT INTO ADMIN_USER (ADMIN_USER_ID,ADMIN_USER_REAL_NAME,ADMIN_USER_NAME,ADMIN_MOBILE_PHONE,
						ADMIN_USER_REMARK,ADMIN_USER_PASSWORD,ADMIN_REGISTER_DATE)
VALUES(3,'应为','yingwei','15164793256','超级超级管理员',MD5('123456'),NOW());

-- INSERT INTO PROVINCE_CITY VALUES(1,'北京市',0,1,1);
-- INSERT INTO PROVINCE_CITY VALUES(2,'天津市',0,2,1);
INSERT INTO PROVINCE_CITY VALUES(3,'上海市',0,3,1);
-- INSERT INTO PROVINCE_CITY VALUES(4,'重庆市',0,4,1);
-- INSERT INTO PROVINCE_CITY VALUES(5,'河北省',0,5,1);
-- INSERT INTO PROVINCE_CITY VALUES(6,'山西省',0,6,1);
-- INSERT INTO PROVINCE_CITY VALUES(7,'台湾省',0,7,1);
-- INSERT INTO PROVINCE_CITY VALUES(8,'辽宁省',0,8,1);
-- INSERT INTO PROVINCE_CITY VALUES(9,'吉林省',0,9,1);
-- INSERT INTO PROVINCE_CITY VALUES(10,'黑龙江省',0,10,1);
INSERT INTO PROVINCE_CITY VALUES(11,'江苏省',0,11,1);
INSERT INTO PROVINCE_CITY VALUES(12,'浙江省',0,12,1);
INSERT INTO PROVINCE_CITY VALUES(13,'安徽省',0,13,1);
-- INSERT INTO PROVINCE_CITY VALUES(14,'福建省',0,14,1);
-- INSERT INTO PROVINCE_CITY VALUES(15,'江西省',0,15,1);
-- INSERT INTO PROVINCE_CITY VALUES(16,'山东省',0,16,1);
-- INSERT INTO PROVINCE_CITY VALUES(17,'河南省',0,17,1);
-- INSERT INTO PROVINCE_CITY VALUES(18,'湖北省',0,18,1);
-- INSERT INTO PROVINCE_CITY VALUES(19,'湖南省',0,19,1);
-- INSERT INTO PROVINCE_CITY VALUES(20,'广东省',0,20,1);
-- INSERT INTO PROVINCE_CITY VALUES(21,'甘肃省',0,21,1);
-- INSERT INTO PROVINCE_CITY VALUES(22,'四川省',0,22,1);
-- INSERT INTO PROVINCE_CITY VALUES(23,'贵州省',0,23,1);
-- INSERT INTO PROVINCE_CITY VALUES(24,'海南省',0,24,1);
-- INSERT INTO PROVINCE_CITY VALUES(25,'云南省',0,25,1);
-- INSERT INTO PROVINCE_CITY VALUES(26,'青海省',0,26,1);
-- INSERT INTO PROVINCE_CITY VALUES(27,'陕西省',0,27,1);
-- INSERT INTO PROVINCE_CITY VALUES(28,'广西壮族自治区',0,28,1);
-- INSERT INTO PROVINCE_CITY VALUES(29,'西藏自治区',0,29,1);
-- INSERT INTO PROVINCE_CITY VALUES(30,'宁夏回族自治区',0,30,1);
-- INSERT INTO PROVINCE_CITY VALUES(31,'新疆维吾尔自治区',0,31,1);
-- INSERT INTO PROVINCE_CITY VALUES(32,'内蒙古自治区',0,32,1);
-- INSERT INTO PROVINCE_CITY VALUES(33,'澳门特别行政区',0,33,1);
-- INSERT INTO PROVINCE_CITY VALUES(34,'香港特别行政区',0,34,1);

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(1,'基础信息查询','',0,1,0,3,0,0,'基础信息查询','基础信息查询模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(2,'市政','',0,1,0,3,1,0,'市政','市政模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(3,'土建','',0,1,0,3,2,0,'土建','土建模块',NOW(),NOW());

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(101,'2003清单','',1,1,0,3,0,0,'2003清单','2003清单查询',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(102,'2008清单','',1,1,0,3,1,0,'2008清单','2008清单查询',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(103,'法律文件','',1,1,0,3,2,0,'法律文件','法律文件查询',NOW(),NOW());

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(201,'市政信息价查询','',2,1,0,3,0,400,'信息价查询','市政信息价查询说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(202,'市政行业期刊','',2,1,0,3,1,300,'行业期刊','市政行业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(203,'市政价格包下载','',2,1,0,3,2,300,'价格包下载','市政价格包下载说明',NOW(),NOW());

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(301,'土建信息价查询','',3,1,0,3,0,400,'信息价查询','土建信息价查询说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(302,'土建行业期刊','',3,1,0,3,1,300,'行业期刊','土建行业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(303,'土建价格包下载','',3,1,0,3,2,300,'价格包下载','土建价格包下载说明',NOW(),NOW());


--INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
--VALUES(8,'期刊软件','',6,1,0,11,2,1000,'期刊软件','该应用可以帮助您及时掌握行业最新动态',NOW(),NOW());
--INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
--VALUES(9,'期刊软件','',6,1,0,12,3,1000,'期刊软件','该应用可以帮助您及时掌握行业最新动态',NOW(),NOW());
--INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
--VALUES(10,'期刊软件','',6,1,0,13,4,1000,'期刊软件','该应用可以帮助您及时掌握行业最新动态',NOW(),NOW());