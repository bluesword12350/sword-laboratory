package top.bluesword.fund.api;

import top.bluesword.fund.HoldFundService;
import top.bluesword.fund.io.EastmoneyFundClient;
import top.bluesword.fund.io.ThymeleafFundHtmlWriter;
import top.bluesword.fund.io.VikaHoldFundClient;

import java.io.IOException;

/**
 * @author 李林峰
 */
public class HoldFundCommand {

    public static void main(String[] args) throws IOException {
        new HoldFundService(new VikaHoldFundClient(),new EastmoneyFundClient(),new ThymeleafFundHtmlWriter()).holdFund();
    }

}
