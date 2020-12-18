package top.bluesword.web.laboratory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchRepositoryFactory;

/**
 * @author 李林峰
 */
@Configuration
public class ElasticsearchConfig {

    @Bean
    public ElasticsearchRepositoryFactory elasticsearchRepositoryFactory(ElasticsearchRestTemplate elasticsearchTemplate){
        return new ElasticsearchRepositoryFactory(elasticsearchTemplate);
    }

}
