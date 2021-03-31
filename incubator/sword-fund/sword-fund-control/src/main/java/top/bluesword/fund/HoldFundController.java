package top.bluesword.fund;

import java.io.IOException;

/**
 * @author 李林峰
 */
public class HoldFundController {

    public static void main(String[] args) throws IOException {
        new HoldFund(new VikaHoldFundClient(),new EastmoneyFundClient(),new ThymeleafFundHtmlWriter()).holdFund();
    }

}
