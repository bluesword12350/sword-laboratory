package top.bluesword.laboratory.domain;

/**
 * @author 李林峰
 */

public enum TypeEnum {

    /**
     * 有效
     */
    EFFECTIVE("Effective"),

    /**
     * 无效的
     */
    INVALID("Invalid"),

    /**
     * 候选
     */
    CANDIDATE("candidate"),
    ;

    TypeEnum(String code) {
    }
}
