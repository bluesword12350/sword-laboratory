package top.bluesword.web.laboratory.config;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public BlazeJPAQuery<?> blazeJpaQuery(EntityManagerFactory entityManagerFactory,EntityManager entityManager){
        CriteriaBuilderConfiguration config = Criteria.getDefault();
        CriteriaBuilderFactory criteriaBuilderFactory = config.createCriteriaBuilderFactory(entityManagerFactory);
        return new BlazeJPAQuery<>(entityManager,criteriaBuilderFactory);
    }

}