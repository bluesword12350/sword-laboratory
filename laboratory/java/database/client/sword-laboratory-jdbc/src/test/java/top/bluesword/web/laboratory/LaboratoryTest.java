package top.bluesword.web.laboratory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class LaboratoryTest {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void contextLoads() {
		String sql = "SELECT 1 where 1 = ? and 'a' in (?)";
		String[] strings = {"a"};
		System.out.println(jdbcTemplate.queryForList(sql,1,strings));
	}
}