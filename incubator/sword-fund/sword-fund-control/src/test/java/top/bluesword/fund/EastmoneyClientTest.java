package top.bluesword.fund;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

class EastmoneyClientTest {

    @Test
    void searchFundRanking() throws IOException {
        EastmoneyFundClient eastmoneyFundClient = new EastmoneyFundClient();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.plusYears(-1);
        System.out.println(eastmoneyFundClient.searchFundRanking(startDate, endDate));
    }

}
