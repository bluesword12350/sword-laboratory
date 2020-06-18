package top.bluesword;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class YamlTest {

    @Autowired
    YamlProperties yaml;

    @Test
    void test() {
        List<String> ls = yaml.getLs();
        System.out.println(ls);
    }
}
