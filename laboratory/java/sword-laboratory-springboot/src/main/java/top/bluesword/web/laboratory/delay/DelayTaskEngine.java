package top.bluesword.web.laboratory.delay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author 李林峰
 */
@Component
public class DelayTaskEngine implements DisposableBean, Runnable{

    private static final Logger log = LoggerFactory.getLogger(DelayTaskEngine.class);

    private volatile boolean someCondition;

    private DelayQueue<Agreement> queue;

    DelayTaskEngine(){
        this.someCondition = true;
        this.queue = new DelayQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), new DelayTaskEngineTreadFactory());
        threadPoolExecutor.execute(this);
    }

    public void addTask(long executionTime){
        queue.add(new Agreement(executionTime));
    }

    @Override
    public void run(){
        while(someCondition){
            try {
                Agreement take = queue.take();
                log.info("延时任务执行时间:{}",take.executionTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy(){
        someCondition = false;
    }

    static class DelayTaskEngineTreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(@NonNull Runnable r) {
            Thread thread = new Thread(r, "renew-delay");
            thread.setDaemon(true);
            return thread;
        }
    }

    class Agreement implements Delayed {

        private long executionTime;

        Agreement(long executionTime) {
            this.executionTime = executionTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.executionTime - System.currentTimeMillis()/1000, TimeUnit.SECONDS);
        }

        @Override
        public int compareTo(@NonNull Delayed o) {
            return 0;
        }

        public void setExecutionTime(long executionTime) {
            this.executionTime = executionTime;
        }
    }
}
