package org.jsoup;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import top.bluesword.util.network.HttpClientUtil;

import java.io.IOException;

class JsoupTest {
    @Test
    void parseTest() throws IOException {
        String html = HttpClientUtil.sendGet("https://www.baidu.com/");
        Document document = Jsoup.parse(html);
        System.out.println(document.body().select("form").get(0));
    }
}