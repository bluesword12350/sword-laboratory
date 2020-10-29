package top.bluesword.java.nio.file;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

class PathTest {

    @Test
    void test(){
        Path path0 = Paths.get("./target/test");
        Path path1 = path0.resolve("test.txt");
        System.out.println(path0);
        System.out.println(path1);
    }

}
