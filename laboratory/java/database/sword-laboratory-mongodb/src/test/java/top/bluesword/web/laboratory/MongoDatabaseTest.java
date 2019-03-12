package top.bluesword.web.laboratory;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDatabaseTest {

    private MongoDatabase mongoDatabase;

    @Test
    public void replaceOne() {
        try (MongoClient localhost = new MongoClient("localhost", 27017)) {
            mongoDatabase = localhost.getDatabase("laboratory");
            MongoCollection<Document> node = mongoDatabase.getCollection("node");
            for (Document doc : node.find()) {
                node.replaceOne(new Document("_id", doc.get("_id")), doc.append("说明", "项目作者"));
            }
        }
    }

    @Test
    public void findAll() {
        try (MongoClient localhost = new MongoClient("localhost", 27017)) {
            mongoDatabase = localhost.getDatabase("laboratory");
            MongoCollection<Document> node = mongoDatabase.getCollection("node");
            FindIterable<Document> documents = node.find();
            for (Document doc : documents) {
                System.out.println(doc.get("_id"));
            }
        }
    }

    @Test
    public void insertOne() {
        try (MongoClient localhost = new MongoClient("localhost", 27017)) {
            mongoDatabase = localhost.getDatabase("laboratory");
            MongoCollection<Document> node = mongoDatabase.getCollection("node");
            node.insertOne(new Document("name", "李林峰"));
        }
    }
}