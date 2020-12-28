package top.bluesword.laboratory;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
public class CookieJarImpl implements CookieJar {

    private final ThreadLocal<Map<String,Cookie>> cookies = ThreadLocal.withInitial(HashMap::new);

    @Override
    public void saveFromResponse(@NotNull HttpUrl httpUrl, List<Cookie> list) {
        list.forEach(cookie -> cookies.get().put(cookie.domain()+"_"+cookie.name()+"_"+cookie.path(),cookie));
    }

    @NotNull
    @Override
    public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
        return new ArrayList<>(cookies.get().values());
    }

}
