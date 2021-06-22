package top.bluesword.laboratory;

import com.mongodb.client.*;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoDatabaseTest {

    private MongoDatabase mongoDatabase;

    @Test
    public void replaceOne() {
        try (MongoClient localhost = MongoClients.create()) {
            mongoDatabase = localhost.getDatabase("laboratory");
            MongoCollection<Document> node = mongoDatabase.getCollection("node");
            for (Document doc : node.find()) {
                node.replaceOne(new Document("_id", doc.get("_id")), doc.append("说明", "项目作者"));
            }
        }
    }

    @Test
    public void findAll() {
        try (MongoClient localhost = MongoClients.create()) {
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
        try (MongoClient localhost = MongoClients.create()) {
            mongoDatabase = localhost.getDatabase("laboratory");
            MongoCollection<Document> node = mongoDatabase.getCollection("node");
            node.insertOne(new Document("name", "李林峰"));
        }
    }
}