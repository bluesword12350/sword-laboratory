package top.bluesword.web.laboratory.rocket.error.sender;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ErrorSenderTest {

    @Autowired
    ErrorSender errorSender;

    @Test
    void send() {
        errorSender.send("主题：topic.message 异常消息");
    }
}