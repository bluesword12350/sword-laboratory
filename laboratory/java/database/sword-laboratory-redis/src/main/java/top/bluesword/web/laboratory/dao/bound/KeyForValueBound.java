package top.bluesword.web.laboratory.dao.bound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 李林峰
 */
@Repository
public class KeyForValueBound {

    private BoundValueOperations<String, String> boundValueOperations;

    private static final String KEY = "keyForValue";

    @Autowired
    public KeyForValueBound(RedisTemplate<String, String> redisTemplate) {
        this.boundValueOperations = redisTemplate.boundValueOps(KEY);
    }

    public void set(String value){
        boundValueOperations.set(value);
    }
}
