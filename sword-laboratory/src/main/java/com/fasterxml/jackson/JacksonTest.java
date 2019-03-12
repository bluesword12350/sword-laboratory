package com.fasterxml.jackson;

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
    void toJsonString() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map.put("string", "123");
        map.put("bigDecimal", new BigDecimal(124));
        String jsonString = mapper.writeValueAsString(map);
        System.out.println(jsonString);
        Map<String, Object> fromJsonMap;
        fromJsonMap = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>(){});
        System.out.println("fromJsonMap:"+fromJsonMap);
        System.out.println("fromJsonMap中string:"+fromJsonMap.get("string"));
        System.out.println("fromJsonMap中bigDecimal是null:"+(fromJsonMap.get("bigDecimal")==null));

        BeanDemo fromJsonBean = mapper.readValue(jsonString, BeanDemo.class);
        System.out.println("fromJsonBean:"+mapper.writeValueAsString(fromJsonBean));
        System.out.println("fromJsonBean中string:"+fromJsonBean.getString());
        System.out.println("fromJsonBean中bigDecimal是null:"+(fromJsonBean.getBigDecimal()==null));
    }
}
