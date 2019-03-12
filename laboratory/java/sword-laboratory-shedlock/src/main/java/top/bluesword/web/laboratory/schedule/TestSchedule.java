package top.bluesword.web.laboratory.schedule;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class TestSchedule {

    @Scheduled(cron = "0/10 * * * * ?")
    @SchedulerLock(name = "testTimer", lockAtMostFor = 20*1000, lockAtLeastFor = 20*1000)
    void testTimer(){
        System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(new Date()));
    }
}