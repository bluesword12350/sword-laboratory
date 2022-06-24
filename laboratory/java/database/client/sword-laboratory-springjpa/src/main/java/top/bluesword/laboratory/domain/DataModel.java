package top.bluesword.laboratory.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import top.bluesword.laboratory.domain.person.PersonSummary;
import top.bluesword.laboratory.domain.person.PersonSummary_;

import javax.persistence.*;
import java.time.Instant;

/**
 * 数据模型
 * @author 李林峰
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class DataModel extends BaseData {

    /**
     * 编号
     */
    private String code;

    /**
     * 名字
     */
    private String name;

    /**
     * 类型
     */
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    /**
     * 时间
     */
    private Instant date;

    /**
     * 正文
     */
    @Embedded
    private DataContext context;

    /**
     * 拥有者
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = PersonSummary_.NAME,column = @Column(name = "ownerName")),
            @AttributeOverride(name = PersonSummary_.IDENTITY_CODE,column = @Column(name = "ownerIdentityCode"))
    })
    private PersonSummary owner;

    /**
     * 版本号
     */
    @Version
    private Integer version;

}
