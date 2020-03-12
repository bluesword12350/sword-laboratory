package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

class ExceptionTest {

    @Test
    void exceptionTest(){
        try {
            throw new Exception("异常测试");
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println("====================");
            System.out.println(e.getMessage());
            System.out.println("====================");
            for (StackTraceElement traceElement : e.getStackTrace()) {
                String s = traceElement.toString();
                if (s.startsWith(getClass().getName())){
                    System.out.println(s);
                }
            }
        }
    }
}