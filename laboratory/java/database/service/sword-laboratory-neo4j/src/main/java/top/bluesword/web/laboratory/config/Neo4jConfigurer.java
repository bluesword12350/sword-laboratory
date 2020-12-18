package top.bluesword.web.laboratory.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * WebMvcConfigurer 实现
 * @author 李林峰
 */
@Configuration
public class Neo4jConfigurer{

	@Bean
	public GraphDatabaseService graphDatabaseService(){
		File storeDir = new File("database");
		return new GraphDatabaseFactory().newEmbeddedDatabase(storeDir);
	}

}
