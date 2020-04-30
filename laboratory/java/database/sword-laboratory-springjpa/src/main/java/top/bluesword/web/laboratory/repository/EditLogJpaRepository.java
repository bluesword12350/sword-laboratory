package top.bluesword.web.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.bluesword.web.laboratory.domain.DataModel;
import top.bluesword.web.laboratory.domain.log.EditLog;

/**
 * @author 李林峰
 */
@Repository
public interface EditLogJpaRepository extends JpaRepository<EditLog,Long>, JpaSpecificationExecutor<DataModel> {
}
