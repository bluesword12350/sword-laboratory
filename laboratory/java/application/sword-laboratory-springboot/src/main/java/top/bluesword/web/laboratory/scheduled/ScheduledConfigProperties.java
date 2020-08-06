package top.bluesword.web.laboratory.scheduled;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Data
@Component
@ConfigurationProperties("scheduled")
public class ScheduledConfigProperties {

    private Integer timeIntervalSecond;

}
