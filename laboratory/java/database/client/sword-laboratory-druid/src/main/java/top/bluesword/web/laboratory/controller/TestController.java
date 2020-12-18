package top.bluesword.web.laboratory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.web.laboratory.dao.TestMapper;

/**
 * @author 李林峰
 */
@RestController
public class TestController {

    @Autowired
    TestMapper testMapper;

    @GetMapping("now")
    public Object now(){
        return testMapper.selectNow();
    }
}
