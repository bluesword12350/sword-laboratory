package top.bluesword;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

class OkHttpClientFactoryTest {

    @Test
    void buildUnsafeSslClient() throws IOException {
        OkHttpClient client = new OkHttpClientFactory().buildUnsafeSslClient();
        String url = "https://bluesword.top";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = Objects.requireNonNull(response.body()).string();
            System.out.println(string);
        }
    }
}