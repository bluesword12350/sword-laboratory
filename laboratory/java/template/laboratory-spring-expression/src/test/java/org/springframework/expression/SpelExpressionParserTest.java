package org.springframework.expression;

import org.junit.jupiter.api.Test;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;

class SpelExpressionParserTest {

    @Test
    void parseExpression(){
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariables(Map.of("name","李林峰"));
        String value = new SpelExpressionParser()
                .parseExpression("他的名字为#{#name}", new TemplateParserContext())
                .getValue(context,String.class);
        System.out.println(value);
    }

}
