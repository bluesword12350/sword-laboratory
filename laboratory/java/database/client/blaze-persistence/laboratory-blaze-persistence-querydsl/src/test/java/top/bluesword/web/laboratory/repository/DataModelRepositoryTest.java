package top.bluesword.web.laboratory.repository;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.JPQLNextQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.domain.DataModel;
import top.bluesword.web.laboratory.domain.QDataModel;

import java.util.List;

@SpringBootTest
class DataModelRepositoryTest {

    @Autowired
    private JPQLNextQueryFactory jpqlQueryFactory;

    private final QDataModel qDataModel = QDataModel.dataModel;

    @Test
    void fetch(){
        List<DataModel> dataModels = jpqlQueryFactory.select(qDataModel).from(qDataModel).fetch();
        System.out.println(dataModels);
    }

    @Test
    void fetchCount(){
        long count = jpqlQueryFactory.select(qDataModel).from(qDataModel).fetchCount();
        System.out.println(count);
    }

    @Test
    void fetchPage(){
        PagedList<DataModel> dataModels =
                jpqlQueryFactory
                        .query()
                        .select(qDataModel)
                        .from(qDataModel)
                        .orderBy(qDataModel.date.desc(),qDataModel.id.asc())
                        .fetchPage(0, 1);
        System.out.println(dataModels);
        List<DataModel> models = jpqlQueryFactory.select(qDataModel).from(qDataModel).fetch();
        System.out.println(models);
    }

}