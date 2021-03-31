package top.bluesword.fund;

import top.bluesword.fund.fund.FundMap;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author 李林峰
 */
public interface FundClient {
    void searchYields(FundMap fundMap) throws IOException;

    FundMap searchFundRanking(LocalDate startDate, LocalDate endDate) throws IOException;
}
