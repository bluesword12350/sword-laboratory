package top.bluesword.laboratory.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.domain.DataContext;
import top.bluesword.laboratory.domain.DataFragment;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.domain.QDataFragment;
import top.bluesword.laboratory.domain.QDataModel;

import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootTest
class DataModelRepositoryTest {

    @Autowired
    private DataModelQueryDslRepository dataModelQueryDslRepository;
    @Autowired
    private JPAQueryFactory queryFactory;

    @Test
    void save() {
        dataModelQueryDslRepository.save(DataModelMock());
    }

    private DataModel DataModelMock() {
        DataModel dataModel = new DataModel();
        dataModel.setKey(UUID.randomUUID().toString());
        DataContext dataContext = new DataContext();
        dataContext.setFragments(List.of(new DataFragment("段落1"),new DataFragment("段落2")));
        dataModel.setContext(dataContext);
        return dataModel;
    }

    @Test
    void selectProjectionForJoinTable(){
        QDataModel qDataModel = QDataModel.dataModel;
        QDataFragment qDataFragment = QDataFragment.dataFragment;
        List<String> titles = queryFactory
                .select(qDataFragment.title)
                .from(qDataModel)
                .leftJoin(qDataFragment).on(qDataFragment.dataModelId.eq(qDataModel.id))
                .where(qDataFragment.title.contains("段落"))
                .fetch();
        log.info("titles:{}",titles);
    }

}