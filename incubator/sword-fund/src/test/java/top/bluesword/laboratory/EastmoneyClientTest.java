package top.bluesword.laboratory;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

class EastmoneyClientTest {

    @Test
    void searchFundRanking() throws IOException {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.plusYears(-1);
        System.out.println(EastmoneyClient.searchFundRanking(startDate, endDate));
    }

}
