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
        String[] strings = {null};
        assertThrows(NullPointerException.class, () -> strings[0].length());
        try {
            int length = strings[0].length();
            System.out.println(length);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}
