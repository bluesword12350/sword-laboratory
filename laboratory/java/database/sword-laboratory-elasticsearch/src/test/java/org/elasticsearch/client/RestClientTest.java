package org.elasticsearch.client;

import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RestClientTest {

    private static RestClient restClient;

    @BeforeAll
    static void before() {
        restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http")
        ).build();
    }

    @Test
    void all() throws IOException {
        Request request = new Request("GET","_all");
        Response response = restClient.performRequest(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @AfterAll
    static void after() throws IOException {
        restClient.close();
    }
}
