package top.bluesword.laboratory.association;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 李林峰
 */
@Data
@Entity
public class Body {

    @Id
    @GeneratedValue
    private Long id;

}
