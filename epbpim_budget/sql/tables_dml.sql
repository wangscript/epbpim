INSERT INTO ADMIN_USER (ADMIN_USER_ID,ADMIN_USER_REAL_NAME,ADMIN_USER_NAME,ADMIN_MOBILE_PHONE,
						ADMIN_USER_REMARK,ADMIN_USER_PASSWORD,ADMIN_REGISTER_DATE)
VALUES(1,'关琛','xxg2guan','13564793256','超级超级管理员',MD5('guan0078'),NOW());
INSERT INTO ADMIN_USER (ADMIN_USER_ID,ADMIN_USER_REAL_NAME,ADMIN_USER_NAME,ADMIN_MOBILE_PHONE,
						ADMIN_USER_REMARK,ADMIN_USER_PASSWORD,ADMIN_REGISTER_DATE)
VALUES(2,'丁宜人','123456','15064793256','超级超级管理员',MD5('123456'),NOW());
INSERT INTO ADMIN_USER (ADMIN_USER_ID,ADMIN_USER_REAL_NAME,ADMIN_USER_NAME,ADMIN_MOBILE_PHONE,
						ADMIN_USER_REMARK,ADMIN_USER_PASSWORD,ADMIN_REGISTER_DATE)
VALUES(3,'应为','yingwei','15164793256','超级超级管理员',MD5('123456'),NOW());

