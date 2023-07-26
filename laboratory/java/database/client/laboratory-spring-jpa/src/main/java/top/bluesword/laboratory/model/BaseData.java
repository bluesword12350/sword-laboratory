package top.bluesword.laboratory.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

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