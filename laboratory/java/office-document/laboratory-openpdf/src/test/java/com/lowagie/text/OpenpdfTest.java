package com.lowagie.text;

import com.lowagie.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class OpenpdfTest {

    @Test
    void main() {
        try(Document document = new Document()) {
            PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("Hello World"));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
    }

}
