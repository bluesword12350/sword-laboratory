package com.alibaba.fastjson.classes;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

class ArrayTest {

    @Test
    void objects() {
        System.out.println(JSON.toJSONString(new Object[1]));
    }

}
