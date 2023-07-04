package top.bluesword.laboratory.util;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimpleExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李林峰
 */
public class BooleanExpressionUtils {

  public static BooleanExpression multiValueInWhenNotEmpty(SimpleExpression<?>[] paths, List<List<Object>> values){
    if (values == null || values.size() < 1) {
      return null;
    }
    return multiValueIn(paths,values);
  }

  public static BooleanExpression multiValueIn(SimpleExpression<?>[] paths, List<List<Object>> values) {
    if (paths.length < 1) {
      throw new RuntimeException("查询列不应该少于1");
    }
    if (values.size() < 1) {
      return Expressions.booleanTemplate("0=1");
    }
    if (values.size() == 1) {
      List<Object> objects = values.get(0);
      List<BooleanExpression> booleanExpressions = new ArrayList<>();
      for (int i = 0; i < paths.length; i++) {
        //noinspection unchecked
        booleanExpressions.add(((SimpleExpression<Object>)paths[i]).eq(objects.get(i)));
      }
      return Expressions.allOf(booleanExpressions.toArray(new BooleanExpression[]{}));
    }
    String template = buildTemplate(paths.length);
    List<Expression<Object>> simpleTemplates = new ArrayList<>();
    for (List<?> value : values) {
      simpleTemplates.add(Expressions.template(Object.class, template, value));
    }
    return Expressions.list(Object.class,paths).in(simpleTemplates.toArray(new Expression[]{}));
  }

  private static String buildTemplate(int length) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('(').append('{').append(0).append('}');
    for (int i = 1; i < length; i++) {
      stringBuilder
        .append(',').append('{').append(i).append('}');
    }
    return stringBuilder.append(')').toString();
  }
}
