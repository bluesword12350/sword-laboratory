package top.bluesword.laboratory.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.projection.DataFragmentProjection;

import java.util.List;

@Slf4j
@SpringBootTest
class DataFragmentProjectionRepositoryTest {

    @Autowired
    private DataFragmentProjectionRepository dataFragmentProjectionRepository;

    @Test
    void findBy() {
        List<DataFragmentProjection> dataFragmentProjections = dataFragmentProjectionRepository.findByTitle("简介");
        log.info("dataFragmentProjections:{}",dataFragmentProjections);
        log.warn("JPA查询方法配置实体导航（EntityGraph）时，实际sql与直接使用领域模型一致，与投影（Projection）预期不一致");
    }

}