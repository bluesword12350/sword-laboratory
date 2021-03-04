package top.bluesword.laboratory;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
public class Fund {

    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getPercentInstance();

    private String code;

    private String name;

    private Instant sellTime;

    private Double yield;

    public Fund(String code, String name, Long sellTime) {
        this.code = code;
        this.name = name;
        this.sellTime = Instant.ofEpochMilli(sellTime);
    }

    public void setYieldStr(String yield){
        if (StringUtils.isBlank(yield)) {
            return;
        }
        try {
            this.yield = NUMBER_FORMAT.parse(yield).doubleValue();
        } catch (ParseException e) {
            this.yield = null;
        }
    }
}
