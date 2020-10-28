package top.bluesword;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

/**
 * @author 李林峰
 * http://www.yyets.com/
 */
public class YyetsCrawler {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().cookieJar(new CustomerCookieJar()).build();
        HttpUrl baseUrl;
        {
            String url = "http://www.rrys.tv/";
            Request request0 = new Request.Builder()
                    .url(url)
                    .build();
            try (Response response = client.newCall(request0).execute()) {
                String html = Objects.requireNonNull(response.body()).string();
                Document document = Jsoup.parse(html);
                Elements elements = document.select("p.domain > a");
                String nextUrl = elements.attr("href");
                baseUrl = HttpUrl.get(nextUrl+"/resourcelist");
            }
        }
        for (int i = 1; i < 2; i++) {
            HttpUrl url = baseUrl.newBuilder()
                    .addQueryParameter("sort", "update")
                    .addQueryParameter("page", String.valueOf(i))
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Document document;
            try (Response response = client.newCall(request).execute()) {
                String html = Objects.requireNonNull(response.body()).string();
                document = Jsoup.parse(html);
            }
            Elements elements = document.select("div.resource-showlist").select("dt").select("a");
            OutFileUtils.outPutFile(elements.toString(),"yyets");
        }
    }

}
