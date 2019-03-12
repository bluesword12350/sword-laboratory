package top.bluesword.web.laboratory.destroy;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author 李林峰
 */
@Component
public class TestAnnotationPreDestroy {

    @PreDestroy
    public void destroy() {
        System.out.println("我被销毁了;我是用的@PreDestory的方式.");
    }
}
