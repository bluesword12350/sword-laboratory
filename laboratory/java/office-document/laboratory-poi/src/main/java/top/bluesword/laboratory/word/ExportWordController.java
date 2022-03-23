package top.bluesword.laboratory.word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("word/export")
public class ExportWordController {

    @GetMapping
    public void exportWord(HttpServletResponse response) throws IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run=paragraph.createRun();
        run.setText("hello XWPFDocument.");
        String fileName = "test.docx";
        downloadFile(response, document, fileName);
    }

    private void downloadFile(HttpServletResponse response, XWPFDocument document, String fileName) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        try(outputStream;document) {
            document.write(outputStream);
        }
    }

}
