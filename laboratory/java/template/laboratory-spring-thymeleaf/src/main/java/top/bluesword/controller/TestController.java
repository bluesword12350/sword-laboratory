package top.bluesword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 李林峰
 */
@Controller
public class TestController {

    @GetMapping("test0")
    public String test() {
        return "test";
    }
}
