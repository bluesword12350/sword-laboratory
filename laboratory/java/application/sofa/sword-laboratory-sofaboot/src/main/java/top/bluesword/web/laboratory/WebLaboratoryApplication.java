package top.bluesword.web.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 李林峰
 */
@SpringBootApplication
public class WebLaboratoryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(WebLaboratoryApplication.class, args);
		System.out.println("bean总数:"+ctx.getBeanDefinitionCount());
	}

}