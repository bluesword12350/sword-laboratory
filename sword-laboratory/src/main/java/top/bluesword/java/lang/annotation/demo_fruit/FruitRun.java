package top.bluesword.java.lang.annotation.demo_fruit;

import top.bluesword.java.lang.annotation.demo_fruit.bean.Apple;
import top.bluesword.java.lang.annotation.demo_fruit.util.FruitInfoUtil;

public class FruitRun {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}