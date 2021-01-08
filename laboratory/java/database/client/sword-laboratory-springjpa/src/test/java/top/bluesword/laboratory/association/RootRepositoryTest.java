package top.bluesword.laboratory.association;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RootRepositoryTest {

    @Autowired
    RootRepository rootRepository;

    @Test
    void save(){
        Root root = new Root();
        root.setBody(new Body());
        Leaf leaf = new Leaf();
        leaf.setBody(new Body());
        root.setLeaves(List.of(leaf));
        rootRepository.save(root);
    }

}