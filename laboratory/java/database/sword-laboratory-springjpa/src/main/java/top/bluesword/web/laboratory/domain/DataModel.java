package top.bluesword.web.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.web.laboratory.domain.person.PersonSummary;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

/**
 * @author 李林峰
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class DataModel extends BaseData {

    @Id
    private Long id;

    private String key;

    private String name;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    private Instant date;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = PersonSummary_.NAME,column = @Column(name = "ownerName")),
            @AttributeOverride(name = PersonSummary_.IDENTITY_CODE,column = @Column(name = "ownerIdentityCode"))
    })
    private PersonSummary owner;

    @OneToMany(mappedBy=EditLog_.DATA_MODEL)
    private List<EditLog> editLogs;
}