package net.sf.jsqlparser.parser;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class CCJSqlParserUtilTest {

  @Test
  void parseSelect() throws JSQLParserException {
    String sql = "select 'L',now()";
    Statement statement = CCJSqlParserUtil.parse(sql);
    Assertions.assertEquals(statement.getClass(), Select.class);
    SelectBody selectBody = ((Select) statement).getSelectBody();
    Assertions.assertEquals(selectBody.getClass(), PlainSelect.class);
    if (selectBody instanceof PlainSelect plainSelect){
      log.info("selectItems : {}",plainSelect.getSelectItems());
    }
  }

}
