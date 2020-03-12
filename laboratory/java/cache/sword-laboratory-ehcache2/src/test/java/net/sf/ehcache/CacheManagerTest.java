package net.sf.ehcache;

import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

class CacheManagerTest {

    @Test
    void test(){
        BeanDemo beanDemo = new BeanDemo();
        String cacheName = "testCache";

        CacheManager cacheManager = CacheManager.create();
        cacheManager.addCache(cacheName);

        String key = "1";
        Cache cache = cacheManager.getCache(cacheName);
        cache.put(new Element(key,beanDemo));
        Element element = cache.get(key);
        Object objectValue = element.getObjectValue();
        System.out.println(beanDemo.equals(objectValue));
    }
}
