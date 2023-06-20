package top.bluesword.laboratory.dao;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryCondition;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.model.Journey;

@SpringBootTest
public class JourneyMapperTest {

  @Resource
  private JourneyMapper journeyMapper;

  @Test
  void paginate(){
    Page<Journey> paginate = journeyMapper.paginate(1, 10, QueryCondition.createEmpty());
    System.out.println(paginate);
  }
}
