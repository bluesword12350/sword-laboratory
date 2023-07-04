package top.bluesword.laboratory.util;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.domain.QDataModel;

import java.util.List;

@Slf4j
@SpringBootTest
class BooleanExpressionUtilsTest {

  @Autowired
  private JPAQueryFactory queryFactory;

  @Test
  void multiValueIn() {
    List<List<Object>> values = List.of(
      List.of("key1", "name1"),
      List.of("key2", "name2")
    );
    QDataModel qDataModel = QDataModel.dataModel;
    List<DataModel> keys = queryFactory
      .selectFrom(qDataModel)
      .where(
        BooleanExpressionUtils.multiValueIn(new SimpleExpression[]{qDataModel.key, qDataModel.name},values)
      )
      .fetch();
    log.info("keys:{}",keys);
  }
}