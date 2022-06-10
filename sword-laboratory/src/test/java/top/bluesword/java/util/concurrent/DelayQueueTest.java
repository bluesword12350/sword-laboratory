package top.bluesword.java.util.concurrent;

import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZ").withZone(ZoneId.systemDefault());
        DelayQueue<Agreement> queue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        Instant ext = Instant.ofEpochMilli(now + 10000);
        System.out.println(dateTimeFormatter.format(Instant.now()));
        System.out.println(dateTimeFormatter.format(ext));
        queue.add(new Agreement((ext), () -> {
            System.out.println("执行时间"+dateTimeFormatter.format(Instant.now()));
            return true;
        }));
        Agreement take = queue.take();
        take.getAction().get();
    }

    record Agreement(Instant executionTime, Supplier<Boolean> action) implements Delayed {

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.executionTime.toEpochMilli() - System.currentTimeMillis(), TimeUnit.MICROSECONDS);
        }

        @Override
        public int compareTo(@Nonnull Delayed o) {
            return this.executionTime.compareTo(((Agreement) o).executionTime);
        }

        Supplier<Boolean> getAction() {
            return action;
        }

    }

}
