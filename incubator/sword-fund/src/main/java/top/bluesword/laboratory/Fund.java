package top.bluesword.laboratory;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
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

    public void setYieldStr(String yield) {
        if (StringUtils.isBlank(yield)) {
            return;
        }
        try {
            this.yield = new BigDecimal(NUMBER_FORMAT.parse(yield).toString());
        } catch (ParseException e) {
            this.yield = null;
        }

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
