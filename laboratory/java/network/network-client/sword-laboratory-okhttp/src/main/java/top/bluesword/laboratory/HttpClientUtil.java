package top.bluesword.laboratory;

import okhttp3.*;
import okhttp3.Request.Builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class HttpClientUtil {

    public static String sendUnsafeHttpsGet(String url, Map<String, String> paramMap, Map<String, String> headersMap) throws IOException {
        return sendGetForString(url, paramMap, headersMap, createUnsafeSslClient());
    }

    public static String sendGetForString(String url, Map<String, String> paramMap, Map<String, String> headersMap) throws IOException {
        return sendGetForString(url, paramMap, headersMap, new OkHttpClient());
    }

    private static String sendGetForString(String url, Map<String, String> paramMap, Map<String, String> headersMap, OkHttpClient httpClient) throws IOException {
        Response response = sendGet(url, paramMap, headersMap, httpClient);
        try(response) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    private static Response sendGet(String url, Map<String, String> paramMap, Map<String, String> headersMap, OkHttpClient httpClient) throws IOException {
        HttpUrl.Builder httpUrlBuilder = HttpUrl.get(url).newBuilder();
        if (Objects.nonNull(paramMap)) {
            for (Map.Entry<String, String> paramEntry : paramMap.entrySet()) {
                httpUrlBuilder.addQueryParameter(paramEntry.getKey(),paramEntry.getValue());
            }
        }
        Request request =
                new Request.Builder()
                        .headers(toHeaders(headersMap))
                        .url(httpUrlBuilder.build())
                        .build();
        return httpClient.newCall(request).execute();
    }

    private static InputStream sendGetForInputStream(String url, OkHttpClient httpClient) throws IOException {
        Response response = sendGet(url, null, null, httpClient);
        try(response) {
            return Objects.requireNonNull(response.body()).byteStream();
        }
    }

    public static String sendPostJson(String url, String json,Map<String, String> headersMap) throws IOException {
        return sendPostJson(url,json,toHeaders(headersMap));
    }

    public static String sendPostJson(String url, String json) throws IOException {
        return sendPostJson(url,json,Headers.of());
    }

    /**
     * 发送json格式的post请求
     *
     * @param url  访问地址
     * @param json 请求参数(json字符串)
     * @return 接收的参数
     */
    public static String sendPostJson(String url, String json, Headers headers) throws IOException {
        MediaType jsonMediaType = MediaType.parse("application/json");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create( json,jsonMediaType);
        Request request = new Builder().url(url).post(body).headers(headers).build();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    /**
     * 发送普通格式参数的post请求
     * @param url 请求地址
     * @param paramMap 参数
     * @param headers 请求头
     * @return 返回参数
     */
    public static String sendPostParam(String url, Map<String, String> paramMap, Headers headers) throws IOException {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (Objects.nonNull(paramMap)) {
            for (Map.Entry<String, String> paramEntry : paramMap.entrySet()) {
                formBodyBuilder.add(paramEntry.getKey(),paramEntry.getValue());
            }
        }
        Request request = new Builder().url(url).post(formBodyBuilder.build()).headers(headers).build();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public static Headers toHeaders(Map<String, String> headersMap) {
        if (Objects.nonNull(headersMap)) {
            return Headers.of(headersMap);
        }
        return Headers.of();
    }

    private static OkHttpClient createUnsafeSslClient() {
        return OkHttpClientFactory.buildUnsafeSslClient();
    }

}
