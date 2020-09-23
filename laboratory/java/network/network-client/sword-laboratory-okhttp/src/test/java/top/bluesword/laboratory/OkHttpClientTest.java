package top.bluesword.laboratory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

public class OkHttpClientTest {

    private final OkHttpClient client = new OkHttpClient();

    @Test
    void test() throws IOException {
        String url = "https://github.com/square/okhttp";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = Objects.requireNonNull(response.body()).string();
            System.out.println(string);
        }
    }
}
