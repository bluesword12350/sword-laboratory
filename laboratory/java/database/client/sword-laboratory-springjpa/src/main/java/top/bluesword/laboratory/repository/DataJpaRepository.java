package top.bluesword.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.bluesword.laboratory.domain.DataModel;

import java.util.List;
import java.util.Optional;

/**
 * @author 李林峰
 */
@Repository
public interface DataJpaRepository extends JpaRepository<DataModel,Long>, JpaSpecificationExecutor<DataModel> {

    Optional<DataModel> findFirstByName(String name);

    List<DataModel> findByName(String name);

    List<DataModel> findByNameAndIdNot(String name, Long id);

}
