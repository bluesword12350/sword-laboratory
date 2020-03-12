package top.bluesword.web.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.bluesword.web.laboratory.domain.Data;

/**
 * @author 李林峰
 */
@Repository
public interface DataJpaRepository extends JpaRepository<Data,Long>, JpaSpecificationExecutor<Data> {
}
