package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class StringTest {

    @Test
    void charsetTest(){
        byte[] bytes = "你好".getBytes();

        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        System.out.println(new String(bytes, StandardCharsets.ISO_8859_1));
        System.out.println(new String(bytes, StandardCharsets.US_ASCII));
        System.out.println(new String(bytes, StandardCharsets.UTF_16));

        System.out.println(new String(bytes, Charset.forName("GBK")));
        System.out.println(new String(bytes, Charset.forName("GB18030")));
        System.out.println(new String(bytes, Charset.forName("GB2312")));
        System.out.println(new String(bytes, Charset.forName("Big5")));
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
		String string2 = String.format("%0"+(16-string.length())+"d%s",0,string);
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