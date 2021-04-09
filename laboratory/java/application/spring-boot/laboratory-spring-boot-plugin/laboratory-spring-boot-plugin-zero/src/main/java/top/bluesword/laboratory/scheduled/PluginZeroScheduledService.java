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
public class PluginZeroScheduledService {

    private static final Logger log = LoggerFactory.getLogger(PluginZeroScheduledService.class);

    @Scheduled(cron = "1/5 * * * * *")
    public void scheduled0(){
        log.info("插件0定时任务执行");
    }

}
