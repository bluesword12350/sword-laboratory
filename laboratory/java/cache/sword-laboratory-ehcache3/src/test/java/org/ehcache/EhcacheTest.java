package org.ehcache;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

class EhcacheTest {

    @Test
    void test(){
        BeanDemo beanDemo = new BeanDemo();
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();
        cacheManager.init();

        Cache<Long, BeanDemo> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, BeanDemo.class, ResourcePoolsBuilder.heap(10)));

        myCache.put(1L, beanDemo);
        System.out.println(beanDemo.equals(myCache.get(1L)));
        cacheManager.removeCache("preConfigured");

        cacheManager.close();
    }
}
