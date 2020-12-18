package top.bluesword.web.laboratory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebLaboratoryTest {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void contextLoads() {
		String sql = "SELECT 1";
		System.out.println(jdbcTemplate.queryForList(sql));
	}
}