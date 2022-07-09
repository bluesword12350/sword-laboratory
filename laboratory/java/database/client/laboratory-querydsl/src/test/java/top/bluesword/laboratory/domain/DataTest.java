package top.bluesword.laboratory.domain;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataTest {

    @Autowired
    JPAQueryFactory queryFactory;

    @Test
    void groupBy(){
        JPAQuery<Integer> integerJPAQuery = queryFactory.selectZero();
        System.out.println(integerJPAQuery);
    }

}