package com.github.benmanes.caffeine.cache;

import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

import java.util.stream.IntStream;

class CaffeineTest {

    @Test
    void test(){
        BeanDemo beanDemo = new BeanDemo();
        Cache<String, BeanDemo> cache = Caffeine.newBuilder().build();
        cache.put("1",beanDemo);
        System.out.println(beanDemo.equals(cache.getIfPresent("1")));
    }

    @Test
    void getIfPresent(){
        Cache<String, String> cache = Caffeine.newBuilder().build();
        System.out.println(cache.getIfPresent("1"));
    }

    @Test
    void estimatedSize(){
        Cache<Integer, BeanDemo> cache = Caffeine.newBuilder().build();
        IntStream.range(0, 1000).forEach(i -> cache.put(i, new BeanDemo()));
        System.out.println(cache.estimatedSize());
    }

    @Test
    void maximumSize(){
        Cache<Integer, BeanDemo> cache = Caffeine.newBuilder().maximumSize(100).build();
        IntStream.range(0, 1000).forEach(i -> cache.put(i, new BeanDemo()));
        System.out.println(cache.asMap().size());
    }

    @Test
    void maximumWeight() {
        Cache<Integer, BeanDemo> cache = Caffeine.newBuilder()
                .weigher(SingletonWeigher.INSTANCE).maximumWeight(100).build();
        IntStream.range(0, 1000).forEach(i -> cache.put(i, new BeanDemo()));
        System.out.println(cache.asMap().size());
    }

//        case "expireAfterAccess":
//        case "expireAfterWrite":
//        case "refreshAfterWrite":
//        case "recordStats":
}
