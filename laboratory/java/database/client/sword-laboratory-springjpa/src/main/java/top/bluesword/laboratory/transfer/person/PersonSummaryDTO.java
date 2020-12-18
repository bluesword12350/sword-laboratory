package top.bluesword.laboratory.transfer.person;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class PersonSummaryDTO {

    private String name;

    private String identityCode;

    private Long personId;

    public static PersonSummaryDTO convert(PersonDTO person){
        PersonSummaryDTO personSummary = new PersonSummaryDTO();
        personSummary.setName(person.getFullName().acquireFullName());
        personSummary.setIdentityCode(person.getIdentityCode());
        personSummary.setPersonId(person.getId());
        return personSummary;
    }
}
