package top.bluesword.web.laboratory.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
@ConfigurationProperties(prefix = "swagger.project")
@Data
public class SwaggerProperties {

    private String version;

}
