package top.bluesword.laboratory;

import com.github.luben.zstd.ZstdInputStream;
import com.github.luben.zstd.ZstdOutputStream;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ZstdOutputStreamTest {

    @Test
    void outputTest() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("pom.xml");
                FileOutputStream fileOutputStream = new FileOutputStream("pom.zstd");
                ZstdOutputStream zstdOutputStream = new ZstdOutputStream(fileOutputStream)
        ) {
            IOUtils.copy(fileInputStream,zstdOutputStream);
        }
    }

    @Test
    void inputTest() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("pom.zstd");
                FileOutputStream fileOutputStream = new FileOutputStream("pom.iml");
                ZstdInputStream zstdInputStream = new ZstdInputStream(fileInputStream)
        ) {
            IOUtils.copy(zstdInputStream,fileOutputStream);
        }
    }
}
