package top.bluesword.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.LaboratoryApplication;
import top.bluesword.laboratory.model.Projection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LaboratoryApplication.class)
class ProjectionRepositoryTest {

  @Autowired
  private ProjectionRepository projectionRepository;

  @Test
  void selectJson() {
    String jsonStr = "[{\"key\":\"key1\",\"name\":\"name1\"},{\"key\":\"key2\",\"name\":\"name2\"}]";
    List<Projection> projections = projectionRepository.selectJson(jsonStr,"key1");
    for (Projection projection : projections) {
      System.out.println("key:"+projection.getKey());
      System.out.println("name:"+projection.getName());
    }
  }
}