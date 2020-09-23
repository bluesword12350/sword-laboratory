package top.bluesword.web.laboratory.bean;

import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author 李林峰
 */
@Data
public class DataModel {

    private String key;

    private String name;

    private Instant date;

    private List<DataFragment> fragments;

}
