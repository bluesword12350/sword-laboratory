package top.bluesword.laboratory;

import org.apache.commons.codec.CharEncoding;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class HttpClientUtil {

    public static String sendUnsafeHttpsGet(String url, Map<String, String> paramMap, Map<String, String> headersMap) throws IOException, ParseException, URISyntaxException {
        try (CloseableHttpClient httpClient = createUnsafeSslClient()) {
            return sendGetForString(url, paramMap, headersMap, httpClient);
        }
    }

    public static String sendGetForString(String url, Map<String, String> paramMap, Map<String, String> headersMap) throws IOException, ParseException, URISyntaxException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            return sendGetForString(url, paramMap, headersMap, httpClient);
        }
    }

    private static String sendGetForString(String url, Map<String, String> paramMap, Map<String, String> headersMap, CloseableHttpClient httpClient) throws IOException, ParseException, URISyntaxException {
        CloseableHttpResponse response = sendGet(url, paramMap, headersMap, httpClient);
        return EntityUtils.toString(response.getEntity());
    }

    private static CloseableHttpResponse sendGet(String url, Map<String, String> paramMap, Map<String, String> headersMap, CloseableHttpClient httpClient) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(url).setParameters(toParamMap(paramMap)).build();
        HttpGet httpGet = new HttpGet(uri);
        if (headersMap != null) {
            for (Map.Entry<String, String> entry : headersMap.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }
        return httpClient.execute(httpGet);
    }

    private static InputStream sendGetForInputStream(String url, CloseableHttpClient httpClient) throws IOException, URISyntaxException {
        CloseableHttpResponse closeableHttpResponse = sendGet(url, null, null, httpClient);
        return closeableHttpResponse.getEntity().getContent();
    }

    public static String sendPostJson(String url, String json,Map<String, String> headersMap) throws IOException, ParseException {
        return sendPostJson(url,json,toHeaders(headersMap));
    }

    public static String sendPostJson(String url, String json) throws IOException, ParseException {
        return sendPostJson(url,json,new Header[0]);
    }

    /**
     * 发送json格式的post请求
     *
     * @param url  访问地址
     * @param json 请求参数(json字符串)
     * @return 接收的参数
     */
    public static String sendPostJson(String url, String json, Header[] headers) throws IOException, ParseException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Encoding", CharEncoding.UTF_8);
            httpPost.setHeader("content-type", "application/json");
            httpPost.setHeaders(headers);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        }
    }

    /**
     * 发送普通格式参数的post请求
     * @param url 请求地址
     * @param paramMap 参数
     * @param headers 请求头
     * @return 返回参数
     */
    public static String sendPostParam(String url, Map<String, String> paramMap, Header[] headers) throws IOException, ParseException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(toParamMap(paramMap), StandardCharsets.UTF_8));
            httpPost.setHeaders(headers);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        }
    }

    public static Header[] toHeaders(Map<String, String> headersMap) {
        if (Objects.isNull(headersMap)) {
            return null;
        }
        List<Header> headers = new ArrayList<>();
        for (Map.Entry<String, String> entry : headersMap.entrySet()) {
            headers.add(new BasicHeader(entry.getKey(),entry.getValue()));
        }
        return headers.toArray(new Header[0]);
    }

    private static List<NameValuePair> toParamMap(Map<String, String> paramMap) {
        List<NameValuePair> params = new ArrayList<>();
        if (paramMap != null) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return params;
    }

    private static CloseableHttpClient createUnsafeSslClient() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            PoolingHttpClientConnectionManager connectionManager = 
                    PoolingHttpClientConnectionManagerBuilder.create().setSSLSocketFactory(sslConnectionSocketFactory).build();
            return HttpClients.custom().setConnectionManager(connectionManager).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            return HttpClients.createDefault();
        }
    }

}
