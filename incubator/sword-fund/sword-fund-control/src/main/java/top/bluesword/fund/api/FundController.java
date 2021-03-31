package top.bluesword.fund.api;

import top.bluesword.fund.FundRanking;
import top.bluesword.fund.io.EastmoneyFundClient;
import top.bluesword.fund.io.ThymeleafFundHtmlWriter;

import java.io.IOException;

/**
 * @author 李林峰
 */
public class FundController {

    public static void main(String[] args) throws IOException {
        new FundRanking(new EastmoneyFundClient(),new ThymeleafFundHtmlWriter()).fundRanking();
    }

}
