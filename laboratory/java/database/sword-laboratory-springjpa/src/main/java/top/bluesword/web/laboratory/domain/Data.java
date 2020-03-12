package top.bluesword.web.laboratory.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

/**
 * @author 李林峰
 */
@lombok.Data
@Entity
public class Data {

    @Id
    private Long id;

    private String key;

    private String name;

    private String type;

    private Instant date;

}
