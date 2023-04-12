package top.bluesword.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Locale;

@Slf4j
public class CurrencyTest {

    @Test
    void test(){
        Currency currency = Currency.getInstance(Locale.getDefault());
        log.info("currency.currencyCode:{}",currency.getCurrencyCode());
        log.info("currency.symbol:{}",currency.getSymbol());
        log.info("currency.getDisplayName(Locale.CHINA):{}",currency.getDisplayName(Locale.CHINA));
    }
}
