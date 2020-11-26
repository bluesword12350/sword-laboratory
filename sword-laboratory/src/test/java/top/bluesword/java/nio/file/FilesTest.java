package top.bluesword.java.nio.file;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Disabled
public class FilesTest {

    @Test
    void readString() throws IOException {
        Path pathDirectory = Paths.get("target/test");
        if (Files.notExists(pathDirectory)) {
            Files.createDirectory(pathDirectory);
        }
        Path path = Paths.get("target/test/test.txt");
        Files.write(path, "测试代码输出文件".getBytes());
        Files.readString(path);
        Files.deleteIfExists(path);
        Files.deleteIfExists(pathDirectory);
    }

    @Test
    void walk() throws IOException {
        Stream<Path> pathStream = Files.walk(Paths.get("src"));
        pathStream.forEach(pathTemp -> System.out.println("Stream: " + pathTemp.toString()));
    }
}
