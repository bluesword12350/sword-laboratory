package top.bluesword.web.laboratory.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.bluesword.web.laboratory.service.HelloService;

/**
 * @author 李林峰
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    HelloService helloService;

    @Override
    public void run(ApplicationArguments args) {
        helloService.startUp();
    }
}
