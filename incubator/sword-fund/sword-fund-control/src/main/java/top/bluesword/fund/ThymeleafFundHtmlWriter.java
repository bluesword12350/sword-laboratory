package top.bluesword.fund;

import org.thymeleaf.context.Context;
import top.bluesword.fund.fund.Fund;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 李林峰
 */
public class ThymeleafFundHtmlWriter implements FundHtmlWriter{

    @Override
    public void write(List<Fund> funds, String fileName) throws IOException {
        write(funds,fileName,false);
    }

    @Override
    public void write(List<Fund> funds, String fileName,boolean showSellTime) throws IOException {
        Context context = new Context();
        context.setVariable("funds", funds);
        context.setVariable("showSellTime", showSellTime);
        context.setVariable("dateTimeFormatter", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        FileWriter fileWriter = new FileWriter(fileName+".html");
        HtmlBuilder.write("fund.html",context,fileWriter);
    }

}
