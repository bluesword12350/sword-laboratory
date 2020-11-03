--https://www.postgresql.org/docs/10/functions-datetime.html#9.9.1

--可选时区列表
select * from pg_timezone_names;

--日期转 unix 纪元 数字时间戳
select extract(epoch from now());

--时间戳格式化为字符串
select to_char(now(),'YYYY-MM-DD HH24:MI:SS.MS TZ');
select to_char(now(),'YYYY-MM-DD HH24:MI:SS.MS OF');

--字符串转时间戳
select TIMESTAMP WITH TIME ZONE '2020-11-03 10:08:21.890+08';
select to_char(TIMESTAMP '2020-11-03 10:08:21.890','YYYY-MM-DD HH24:MI:SS.MS OF');

--当前日期
select current_date;
select current_time;
SELECT current_timestamp,localtimestamp;

--日期运算
--https://www.postgresql.org/docs/13/functions-datetime.html
select current_date - interval '6 month';
select current_date + 1,current_date + interval '1 day';

--日期比较
select date '2020-04-07' >= current_date - interval '6 month';
