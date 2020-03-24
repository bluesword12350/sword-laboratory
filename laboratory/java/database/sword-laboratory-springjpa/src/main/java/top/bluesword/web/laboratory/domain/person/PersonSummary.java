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

    public static PersonSummary convert(Person person){
        PersonSummary personSummary = new PersonSummary();
        personSummary.setName(person.getFullName().acquireFullName());
        personSummary.setIdentityCode(person.getIdentityCode());
        personSummary.setPerson(person);
        return personSummary;
    }
}
