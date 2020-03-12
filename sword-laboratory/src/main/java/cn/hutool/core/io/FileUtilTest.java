package cn.hutool.core.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author 李林峰
 */
public class FileUtilTest {

    @Test
    void readString(){
        System.out.println(FileUtil.readString(new File("pom.xml"), StandardCharsets.UTF_8));
    }
}
