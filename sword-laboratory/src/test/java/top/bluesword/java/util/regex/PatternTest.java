package top.bluesword.java.util.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PatternTest {

    @Test
    void matches() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher("1123");
        System.out.println(m.matches());
    }
}
