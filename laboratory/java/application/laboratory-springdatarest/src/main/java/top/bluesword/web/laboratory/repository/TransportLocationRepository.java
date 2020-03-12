package top.bluesword.web.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.bluesword.web.laboratory.entity.TransportLocation;

/**
 * @author 李林峰
 */
@Repository
public interface TransportLocationRepository extends JpaRepository<TransportLocation, String> {
}
