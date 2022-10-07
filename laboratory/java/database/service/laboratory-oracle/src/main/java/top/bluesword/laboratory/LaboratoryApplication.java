package top.bluesword.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="top.bluesword.laboratory.dao")
public class LaboratoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}
}