package top.bluesword.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.bluesword.laboratory.model.Journey;

/**
 * @author 李林峰
 */
@Repository
public interface JourneyRepository extends JpaRepository<Journey,Long> {
}
