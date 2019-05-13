package top.bluesword.java.util;

import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

class OptionalTest {

    @Test
    void get(){
        BeanDemo beanDemo = new Random().nextInt(2)==1?null:new BeanDemo();
        Optional<BeanDemo> demo = Optional.ofNullable(beanDemo);
        BeanDemo result = demo.orElse(null);
        System.out.println(result);
    }

    @Test
    void mainTest(){
        BeanDemo beanDemo,cache = new BeanDemo("初始bean");
        int i = new Random().nextInt(2);
        if (i==1) beanDemo = cache;
        else beanDemo = null;
        Optional<BeanDemo> demo = Optional.ofNullable(beanDemo);
        demo.ifPresent(o -> System.out.println("beanDemo不为空"));
        beanDemo = demo.orElse(new BeanDemo("orElseBean", BigDecimal.ONE));
        System.out.println(beanDemo.getString());

        if (i==1) beanDemo = cache;
        else beanDemo = null;
        demo = Optional.ofNullable(beanDemo);
        beanDemo = demo.orElseGet(() -> new BeanDemo("orElseGetBean", BigDecimal.ONE));
        System.out.println(beanDemo.getString());

        demo = Optional.of(beanDemo).filter(b -> "初始bean".equals(b.getString()));
        System.out.println(demo.map(BeanDemo::getString).orElse("空值"));
    }
}