package top.bluesword.web.laboratory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李林峰
 */
@SpringBootApplication
@MapperScan(basePackages="top.bluesword.web.laboratory.dao")
public class WebLaboratoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebLaboratoryApplication.class, args);
	}
}