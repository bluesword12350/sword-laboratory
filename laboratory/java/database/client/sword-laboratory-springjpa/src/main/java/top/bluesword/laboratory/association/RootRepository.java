package top.bluesword.laboratory.association;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李林峰
 */
@Repository
public interface RootRepository extends JpaRepository<Root,Long> {
}
