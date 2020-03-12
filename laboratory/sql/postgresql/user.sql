--查询用户
    select * from pg_roles;
--创建用户
    CREATE USER postgres SUPERUSER;
--设置用户密码
    ALTER USER postgres WITH PASSWORD 'new password';