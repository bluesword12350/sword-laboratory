package top.bluesword.java.util.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService= new ScheduledThreadPoolExecutor(1, (ThreadFactory) Thread::new);
        scheduledExecutorService.scheduleAtFixedRate(new Task(scheduledExecutorService), 3, 1, TimeUnit.SECONDS);
    }

    static class Task implements Runnable {
        private final ScheduledExecutorService timer;

        public Task(ScheduledExecutorService timer) {
            this.timer = timer;
        }

        int i = 1;

        @Override
        public void run() {
            System.out.println("******程序执行******");
            //当执行到第5秒，程序结束
            if (i++ == 5) {
                this.timer.shutdown();
                System.out.println("******程序结束******");
            }
        }
    }

}


