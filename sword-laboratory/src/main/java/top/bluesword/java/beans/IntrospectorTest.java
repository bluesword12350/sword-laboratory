package top.bluesword.java.beans;

import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

class IntrospectorTest {

    @Test
    void getBeanInfo() throws IntrospectionException {
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(BeanDemo.class)
                .getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            String name = descriptor.getName();
            System.out.print(name);
            System.out.print(" (");
            System.out.print(descriptor.getPropertyType());
            System.out.println(")");
        }
    }
}
