package top.bluesword.laboratory.repository;

import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.domain.*;
import top.bluesword.laboratory.domain.projection.DataGroup;
import top.bluesword.laboratory.domain.projection.DataModelQueryResult;

import java.util.List;
import java.util.Map;
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
    void containsIgnoreCase(){
        BooleanExpression expression = QDataModel.dataModel.name.containsIgnoreCase("aBc");
        Iterable<DataModel> all = dataModelQueryDslRepository.findAll(expression);
        log.info("{}",all);
    }

    @Test
    void isEmpty(){
        BooleanExpression expression = QDataModel.dataModel.name.isEmpty();
        Iterable<DataModel> all = dataModelQueryDslRepository.findAll(expression);
        log.info("{}",all);
    }

    @Test
    void groupByKey(){
        QDataModel qDataModel = QDataModel.dataModel;
        List<DataGroup> total = queryFactory
                .select(Projections.bean(DataGroup.class, qDataModel.key, qDataModel.count().as("total")))
                .from(qDataModel)
                .groupBy(qDataModel.key)
                .fetch();
        log.info("{}",total);
    }

    @Test
    void transformBean(){
        QDataModel qDataModel = QDataModel.dataModel;
        QDataFragment qDataFragment = QDataFragment.dataFragment;
        Map<Long, DataModelQueryResult> fragmentTitles = queryFactory
                .from(qDataModel)
                .leftJoin(qDataFragment).on(qDataFragment.dataModelId.eq(qDataModel.id))
                .transform(GroupBy.groupBy(qDataModel.id)
                        .as(Projections.bean(DataModelQueryResult.class, qDataModel.key, GroupBy.list(qDataFragment.title).as("fragmentTitles")))
                );
        log.info("{}",fragmentTitles);
    }

    @Test
    void transform(){
        QDataModel qDataModel = QDataModel.dataModel;
        QDataFragment qDataFragment = QDataFragment.dataFragment;
        Map<Long, List<String>> fragmentTitles = queryFactory
                .from(qDataModel)
                .leftJoin(qDataFragment).on(qDataFragment.dataModelId.eq(qDataModel.id))
                .transform(GroupBy.groupBy(qDataModel.id).as(GroupBy.list(qDataFragment.title).as("fragmentTitles"))
                );
        log.info("{}",fragmentTitles);
    }

    @Test
    void selectProjection(){
        QDataModel qDataModel = QDataModel.dataModel;
        List<String> keys = queryFactory
                .select(qDataModel.key)
                .from(qDataModel)
                .where(qDataModel.key.contains("f"))
                .fetch();
        log.info("keys:{}",keys);
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

    @Test
    void coalesce(){
        QDataModel qDataModel = QDataModel.dataModel;
        List<String> strings = queryFactory
                .select(
                        qDataModel.key.coalesce(qDataModel.name)
                )
                .from(qDataModel)
                .orderBy(qDataModel.key.coalesce(qDataModel.name).desc())
                .fetch();
        System.out.println(strings);
    }

}