package io.protostuff;

import io.protostuff.runtime.RuntimeSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;
import top.bluesword.bean.InsideBeanDemo;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Random;

class ProtostuffIOUtilTest {

    @Test
    void test() {
        BeanDemo beanDemo = new BeanDemo();
        beanDemo.setString("132321");
        beanDemo.setDate(ZonedDateTime.now());
        beanDemo.setBigDecimal(BigDecimal.valueOf(new Random().nextDouble()));
        beanDemo.setInsideBeanDemo(new InsideBeanDemo("asd|1212"));
        Schema<BeanDemo> schema = RuntimeSchema.getSchema(BeanDemo.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        final byte[] protostuff;
        try {
            protostuff = ProtostuffIOUtil.toByteArray(beanDemo, schema, buffer);
        } finally {
            buffer.clear();
        }
        BeanDemo fooParsed = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(protostuff, fooParsed, schema);
        System.out.println(fooParsed.toString());
        Assertions.assertEquals(beanDemo,fooParsed);
    }
}
