package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringTest {

    @Test
    void emoji() {
        System.out.println("\uD83D\uDE18");
    }

    @Test
    void substring() {
        System.out.println("abc.substring(2):"+"abc".substring(3,3));
    }

    @Test
    void contentEquals() {
        System.out.println("leftTrim".contentEquals(new StringBuilder("leftTrim")));
    }

    @Test
    void join(){
        System.out.println(String.join("-", List.of("1", "2","3")));
    }

    @Test
    void indexOf(){
        System.out.println("Asd".indexOf("As"));
    }

    @Test
    void charsetTest(){
        String source = "你好";
        byte[] bytes = "你好".getBytes();
        Charset[] charsets = new Charset[]{
                StandardCharsets.UTF_8,StandardCharsets.ISO_8859_1,StandardCharsets.US_ASCII,StandardCharsets.UTF_16,
                Charset.forName("GBK"),Charset.forName("GB18030"),Charset.forName("GB2312"),Charset.forName("Big5")
        };
        List<Charset> possibleCharset = new ArrayList<>();
        for (Charset charset : charsets) {
            if (source.equals(new String(bytes, charset))) {
                possibleCharset.add(charset);
            }
        }
        if (possibleCharset.isEmpty()) {
            System.out.println("没有找到匹配的编码");
        } else {
            System.out.println("可能的编码有："+possibleCharset);
        }
    }

    @Test
    void testStrip(){
        String text = "  \u2000a  b  ";
        System.out.println("\u2000");
        System.out.println(text.strip());
        System.out.println(text.trim());
        System.out.println("a  b  ".equals(text.stripLeading()));
        System.out.println("  \u2000a  b".equals(text.stripTrailing()));
    }

    @Test
    void formatTest() {
		String string = "DS16AWARDS";
		String string2 = String.format("%08d%s",12345,string);
		System.out.println(string2);
		System.out.println(string2.length());

        String aaa = String.format("%-12s", "aaa");
        System.out.println(aaa);
        System.out.println(aaa.length());

        String aaa1 = String.format("%12s", "aaa");
        System.out.println(aaa1);
        System.out.println(aaa1.length());
    }

    @Test
    void dateTimeFormatTest() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.printf("%1$tY%1$tm%1$td %1$tH:%1$tM",now);
    }

    @Test
    void formatTest0() {
        System.out.printf("AND updated >= -%dm%n", 30);
    }

	@Test
    void stringSort(){
        String[] s = {"121","1212","12","1212"};
        Arrays.sort(s, (o1, o2) -> {
            char[] c1 = o1.toCharArray();
            char[] c2 = o2.toCharArray();
            int c1l = c1.length,c2l = c2.length,
                    b = Math.max(c1l, c2l),
                    m = Math.min(c1l, c2l);
            for (int i = 0;; i++) {
                char cc1 = i>=c1l? c1[i%c1l] : c1[i];
                char cc2 = i>=c2l? c2[i%c2l] : c2[i];
                if (cc1<cc2) {
                    return 1;
                }else if (cc1>cc2) {
                    return -1;
                }else if (i==b && b%m == 0) {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(s));
    }
}