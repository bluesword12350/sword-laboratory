package top.bluesword.laboratory.transfer.person;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class FullNameDTO {

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
