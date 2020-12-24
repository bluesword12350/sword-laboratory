package top.bluesword.web.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 李林峰
 */
@EnableOpenApi
@SpringBootApplication
public class LaboratoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}

}