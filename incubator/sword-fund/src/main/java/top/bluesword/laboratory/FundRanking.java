package top.bluesword.laboratory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class FundRanking {

    public static void main(String[] args) throws IOException {
        fundRanking();
    }

    private static void fundRanking() throws IOException {
        int year = LocalDate.now().getYear() - 1;
        LocalDate oneYearEnd = LocalDate.of(year, 12, 31);
        LocalDate twoYearEnd = oneYearEnd.plusYears(-1);
        LocalDate threeYearEnd = twoYearEnd.plusYears(-1);
        LocalDate fourYearEnd = threeYearEnd.plusYears(-1);
        FundMap oneYearRank = EastmoneyClient.searchFundRanking(twoYearEnd, oneYearEnd);
        FundHtmlWriter.write(List.copyOf(oneYearRank.values()),oneYearEnd.getYear()+"年基金排行榜");
        FundMap twoYearRank = EastmoneyClient.searchFundRanking(threeYearEnd, twoYearEnd);
        FundHtmlWriter.write(List.copyOf(twoYearRank.values()),twoYearEnd.getYear()+"年基金排行榜");
        FundMap threeYearRank = EastmoneyClient.searchFundRanking(fourYearEnd, threeYearEnd);
        FundHtmlWriter.write(List.copyOf(threeYearRank.values()),threeYearEnd.getYear()+"年基金排行榜");

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
        List<Fund> funds = allYearFund.values().stream().sorted(Fund.YIELD_COMPARATOR.reversed()).collect(Collectors.toList());
        FundHtmlWriter.write(funds,threeYearEnd.getYear()+"到"+oneYearEnd.getYear()+"年上榜基金");
    }

}
