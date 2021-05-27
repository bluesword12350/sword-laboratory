package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

class NullPointerExceptionTest {

    /**
     * java 14 增强型 NullPointerException
     * 添加启动参数 `-XX:+ShowCodeDetailsInExceptionMessages`
     */
    @Test
    void checkThrows(){
        Random random = new Random();
        Boolean flag = random.nextBoolean();
        String s = null;
        if (flag) {
            s = "";
        }
        final String cs = s;
        if (flag) {
            assertEquals(0, cs.length());
        } else {
            assertThrows(NullPointerException.class, () -> cs.length());
        }
        
    }

}
