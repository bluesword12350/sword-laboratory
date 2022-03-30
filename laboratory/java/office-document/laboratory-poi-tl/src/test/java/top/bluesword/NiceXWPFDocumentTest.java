package top.bluesword;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.util.HashMap;

public class NiceXWPFDocumentTest {

    @Test
    void merge() throws Exception {
        NiceXWPFDocument word1 = compile();
        NiceXWPFDocument word2 = compile();
        word1.createParagraph().createRun().addBreak(BreakType.PAGE);
        NiceXWPFDocument niceXWPFDocument = word1.merge(word2);
        niceXWPFDocument.write(new FileOutputStream("target/海运INV完整模板导出测试.docx"));
    }

    private NiceXWPFDocument compile() {
        return XWPFTemplate
                .compile("海运INV+PW模板.docx")
                .render(
                    new HashMap<String, Object>(){{
                        put("title", "Hi, poi-tl Word模板引擎");
                    }}
                )
                .getXWPFDocument();
    }
}
