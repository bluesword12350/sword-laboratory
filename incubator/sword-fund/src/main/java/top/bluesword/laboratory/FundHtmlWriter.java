package top.bluesword.laboratory;

import org.thymeleaf.context.Context;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FundHtmlWriter {

    public static void write(List<Fund> funds, String fileName) throws IOException {
        Context context = new Context();
        context.setVariable("funds", funds);
        FileWriter fileWriter = new FileWriter(fileName+".html");
        HtmlBuilder.write("fund.html",context,fileWriter);
    }

}
