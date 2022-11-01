package top.bluesword.laboratory.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.laboratory.model.InstantTestModel;

/**
 * @author 李林峰
 */
@Slf4j
@RestController
@RequestMapping("instant-test")
public class InstantTestController {

    @GetMapping
    InstantTestModel getTest(InstantTestModel instantTestModel){
        log.info("{}",instantTestModel);
        return instantTestModel;
    }

}
