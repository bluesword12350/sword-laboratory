package top.bluesword.web.laboratory.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.bluesword.web.laboratory.destroy.TestAnnotationPreDestroy;

/**
 * @author 李林峰
 */
@Component
public class ScheduledService {

    private static final Logger log = LoggerFactory.getLogger(TestAnnotationPreDestroy.class);

    @Scheduled(cron = "0 0 * * * *")
    public void scheduled0(){
        log.info("定时任务0执行");
    }

    @Scheduled(initialDelay = 0,fixedDelay = 1000*60*5)
    public void scheduled1(){
        log.info("定时任务1执行");
    }

}
