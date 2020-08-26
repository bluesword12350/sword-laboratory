package top.bluesword.web.laboratory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
	
	@Value("${project.version}")
	String version;
	
    @Bean
    public Docket api() {
    	ApiInfo apiInfo = new ApiInfoBuilder()
					        .title("Spring-Boot-Swagger2-APIs")
					        .description("Spring Boot中使用Swagger2构建RESTful APIs")
					        .termsOfServiceUrl("")
					        .version(version)
					        .build();
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}