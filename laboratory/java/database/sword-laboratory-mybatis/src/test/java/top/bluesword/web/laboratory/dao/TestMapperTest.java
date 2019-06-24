package top.bluesword.web.laboratory.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperTest {

    @Autowired
    TestMapper mapper;

    @Test
    public void selectNow() {
        System.out.println(mapper.selectNow());
    }
}