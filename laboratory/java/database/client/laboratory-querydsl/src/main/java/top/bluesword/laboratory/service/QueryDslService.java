package top.bluesword.laboratory.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bluesword.laboratory.domain.DataContext;
import top.bluesword.laboratory.domain.DataFragment;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.domain.QDataModel;
import top.bluesword.laboratory.repository.DataModelQueryDslRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author 李林峰
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class QueryDslService {

    private final DataModelQueryDslRepository dataModelQueryDslRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public void delete(Long id){
        QDataModel qDataModel = QDataModel.dataModel;
        jpaQueryFactory
                .delete(qDataModel)
                .where(qDataModel.id.eq(id))
                .execute();
    }

    public List<DataModel> findAll() {
        return dataModelQueryDslRepository.findAll();
    }

    public DataModel mock() {
        DataModel dataModel = new DataModel();
        dataModel.setKey(UUID.randomUUID().toString());
        DataContext dataContext = new DataContext();
        dataContext.setFragments(List.of(new DataFragment("段落1"),new DataFragment("段落2")));
        dataModel.setContext(dataContext);
        return dataModelQueryDslRepository.save(dataModel);
    }

}
