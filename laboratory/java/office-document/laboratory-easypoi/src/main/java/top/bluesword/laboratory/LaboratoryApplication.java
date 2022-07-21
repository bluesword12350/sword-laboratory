package top.bluesword.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 李林峰
 */
@SpringBootApplication
@EnableOpenApi
public class LaboratoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}
}