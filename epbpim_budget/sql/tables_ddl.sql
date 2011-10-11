USE EPBPIM_BUDGET;

DROP TABLE IF EXISTS ADMIN_LOG;
DROP TABLE IF EXISTS ADMIN_MENU;
DROP TABLE IF EXISTS PROVINCE_CITY;
DROP TABLE IF EXISTS ADMIN_USER;
DROP TABLE IF EXISTS USER_MENU_RESTRACTION;
DROP TABLE IF EXISTS USER_INFO;
DROP TABLE IF EXISTS ENTERPRISE_INFO;
DROP TABLE IF EXISTS GOVERNMENT_FILE;
DROP TABLE IF EXISTS GOVERNMENT_INVENTORY;
DROP TABLE IF EXISTS NEWS_ANNOUNCEMENT;
DROP TABLE IF EXISTS USER_ADVINCE;
DROP TABLE IF EXISTS PRICEPACKAGE_FILE;
DROP TABLE IF EXISTS PERIODICAL_FILE;
DROP TABLE IF EXISTS GUIDE_PRICE;

-- 菜单表。显示菜单
CREATE TABLE ADMIN_MENU (
  MENU_ID INT(5) NOT NULL,
  MENU_NAME varchar(100) NOT NULL default '',
  MENU_URL varchar(255) NOT NULL default '',
  PARENT_MENU_ID INT(5) NOT NULL default '0',
  MENU_ENABLE tinyint(1) NOT NULL default '1',
  MENU_DEFAULT tinyint(1) NOT NULL default '0',-- 是否显示. 1 任何人登录都会显示 0根据权限登录显示
  MENU_REGION INT(5), -- 和省市数据库关联。手动建立关系
  MENU_INDEX INT(5),
  MENU_PRICE INT(5),
  TITLE VARCHAR(100),
  DESCRIPTION VARCHAR(1000),
  REGISTER_DATE TIMESTAMP DEFAULT '0000-00-00 00:00:00',
  ADVICE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY  (MENU_ID)
) ENGINE=MyISAM DEFAULT CHARSET = UTF8;

-- 日志表。记录用户在系统中的操作
CREATE TABLE ADMIN_LOG (
  LOG_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
  USER_NAME VARCHAR(50) NOT NULL,               
  ACTION_TYPE     INT(15) NOT NULL default '0',        
  USER_IP         varchar(15),        
  LOG_TIME        TIMESTAMP DEFAULT '0000-00-00 00:00:00',      
  MODULE_ID       INT(11) NOT NULL default '0',        
  LOG_REMARK      varchar(100) default NULL,          
  PRIMARY KEY (LOG_ID)
) ENGINE=MyISAM DEFAULT CHARSET = UTF8;

-- 省级数据库
CREATE TABLE PROVINCE_CITY (
	PROVINCE_ID INT( 10 ) NOT NULL AUTO_INCREMENT,
	CITY VARCHAR( 50 ) NOT NULL ,
	PARENT_ID INT NOT NULL DEFAULT '0',
	SORT INT( 5 ) NOT NULL DEFAULT '1',
	ENABLE TINYINT( 1 ) NOT NULL DEFAULT '1',
	PRIMARY KEY (PROVINCE_ID)
) ENGINE=MYISAM DEFAULT CHARSET=UTF8;

