package com.github.benmanes.caffeine.cache;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CacheTest {

    private static Cache<Object, Object> cache;

    @BeforeAll
    static void before(){
        CaffeineSpec caffeineSpec = CaffeineSpec.parse("maximumWeight=1000,expireAfterWrite=10m");
        cache = Caffeine.from(caffeineSpec).build();
    }

    @Test
    void put(){
        cache.put("key1","v1");
        System.out.println(cache.getIfPresent("key1"));
    }
}
