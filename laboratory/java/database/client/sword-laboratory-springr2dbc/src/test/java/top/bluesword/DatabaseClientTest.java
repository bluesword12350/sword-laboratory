package top.bluesword;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@SpringBootApplication
@SpringBootTest
public class DatabaseClientTest {

    @Autowired
    DatabaseClient databaseClient;

    @Test
    void test() {
        Flux<Map<String, Object>> all = databaseClient.sql("select :num;").bind("num","5").fetch().all();
        System.out.println(all.blockFirst());
    }
}
