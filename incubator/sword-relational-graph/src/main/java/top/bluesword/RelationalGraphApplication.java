package top.bluesword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 李林峰
 */
@SpringBootApplication
public class RelationalGraphApplication {

	private static final Logger log = LoggerFactory.getLogger(RelationalGraphApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RelationalGraphApplication.class, args);
		log.info("bean总数:{}",ctx.getBeanDefinitionCount());
	}

}