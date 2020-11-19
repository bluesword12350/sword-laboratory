package top.bluesword.maven.domain;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class Dependency {

    private String groupId;

    private String artifactId;

    private String version;

}
