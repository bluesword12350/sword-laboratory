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

    private String groupPath;

    Dependency(final String groupId, final String artifactId, final String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.groupPath = groupId.replaceAll("\\.","/");
    }

    public static Dependency.DependencyBuilder builder() {
        return new Dependency.DependencyBuilder();
    }

    public static class DependencyBuilder {
        private String groupId;
        private String artifactId;
        private String version;

        DependencyBuilder() {
        }

        public Dependency.DependencyBuilder groupId(final String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Dependency.DependencyBuilder artifactId(final String artifactId) {
            this.artifactId = artifactId;
            return this;
        }

        public Dependency.DependencyBuilder version(final String version) {
            this.version = version;
            return this;
        }

        public Dependency build() {
            return new Dependency(this.groupId, this.artifactId, this.version);
        }

    }
}
