DROP TABLE IF EXISTS ROLE_MENU_RESTRACTION;
DROP TABLE IF EXISTS ADMIN_MENU;
DROP TABLE IF EXISTS ADMIN_LOG;
DROP TABLE IF EXISTS USER_INFO;
DROP TABLE IF EXISTS ADMIN_ROLE;
DROP TABLE IF EXISTS ADMIN_DEPT;

CREATE TABLE ADMIN_MENU (
  MENU_ID INT(5) NOT NULL AUTO_INCREMENT,
  MENU_NAME varchar(100) NOT NULL default '',
  MENU_URL varchar(255) NOT NULL default '',
  PARENT_MENU_ID INT(5) NOT NULL default '0',
  MENU_ENABLE tinyint(1) NOT NULL default '1',
  MENU_INDEX INT(5),
  PRIMARY KEY  (MENU_ID)
) ENGINE=MyISAM DEFAULT CHARSET = UTF8;

CREATE TABLE ADMIN_LOG (
  LOG_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
  USER_NAME VARCHAR(50) NOT NULL,               
  ACTION_TYPE     BIGINT(15) NOT NULL default '0',        
  USER_IP         varchar(15),        
  LOG_TIME        TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',      
  MODULE_ID       INT(11) NOT NULL default '0',        
  LOG_REMARK      varchar(100) default NULL,          
  PRIMARY KEY (LOG_ID)
) ENGINE=MyISAM DEFAULT CHARSET = UTF8;

CREATE TABLE ADMIN_ROLE (
  ROLE_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
  ROLE_NAME varchar(100) NOT NULL,
  ROLE_COUNT tinyint(1) NOT NULL default '0',
  ROLE_REMARK varchar(255) default NULL,
  PRIMARY KEY (ROLE_ID)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

CREATE TABLE ROLE_MENU_RESTRACTION (
  ROLE_ID BIGINT(15),
  MENU_ID BIGINT(15), 
  CONSTRAINT ADMIN_ROLE_FK1 FOREIGN KEY (ROLE_ID) REFERENCES ADMIN_ROLE(ROLE_ID),
  CONSTRAINT ADMIN_MENU_FK1 FOREIGN KEY (MENU_ID) REFERENCES ADMIN_MENU(MENU_ID)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

CREATE TABLE ADMIN_DEPT (
	DEPT_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
	DEPT_NAME VARCHAR(50) NOT NULL,
	DEPT_REMARK varchar(255) default NULL,
	PRIMARY KEY (DEPT_ID)
) ENGINE=MyISAM DEFAULT CHARSET = UTF8;

CREATE TABLE USER_INFO 
(
	USER_ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	USER_NAME VARCHAR(50) NOT NULL,                        
	USER_PASSWORD VARCHAR(200) NOT NULL,                  
	REGISTER_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00', 							   
	EXPIRE_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',							   
	EMAIL  VARCHAR(100), 								   
	COMPANY VARCHAR(100),								   
	PHONE  VARCHAR(50),									   
	QUESTION VARCHAR(200),								   
	ANSWER VARCHAR(200), 
	STATUS TINYINT(1) NOT NULL, 
	MOBILE_IDENTIFY VARCHAR(100),
	DEPT_ID BIGINT(15) NOT NULL, 
	ROLE_ID BIGINT(15) NOT NULL, 
	CONSTRAINT ADMIN_DEPT_FK1 FOREIGN KEY (DEPT_ID) REFERENCES ADMIN_DEPT(DEPT_ID),
	CONSTRAINT ADMIN_ROLE_FK2 FOREIGN KEY (ROLE_ID) REFERENCES ADMIN_ROLE(ROLE_ID)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;
  
