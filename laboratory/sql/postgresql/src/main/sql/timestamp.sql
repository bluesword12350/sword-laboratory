--https://www.postgresql.org/docs/10/functions-datetime.html#9.9.1

--日期转 unix 纪元 数字时间戳
select extract(epoch from now());

--时间戳格式化为字符串
select to_char(now(),'YYYY-MM-DD HH24:MI:SS TZ');
select to_char(now(),'YYYY-MM-DD HH24:MI:SS OF');

--当前日期
select current_date;

--日期运算
select current_date - interval '6 month';

--日期比较
select date '2020-04-07' >= current_date - interval '6 month'