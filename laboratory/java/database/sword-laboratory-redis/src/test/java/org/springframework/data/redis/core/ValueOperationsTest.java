package org.springframework.data.redis.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.WebLaboratoryApplication;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = WebLaboratoryApplication.class)
class ValueOperationsTest {

    private final ValueOperations<String, String> valueOperations;

    @Autowired
    public ValueOperationsTest(RedisTemplate<String, String> redisTemplate) {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Test
    void setIfAbsent(){
        Boolean set = valueOperations.setIfAbsent("key1", "v1", 1000, TimeUnit.SECONDS);
        System.out.println(set);
    }
    
}
