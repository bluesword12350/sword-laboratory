package top.bluesword.laboratory.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.projection.DataModelProjection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DataModelProjectionJpaRepositoryTest {

    @Autowired
    private DataModelProjectionJpaRepository dataModelProjectionJpaRepository;

    @Test
    void findByCode() {
        List<DataModelProjection> dataModelProjections = dataModelProjectionJpaRepository.findByCode("code");
        log.info("{}",dataModelProjections);
    }

}
