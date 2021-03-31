package top.bluesword.fund;

import lombok.AllArgsConstructor;
import top.bluesword.fund.fund.Fund;
import top.bluesword.fund.fund.FundMap;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
@AllArgsConstructor
public class HoldFundService {

    private final HoldFundClient holdFundClient;
    private final FundClient fundClient;
    private final FundHtmlWriter fundHtmlWriter;

    public void holdFund() throws IOException {
        FundMap fundMap = this.holdFundClient.getHoldFunds();
        this.fundClient.searchYields(fundMap);
        List<Fund> funds = sortFunds(fundMap);
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        this.fundHtmlWriter.write(funds,date + "持有基金近三年收益率报告",true);
    }

    private static List<Fund> sortFunds(FundMap fundMap) {
        return fundMap.values().stream()
                .sorted(Fund.YIELD_COMPARATOR.reversed())
                .collect(Collectors.toList());
    }

}
