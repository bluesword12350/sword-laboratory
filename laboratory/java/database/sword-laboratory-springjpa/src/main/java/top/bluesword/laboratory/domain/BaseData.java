package top.bluesword.laboratory.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@MappedSuperclass
public class BaseData {

    @Id
    @GeneratedValue
    private Long id;

    private Instant createTime;

}
