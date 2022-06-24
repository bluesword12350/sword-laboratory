package top.bluesword.laboratory.transfer;

import lombok.*;
import top.bluesword.laboratory.domain.BaseData;

import javax.persistence.Entity;

/**
 * @author 李林峰
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExternalLinkDTO extends BaseData {

    private String name;

    private String url;

    private Long dataFragmentId;

}
