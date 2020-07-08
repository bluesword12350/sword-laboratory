package top.bluesword.im.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 李林峰
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TextMessage extends Message {

    private String text;

}
