package top.bluesword.laboratory;

import com.google.common.io.ByteStreams;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamsTest {

    @Test
    void copyTest() {
        try (
                FileInputStream fileInputStream = new FileInputStream("pom.xml");
                FileOutputStream fileOutputStream = new FileOutputStream("pom2.iml")
        ) {
            ByteStreams.copy(fileInputStream,fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
