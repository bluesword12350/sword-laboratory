package com.squareup.okhttp3;

import okhttp3.FormBody;
import org.junit.jupiter.api.Test;

import java.util.Map;

class FormBodyTest {
    @Test
    void stringTest(){
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        Map<String, String> paramMap = Map.of("name","llf","password","12350");
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            formBodyBuilder.add(entry.getKey(), entry.getValue());
        }
        System.out.println(formBodyBuilder.build());
    }
}
