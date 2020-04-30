package top.bluesword.web.laboratory.domain.log;

import lombok.Data;
import top.bluesword.web.laboratory.domain.DataModel;
import top.bluesword.web.laboratory.domain.person.PersonSummary;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author 李林峰
 */
@Data
@Entity
public class EditLog {

    @Id
    @GeneratedValue
    private Long id;

    private Instant editTime;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name",column = @Column(name = "editorName")),
            @AttributeOverride(name = "identityCode",column = @Column(name = "editorIdentityCode"))
    })
    private PersonSummary editor;

    @ManyToOne
    private DataModel dataModel;
}
