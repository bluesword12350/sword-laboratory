package top.bluesword.java.text;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class NumberFormatTest {

    @Test
    void currencyFormat(){
        System.out.println(NumberFormat.getCurrencyInstance().format(12));
    }
}
