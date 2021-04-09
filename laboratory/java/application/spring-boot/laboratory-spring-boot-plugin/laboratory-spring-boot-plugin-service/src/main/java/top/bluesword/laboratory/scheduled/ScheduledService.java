package top.bluesword.laboratory.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
@EnableScheduling
public class ScheduledService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledService.class);

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled0(){
        log.info("主程序定时任务执行");
    }

}
