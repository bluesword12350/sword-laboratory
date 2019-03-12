package top.bluesword.web.laboratory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.web.laboratory.service.UserService;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("all")
    public Object all(){
        return userService.list();
    }
}
