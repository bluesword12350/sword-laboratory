package top.bluesword.web.laboratory.domain.person;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * @author 李林峰
 */
@Data
@Embeddable
public class FullName {

    /**
     * 姓
     */
    private String surname;

    /**
     * 名
     */
    private String name;

    public String acquireFullName(){
        return surname+name;
    }

}
