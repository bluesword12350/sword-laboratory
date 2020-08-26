package com.alibaba.fastjson;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

class JsonFieldTest {

    @Test
    void test() {
        BeanDemo beanDemo = new BeanDemo();
        beanDemo.setDate(ZonedDateTime.now());
        String jsonString = JSON.toJSONString(beanDemo);
        System.out.println(jsonString);
        BeanDemo demo = JSON.parseObject(jsonString, BeanDemo.class);
        System.out.println(demo);
    }

}
