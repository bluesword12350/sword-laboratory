package top.bluesword;

import com.deepoove.poi.XWPFTemplate;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class XwpfTemplateTest {

    @Test
    void compile() throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("海运INV+PW模板.docx").render(
                new HashMap<String, Object>(){{
                    put("title", "Hi, poi-tl Word模板引擎");
                }});
        template.writeAndClose(new FileOutputStream("output.docx"));
    }

}
