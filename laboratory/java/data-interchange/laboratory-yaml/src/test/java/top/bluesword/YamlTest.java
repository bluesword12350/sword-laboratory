package top.bluesword;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class YamlTest {

    @Autowired
    private YamlProperties yaml;

    @Test
    void yaml() {
        log.info("yaml:{}",yaml);
    }

    @Test
    void ls() {
        List<String> ls = yaml.getLs();
        log.info("list:{}",ls);
    }

    @Test
    void map() {
        Map<String, List<String>> map = yaml.getMap();
        log.info("map:{}",map);
    }

}
