package top.bluesword.laboratory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 李林峰
 */
@EnableScheduling
@SpringBootApplication
public class LaboratoryApplication {

	private static final Logger log = LoggerFactory.getLogger(LaboratoryApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LaboratoryApplication.class, args);
		log.info("bean总数:{}",ctx.getBeanDefinitionCount());
	}

}