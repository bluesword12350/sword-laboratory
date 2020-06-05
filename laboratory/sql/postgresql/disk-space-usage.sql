-- 查询值占用的字节数（压缩后）
select pg_column_size(120.4135465);

-- 查询指定表使用的磁盘空间，不包括索引（但包括TOAST，可用空间图和可见性图）
select pg_table_size('#{tableName}');

-- 查询指定表使用的总磁盘空间，包括所有索引和TOAST数据
select pg_total_relation_size('#{tableName}');

-- 将以数值表示的字节大小转换为具有大小单位的人类可读格式
select pg_size_pretty('#{sizeNumber}')