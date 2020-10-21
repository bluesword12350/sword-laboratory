package top.bluesword.java.nio.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesTest {

    @Test
    void createDirectory() throws IOException {
        Path path = Paths.get("target/test");
        Files.createDirectory(path);
    }

    @Test
    void write() throws IOException {
        Path path = Paths.get("target/test/test.txt");
        Files.write(path, "测试代码输出文件".getBytes());
    }

    @Test
    void deleteIfExists() throws IOException {
        Path path = Paths.get("target/test/test.txt");
        Files.deleteIfExists(path);
    }

    @Test
    void walk() throws IOException {
        Stream<Path> pathStream = Files.walk(Paths.get("src"));
        pathStream.forEach(pathTemp -> System.out.println("Stream: " + pathTemp.toString()));
    }
}
