package top.bluesword.java.security;

import org.junit.jupiter.api.Test;
import top.bluesword.java.util.RandomTest;

import java.security.SecureRandom;
import java.util.Random;

class SecureRandomTest {

    private Random random = new Random();

    @Test
    void nextIntTest() {
        new RandomTest().baseRandomTest(this.random);
    }

    @Test
    void seedTest(){
        SecureRandom random1 = new SecureRandom();
        byte[] bytes = random1.generateSeed(123);
        random1.setSeed(bytes);
        int pn = 3;
        for (int i = 0;i < pn;i++) {
            System.out.println(random1.nextInt(1000));
        }
        System.out.println();

        SecureRandom random2 = new SecureRandom();
        random2.setSeed(bytes);
        for (int i = 0;i < pn;i++) {
            System.out.println(random2.nextInt(1000));
        }
    }
}
