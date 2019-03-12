package top.bluesword.web.laboratory.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisRepositoryTest {

    @Autowired
    RedisRepository redisRepository;

    @Test
    public void valueSet() {
        redisRepository.valueSet("keyForValue","v1");
    }

    @Test
    public void hashPut() {
        redisRepository.hashPut("keyForHash","hk1","hv1");
    }

    @Test
    public void listRightPush() {
        redisRepository.listRightPush("keyForList","lv1");
    }
}