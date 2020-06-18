package top.bluesword;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class YamlTest {

    @Autowired
    YamlProperties yaml;

    @Test
    void test() {
        System.out.println(yaml.getLs());
    }
}
