package top.bluesword.web.laboratory.domain.person;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * @author 李林峰
 */
@Data
@Embeddable
public class FullName {

    private String surname;

    private String name;

    public String acquireFullName(){
        return surname+name;
    }

}
