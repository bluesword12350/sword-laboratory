package top.bluesword.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadPoolExecutorTest {

    @Test
    void base() throws InterruptedException {
        // 阻塞队列容量声明为100个
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));

        // 设置拒绝策略
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 空闲队列存活时间
        executorService.setKeepAliveTime(20, TimeUnit.SECONDS);
        try {
            for (int i = 0; i < 200; i++) {
                final int num = i;
                executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "-结果:" + num));
            }
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        }
    }

}
