package top.bluesword.web.laboratory.domain.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 李林峰
 */
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private FullName fullName;

    private String identityCode;

}
