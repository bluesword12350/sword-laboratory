package top.bluesword.web.laboratory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.bluesword.web.laboratory.domain.person.Person;
import top.bluesword.web.laboratory.domain.person.PersonSummary;
import top.bluesword.web.laboratory.domain.person.PersonSummary_;

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

    private String key;

    private String name;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    private Instant date;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = DataFragment_.DATA_MODEL_ID)
    private List<DataFragment> fragments;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = PersonSummary_.NAME,column = @Column(name = "ownerName")),
            @AttributeOverride(name = PersonSummary_.IDENTITY_CODE,column = @Column(name = "ownerIdentityCode"))
    })
    private PersonSummary owner;

    @OneToMany(cascade = CascadeType.DETACH)
    private List<Person> subscribers;

}
