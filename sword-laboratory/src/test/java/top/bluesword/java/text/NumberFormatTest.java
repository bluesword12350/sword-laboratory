package top.bluesword.java.text;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberFormatTest {

    @Test
    void currencyFormat(){
        System.out.println(NumberFormat.getCurrencyInstance().format(12));
    }

    @Test
    void parse() throws ParseException {
        System.out.println(NumberFormat.getPercentInstance().parse("3.50%"));
    }
}
