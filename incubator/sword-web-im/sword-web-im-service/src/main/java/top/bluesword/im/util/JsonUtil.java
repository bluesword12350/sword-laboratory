package top.bluesword.im.util;

import com.google.gson.Gson;

/**
 * @author 李林峰
 */
public class JsonUtil {

    private static final Gson GSON = new Gson();

    public static <T> T fromJson(String jsonText, Class<T> objClass) {
        return GSON.fromJson(jsonText,objClass);
    }

    public static String toJson(Object jsonObj) {
        return GSON.toJson(jsonObj);
    }
}
