INSERT INTO [EAJDBCMONITOR] VALUES (19, 'SELECT  		   sequenceid as sequenceid, fieldname as fieldname, maxid as maxid, remark as remark,  		   pattern as pattern, idtype as idtype 		FROM easequence WHERE fieldname = ''USERID''', '20120825082118', '3', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (933, 'SELECT DISTINCT b.menuid, b.menuname, b.iconcls,b.parentid,b.request,b.sortno,   		                b.expanded,''1'' as authorizelevel, b.icon 		           FROM eamenu b 		          WHERE  b.menuid like ''0101%'' 		       ORDER BY b.sortno asc', '20120825115253', '7', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (934, 'SELECT menuname FROM eamenu WHERE menuid = ''01''', '20120825115253', '2', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (935, 'SELECT DISTINCT b.menuid, b.menuname, b.iconcls,b.parentid,b.request,b.sortno,   		                b.expanded,''1'' as authorizelevel, b.icon 		           FROM eamenu b 		          WHERE  b.menuid like ''0102%'' 		       ORDER BY b.sortno asc', '20120825115253', '20', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (936, 'SELECT menuname FROM eamenu WHERE menuid = ''01''', '20120825115253', '2', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (937, 'SELECT DISTINCT b.menuid, b.menuname, b.iconcls,b.parentid,b.request,b.sortno,   		                b.expanded,''1'' as authorizelevel, b.icon 		           FROM eamenu b 		          WHERE  b.menuid like ''0103%'' 		       ORDER BY b.sortno asc', '20120825115253', '3', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (938, 'SELECT menuname FROM eamenu WHERE menuid = ''01''', '20120825115253', '1', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (939, 'UPDATE easequence SET maxid = ''100000000033515'' WHERE fieldname = ''EVENTID''', '20120825115253', '2', '1', '2');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (940, 'UPDATE easequence SET maxid = ''100000000033516'' WHERE fieldname = ''EVENTID''', '20120825115253', '1', '1', '2');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (941, 'INSERT INTO eaevent ( 		   eventid, userid, account,  		   username, description, activetime,requestpath,methodname,costtime)  		VALUES (''100000000033516'', ''10000001'', ''developer'',  		   ''开发人员', ''开发人员[developer]调用了Action方法[indexInit]'', 20120825115253,''/G4Studio/index.ered'',''indexInit'',406)', '20120825115253', '3', '1', '1');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (942, 'SELECT theme FROM eausersubinfo 		  WHERE userid = ''10000001''', '20120825115254', '2', '-1', '4');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (943, 'UPDATE easequence SET maxid = ''100000000033517'' WHERE fieldname = ''EVENTID''', '20120825115254', '11', '1', '2');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (944, 'UPDATE easequence SET maxid = ''100000000033518'' WHERE fieldname = ''EVENTID''', '20120825115254', '2', '1', '2');
GO
INSERT INTO [EAJDBCMONITOR] VALUES (945, 'INSERT INTO eaevent ( 		   eventid, userid, account,  		   username, description, activetime,requestpath,methodname,costtime)  		VALUES (''100000000033518'', ''10000001'', ''developer'',  		   ''开发人员', ''开发人员[developer]调用了Action方法[preferencesInit]'', 20120825115254,''/G4Studio/index.ered'',''preferencesInit'',116)', '20120825115254', '3', '1', '1');
GO
