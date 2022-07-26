package freemarker.template;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
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
        Map<String, Object> root = new HashMap<>(Map.of(
                "name", "Apache FreeMarker™",
                "url", "https://bluesword.top",
                "number", 4927878744830128128L,
                "numberStr", 4927878744830128128L
        ));
        root.put("null",null);
        temp.process(root, out);
    }

}
