package top.bluesword.maven.api;

import org.junit.jupiter.api.Test;
import top.bluesword.maven.domain.Pack;

import javax.xml.bind.JAXBException;
import java.io.IOException;

class MavenRemoteRepositoryTest {

    @Test
    void getPackMetadata() throws IOException, JAXBException {
        String repositoryUrlStr = "https://maven.aliyun.com/nexus/content/groups/public/";
        MavenRemoteRepository remoteRepository = new MavenRemoteRepository(repositoryUrlStr);
        Pack pack = Pack.builder().groupId("org.springframework.boot").artifactId("spring-boot-starter-parent").build();
        System.out.println(remoteRepository.getPackMetadata(pack));
    }
}