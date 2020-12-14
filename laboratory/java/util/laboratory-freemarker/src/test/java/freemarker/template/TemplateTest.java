package freemarker.template;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

public class TemplateTest {

    @Test
    void process() throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("src/test/resources"));
        Template temp = cfg.getTemplate("test.ftlh");
        Map<String, String> root = Map.of("name", "Apache FreeMarker™");
        StringWriter out = new StringWriter();
        temp.process(root, out);
        System.out.println(out.toString());
    }
}
