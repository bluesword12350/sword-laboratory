package top.bluesword.web.laboratory.rocket.topic.sender;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TopicSenderTest {
    @Autowired
    TopicSender topicSender;

    @Test
    void send1() {
        topicSender.send("主题：topic.message 测试 消息6");
    }
}