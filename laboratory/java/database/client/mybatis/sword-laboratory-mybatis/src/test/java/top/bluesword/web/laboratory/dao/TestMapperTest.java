package top.bluesword.web.laboratory.dao;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
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

    @Test
    void scan() throws IOException {
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Cursor<Integer> cursor = sqlSession.getMapper(TestMapper.class).scan()
        ) {
            cursor.forEach(System.out::println);
        }
    }
}