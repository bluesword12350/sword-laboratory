package top.bluesword.laboratory.transfer.person;

import lombok.Data;
import top.bluesword.laboratory.domain.person.FullName;

/**
 * @author 李林峰
 */
@Data
public class PersonDTO {

    private Long id;

    private FullNameDTO fullName;

    private String identityCode;

}
