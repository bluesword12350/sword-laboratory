package top.bluesword.fund.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * @author 李林峰
 */
public class HtmlBuilder {

    public static void write(String template, Context context, Writer writer) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheTTLMs(3600000L);
        templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.process(template, context,writer);
    }

}
