package top.bluesword.java.util.concurrent.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

class AtomicReferenceTest {

    @Test
    void compareAndSet() throws InterruptedException {
        AtomicReference<String> atomicReference = new AtomicReference<>("old value");
        new Thread(() -> atomicReference.compareAndSet("old value", "123")).start();
        new Thread(() -> atomicReference.compareAndSet("old value", "456")).start();
        Thread.sleep(100);
        System.out.println(atomicReference.get());
    }

}
