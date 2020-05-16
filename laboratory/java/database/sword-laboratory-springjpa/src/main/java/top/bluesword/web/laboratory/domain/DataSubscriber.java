package top.bluesword.web.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.web.laboratory.domain.person.Person;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author 李林峰
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class DataSubscriber extends BaseData {

    @ManyToOne
    private DataModel dataModel;

    @ManyToOne
    private Person person;

}
