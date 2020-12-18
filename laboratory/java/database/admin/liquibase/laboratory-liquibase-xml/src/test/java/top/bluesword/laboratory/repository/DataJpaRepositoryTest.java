package top.bluesword.laboratory.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.domain.DataModel;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@Slf4j
class DataJpaRepositoryTest {

    @Autowired
    private DataJpaRepository dataJpaRepository;

    @Test
    void save() {
        DataModel dataModel = new DataModel();
        dataModel.setSize(new BigDecimal("100000000000000000000000000000.1000465441"));
        dataJpaRepository.save(dataModel);
    }

    @Test
    void findAll() {
        List<DataModel> all = dataJpaRepository.findAll();
        log.info("{}",all);
    }

}