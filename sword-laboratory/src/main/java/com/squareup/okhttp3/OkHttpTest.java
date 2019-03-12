package com.squareup.okhttp3;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class OkHttpTest {

    @Test
    void get() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Test
    String post() throws IOException {
        String url = "https://www.baidu.com";
        String json = "{}";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
