package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;
import top.bluesword.model.DataModel;

import java.lang.reflect.Field;
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

    @Test
    void classTest() throws IllegalAccessException {
        DataModel result = new DataModel();
        for (Field declaredField : DataModel.class.getDeclaredFields()) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.getName()+":"+declaredField.get(result));
            declaredField.setAccessible(false);
        }
    }

}