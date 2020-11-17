package top.bluesword.laboratory.transfer;

import lombok.Data;

import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
public class BaseDataDTO {

    private Long id;

    private Instant createTime;

}
