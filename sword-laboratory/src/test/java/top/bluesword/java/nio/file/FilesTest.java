package top.bluesword.java.nio.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class FilesTest {

    @Test
    void readString() throws IOException {
        Path pathDirectory = Paths.get("target/test");
        if (Files.notExists(pathDirectory)) {
            Files.createDirectory(pathDirectory);
        }
        Path path = Paths.get("target/test/test.txt");
        String writeString = "test out file";
        Files.writeString(path, writeString);
        String readString = Files.readString(path);
        Assertions.assertEquals(writeString,readString);
        Files.deleteIfExists(path);
        Files.deleteIfExists(pathDirectory);
    }

    @Test
    void walk() throws IOException {
        Stream<Path> pathStream = Files.walk(Paths.get("src"));
        try(pathStream) {
            pathStream.forEach(pathTemp -> System.out.println("Stream: " + pathTemp.toString()));
        }
    }
}
