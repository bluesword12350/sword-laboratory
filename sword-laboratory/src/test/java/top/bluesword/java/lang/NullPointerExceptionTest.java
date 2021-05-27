package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NullPointerExceptionTest {

    /**
     * java 14 增强型 NullPointerException
     * 添加启动参数 `-XX:+ShowCodeDetailsInExceptionMessages`
     */
    @Test
    void base(){
        String s = null;
        assertThrows(NullPointerException.class, () -> System.out.println(s.length()));
    }

}
