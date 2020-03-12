package cn.hutool.core.io;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 李林峰
 */
public class IoUtilTest {

    @Test
    void test(){
        byte[] bytes = IoUtil.readBytes(FileUtil.getInputStream(new File("pom.xml")));
        System.out.println(new String(bytes));
    }
}
