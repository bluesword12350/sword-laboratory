package top.bluesword.web.laboratory;

import org.junit.Test;
import org.neo4j.driver.v1.*;

public class Neo4jDriverTest {

    @Test
    public void getAll() {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687");
        try (Session session = driver.session()) {
            StatementResult result = session.run("match (n) return n");
            while (result.hasNext()) {
                Record record = result.next();
                record.values();
                for (Value value :record.values()) {
                    System.out.println(value);
                }
            }
        }
        driver.close();
    }
}
