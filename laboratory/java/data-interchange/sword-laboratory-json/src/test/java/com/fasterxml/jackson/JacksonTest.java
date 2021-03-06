package com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class JacksonTest {

    @Test
    void jsonFormat() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JacksonBeanDemo beanDemo = new JacksonBeanDemo();
        beanDemo.setNumber(BigDecimal.valueOf(1468465465465.4646546));
        beanDemo.setInteger(BigDecimal.valueOf(165463.46543));
        System.out.println(mapper.writeValueAsString(beanDemo));
    }

    @Test
    void toJsonString() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>(2);
        map.put("string", "123");
        map.put("bigDecimal", new BigDecimal(124));
        String jsonString = mapper.writeValueAsString(map);
        System.out.println(jsonString);
        Map<String, Object> fromJsonMap;
        fromJsonMap = mapper.readValue(jsonString, new TypeReference<>() {
        });
        System.out.println("fromJsonMap:"+fromJsonMap);
        System.out.println("fromJsonMap中string:"+fromJsonMap.get("string"));
        System.out.println("fromJsonMap中bigDecimal是null:"+(fromJsonMap.get("bigDecimal")==null));

        BeanDemo fromJsonBean = mapper.readValue(jsonString, BeanDemo.class);
        System.out.println("fromJsonBean:"+mapper.writeValueAsString(fromJsonBean));
        System.out.println("fromJsonBean中string:"+fromJsonBean.string);
        System.out.println("fromJsonBean中bigDecimal是null:"+(fromJsonBean.bigDecimal==null));
    }

    @Test
    void jsonProperty() throws IOException {
        JacksonBeanDemo jacksonBeanDemo = new JacksonBeanDemo();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(jacksonBeanDemo));
    }
}