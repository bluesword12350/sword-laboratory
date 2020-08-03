package com.alibaba.fastjson;

import org.junit.jupiter.api.Test;

import java.util.Date;

class JsonFieldTest {

    @Test
    void test() {
        BeanDemo beanDemo = new BeanDemo();
        beanDemo.setDate(new Date());
        String jsonString = JSON.toJSONString(beanDemo);
        System.out.println(jsonString);
        BeanDemo demo = JSON.parseObject(jsonString, BeanDemo.class);
        System.out.println(demo);
    }

}
