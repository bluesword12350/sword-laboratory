package top.bluesword.laboratory;

import lombok.Data;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author 李林峰
 */
@Data
public class Fund {

    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getPercentInstance();

    private String code;

    private String name;

    private Instant sellTime;

    private BigDecimal yield;

    public Fund(String code, String name, Long sellTime) {
        this.code = code;
        this.name = name;
        this.sellTime = Instant.ofEpochMilli(sellTime);
    }

    public Fund(String code, String name, BigDecimal yield) {
        this.code = code;
        this.name = name;
        this.yield = yield;
    }

    public static class YieldComparator implements Comparator<Fund> {

        @Override
        public int compare(Fund o1, Fund o2) {
            BigDecimal yield1 = o1.getYield();
            yield1 = Objects.isNull(yield1) ? BigDecimal.ZERO : yield1;
            BigDecimal yield2 = o2.getYield();
            yield2 = Objects.isNull(yield2) ? BigDecimal.ZERO : yield2;
            return yield1.compareTo(yield2);
        }

    }
}
