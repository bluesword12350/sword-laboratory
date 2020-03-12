package com.alibaba.fastjson.classes;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

class JavaNullTest {

    @Test
    void nullTest(){
        try {
            String key = "key";
            if (new JSONObject().getBoolean(key)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }catch (NullPointerException e){
            System.out.println("空指针异常");
        }
    }

}
