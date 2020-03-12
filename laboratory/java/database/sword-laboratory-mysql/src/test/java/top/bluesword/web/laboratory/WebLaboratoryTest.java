package top.bluesword.web.laboratory;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import top.bluesword.web.laboratory.dao.RoleMapper;
import top.bluesword.web.laboratory.dao.UserMapper;
import top.bluesword.web.laboratory.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebLaboratoryTest {

	@Autowired UserMapper userMapper;
	
	@Test
	public void selectAll() {
		List<User> all = userMapper.selectAll();
		System.out.println(JSON.toJSONString(all));
	}
}