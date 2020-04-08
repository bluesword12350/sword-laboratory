package org.springframework.expression.spel.standard;

import org.junit.jupiter.api.Test;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

class SpelExpressionParserTest {

    @Test
    void parseExpression(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","李林峰");
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariables(map);
        SpelExpressionParser el = new SpelExpressionParser();
        String value = el.parseExpression("他的名字为#{#name}", new TemplateParserContext())
                .getValue(context,String.class);
        System.out.println(value);
    }
}
