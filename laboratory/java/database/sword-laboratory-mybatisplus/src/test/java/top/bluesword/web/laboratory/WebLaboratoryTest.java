package top.bluesword.web.laboratory;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.bluesword.web.laboratory.entity.User;
import top.bluesword.web.laboratory.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebLaboratoryTest {

	@Autowired
	UserService userService;

    @Test
    public void list() {
        System.out.println(1);
		User user = new User();
		user.setUsername("测试用户");

		System.out.println(JSON.toJSONString(userService.list(new QueryWrapper<>(user))));

		System.out.println(JSON.toJSONString(userService.list(
				new QueryWrapper<User>().select("password").like("username","测试用户")
				)));
	}
	
	@Test
	public void save() {
		User user = new User();
		user.setPassword("2334");
		user.setState(1);
		user.setUsername("测试用户");
		userService.save(user);
	}

}