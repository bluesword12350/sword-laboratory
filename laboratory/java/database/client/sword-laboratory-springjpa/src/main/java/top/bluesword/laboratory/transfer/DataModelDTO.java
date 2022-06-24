package top.bluesword.laboratory.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.laboratory.domain.TypeEnum;
import top.bluesword.laboratory.transfer.person.PersonSummaryDTO;

import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataModelDTO extends BaseDataDTO {

    private String code;

    private String name;

    private TypeEnum type;

    private Instant date;

    private DataContextDTO context;

    private PersonSummaryDTO owner;

    private Integer version;

}
