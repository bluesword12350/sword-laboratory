package top.bluesword.fund.api;

import top.bluesword.fund.HoldFund;
import top.bluesword.fund.io.EastmoneyFundClient;
import top.bluesword.fund.io.ThymeleafFundHtmlWriter;
import top.bluesword.fund.io.VikaHoldFundClient;

import java.io.IOException;

/**
 * @author 李林峰
 */
public class HoldFundController {

    public static void main(String[] args) throws IOException {
        new HoldFund(new VikaHoldFundClient(),new EastmoneyFundClient(),new ThymeleafFundHtmlWriter()).holdFund();
    }

}
