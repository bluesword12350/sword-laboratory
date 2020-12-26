package top.bluesword;

import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * @author 李林峰
 */
public class OkHttpClientFactory {

    public OkHttpClient buildUnsafeSslClient() {
        try {
            X509TrustManager x509TrustManager = getX509TrustManager();
            final SSLSocketFactory sslSocketFactory = getSslSocketFactory(x509TrustManager);
            return new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory,x509TrustManager)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private SSLSocketFactory getSslSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
        return sslContext.getSocketFactory();
    }

    @NotNull
    private X509TrustManager getX509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
        };
    }

}
