package io.protostuff;

import io.protostuff.runtime.RuntimeSchema;
import org.junit.jupiter.api.Test;
import top.bluesword.bean.BeanDemo;
import top.bluesword.bean.InsideBeanDemo;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProtostuffIOUtilTest {

    @Test
    void toByteArray() {
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
        System.out.println(fooParsed);
        assertEquals(beanDemo,fooParsed);
    }

    @Test
    void list() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add(null);
        stringList.add("3");
        Schema<String> schema = RuntimeSchema.getSchema(String.class);
        MessageCollectionSchema<String> stringMessageCollectionSchema = new MessageCollectionSchema<>(schema);
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        final byte[] protostuff;
        try {
            protostuff = ProtostuffIOUtil.toByteArray(stringList, stringMessageCollectionSchema, buffer);
        } finally {
            buffer.clear();
        }
        Collection<String> strings = stringMessageCollectionSchema.newMessage();
        ProtostuffIOUtil.mergeFrom(protostuff, strings, stringMessageCollectionSchema);
        System.out.println(strings);
    }
}
