package top.bluesword.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 李林峰
 */
@RestController
public class RestTestController {

    @GetMapping("test1")
    public ModelAndView test() {
        return new ModelAndView("test");
    }
}
