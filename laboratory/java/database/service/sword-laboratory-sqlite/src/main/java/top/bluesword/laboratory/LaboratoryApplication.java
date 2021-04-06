package top.bluesword.laboratory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李林峰
 */
@SpringBootApplication
@MapperScan(basePackages="top.bluesword.laboratory.dao")
public class LaboratoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}
}