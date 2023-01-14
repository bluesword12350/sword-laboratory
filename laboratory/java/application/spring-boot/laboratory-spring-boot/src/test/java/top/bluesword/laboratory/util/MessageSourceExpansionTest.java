package top.bluesword.laboratory.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@Slf4j
@SpringBootTest
class MessageSourceExpansionTest {

    @Autowired
    private MessageSourceExpansion messageSourceExpansion;

    @Test
    void replaceParameters() {
        String message = messageSourceExpansion.getMessage("{demand.message.hello}", Locale.getDefault());
        log.info(message);
    }

    @Test
    void getMessageWithSingleArgs() {
        String message =
                messageSourceExpansion.getMessageWithSingleArgs(
                        "{demand.message.hello},{demand.message.args}",new Object[]{"测试参数"}, Locale.getDefault()
                );
        log.info(message);
    }

}
