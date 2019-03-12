package top.bluesword.web.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import top.bluesword.web.laboratory.Bean.BeanDemo;

@RestController
@SpringBootApplication
public class WebLaboratoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebLaboratoryApplication.class, args);
	}
	
	@PostMapping
	public String test(@Validated BeanDemo demo) {
		return "success";
	}
}