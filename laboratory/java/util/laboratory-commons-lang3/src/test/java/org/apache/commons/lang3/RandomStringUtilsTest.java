package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;

class RandomStringUtilsTest {

    @Test
    void random() {
        System.out.println(RandomStringUtils.random(12));
    }

    @Test
    void randomAlphabetic() {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomStringUtils.randomAlphabetic(12));
        }
    }

    @Test
    void randomAlphanumeric() {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomStringUtils.randomAlphanumeric(12));
        }
    }

    @Test
    void randomAscii() {
        System.out.println(RandomStringUtils.randomAscii(12));
    }

    @Test
    void randomGraph() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomStringUtils.randomGraph(12));
        }
    }

    @Test
    void randomNumeric() {
        System.out.println(RandomStringUtils.randomNumeric(12));
    }

    @Test
    void randomPrint() {
        System.out.println(RandomStringUtils.randomPrint(12));
    }
}
