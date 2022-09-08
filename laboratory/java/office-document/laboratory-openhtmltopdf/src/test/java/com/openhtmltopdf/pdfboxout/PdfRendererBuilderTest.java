package com.openhtmltopdf.pdfboxout;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class PdfRendererBuilderTest {

    @Test
    void test() throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("test1.html");
        FileOutputStream os = new FileOutputStream("HelloWorld.pdf");
        try (os;resourceAsStream) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            byte[] readAllBytes = Objects.requireNonNull(resourceAsStream).readAllBytes();
            builder.withHtmlContent(new String(readAllBytes),null);
            builder.toStream(os);
            File file = new File("src/test/resources/MSYH.TTC");
            builder.useFont(file, "Microsoft YaHei UI");
            builder.run();
        }
    }

}
