package top.bluesword.web.laboratory.config;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.querydsl.JPQLNextQueryFactory;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author 李林峰
 */
@Configuration
public class QueryDslConfig {

    @Bean
    public JPQLNextQueryFactory jpqlQueryFactory(EntityManagerFactory entityManagerFactory, EntityManager entityManager){
        CriteriaBuilderConfiguration config = Criteria.getDefault();
        CriteriaBuilderFactory criteriaBuilderFactory = config.createCriteriaBuilderFactory(entityManagerFactory);
        return new JPQLNextQueryFactory(entityManager,criteriaBuilderFactory);
    }

}