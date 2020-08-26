package top.bluesword;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class YamlTest {

    @Autowired
    YamlProperties yaml;

    @Test
    void ls() {
        List<String> ls = yaml.getLs();
        System.out.println(ls);
    }

    @Test
    void map() {
        Map<String, List<String>> map = yaml.getMap();
        System.out.println(map);
    }
}
