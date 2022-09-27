package top.bluesword.laboratory.projection;

import top.bluesword.laboratory.domain.ExternalLink;

import java.util.List;

/**
 * @author 李林峰
 */
public interface DataFragmentProjection {

    String getTitle();

    List<ExternalLink> getExternalLinks();

}
