1. 创建用户
   ```mysql
   CREATE USER 'username'@'host' IDENTIFIED BY 'password';
   ```

2. 授权

   ```mysql
   GRANT privileges ON databasename.tablename TO 'username'@'host';
   ```

3. 设置用户密码

   ```mysql
   SET PASSWORD FOR 'username'@'host' = PASSWORD('newpassword');
   ```

4. 删除用户

   ```mysql
   DROP USER 'username'@'host';
   ```

