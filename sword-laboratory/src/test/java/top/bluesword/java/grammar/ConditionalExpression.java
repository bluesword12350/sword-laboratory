package top.bluesword.java.grammar;

import org.junit.jupiter.api.Test;

import java.util.Random;

class ConditionalExpression {
    @Test
    void main(){
        Integer i = 1;
        Double d = 2.0;
        Object o = new Random().nextBoolean() ? i : d;
        System.out.println(o);
    }
}