-- 企业信息表
CREATE TABLE ENTERPRISE_INFO (
  ENTERPRISE_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
  ENTERPRISE_NAME varchar(100),
  ENTERPRISE_EMAIL varchar(50),
  ENTERPRISE_PHONE varchar(20),
  ENTERPRISE_PRINCIPAL varchar(20),
  ENTERPRISE_FAVORITE INT(10),
  ENTERPRISE_BALANCE NUMERIC(10,2) DEFAULT 0,
  INSERT_TIME TIMESTAMP DEFAULT '0000-00-00 00:00:00',
  UPDATE_TIME TIMESTAMP DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (ENTERPRISE_ID),
  CONSTRAINT ENTERPRISE_INFO_FK1 FOREIGN KEY (ENTERPRISE_FAVORITE) REFERENCES PROVINCE_CITY(PROVINCE_ID)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

-- 员工表
CREATE TABLE USER_INFO
(
	USER_ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	USER_REAL_NAME VARCHAR(50),         -- 真实姓名
	USER_IDENTIFIER VARCHAR(30),     	 		 -- 员工编号
	USER_NAME VARCHAR(50),  			 -- 用户名
	USER_SEX INT(1),					 -- 性别
	USER_IDCARD VARCHAR(20),			 -- 身份证
	USER_BIRTHDAY TIMESTAMP DEFAULT '0000-00-00 00:00:00',  -- 生日
	FAMILY_ADDRESS VARCHAR(100),				 -- 家庭住址
	MOBILE_PHONE VARCHAR(50),					 -- 手机
	USER_REMARK VARCHAR(255),					 -- 备注
	USER_PASSWORD VARCHAR(200) DEFAULT 'e10adc3949ba59abbe56e057f20f883e',		 -- 密码
	REGISTER_DATE TIMESTAMP DEFAULT '0000-00-00 00:00:00', -- 注册时间
	EMAIL  VARCHAR(100), 								   
	ROLE_ID VARCHAR(30),		 -- 对应roleEnum    1普通用户，2企业用户，3管理员
	ENABLE INT(2) DEFAULT 1,								-- 是否可用 0不可用 1可用
	ENTERPRISE_ID BIGINT(15) NOT NULL,
	CONSTRAINT USER_INFO_FK1 FOREIGN KEY (ENTERPRISE_ID) REFERENCES ENTERPRISE_INFO(ENTERPRISE_ID)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

-- 省市员工中间表 对应
CREATE TABLE USER_PROVINCE_RESTRACTION (
  USER_ID BIGINT(15),
  PROVINCE_ID BIGINT(15), 
  CONSTRAINT USER_PROVINCE_RESTRACTION_FK1 FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID),
  CONSTRAINT USER_PROVINCE_RESTRACTION_FK2 FOREIGN KEY (PROVINCE_ID) REFERENCES PROVINCE_CITY(PROVINCE_ID)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

-- 菜单员工中间表 对应
CREATE TABLE USER_MENU_RESTRACTION (
  USER_ID BIGINT(15),
  MENU_ID BIGINT(15), 
  REGISTER_DATE TIMESTAMP DEFAULT '0000-00-00', -- 订阅时间
  EXPIRE_DATE TIMESTAMP DEFAULT '0000-00-00', -- 过期时间
  CONSTRAINT USER_MENU_RESTRACTION_FK1 FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID),
  CONSTRAINT USER_MENU_RESTRACTION_FK2 FOREIGN KEY (MENU_ID) REFERENCES ADMIN_MENU(MENU_ID)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

-- 管理员表
CREATE TABLE ADMIN_USER 
(
	ADMIN_USER_ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	ADMIN_USER_REAL_NAME VARCHAR(50) NOT NULL,         -- 真实姓名
	ADMIN_USER_NAME VARCHAR(50) NOT NULL,  			 -- 用户名
	ADMIN_MOBILE_PHONE VARCHAR(50),					 -- 手机
	ADMIN_USER_REMARK VARCHAR(255),					 -- 备注
	ADMIN_USER_PASSWORD VARCHAR(200) DEFAULT '123456',		 -- 密码
	ADMIN_REGISTER_DATE TIMESTAMP DEFAULT '0000-00-00 00:00:00', -- 注册时间
	ADMIN_EMAIL  VARCHAR(100)					   
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

-- 充值记录表
CREATE TABLE PAY_RECORD
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	ENTERPRISE_ID BIGINT(15) NOT NULL, 
	BALANCE NUMERIC(10,2) NOT NULL, 
	BALANCE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00', 
	USER_IDENTIFIER VARCHAR(30),
	CONSTRAINT EXPENSE_RECORD_FK1 FOREIGN KEY (ENTERPRISE_ID) REFERENCES ENTERPRISE_INFO (ENTERPRISE_ID)
)ENGINE=MyISAM DEFAULT CHARSET=UTF8;

-- 消费记录表
CREATE TABLE EXPENSE_RECORD
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	ENTERPRISE_ID BIGINT(15) NOT NULL, 
	MONEY NUMERIC(10,2) NOT NULL, 
	EXPENSE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00', 
	USER_REAL_NAME VARCHAR(50),
	CONSTRAINT EXPENSE_RECORD_FK1 FOREIGN KEY (ENTERPRISE_ID) REFERENCES ENTERPRISE_INFO (ENTERPRISE_ID)
)ENGINE=MyISAM DEFAULT CHARSET=UTF8;

-- 政府文件表
CREATE TABLE GOVERNMENT_FILE
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	FILE_TITLE VARCHAR(300),
	FILE_TYPE VARCHAR(10),
	FILE_SUB_TYPE VARCHAR(10),
	AREA VARCHAR(10),
	SOURCE_CODE MEDIUMTEXT,
	FILE_PUBLISH_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
	FILE_EFFECTIVE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
	EFFECTIVE BOOLEAN
)DEFAULT CHARSET=UTF8;

