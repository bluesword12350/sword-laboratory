package top.bluesword.web.laboratory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 李林峰
 */
@Repository
public class RedisRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void valueSet(String key, String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void hashPut(String key, Object hashKey, Object value){
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    public void listRightPush(String key, String value){
        redisTemplate.opsForList().rightPush(key,value);
    }

}
