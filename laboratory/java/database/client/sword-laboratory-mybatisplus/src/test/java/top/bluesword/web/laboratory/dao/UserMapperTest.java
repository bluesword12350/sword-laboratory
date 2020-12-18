package top.bluesword.web.laboratory.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.bluesword.web.laboratory.entity.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void getUserAndRole(){
        List<User> userAndRole = userMapper.getUserAndRole();
        System.out.println(userAndRole);
    }

    @Test
    public void getAllDiy(){
        List<User> users = userMapper.getAllDiy();
        System.out.println(users);
    }
}