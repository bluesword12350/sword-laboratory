package top.bluesword.web.laboratory.rabbit.delayed.sender;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class DelayedSenderTest {
    @Autowired
    private DelayedSender delayedSender;

    @Test
    void delayedSender() {
        delayedSender.delayedSender(UUID.randomUUID()+"："
                +DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date()),1000);
    }
}