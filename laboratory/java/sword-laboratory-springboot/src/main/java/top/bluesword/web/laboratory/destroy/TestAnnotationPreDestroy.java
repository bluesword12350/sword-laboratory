package top.bluesword.web.laboratory.destroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.bluesword.web.laboratory.delay.DelayTaskEngine;

import javax.annotation.PreDestroy;

/**
 * @author 李林峰
 */
@Component
public class TestAnnotationPreDestroy {

    private static final Logger log = LoggerFactory.getLogger(TestAnnotationPreDestroy.class);

    @PreDestroy
    public void destroy() {
        System.out.println("我被销毁了;我是用的@PreDestory的方式.");
    }
}
