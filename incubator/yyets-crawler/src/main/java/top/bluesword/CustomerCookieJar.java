package top.bluesword;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李林峰
 */
public class CustomerCookieJar implements CookieJar {

    private final List<Cookie> cookies = new ArrayList<>();

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        return cookies;
    }

    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        cookies.addAll(list);
    }
}
