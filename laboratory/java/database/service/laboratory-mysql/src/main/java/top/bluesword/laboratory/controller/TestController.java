package top.bluesword.laboratory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.bluesword.laboratory.entity.User;
import top.bluesword.laboratory.dao.UserMapper;

/**
 * 主页
 * @author 李林峰
 */
@RestController
public class TestController {

	@Autowired UserMapper userMapper;

    @RequestMapping("test")
    public List<User> test(HttpServletRequest rs) {
        return userMapper.getUserAndRole();
    }

}