1. 创建用户
   ```mysql
   CREATE USER 'username'@'host' IDENTIFIED BY 'password';
   ```

2. 授权
   ```mysql
   GRANT all ON database_name.tablename TO 'username'@'host';
   ```

3. 设置用户密码
   ```mysql
   SET PASSWORD FOR 'username'@'host' = PASSWORD('new password');
   alter user 'username' identified by 'new password';
   alter user user() identified by 'new password'
   ```

4. 删除用户
   ```mysql
   DROP USER 'username'@'host';
   ```
   
5. 查询用户
   ```mysql
   select host,user,password from mysql.user;
   ```

