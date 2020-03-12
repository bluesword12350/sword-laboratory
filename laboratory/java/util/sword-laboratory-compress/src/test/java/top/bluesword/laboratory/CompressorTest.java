package top.bluesword.laboratory;

import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CompressorTest {

    @Test
    void outputTest() throws IOException, CompressorException {
        FileInputStream fileInputStream = new FileInputStream("pom.xml");
        FileOutputStream fileOutputStream = new FileOutputStream("pom.gz");
        CompressorOutputStream gzippedOut = new CompressorStreamFactory()
                .createCompressorOutputStream(CompressorStreamFactory.GZIP, fileOutputStream);
        try (fileInputStream;fileOutputStream;gzippedOut) {
            IOUtils.copy(fileInputStream,gzippedOut);
        }
    }

    @Test
    void inputTest() throws IOException, CompressorException {
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("pom.gz"));
        FileOutputStream fileOutputStream = new FileOutputStream("pom.iml");
        CompressorInputStream input = new CompressorStreamFactory()
                .createCompressorInputStream(bufferedInputStream);
        try (bufferedInputStream;fileOutputStream;input) {
            IOUtils.copy(input,fileOutputStream);
        }
    }
}
