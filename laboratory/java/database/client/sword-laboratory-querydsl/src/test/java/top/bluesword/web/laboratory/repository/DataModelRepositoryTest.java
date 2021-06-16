package top.bluesword.web.laboratory.repository;

import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.domain.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        BooleanExpression expression = QDataForQueryDsl.dataForQueryDsl.name.containsIgnoreCase("aBc");
        Iterable<DataModel> all = dataModelQueryDslRepository.findAll(expression);
        System.out.println(all);
    }

    @Test
    void groupByKey(){
        QDataForQueryDsl qDataForQueryDsl = QDataForQueryDsl.dataForQueryDsl;
        List<DataGroup> total = queryFactory
                .select(Projections.bean(DataGroup.class, qDataForQueryDsl.key, qDataForQueryDsl.count().as("total")))
                .from(qDataForQueryDsl)
                .groupBy(qDataForQueryDsl.key)
                .fetch();
        System.out.println(total);
    }

    @Test
    void transformBean(){
        QDataModel qDataModel = QDataModel.dataModel;
        QDataFragment dataFragment = QDataFragment.dataFragment;
        Map<Long, DataModelQueryResult> fragmentTitles = queryFactory
                .from(qDataModel)
                .leftJoin(dataFragment).on(dataFragment.dataModelId.eq(qDataModel.id))
                .transform(GroupBy.groupBy(qDataModel.id)
                        .as(Projections.bean(DataModelQueryResult.class, qDataModel.key, GroupBy.list(dataFragment.title).as("fragmentTitles")))
                );
        System.out.println(fragmentTitles);
    }

    @Test
    void transform(){
        QDataModel qDataModel = QDataModel.dataModel;
        QDataFragment dataFragment = QDataFragment.dataFragment;
        Map<Long, List<String>> fragmentTitles = queryFactory
                .from(qDataModel)
                .leftJoin(dataFragment).on(dataFragment.dataModelId.eq(qDataModel.id))
                .transform(GroupBy.groupBy(qDataModel.id).as(GroupBy.list(dataFragment.title).as("fragmentTitles"))
                );
        System.out.println(fragmentTitles);
    }
}