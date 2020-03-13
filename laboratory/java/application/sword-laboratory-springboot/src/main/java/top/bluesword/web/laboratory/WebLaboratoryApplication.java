package top.bluesword.web.laboratory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import top.bluesword.web.laboratory.controller.TestController;

/**
 * @author 李林峰
 */
@EnableScheduling
@SpringBootApplication
public class WebLaboratoryApplication {

	private static final Logger log = LoggerFactory.getLogger(WebLaboratoryApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(WebLaboratoryApplication.class, args);
		log.info("bean总数:{}",ctx.getBeanDefinitionCount());
	}

}