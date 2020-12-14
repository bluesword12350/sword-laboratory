package top.bluesword.maven.domain;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class Pack {

    private final String groupId;

    private final String artifactId;

    private final String version;

    private final String groupPath;

    Pack(final String groupId, final String artifactId, final String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.groupPath = groupId.replaceAll("\\.","/");
    }

    public static PackBuilder builder() {
        return new PackBuilder();
    }

    public static class PackBuilder {
        private String groupId;
        private String artifactId;
        private String version;

        PackBuilder() {
        }

        public PackBuilder groupId(final String groupId) {
            this.groupId = groupId;
            return this;
        }

        public PackBuilder artifactId(final String artifactId) {
            this.artifactId = artifactId;
            return this;
        }

        public PackBuilder version(final String version) {
            this.version = version;
            return this;
        }

        public Pack build() {
            return new Pack(this.groupId, this.artifactId, this.version);
        }

    }
}
