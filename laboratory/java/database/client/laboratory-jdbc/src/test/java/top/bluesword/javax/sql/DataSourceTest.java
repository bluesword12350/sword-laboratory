package top.bluesword.javax.sql;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.LaboratoryApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@SpringBootTest(classes = LaboratoryApplication.class)
public class DataSourceTest {

  @Autowired
  DataSource dataSource;

  @Test
  void test() throws SQLException {
    Connection connection = dataSource.getConnection();
    DatabaseMetaData metaData = connection.getMetaData();
    ResultSet tables = metaData.getTables(null, null, null, null);
    ResultSetMetaData tablesMetaData = tables.getMetaData();
    Set<String> columnNames = new HashSet<>();
    for (int i = 0; i < tablesMetaData.getColumnCount();) {
      String columnName = tablesMetaData.getColumnName(++i);
      columnNames.add(columnName);
    }
    List<Map<String,Object>> resultMap = new ArrayList<>();
    Set<String> postgresqlOriginalSchema = Set.of("pg_catalog","information_schema","pg_toast");
    while (tables.next()) {
      Map<String,Object> map = new HashMap<>();
      String tableSchema = tables.getString("TABLE_SCHEM");
      if (postgresqlOriginalSchema.contains(tableSchema)){
        continue;
      }
      for (String columnName : columnNames) {
        map.put(columnName,tables.getObject(columnName));
      }
      resultMap.add(map);
    }
    for (Map<String, Object> map : resultMap) {
      System.out.println(map);
    }
  }
}
