package top.bluesword.web.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import top.bluesword.web.laboratory.domain.DataModel;

/**
 * @author 李林峰
 */
@Repository
public interface DataModelQueryDslRepository extends JpaRepository<DataModel, String>, QuerydslPredicateExecutor<DataModel> {
}
