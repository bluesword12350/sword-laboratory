package freemarker.template;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class StaticModelTest {

    @Test
    void test() throws TemplateException, IOException {
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS).build();
        TemplateModel templateModel = beansWrapper.getStaticModels().get(Names.class.getName());

        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        cfg.setDirectoryForTemplateLoading(new File("src/test/resources"));
        Template temp = cfg.getTemplate("StaticModels.ftlh");
        Map<String, Object> root = Map.of("Names", templateModel);
        StringWriter out = new StringWriter();
        temp.process(root, out);
        System.out.println(out);
    }

    public static class Names {
        public static final String name = "Apache FreeMarker™";
    }
}
