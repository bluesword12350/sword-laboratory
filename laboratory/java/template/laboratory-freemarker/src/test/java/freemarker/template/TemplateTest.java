package freemarker.template;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

public class TemplateTest {

    @Test
    void process() throws IOException, TemplateException {
        StringWriter out = new StringWriter();
        process(out);
        System.out.println(out);
    }

    @Test
    void outFile() throws IOException, TemplateException {
        process(new FileWriter("target/test.html"));
    }

    private void process(Writer out) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        cfg.setDirectoryForTemplateLoading(new File("src/test/resources"));
        Template temp = cfg.getTemplate("test.ftlh");
        Map<String, String> root = Map.of(
                "name", "Apache FreeMarker™",
                "url","https://bluesword.top"
        );
        temp.process(root, out);
    }

}
