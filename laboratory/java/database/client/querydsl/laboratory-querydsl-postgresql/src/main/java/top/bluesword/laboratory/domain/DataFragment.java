package top.bluesword.laboratory.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李林峰
 */
@Data
@NoArgsConstructor
public class DataFragment {

    private String title;

    private String content;

    private Integer index;

    private Long dataModelId;

    public DataFragment(String title) {
        this.title = title;
    }
}
