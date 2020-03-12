package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ClassTest {

    @Test
    void arrayClass() throws ClassNotFoundException {
        BigDecimal[][] bigDecimals = {};
        Class<? extends BigDecimal[][]> aClass = bigDecimals.getClass();
        System.out.println(aClass);
        String className = aClass.getName();
        System.out.println(className);
        Class<?> bClass = Class.forName(className);
        System.out.println(aClass.equals(bClass));
    }

    @Test
    void forName() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("[[Ljava.math.BigDecimal;");
        System.out.println(aClass);
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);
    }
}