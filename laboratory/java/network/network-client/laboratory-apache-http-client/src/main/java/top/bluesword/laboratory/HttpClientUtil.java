package top.bluesword.laboratory;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
public class HttpClientUtil {

    public static String sendUnsafeHttpsGet(String url, Map<String, String> paramMap, Map<String, String> headersMap) throws IOException {
        try (CloseableHttpClient httpClient = createUnsafeSslClient()) {
            return sendGet(url, paramMap, headersMap, httpClient);
        }
    }

    public static String sendGet(String url, Map<String, String> paramMap, Map<String, String> headersMap) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            return sendGet(url, paramMap, headersMap, httpClient);
        }
    }

    private static String sendGet(String url, Map<String, String> paramMap, Map<String, String> headersMap, CloseableHttpClient httpClient) throws IOException {
        String param = URLEncodedUtils.format(toParamMap(paramMap), CharEncoding.UTF_8);
        if (StringUtils.isNotBlank(param)) {
            param = "?" + param;
        }
        HttpGet httpGet = new HttpGet(url + param);
        if (headersMap != null) {
            for (Map.Entry<String, String> entry : headersMap.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = httpClient.execute(httpGet);
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * 发送json格式的post请求
     *
     * @param url  访问地址
     * @param json 请求参数(json字符串)
     * @return 接收的参数
     */
    public static String sendPostJson(String url, String json) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(json, CharEncoding.UTF_8);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Encoding", CharEncoding.UTF_8);
            httpPost.setHeader("content-type", "application/json");
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
    public static String sendPostParam(String url, Map<String, String> paramMap, Header[] headers) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(toParamMap(paramMap), CharEncoding.UTF_8));
            httpPost.setHeaders(headers);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        }
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
            return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            return HttpClients.createDefault();
        }
    }

}
