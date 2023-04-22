package top.bluesword.laboratory.domain.projection;

import lombok.Data;

import java.util.List;

/**
 * @author 李林峰
 */
@Data
public class DataModelQueryResult {

    private String key;

    private List<String> fragmentTitles;

}
