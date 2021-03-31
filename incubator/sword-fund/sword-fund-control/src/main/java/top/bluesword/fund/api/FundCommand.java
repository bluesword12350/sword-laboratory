package top.bluesword.fund.api;

import top.bluesword.fund.FundRankingService;
import top.bluesword.fund.io.EastmoneyFundClient;
import top.bluesword.fund.io.ThymeleafFundHtmlWriter;

import java.io.IOException;

/**
 * @author 李林峰
 */
public class FundCommand {

    public static void main(String[] args) throws IOException {
        new FundRankingService(new EastmoneyFundClient(),new ThymeleafFundHtmlWriter()).fundRanking();
    }

}
