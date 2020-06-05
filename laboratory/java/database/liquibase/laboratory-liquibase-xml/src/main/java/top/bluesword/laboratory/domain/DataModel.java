package top.bluesword.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.laboratory.domain.person.PersonSummary;
import top.bluesword.laboratory.domain.person.PersonSummary_;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class DataModel extends BaseData {

    private String key;

    private String name;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    private Instant date;

    @Column(precision = 36,scale = 6)
    private BigDecimal size;

    @Embedded
    private DataContext context;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = PersonSummary_.NAME,column = @Column(name = "ownerName")),
            @AttributeOverride(name = PersonSummary_.IDENTITY_CODE,column = @Column(name = "ownerIdentityCode")),
            @AttributeOverride(name = PersonSummary_.PERSON_ID,column = @Column(name = "ownerId"))
    })
    private PersonSummary owner;

}
