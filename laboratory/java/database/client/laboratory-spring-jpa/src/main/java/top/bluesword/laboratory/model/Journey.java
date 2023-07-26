package top.bluesword.laboratory.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 旅程
 * @author 李林峰
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Journey extends BaseData{

    @Embedded
    private OffsetTimeSpan timeSpan;

}
