package top.bluesword.laboratory.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 李林峰
 */
@Data
public class DataContext {

    private String briefIntroduction;

    private List<DataFragment> fragments;

}
