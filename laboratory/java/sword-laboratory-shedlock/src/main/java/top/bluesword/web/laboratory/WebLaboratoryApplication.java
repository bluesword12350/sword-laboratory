package top.bluesword.web.laboratory;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class WebLaboratoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebLaboratoryApplication.class, args);
	}
}