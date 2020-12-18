package top.bluesword.web.laboratory.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestMapperTest {

    @Autowired
    TestMapper mapper;

    @Test
    void nMonthsAgo() {
        System.out.println(mapper.nMonthsAgo(1));
    }
}