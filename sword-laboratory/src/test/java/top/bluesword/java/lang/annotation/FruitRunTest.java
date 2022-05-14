package top.bluesword.java.lang.annotation;

import org.junit.jupiter.api.Test;
import top.bluesword.java.lang.annotation.bean.Apple;
import top.bluesword.java.lang.annotation.util.FruitInfoUtil;

class FruitRunTest {

    @Test
    void main() {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }

}