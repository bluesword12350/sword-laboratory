package top.bluesword.laboratory;

import org.thymeleaf.context.Context;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 李林峰
 */
public class FundHtmlWriter {

    public static void write(List<Fund> funds, String fileName) throws IOException {
        write(funds,fileName,false);
    }

    public static void write(List<Fund> funds, String fileName,boolean showSellTime) throws IOException {
        Context context = new Context();
        context.setVariable("funds", funds);
        context.setVariable("showSellTime", showSellTime);
        context.setVariable("dateTimeFormatter", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        FileWriter fileWriter = new FileWriter(fileName+".html");
        HtmlBuilder.write("fund.html",context,fileWriter);
    }

}
