package okhttp3;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class HttpUrlTest {

    @Test
    void get() {
        HttpUrl httpUrl = HttpUrl.get("https://www.baidu.com");
        System.out.println(httpUrl);
    }

    @Test
    void resolve() {
        HttpUrl httpUrl = HttpUrl.get("https://www.baidu.com");
        httpUrl = httpUrl.resolve("s");
        System.out.println(httpUrl);
    }

    @Test
    void newBuilder() {
        HttpUrl httpUrl = HttpUrl.get("https://www.baidu.com");
        httpUrl = Objects.requireNonNull(httpUrl.newBuilder("s")).build();
        System.out.println(httpUrl);
    }

    @Test
    void addPathSegment() {
        HttpUrl httpUrl = HttpUrl.get("https://www.baidu.com").newBuilder().addPathSegment("img").addPathSegment("flexible").build();
        System.out.println(httpUrl);
    }

}
