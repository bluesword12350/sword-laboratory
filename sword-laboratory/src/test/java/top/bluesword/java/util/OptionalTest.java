package top.bluesword.java.util;

import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;
import top.bluesword.bean.InsideBeanDemo;

import java.util.Optional;
import java.util.Random;

class OptionalTest {

    @Test
    void ofNullable(){
        BeanDemo beanDemo = new Random().nextBoolean()?null:new BeanDemo();
        Optional<BeanDemo> demo = Optional.ofNullable(beanDemo);
        BeanDemo result = demo.orElse(null);
        System.out.println(result);
    }

    @Test
    void map(){
        BeanDemo beanDemo;
        if (new Random().nextBoolean()) {
            beanDemo = null;
        } else {
            beanDemo = new BeanDemo();
            beanDemo.setInsideBeanDemo(new InsideBeanDemo());
        }
        Optional<InsideBeanDemo> optional = Optional.ofNullable(beanDemo)
                .map(BeanDemo::getInsideBeanDemo);
        System.out.println(optional);
    }

}