package top.bluesword.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 李林峰
 */
@EnableScheduling
@SpringBootApplication
public class LaboratoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}

}