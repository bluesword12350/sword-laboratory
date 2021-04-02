package top.bluesword.laboratory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.r2dbc.core.DatabaseClient;

@SpringBootTest
public class DatabaseClientTest {

    @Autowired
    DatabaseClient databaseClient;

    @Test
    void test() {
        System.out.println(databaseClient.sql("select 1").fetch().all().blockFirst());
    }

}
