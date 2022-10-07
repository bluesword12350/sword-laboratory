package top.bluesword.laboratory.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.bluesword.laboratory.entity.LTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired TransactionalTestService transactionalTestService;

    @Test
    public void getOne() {
        LTest one = transactionalTestService.getOne();
        if (one==null) log.error("没有数据");
        else log.info(one.getTestId());
    }

    @Test
    public void updateValue() {
        transactionalTestService.updateValue("1");
    }
}