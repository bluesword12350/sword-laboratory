package top.bluesword.laboratory.domain;

import lombok.Data;

import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
public class BaseData {

    private Long id;

    private Instant createTime;

}
