package top.bluesword;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

/**
 * @author 李林峰
 */
@SpringBootApplication
public class WebLaboratoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLaboratoryApplication.class);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("libai-cipher-book:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}
