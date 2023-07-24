package top.bluesword.laboratory.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.EnabledIf;

@Slf4j
@SpringBootTest
@EnabledIf(expression = "#{'${spring.messages.basename}'=='demand-message'}",loadContext = true)
class MessageSourceExpansionTest {

    @Autowired
    private MessageSourceExpansion messageSourceExpansion;

    @Test
    void replaceParameters() {
        String message = messageSourceExpansion.getMessage("{demand.message.hello},{demand.message.args}");
        log.info(message);
    }

    @Test
    void getMessageWithSingleArgs() {
        String message =
                messageSourceExpansion.getMessageWithSingleArgs(
                        "{demand.message.hello},{demand.message.args}",new Object[]{"测试参数"}
                );
        log.info(message);
    }

}
