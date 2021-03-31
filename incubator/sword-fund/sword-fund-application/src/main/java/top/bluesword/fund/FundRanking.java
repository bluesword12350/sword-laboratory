package top.bluesword.fund;

import top.bluesword.fund.fund.Fund;
import top.bluesword.fund.fund.FundMap;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class FundRanking {

    private final FundClient fundClient;
    private final FundHtmlWriter fundHtmlWriter;

    public FundRanking(FundClient fundClient,FundHtmlWriter fundHtmlWriter) {
        this.fundClient = fundClient;
        this.fundHtmlWriter = fundHtmlWriter;
    }

    public void fundRanking() throws IOException {
        int year = LocalDate.now().getYear() - 1;
        LocalDate oneYearEnd = LocalDate.of(year, 12, 31);
        LocalDate twoYearEnd = oneYearEnd.plusYears(-1);
        LocalDate threeYearEnd = twoYearEnd.plusYears(-1);
        LocalDate fourYearEnd = threeYearEnd.plusYears(-1);
        FundMap oneYearRank = this.fundClient.searchFundRanking(twoYearEnd, oneYearEnd);
        this.fundHtmlWriter.write(List.copyOf(oneYearRank.values()),oneYearEnd.getYear()+"年基金排行榜");
        FundMap twoYearRank = this.fundClient.searchFundRanking(threeYearEnd, twoYearEnd);
        this.fundHtmlWriter.write(List.copyOf(twoYearRank.values()),twoYearEnd.getYear()+"年基金排行榜");
        FundMap threeYearRank = this.fundClient.searchFundRanking(fourYearEnd, threeYearEnd);
        this.fundHtmlWriter.write(List.copyOf(threeYearRank.values()),threeYearEnd.getYear()+"年基金排行榜");

        FundMap oneAndTwoFund = new FundMap();
        for (Fund fund : twoYearRank.values()) {
            if (oneYearRank.containsKey(fund.getCode())) {
                oneAndTwoFund.add(fund);
            }
        }
        FundMap allYearFund = new FundMap();
        for (Fund fund : threeYearRank.values()) {
            if (oneAndTwoFund.containsKey(fund.getCode())) {
                allYearFund.add(fund);
            }
        }
        this.fundClient.searchYields(allYearFund);
        List<Fund> funds = allYearFund.values().stream().sorted(Fund.YIELD_COMPARATOR.reversed()).collect(Collectors.toList());
        this.fundHtmlWriter.write(funds,threeYearEnd.getYear()+"到"+oneYearEnd.getYear()+"年上榜基金");
    }

}
