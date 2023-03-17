package top.bluesword.laboratory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@AllArgsConstructor
public class BaseData {

    private Long id;

    private Instant createTime;

}
