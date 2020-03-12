package com.squareup.okhttp3;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

class OkHttpTest {

    @Test
    void get() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(Objects.requireNonNull(response.body()).string());
    }

    @Test
    void post() throws IOException {
        String url = "https://www.baidu.com";
        String json = "{}";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(Objects.requireNonNull(response.body()).string());
    }
}