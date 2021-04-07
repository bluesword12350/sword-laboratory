package top.bluesword.laboratory.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
public class ScheduledService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledService.class);

    @Scheduled(cron = "0 0 * * * *")
    public void scheduled0(){
        log.info("定时任务0执行");
    }

    @Scheduled(initialDelay = 0,fixedDelay = 1000*60*5)
    public void scheduled1(){
        log.info("定时任务1执行");
    }

    @Scheduled(initialDelay = 0,fixedDelayString = "#{${scheduled.time-interval-second}*1000}")
    public void scheduled2(){
        log.info("定时任务2执行");
    }

    /**
     * @see org.springframework.scheduling.support.CronExpression#parse(java.lang.String)
     */
    @Scheduled(cron = "@hourly")
    public void scheduled3(){
        log.info("定时任务3执行");
    }

}
