DROP TABLE IF EXISTS ADMIN_LOG;

CREATE TABLE ADMIN_LOG (
  LOG_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
  USER_NAME               -- 用户的名称
  ACTION_TYPE     BIGINT(15) NOT NULL default '0',        -- 操作类型。参考ActionTypeEnum
  USER_IP         varchar(15)        -- 用户IP 
  LOG_TIME        TIMESTAMP        -- 操作时间
  MODULE_ID       INT(11) NOT NULL default '0',        -- 模块ID
  LOG_REMARK      varchar(255) default NULL,          -- 详细信息
  PRIMARY KEY  (LOG_ID)
) DEFAULT CHARSET = UTF8;

CREATE TABLE ADMIN_ROLE (
  ROLE_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
  ROLE_NAME varchar(100) NOT NULL,
  IS_UNIQUE tinyint(1) NOT NULL default '0',
  ROLE_REMARK varchar(255) default NULL,
  PRIMARY KEY  (role_id)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk;

CREATE TABLE USER_INFO 
(
	ID BIGINT(15) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	USER_NAME VARCHAR(50) NOT NULL,                        
	USER_PASSWORD VARCHAR(200) NOT NULL,                  
	REGISTER_DATE TIMESTAMP,  							   
	EXPIRE_DATE TIMESTAMP, 								   
	EMAIL  VARCHAR(100), 								   
	COMPANY VARCHAR(100),								   
	PHONE  VARCHAR(50),									   
	LAST_PAY_DATE TIMESTAMP,			
	QUESTION VARCHAR(200),								   
	ANSWER VARCHAR(200), 
	SERVICE_PLAN_ID BIGINT(15), 
	PC_MAC VARCHAR(100), 
	MOBILE_IDENTIFY VARCHAR(100),
	CONSTRAINT USER_INFO_FK1 FOREIGN KEY (SERVICE_PLAN_ID) REFERENCES SERVICE_PLAN (ID)
)DEFAULT CHARSET=UTF8;
  
CREATE TABLE ADMIN_MENU (
  LOG_ID BIGINT(15) NOT NULL AUTO_INCREMENT,
  USER_NAME               -- 用户的名称
  ACTION_TYPE     INT(11) NOT NULL default '0',        -- 操作类型。参考ActionTypeEnum
  USER_IP         varchar(15)        -- 用户IP 
  LOG_TIME        TIMESTAMP        -- 操作时间
  MODULE_ID       INT(11) NOT NULL default '0',        -- 模块ID
  LOG_MEMO                -- 详细信息
  PRIMARY KEY  (LOG_ID)
) DEFAULT CHARSET = UTF8;