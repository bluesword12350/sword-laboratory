package top.bluesword.maven.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author 李林峰
 */
@Data
@Builder
public class Pom {

    private List<Pack> dependencies;

}
