package tob.bluesword;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@Data
public class Metadata {

    private String groupId;

    private String artifactId;

    private Versioning versioning;

    @Data
    static class Versioning {

        private String latest;

        private String release;

        private Versions versions;

        private Long lastUpdated;

        @Data
        static class Versions {

            private List<String> version;

        }
    }
}
