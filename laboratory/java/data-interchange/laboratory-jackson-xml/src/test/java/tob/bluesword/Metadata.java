package tob.bluesword;

import lombok.Data;

import java.util.List;

@Data
public class Metadata {

    private String groupId;

    private String artifactId;

    private Versioning versioning;

    @Data
    public static class Versioning {

        private String latest;

        private String release;

        private Versions versions;

        private Long lastUpdated;

        @Data
        public static class Versions {

            private List<String> version;

        }
    }
}
