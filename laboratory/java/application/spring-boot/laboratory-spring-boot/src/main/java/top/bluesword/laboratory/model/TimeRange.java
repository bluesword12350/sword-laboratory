package top.bluesword.laboratory.model;

import lombok.Data;

import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
public class TimeRange {

    private Instant from;

    private Instant to;

}
