package top.bluesword.web.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 李林峰
 */
@EnableScheduling
@SpringBootApplication
public class WebLaboratoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebLaboratoryApplication.class, args);
	}

}