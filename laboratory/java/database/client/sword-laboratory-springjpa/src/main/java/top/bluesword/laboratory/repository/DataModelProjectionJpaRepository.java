package top.bluesword.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.projection.DataModelProjection;

import java.util.List;

/**
 * @author 李林峰
 */
@Repository
public interface DataModelProjectionJpaRepository extends JpaRepository<DataModel,Long> {

    List<DataModelProjection> findByCode(String code);

}
