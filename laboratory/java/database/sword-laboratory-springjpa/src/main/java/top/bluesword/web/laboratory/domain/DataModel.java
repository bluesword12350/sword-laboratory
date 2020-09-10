package top.bluesword.web.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.web.laboratory.domain.person.PersonSummary;
import top.bluesword.web.laboratory.domain.person.PersonSummary_;

import javax.persistence.*;
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

    @Embedded
    private DataContext context;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = PersonSummary_.NAME,column = @Column(name = "ownerName")),
            @AttributeOverride(name = PersonSummary_.IDENTITY_CODE,column = @Column(name = "ownerIdentityCode"))
    })
    private PersonSummary owner;

    @Version
    private Integer version;

}
