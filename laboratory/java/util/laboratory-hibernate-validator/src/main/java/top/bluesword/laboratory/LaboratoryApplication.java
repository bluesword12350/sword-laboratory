package top.bluesword.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.laboratory.bean.BeanDemo;
import top.bluesword.laboratory.validation.group.StringChecks;

import javax.validation.groups.Default;

/**
 * @author 李林峰
 */
@RestController
@SpringBootApplication
public class LaboratoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}

	@PostMapping
	public BeanDemo test(@RequestBody @Validated({Default.class,StringChecks.class}) BeanDemo demo) {
		return demo;
	}

}
