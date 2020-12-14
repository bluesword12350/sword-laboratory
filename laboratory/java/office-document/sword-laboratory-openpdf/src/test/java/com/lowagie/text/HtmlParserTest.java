package com.lowagie.text;

import com.lowagie.text.html.HtmlParser;
import com.lowagie.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class HtmlParserTest {

    @Test
    void main() {
        try(Document document = new Document()) {
            PdfWriter.getInstance(document, new FileOutputStream("ParseHtmlHelloWorld.pdf"));
            document.open();
            HtmlParser.parse(document, this.getClass().getClassLoader().getResourceAsStream("test.html"));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
    }

}
