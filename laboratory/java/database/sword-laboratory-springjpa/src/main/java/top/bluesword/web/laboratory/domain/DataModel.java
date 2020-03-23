package top.bluesword.web.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class DataModel extends BaseData{

    @Id
    private Long id;

    private String key;

    private String name;

    private String type;

    private Instant date;

}
