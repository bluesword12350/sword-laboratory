package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class StringBuilderTest {

    @Test
    void test() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        if (random.nextBoolean()) {
            builder.append("1");
        }
        System.out.println("".equals(builder.toString()));
    }
}
