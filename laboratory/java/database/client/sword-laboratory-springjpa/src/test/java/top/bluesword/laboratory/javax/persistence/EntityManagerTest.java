package top.bluesword.laboratory.javax.persistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.mock.DataModelMock;

import javax.persistence.EntityManager;

@Slf4j
@SpringBootTest
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional(rollbackFor = Throwable.class)
    void persist(){
        DataModel dataModel = DataModelMock.mock();
        entityManager.persist(dataModel);
        log.info("persist dataModel0: {}",dataModel);
    }

}
