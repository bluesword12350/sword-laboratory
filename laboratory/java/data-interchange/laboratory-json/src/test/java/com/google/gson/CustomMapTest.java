package com.google.gson;

import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;
import top.bluesword.bean.BeanDemoMap;

public class CustomMapTest {

    @Test
    void parseObject() {
        Gson gson = new Gson();
        BeanDemoMap beanDemoMap = new BeanDemoMap();
        beanDemoMap.put(1, new BeanDemo());
        String jsonString = gson.toJson(beanDemoMap);
        beanDemoMap = gson.fromJson(jsonString,BeanDemoMap.class);
        BeanDemo beanDemo = beanDemoMap.get(1);
        System.out.println(beanDemo);
    }

}
