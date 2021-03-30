package top.bluesword.laboratory;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author 李林峰
 */
@Data
public class Fund {

    public static final Fund.YieldComparator YIELD_COMPARATOR = new Fund.YieldComparator();

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    public String getSellTimeLocalDateStr() {
        if (Objects.isNull(this.sellTime)) {
            return null;
        }
        return this.sellTime.atZone(ZoneId.systemDefault()).format(DATE_TIME_FORMATTER);
    }

    public boolean canSell() {
        return Objects.nonNull(this.sellTime) && this.sellTime.compareTo(Instant.now()) <= 0;
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