INSERT INTO MAJOR VALUES(1,'土建','');
INSERT INTO MAJOR VALUES(2,'园林','');
INSERT INTO MAJOR VALUES(3,'市政','');
INSERT INTO MAJOR VALUES(4,'安装','');
INSERT INTO MAJOR VALUES(5,'公用','');
INSERT INTO MAJOR VALUES(6,'水利','');
INSERT INTO MAJOR VALUES(7,'人防','');
INSERT INTO MAJOR VALUES(8,'房修','');
INSERT INTO MAJOR VALUES(9,'公路','');

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
-- INSERT INTO PROVINCE_CITY VALUES(11,'江苏省',0,11,1);
-- INSERT INTO PROVINCE_CITY VALUES(12,'浙江省',0,12,1);
-- INSERT INTO PROVINCE_CITY VALUES(13,'安徽省',0,13,1);
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
VALUES(99,'基础信息','',0,1,1,3,1,0,'基础信息查询','基础信息查询模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(1,'土建','',0,1,1,3,2,0,'土建','土建模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(2,'园林','',0,1,1,3,3,0,'园林','园林模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(3,'市政','',0,1,1,3,4,0,'市政','市政模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(4,'安装','',0,1,1,3,5,0,'安装','安装模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(5,'公用','',0,1,1,3,6,0,'公用','公用模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(6,'水利','',0,1,1,3,7,0,'水利','水利模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(7,'人防','',0,1,1,3,8,0,'人防','人防模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(8,'房修','',0,1,1,3,9,0,'房修','房修模块',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(9,'公路','',0,1,1,3,10,0,'公路','公路模块',NOW(),NOW());

INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(9901,'2003清单','searchGovernmentInventory.do?condition.governmentInventoryType=2003',99,1,1,3,1,0,'2003清单','2003清单查询',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(9902,'2008清单','searchGovernmentInventory.do?condition.governmentInventoryType=2008',99,1,1,3,2,0,'2008清单','2008清单查询',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(9903,'法律文件','searchGovernmentFile.do',99,1,1,3,3,0,'法律文件','法律文件查询',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(9904,'定额信息','searchGovernmentQuota.do',99,1,1,3,4,0,'定额信息','定额信息查询',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(9905,'专业书籍信息','searchBook.do',99,1,1,3,5,0,'专业书籍信息','专业书籍查询',NOW(),NOW());

-- INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
-- VALUES(201,'信息价查询','searchGuidePrice.do?guidePrice.guidePriceType=1&guidePrice.provinceCity.id=3',2,1,0,3,1,400,'信息价查询','市政信息价查询说明',NOW(),NOW());
-- INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
-- VALUES(202,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=1&periodicalFile.provinceCity.id=3',2,1,0,3,2,300,'专业期刊','市政专业期刊说明',NOW(),NOW());
-- INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
-- VALUES(203,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=1&pricePackageFile.provinceCity.id=3',2,1,0,3,3,300,'价格包下载','市政价格包下载说明',NOW(),NOW());

-- INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
-- VALUES(302,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=3&periodicalFile.provinceCity.id=3',3,1,0,3,2,300,'专业期刊','土建专业期刊说明',NOW(),NOW());
-- INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
-- VALUES(303,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=3&pricePackageFile.provinceCity.id=3',3,1,0,3,3,300,'价格包下载','土建价格包下载说明',NOW(),NOW());

-- INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
-- VALUES(401,'信息价查询','searchGuidePrice.do?guidePrice.guidePriceType=2&guidePrice.provinceCity.id=3',4,1,0,3,1,400,'信息价查询','园林信息价查询说明',NOW(),NOW());

-- 土建
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(102,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=1&periodicalFile.provinceCity.id=3',1,1,0,3,2,300,'土建专业期刊','土建专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(103,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=1&pricePackageFile.provinceCity.id=3',1,1,0,3,3,300,'土建价格包下载','土建价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(104,'信息价查询','searchGuideData.do?guideData.major.id=1&guideData.provinceCity.id=3',1,1,0,3,4,300,'土建信息价查询','土建信息价查询说明',NOW(),NOW());

-- 园林
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(202,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=2&periodicalFile.provinceCity.id=3',2,1,0,3,2,300,'园林专业期刊','园林专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(203,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=2&pricePackageFile.provinceCity.id=3',2,1,0,3,3,300,'价格包下载','园林价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(204,'信息价查询','searchGuideData.do?guideData.major.id=2&guideData.provinceCity.id=3',2,1,0,3,4,300,'园林信息价查询','园林信息价查询说明',NOW(),NOW());

-- 市政
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(302,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=3&periodicalFile.provinceCity.id=3',3,1,0,3,2,300,'市政专业期刊','市政专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(303,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=3&pricePackageFile.provinceCity.id=3',3,1,0,3,3,300,'市政价格包下载','市政价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(304,'信息价查询','searchGuideData.do?guideData.major.id=3&guideData.provinceCity.id=3',3,1,0,3,4,300,'市政信息价查询','市政信息价查询说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(305,'指导价查询','searchGuidePrice.do?guidePrice.major.id=3',3,1,0,3,5,300,'市政指导价查询','市政指导价查询说明',NOW(),NOW());

-- 安装
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(402,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=4&periodicalFile.provinceCity.id=3',4,1,0,3,2,300,'安装专业期刊','安装专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(403,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=4&pricePackageFile.provinceCity.id=3',4,1,0,3,3,300,'安装价格包下载','安装价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(404,'信息价查询','searchGuideData.do?guideData.major.id=4&guideData.provinceCity.id=3',4,1,0,3,4,300,'安装信息价查询','安装信息价查询说明',NOW(),NOW());

-- 公用
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(502,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=5&periodicalFile.provinceCity.id=3',5,1,0,3,2,300,'公用专业期刊','公用专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(503,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=5&pricePackageFile.provinceCity.id=3',5,1,0,3,3,300,'公用价格包下载','公用价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(504,'信息价查询','searchGuideData.do?guideData.major.id=5&guideData.provinceCity.id=3',5,1,0,3,4,300,'公用信息价查询','公用信息价查询说明',NOW(),NOW());

-- 水利
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(602,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=6&periodicalFile.provinceCity.id=3',6,1,0,3,2,300,'水利专业期刊','水利专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(603,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=6&pricePackageFile.provinceCity.id=3',6,1,0,3,3,300,'水利价格包下载','水利价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(604,'信息价查询','searchGuideData.do?guideData.major.id=6&guideData.provinceCity.id=3',6,1,0,3,4,300,'水利信息价查询','水利信息价查询说明',NOW(),NOW());

-- 人防
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(702,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=7&periodicalFile.provinceCity.id=3',7,1,0,3,2,300,'人防专业期刊','人防专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(703,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=7&pricePackageFile.provinceCity.id=3',7,1,0,3,3,300,'人防价格包下载','人防价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(704,'信息价查询','searchGuideData.do?guideData.major.id=7&guideData.provinceCity.id=3',7,1,0,3,4,300,'人防信息价查询','人防信息价查询说明',NOW(),NOW());

-- 房修
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(802,'专业期刊','searchPeriodicalFile.do?periodicalFile.major.id=8&periodicalFile.provinceCity.id=3',8,1,0,3,2,300,'房修专业期刊','房修专业期刊说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(803,'价格包下载','searchPricePackageFile.do?pricePackageFile.major.id=8&pricePackageFile.provinceCity.id=3',8,1,0,3,3,300,'房修价格包下载','房修价格包下载说明',NOW(),NOW());
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(804,'信息价查询','searchGuideData.do?guideData.major.id=8&guideData.provinceCity.id=3',8,1,0,3,4,300,'房修信息价查询','房修信息价查询说明',NOW(),NOW());

--公路
INSERT INTO ADMIN_MENU (MENU_ID,MENU_NAME,MENU_URL,PARENT_MENU_ID,MENU_ENABLE,MENU_DEFAULT,MENU_REGION,MENU_INDEX,MENU_PRICE,TITLE,DESCRIPTION,REGISTER_DATE,ADVICE_DATE)
VALUES(902,'指导价查询','searchGuidePrice.do?guidePrice.major.id=3',9,1,0,3,2,300,'公路指导价查询','公路指导价查询说明',NOW(),NOW());

