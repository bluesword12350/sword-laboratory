package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NullPointerExceptionTest {

    Logger logger = Logger.getLogger(NullPointerExceptionTest.class.getName());

    /**
     * java 14 增强型 NullPointerException
     * 添加启动参数 `-XX:+ShowCodeDetailsInExceptionMessages`
     */
    @Test
    void checkThrows(){
        String[] strings = {null};
        assertThrows(NullPointerException.class, () -> strings[0].length());
        try {
            int length = strings[0].length();
            logger.info(String.valueOf(length));
        } catch (NullPointerException e){
            logger.info(e.getMessage());
        }
    }

}
