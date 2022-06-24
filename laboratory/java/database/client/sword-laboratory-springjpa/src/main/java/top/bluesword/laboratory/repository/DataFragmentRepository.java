package top.bluesword.laboratory.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.bluesword.laboratory.domain.DataFragment;
import top.bluesword.laboratory.domain.DataFragment_;

import java.util.List;

/**
 * @author 李林峰
 */
@Repository
public interface DataFragmentRepository extends JpaRepository<DataFragment,Long> {

    /**
     *  查询所有数据
     * @return 所有数据
     */
    @EntityGraph(attributePaths = {
            DataFragment_.EXTERNAL_LINKS
    })
    @Override
    List<DataFragment> findAll();

}
