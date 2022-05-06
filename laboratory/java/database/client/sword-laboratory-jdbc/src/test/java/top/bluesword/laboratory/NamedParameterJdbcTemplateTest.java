package top.bluesword.laboratory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class NamedParameterJdbcTemplateTest {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
        String sql = "SELECT 1 where 'a' in (:list)";
        System.out.println(jdbcTemplate.queryForList(sql,Map.of("list",List.of("a","b"))));
    }

}
