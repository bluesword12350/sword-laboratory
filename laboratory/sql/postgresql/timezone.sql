--查看服务器时区
show timezone;

--查询设置时区（‘-’为东，‘+’为西）
select now() at time zone '-08:00';