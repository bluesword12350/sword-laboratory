package top.bluesword.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.bluesword.laboratory.domain.CompositePrimaryKeyTable;
import top.bluesword.laboratory.domain.DataModel;

/**
 * @author 李林峰
 */
@Repository
public interface CompositePrimaryKeyRepository extends JpaRepository<CompositePrimaryKeyTable,Long>, JpaSpecificationExecutor<CompositePrimaryKeyTable> {
}
