package com.alibaba.fastjson2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

@Slf4j
class JsonTest {

    @Test
    void test(){
        BeanDemo beanDemo = new BeanDemo();
        beanDemo.string = "fastjson2 test";
        String json = JSON.toJSONString(beanDemo);
        log.info("{}",json);
    }

}
