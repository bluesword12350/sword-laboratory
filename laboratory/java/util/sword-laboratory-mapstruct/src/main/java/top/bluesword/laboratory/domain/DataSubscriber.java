package top.bluesword.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.laboratory.domain.person.Person;

/**
 * @author 李林峰
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class DataSubscriber extends BaseData {

    private DataModel dataModel;

    private Person person;

}
