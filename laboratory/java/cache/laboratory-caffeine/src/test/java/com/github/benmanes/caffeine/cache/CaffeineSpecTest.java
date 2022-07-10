package com.github.benmanes.caffeine.cache;

import org.junit.jupiter.api.Test;

class CaffeineSpecTest {

    @Test
    void test(){
        CaffeineSpec caffeineSpec = CaffeineSpec.parse("maximumSize=1000,expireAfterWrite=10m");
        Cache<Object, Object> cache = Caffeine.from(caffeineSpec).build();
        System.out.println(cache.asMap());
    }
}
