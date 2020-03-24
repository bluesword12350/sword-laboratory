package top.bluesword.web.laboratory.domain.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 李林峰
 */
@Data
@Entity
public class Person {

    @Id
    private Long id;

    private FullName name;

    private String identityCode;

}
