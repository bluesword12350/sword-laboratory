package top.bluesword.web.laboratory.rabbit.simplest.sender;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SimplestSenderTest {

	@Autowired
	private SimplestSender simplestSend;

	@Test
	void simplestSend() {
		simplestSend.simplestSend("测试消息2");
	}
}