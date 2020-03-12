package top.bluesword.web.laboratory;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebLaboratoryTest {

    @Autowired
    GraphDatabaseService gdb;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getAllNodes() {
        try (Transaction tx = gdb.beginTx()) {
            ResourceIterable<Node> allNodes = gdb.getAllNodes();
            System.out.println(JSON.toJSONString(allNodes));
            tx.success();
        }
    }

    @Test
    public void createNode() {
        try (Transaction tx = gdb.beginTx()) {
            Node node = gdb.createNode();
            node.addLabel(Label.label("人"));
            node.setProperty("姓名", "李林峰");
            tx.success();
        }
    }


}