package top.bluesword.fund;

import java.io.IOException;

/**
 * @author 李林峰
 */
public class FundController {

    public static void main(String[] args) throws IOException {
        new FundRanking(new EastmoneyFundClient(),new ThymeleafFundHtmlWriter()).fundRanking();
    }

}
