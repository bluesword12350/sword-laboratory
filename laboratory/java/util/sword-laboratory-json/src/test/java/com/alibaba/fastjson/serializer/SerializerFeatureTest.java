package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

class SerializerFeatureTest {

    @Test
    void WriteMapNullValue() {
        String jsonString = JSON.toJSONString(new BeanDemo(),SerializerFeature.WriteMapNullValue);
        System.out.println(jsonString);
    }

}
