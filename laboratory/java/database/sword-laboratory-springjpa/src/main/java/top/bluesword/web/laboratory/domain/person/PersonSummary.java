package top.bluesword.web.laboratory.domain.person;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

/**
 * @author 李林峰
 */
@Data
@Embeddable
public class PersonSummary {

    private String name;

    private String identityCode;

    @OneToOne
    private Person person;
}
