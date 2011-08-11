//都有哪些用户上传过数据
select * from USER_INFO where ID in(select distinct(USER_INFO_ID) from USER_PROJECT_DATA);