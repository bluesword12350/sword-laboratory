package top.bluesword.fund;

import top.bluesword.fund.fund.FundMap;

import java.io.IOException;

/**
 * @author 李林峰
 */
public interface HoldFundClient {
    FundMap getHoldFunds() throws IOException;
}
