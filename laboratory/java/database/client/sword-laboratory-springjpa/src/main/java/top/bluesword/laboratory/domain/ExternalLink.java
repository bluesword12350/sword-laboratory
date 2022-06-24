package top.bluesword.laboratory.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @author 李林峰
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ExternalLink extends BaseData{

    private String name;

    private String url;

    private Long dataFragmentId;

}
