package com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;
import top.bluesword.bean.BeanDemoMap;

public class CustomMapTest {

    @Test
    void parseObject() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BeanDemoMap beanDemoMap = new BeanDemoMap();
        beanDemoMap.put(1, new BeanDemo());
        String jsonString = mapper.writeValueAsString(beanDemoMap);
        beanDemoMap = mapper.readValue(jsonString,BeanDemoMap.class);
        BeanDemo beanDemo = beanDemoMap.get(1);
        System.out.println(beanDemo);
    }

}
