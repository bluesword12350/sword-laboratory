package com.google.common.collect;

import org.junit.jupiter.api.Test;

class ImmutableMapTest {
    @Test
    void of(){
        ImmutableMap<String, Integer> map = ImmutableMap.of("1", 1414);
        System.out.println(map.get("1"));
    }
}