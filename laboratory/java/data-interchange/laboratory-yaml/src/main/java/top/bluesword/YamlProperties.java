package top.bluesword;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
@Component
@ConfigurationProperties(prefix = "blue-sword")
@Data
@SpringBootApplication
public class YamlProperties {

    private String string;

    private List<String> ls;

    private Map<String,List<String>> map;

}
