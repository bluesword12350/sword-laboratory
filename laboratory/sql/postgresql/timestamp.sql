--日期转 unix 纪元 数字时间戳
select extract(epoch from now());

--时间戳格式化为字符串
select to_char(now(),'YYYY-MM-DD HH24:MI:SS TZ');
select to_char(now(),'YYYY-MM-DD HH24:MI:SS OF');