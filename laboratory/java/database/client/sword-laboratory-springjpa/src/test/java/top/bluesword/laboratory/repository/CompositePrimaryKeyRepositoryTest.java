package top.bluesword.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.domain.CompositePrimaryKey;
import top.bluesword.laboratory.domain.CompositePrimaryKeyTable;

@SpringBootTest
class CompositePrimaryKeyRepositoryTest {

    @Autowired
    private CompositePrimaryKeyRepository compositePrimaryKeyRepository;

    @Test
    void save() {
        CompositePrimaryKeyTable compositePrimaryKeyTable = new CompositePrimaryKeyTable();
        compositePrimaryKeyTable.setCompositePrimaryKey(new CompositePrimaryKey("1","1"));
        compositePrimaryKeyRepository.save(compositePrimaryKeyTable);
    }

    @Test
    void findAll() {
        System.out.println(compositePrimaryKeyRepository.findAll());
    }

}