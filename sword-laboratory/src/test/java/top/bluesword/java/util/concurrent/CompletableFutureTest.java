package top.bluesword.java.util.concurrent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * @author 李林峰
 */
class CompletableFutureTest {

    static class CompletableTestException extends RuntimeException{
        private CompletableTestException(Throwable cause){
            super(cause);
        }
        private CompletableTestException(String message){
            super(message);
        }
    }

    @Test
    void completedFuture(){
        Integer i = 0;
        CompletableFuture.completedFuture(i).completeAsync(() -> {
            System.out.println(i);
            return i+1;
        });
    }

    @Test
    void runAsyncJoin() {
        boolean error = new Random().nextBoolean();
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.interrupted();
                throw new CompletableTestException(e);
            }
            if (error) {
                throw new CompletableTestException("随机异常");
            }
        });
        CompletableFuture<Void> future = CompletableFuture.allOf(completableFuture);
        if (error) {
            System.out.println("出现随机异常");
            Assertions.assertThrows(CompletionException.class, future::join);
        } else {
            future.join();
        }
    }

    @Test
    void runAsyncGet() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.interrupted();
                throw new CompletableTestException(e);
            }
            throw new CompletableTestException("随机异常");
        });
        CompletableFuture<Void> future = CompletableFuture.allOf(completableFuture);
        Assertions.assertThrows(ExecutionException.class, future::get);
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
            System.out.println(1);
            return "hello";
        }).thenAccept(result -> map.put(result, result));
        CompletableFuture<Void> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
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
                Thread.interrupted();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }

}