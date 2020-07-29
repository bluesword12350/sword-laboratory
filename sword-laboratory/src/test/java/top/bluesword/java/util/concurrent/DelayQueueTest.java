package top.bluesword.java.util.concurrent;

import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author 李林峰
 */
class DelayQueueTest {

    @Test
    void main() throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ZZ");
        DelayQueue<Agreement> queue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        long ext = now + 10000;
        System.out.println(simpleDateFormat.format(now));
        System.out.println(simpleDateFormat.format(ext));
        queue.add(new Agreement(Instant.ofEpochMilli(ext), () -> {
            System.out.println("执行时间"+simpleDateFormat.format(ext));
            return true;
        }));
        Agreement take = queue.take();
        take.getAction().get();
    }

    static class Agreement implements Delayed {

        private final Instant executionTime;

        private final Supplier<Boolean> action;

        Agreement(Instant executionTime, Supplier<Boolean> action) {
            this.executionTime = executionTime;
            this.action = action;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.executionTime.toEpochMilli() - System.currentTimeMillis(), TimeUnit.MICROSECONDS);
        }

        @Override
        public int compareTo(@Nonnull Delayed o) {
            return this.executionTime.compareTo(((Agreement)o).executionTime);
        }

        Supplier<Boolean> getAction() {
            return action;
        }
    }

}
