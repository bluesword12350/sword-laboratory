package top.bluesword.java.util.concurrent;

import org.junit.jupiter.api.Test;
import top.bluesword.util.exception.SwordRuntimeException;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author 李林峰
 */
class CompletableFutureTest {
    @Test
    void runAsync(){
        CompletableFuture.runAsync(()-> {
            if (new Random().nextBoolean()){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new SwordRuntimeException("随机异常");
            }
            System.out.println("Async");
        });
        System.out.println("result");
    }

    @Test
    void supplyAsync(){
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }
}