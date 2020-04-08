package top.bluesword.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

class ExecutorsTest {

    @Test
    void callableTest() throws Exception {
        Executors.callable(() -> System.out.println(1)).call();
    }
}