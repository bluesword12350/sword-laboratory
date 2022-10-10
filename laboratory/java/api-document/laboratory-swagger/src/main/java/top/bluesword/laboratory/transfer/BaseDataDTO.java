package top.bluesword.laboratory.transfer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@Schema(description = "基础数据结构")
public class BaseDataDTO {

    private Long id;

    @Schema(description = "创建时间")
    private Instant createTime;

}
