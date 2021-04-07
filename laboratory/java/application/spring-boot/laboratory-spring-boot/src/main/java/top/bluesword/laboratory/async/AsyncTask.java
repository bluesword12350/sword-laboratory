package top.bluesword.laboratory.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@EnableAsync
@Component
public class AsyncTask {

    Logger log = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public void doTaskOne() throws InterruptedException {
        log.info("异步任务开始执行");
        Thread.sleep(3000);
        log.info("异步任务执行完成");
    }

    @Async
    public void doTaskTwo() throws InterruptedException {
        doTaskOne();
    }

}
