package com.github.benmanes.caffeine.cache;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PolicyTest {

    private static Policy<Object, Object> policy;
    private final static String key1 = "key1";

    @BeforeAll
    static void before(){
        CaffeineSpec caffeineSpec = CaffeineSpec.parse("maximumSize=1000,expireAfterWrite=10m");
        Cache<Object, Object> cache = Caffeine.from(caffeineSpec).build();
        cache.put(key1,"v1");
        cache.getIfPresent(key1);
        policy = cache.policy();
    }

    @Test
    void ageOf(){
        System.out.println(policy.expireAfterWrite().orElseThrow().ageOf(key1).orElseThrow());
    }

}
