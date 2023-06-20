package top.bluesword.laboratory.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TestMapperTest {

    @Autowired
    TestMapper mapper;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    void selectNow() {
        Optional<String> nowOptional = mapper.selectNow();
        nowOptional.ifPresent(System.out::println);
    }

}