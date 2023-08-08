package org.springframework.jdbc.core.namedparam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.LaboratoryApplication;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = LaboratoryApplication.class)
public class NamedParameterJdbcTemplateTest {

  @Autowired
  NamedParameterJdbcTemplate jdbcTemplate;

  @Test
  public void contextLoads() {
    String sql = "SELECT 1 where 'a' in (:list)";
    System.out.println(jdbcTemplate.queryForList(sql,Map.of("list",List.of("a","b"))));
  }

}
