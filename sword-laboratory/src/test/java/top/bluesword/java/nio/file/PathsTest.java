package top.bluesword.java.nio.file;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {

    @Test
    void get(){
        Path path = Paths.get("./target/test/test.txt");
        System.out.println(path.toString());
        System.out.println(path.getRoot());
    }

}
