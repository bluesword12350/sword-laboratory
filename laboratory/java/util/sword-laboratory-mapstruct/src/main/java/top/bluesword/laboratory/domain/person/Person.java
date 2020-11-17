package top.bluesword.laboratory.domain.person;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class Person {

    private Long id;

    private FullName fullName;

    private String identityCode;

}
