package top.bluesword.web.laboratory.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.domain.DataForQueryDsl;
import top.bluesword.web.laboratory.domain.DataGroup;
import top.bluesword.web.laboratory.domain.QDataForQueryDsl;

import java.util.List;

@SpringBootTest
class DataForQueryDslRepositoryTest {

    @Autowired
    private DataForQueryDslRepository dataForQueryDslRepository;
    @Autowired
    JPAQueryFactory queryFactory;

    @Test
    void containsIgnoreCase(){
        BooleanExpression expression = QDataForQueryDsl.dataForQueryDsl.name.containsIgnoreCase("aBc");
        Iterable<DataForQueryDsl> all = dataForQueryDslRepository.findAll(expression);
        System.out.println(all);
    }

    @Test
    void groupByKey(){
        QDataForQueryDsl qDataForQueryDsl = QDataForQueryDsl.dataForQueryDsl;
        List<DataGroup> total = queryFactory.select(
                Projections.bean(DataGroup.class, qDataForQueryDsl.key, qDataForQueryDsl.count().as("total"))
        ).from(qDataForQueryDsl).groupBy(qDataForQueryDsl.key).fetch();
        System.out.println(total);
    }

}