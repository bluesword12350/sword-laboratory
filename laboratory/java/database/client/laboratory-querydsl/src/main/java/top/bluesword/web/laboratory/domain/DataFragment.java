package top.bluesword.web.laboratory.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 李林峰
 */
@Data
@Entity
public class DataFragment {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private Integer index;

    private Long dataModelId;

    public DataFragment() {
    }

    public DataFragment(String title) {
        this.title = title;
    }
}
