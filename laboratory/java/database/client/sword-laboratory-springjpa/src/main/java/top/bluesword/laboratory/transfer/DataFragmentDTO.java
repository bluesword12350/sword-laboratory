package top.bluesword.laboratory.transfer;

import lombok.Data;
import top.bluesword.laboratory.domain.ExternalLink;

import java.util.List;

/**
 * @author 李林峰
 */
@Data
public class DataFragmentDTO {

    private Long id;

    private String title;

    private String content;

    private Integer index;

    private Long dataModelId;

    private List<ExternalLink> externalLinks;

}
