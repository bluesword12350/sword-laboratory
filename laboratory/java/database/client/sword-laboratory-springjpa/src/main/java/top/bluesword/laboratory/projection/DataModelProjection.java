package top.bluesword.laboratory.projection;

import top.bluesword.laboratory.domain.TypeEnum;

import java.time.Instant;

/**
 * @author 李林峰
 */
public interface DataModelProjection {

    String getCode();

    String getName();

    TypeEnum getType();

    Instant getDate();

}
