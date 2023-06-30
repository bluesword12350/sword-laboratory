package jakarta.persistence;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.LaboratoryApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = LaboratoryApplication.class)
class EntityManagerTest {

  @Resource
  private EntityManager entityManager;

  @Test
  void test(){
    String jsonStr = "[{\"key\":\"key1\",\"name\":\"name1\"},{\"key\":\"key2\",\"name\":\"name2\"}]";
    List<?> resultList = entityManager.createNativeQuery(
      "select key,name from json_to_recordset(:json ::::json) as t(key varchar,name varchar)"
    )
      .setParameter("json",jsonStr)
      .getResultList();
    for (Object o : resultList) {
      System.out.println(Arrays.toString((Object[]) o));
    }
  }

}
