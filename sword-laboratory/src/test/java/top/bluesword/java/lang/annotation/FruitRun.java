package top.bluesword.java.lang.annotation;

import top.bluesword.java.lang.annotation.bean.Apple;
import top.bluesword.java.lang.annotation.util.FruitInfoUtil;

public class FruitRun {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}