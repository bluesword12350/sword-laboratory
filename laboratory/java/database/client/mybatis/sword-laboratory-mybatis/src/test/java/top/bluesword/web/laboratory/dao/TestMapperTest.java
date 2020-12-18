package top.bluesword.web.laboratory.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TestMapperTest {

    @Autowired
    TestMapper mapper;

    @Test
    void selectNow() {
        Optional<String> nowOptional = mapper.selectNow();
        nowOptional.ifPresent(System.out::println);
    }
}