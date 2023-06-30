package top.bluesword.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.bluesword.laboratory.model.Journey;
import top.bluesword.laboratory.model.Projection;

import java.util.List;

/**
 * @author 李林峰
 */
public interface ProjectionRepository extends JpaRepository<Journey,Long> {

  @Query(
    value =
      """
        select key,name from json_to_recordset(:json ::::json) as t(key varchar,name varchar)
      """,
    nativeQuery = true
  )
  List<Projection> selectJson(String json);

}
