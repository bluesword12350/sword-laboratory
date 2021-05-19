package top.bluesword.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 李林峰
 */
class CompletableFutureTest {

    @Test
    void completedFuture(){
        Integer i = 0;
        CompletableFuture.completedFuture(i).completeAsync(() -> {
            System.out.println(i);
            return i+1;
        });
    }

    @Test
    void runAsync() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            if (new Random().nextBoolean()) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("随机异常");
            }
        });
        System.out.println("result0");
        CompletableFuture.allOf(completableFuture).join();
        System.out.println("result1");
    }

    @Test
    void supplyAsync() throws ExecutionException, InterruptedException {
        HashMap<String, String> map = new HashMap<>();
        CompletableFuture<Void> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenAccept(result -> map.put(result, result));
        CompletableFuture<Void> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }).thenAccept(result -> map.put(result, result));
        CompletableFuture.allOf(cf1,cf2).get();
        System.out.println(map);
    }

    @Test
    void thenCombine(){
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