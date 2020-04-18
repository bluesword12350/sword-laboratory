package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    @Test
    void test(){
        Currency currency = Currency.getInstance(Locale.getDefault());
        System.out.println(currency.getSymbol());
    }
}
