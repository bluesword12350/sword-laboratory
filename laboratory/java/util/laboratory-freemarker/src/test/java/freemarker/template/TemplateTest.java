package freemarker.template;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

public class TemplateTest {

    @Test
    void process() throws IOException, TemplateException {
        StringWriter out = new StringWriter();
        process(out);
        System.out.println(out.toString());
    }

    @Test
    void outFile() throws IOException, TemplateException {
        process(new FileWriter("test.html"));
    }

    private void process(Writer out) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("src/test/resources"));
        Template temp = cfg.getTemplate("test.ftlh");
        Map<String, String> root = Map.of("name", "Apache FreeMarker™");
        temp.process(root, out);
    }

}
