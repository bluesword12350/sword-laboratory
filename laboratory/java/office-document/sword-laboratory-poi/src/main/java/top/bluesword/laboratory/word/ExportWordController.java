package top.bluesword.laboratory.word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("word/export")
public class ExportWordController {

    @GetMapping
    public Mono<Void> exportWord(ServerHttpResponse response) {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run=paragraph.createRun();
        run.setText("hello XWPFDocument.");
        String fileName = "test.docx";
        return Mono.fromCallable(() -> outputFile(document, fileName)).flatMap(file -> downloadFile(response, file, fileName));
    }

    private File outputFile(XWPFDocument colorTable, String fileName) throws IOException {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try(colorTable;fileOutputStream) {
            colorTable.write(new FileOutputStream(file));
        }
        return file;
    }

    private Mono<Void> downloadFile(ServerHttpResponse response, File file, String fileName) {
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
        return ((ZeroCopyHttpOutputMessage) response).writeWith(file, 0, file.length());
    }

}
