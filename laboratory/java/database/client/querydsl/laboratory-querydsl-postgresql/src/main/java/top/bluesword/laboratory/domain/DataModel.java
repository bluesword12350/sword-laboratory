package top.bluesword.laboratory.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@Entity
public class DataModel {

    @Id
    @GeneratedValue
    private Long id;

    private String key;

    private String name;

    private String type;

    private Instant date;

    @Type(type = "json")
    private DataContext context;

}
