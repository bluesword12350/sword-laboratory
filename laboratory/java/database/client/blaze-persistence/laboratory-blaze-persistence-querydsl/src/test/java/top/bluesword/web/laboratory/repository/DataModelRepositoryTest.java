package top.bluesword.web.laboratory.repository;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.web.laboratory.domain.DataModel;
import top.bluesword.web.laboratory.domain.QDataModel;

import java.util.List;

@SpringBootTest
class DataModelRepositoryTest {

    @Autowired
    private BlazeJPAQuery<?> blazeJpaQuery;

    private final QDataModel qDataModel = QDataModel.dataModel;

    @Test
    void fetch(){
        List<DataModel> dataModels = blazeJpaQuery.select(qDataModel).from(qDataModel).fetch();
        System.out.println(dataModels);
    }

    @Test
    void fetchCount(){
        long count = blazeJpaQuery.select(qDataModel).from(qDataModel).fetchCount();
        System.out.println(count);
    }

    @Test
    void fetchPage(){
        PagedList<DataModel> dataModels =
                blazeJpaQuery
                        .select(qDataModel)
                        .from(qDataModel)
                        .orderBy(qDataModel.id.asc())
                        .fetchPage(0, 10);
        System.out.println(dataModels);
    }

}