package top.bluesword.laboratory.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author 李林峰
 */
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class DataFragment {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private Integer index;

    private Long dataModelId;

    /**
     * 外部链接
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = ExternalLink_.DATA_FRAGMENT_ID)
    private List<ExternalLink> externalLinks;

}
