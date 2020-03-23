package top.bluesword.web.laboratory.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@MappedSuperclass
public class BaseData {

    private Instant createTime;

}
