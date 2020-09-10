package top.bluesword.web.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 李林峰
 */
@EnableRetry
@EnableAsync
@SpringBootApplication
public class LaboratoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}
}