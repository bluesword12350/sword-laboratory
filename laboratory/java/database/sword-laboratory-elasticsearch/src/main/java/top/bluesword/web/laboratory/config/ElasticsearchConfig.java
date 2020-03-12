package top.bluesword.web.laboratory.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ResultsMapper;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchRepositoryFactory;

@Configuration
public class ElasticsearchConfig {

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate(RestHighLevelClient client, ElasticsearchConverter converter,
//                                                           ResultsMapper resultsMapper) {
//        return new ElasticsearchRestTemplate(client, converter, resultsMapper);
//    }

    @Bean
    public ElasticsearchRepositoryFactory elasticsearchRepositoryFactory(ElasticsearchRestTemplate elasticsearchTemplate){
        return new ElasticsearchRepositoryFactory(elasticsearchTemplate);
    }

}
