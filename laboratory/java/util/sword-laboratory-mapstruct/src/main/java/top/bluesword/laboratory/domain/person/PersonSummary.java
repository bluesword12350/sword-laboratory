package top.bluesword.laboratory.domain.person;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class PersonSummary {

    private String name;

    private String identityCode;

    private Person person;

    public static PersonSummary convert(Person person){
        PersonSummary personSummary = new PersonSummary();
        personSummary.setName(person.getFullName().acquireFullName());
        personSummary.setIdentityCode(person.getIdentityCode());
        personSummary.setPerson(person);
        return personSummary;
    }
}
