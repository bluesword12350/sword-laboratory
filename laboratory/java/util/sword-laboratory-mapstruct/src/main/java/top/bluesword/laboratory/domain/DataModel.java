package top.bluesword.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.laboratory.domain.person.PersonSummary;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataModel extends BaseData {

    private String key;

    private String name;

    private TypeEnum type;

    private Instant date;

    private DataContext context;

    private PersonSummary owner;

}