CREATE TABLE GOVERNMENT_INVENTORY
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	GOVERNMENT_INVENTORY_TYPE VARCHAR(10),
	PROJECT_CLASS_LEVEL_1_NUM VARCHAR(20),
	PROJECT_CLASS_LEVEL_2_NUM VARCHAR(20),
	PROJECT_NUM VARCHAR(20),
	PROJECT_NAME VARCHAR(40),
	PROJECT_NAME_FEATURE VARCHAR(300),
	UNIT VARCHAR(10),
	AMOUNT NUMERIC(8,2),
	DETAIL VARCHAR(200),
	COMMENTS VARCHAR(100)
)DEFAULT CHARSET=UTF8;

CREATE TABLE NEWS_ANNOUNCEMENT
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NEWS_TITLE VARCHAR(100) NOT NULL,
	NEWS_CONTENT VARCHAR(800) NOT NULL, 
	ADD_TIME TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
)DEFAULT CHARSET = UTF8;

CREATE TABLE USER_ADVINCE
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	USER_ID BIGINT(15),	
	ADVICE_CONTENT VARCHAR(1000),
	ADVICE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
)DEFAULT CHARSET=UTF8;

CREATE TABLE PRICEPACKAGE_FILE (
	ID BIGINT(15) NOT NULL AUTO_INCREMENT,
	PRICEPACKAGE_NAME VARCHAR(50) NOT NULL,
	PRICEPACKAGE_PATH VARCHAR(100) NOT NULL,
	PRICEPACKAGE_PROVICE VARCHAR(50),
	PRICEPACKAGE_TYPE VARCHAR(50),
	PRICEPACKAGE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00',
	UPLOAD_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
	PRIMARY KEY (ID)
) ENGINE=MyISAM DEFAULT CHARSET = UTF8;

CREATE TABLE PERIODICAL_FILE
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	PERIODICAL_NAME VARCHAR(300),
	PERIODICAL_PROVICE VARCHAR(50),
	PERIODICAL_TYPE VARCHAR(50),
	PERIODICAL_URL VARCHAR(300),
	PERIODICAL_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00',
	UPLOAD_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
)DEFAULT CHARSET=UTF8;

CREATE TABLE GUIDE_PRICE
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	GUIDEPRICE_PROVICE VARCHAR(10),
	GUIDEPRICE_TYPE VARCHAR(10),
	GUIDEPRICE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00',
	CODE VARCHAR(20),
	NAME VARCHAR(200),
	UNIT VARCHAR(20),
	PRICE NUMERIC(10,2) NOT NULL, 
	UN_NAME VARCHAR(20),
	TAG VARCHAR(20),
	UPLOAD_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
)DEFAULT CHARSET=UTF8;
