package top.bluesword.web.laboratory.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.domain.DataForQueryDsl;
import top.bluesword.web.laboratory.domain.QDataForQueryDsl;

@SpringBootTest
class DataForQueryDslRepositoryTest {

    @Autowired
    private DataForQueryDslRepository dataForQueryDslRepository;

    @Test
    void containsIgnoreCase(){
        BooleanExpression expression = QDataForQueryDsl.dataForQueryDsl.name.containsIgnoreCase("aBc");
        Iterable<DataForQueryDsl> all = dataForQueryDslRepository.findAll(expression);
        System.out.println(all);
    }
}