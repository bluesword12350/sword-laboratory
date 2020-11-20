package top.bluesword.maven.domain;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class Pack {

    private String groupId;

    private String artifactId;

    private String version;

    private String groupPath;

    Pack(final String groupId, final String artifactId, final String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.groupPath = groupId.replaceAll("\\.","/");
    }

    public static Pack.DependencyBuilder builder() {
        return new Pack.DependencyBuilder();
    }

    public static class DependencyBuilder {
        private String groupId;
        private String artifactId;
        private String version;

        DependencyBuilder() {
        }

        public Pack.DependencyBuilder groupId(final String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Pack.DependencyBuilder artifactId(final String artifactId) {
            this.artifactId = artifactId;
            return this;
        }

        public Pack.DependencyBuilder version(final String version) {
            this.version = version;
            return this;
        }

        public Pack build() {
            return new Pack(this.groupId, this.artifactId, this.version);
        }

    }
}
