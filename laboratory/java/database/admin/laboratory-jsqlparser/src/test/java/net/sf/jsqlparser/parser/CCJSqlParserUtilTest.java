package net.sf.jsqlparser.parser;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class CCJSqlParserUtilTest {

  @Test
  void parseSelect() throws JSQLParserException {
    String sql = "select 'L',now(),a.key,b.name,b.*,a.key||b.name  from t_a a left join t_b b where a.id = b.w_id";
    Statement statement = CCJSqlParserUtil.parse(sql);
    Assertions.assertEquals(statement.getClass(), Select.class);
    SelectBody selectBody = ((Select) statement).getSelectBody();
    Assertions.assertEquals(selectBody.getClass(), PlainSelect.class);
    if (selectBody instanceof PlainSelect plainSelect){
      log.info("fromItem:{}",plainSelect.getFromItem());
      log.info("joins:{}",plainSelect.getJoins());
      for (SelectItem selectItem : plainSelect.getSelectItems()) {
        if (selectItem instanceof SelectExpressionItem expressionItem) {
          Expression expression = expressionItem.getExpression();
          log.info("expression.getClass():{}",expression.getClass());
        } else if (selectItem instanceof AllTableColumns allTableColumns){
          log.info("allTableColumns.getTable():{}", allTableColumns.getTable());
        } else {
          log.info("selectItem.getClass():{}",selectItem.getClass());
        }
      }
    }
  }

}
