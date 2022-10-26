package org.apache.poi.xwpf.usermodel;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李林峰
 */
public class XWPFDocumentTest {

    @Test
    public void exportWord() throws IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run=paragraph.createRun();
        run.setText("hello XWPFDocument.");
        String fileName = "test.docx";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        try(fileOutputStream;document) {
            document.write(fileOutputStream);
        }
    }

}
