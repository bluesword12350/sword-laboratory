package top.bluesword.java.text;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormatSymbols;

public class DecimalFormatSymbolsTest {

    @Test
    void test(){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        System.out.println(symbols.getCurrencySymbol());
    }
}
