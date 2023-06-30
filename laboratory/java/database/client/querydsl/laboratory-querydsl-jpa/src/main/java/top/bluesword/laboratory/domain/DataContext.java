package top.bluesword.laboratory.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 李林峰
 */
@Data
@Embeddable
public class DataContext {

    private String briefIntroduction;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "dataModelId")
    private List<DataFragment> fragments;

}
