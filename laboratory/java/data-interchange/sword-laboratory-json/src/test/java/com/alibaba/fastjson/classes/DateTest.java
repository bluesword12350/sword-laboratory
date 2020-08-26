package com.alibaba.fastjson.classes;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

import java.util.Date;

class DateTest {

    @Test
    void date() {
        BeanDemo beanDemo=new BeanDemo();
        beanDemo.date = new Date();
        System.out.println(JSON.toJSONString(beanDemo));
    }

}
