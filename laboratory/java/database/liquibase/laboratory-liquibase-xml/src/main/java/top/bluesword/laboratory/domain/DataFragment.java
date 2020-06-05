package top.bluesword.laboratory.domain;

import lombok.Data;

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

}
