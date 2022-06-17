package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NullPointerExceptionTest {

    /**
     * java 14 增强型 NullPointerException
     * 添加启动参数 `-XX:+ShowCodeDetailsInExceptionMessages`
     */
    @Test
    void checkThrows(){
        String s = new String[]{null}[0];
        assertThrows(NullPointerException.class, () -> System.out.println(s.length()));
        try {
            System.out.println(s.length());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

}
