package top.bluesword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 李林峰
 */
@SpringBootApplication
@EnableFeignClients
public class EurekaApplicationApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationApplication.class, args);
    }
}