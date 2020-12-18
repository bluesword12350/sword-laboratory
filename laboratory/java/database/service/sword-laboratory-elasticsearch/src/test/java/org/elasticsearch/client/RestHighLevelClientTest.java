package org.elasticsearch.client;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class RestHighLevelClientTest {

    private static RestHighLevelClient restHighLevelClient;

    @BeforeAll
    static void before() {
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );
    }

    @Test
    void test() throws IOException {
        SearchResponse search = restHighLevelClient.search(new SearchRequest(), RequestOptions.DEFAULT);
        System.out.println(search);
    }

}
