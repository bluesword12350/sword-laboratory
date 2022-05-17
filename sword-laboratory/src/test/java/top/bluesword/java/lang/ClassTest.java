package top.bluesword.java.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.bluesword.model.DataModel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

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
    void getDeclaredFields() throws IllegalAccessException {
        DataModel result = new DataModel();
        for (Field declaredField : DataModel.class.getDeclaredFields()) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.getName()+":"+declaredField.get(result));
            declaredField.setAccessible(false);
        }
    }

    @Test
    void testGetClass() {
        List<Object> data = List.of(new DataModel());
        Object o = data.get(0);
        Class<?> oClass = o.getClass();
        System.out.println(oClass);
        Assertions.assertEquals(DataModel.class, oClass);
    }

}