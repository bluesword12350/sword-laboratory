package top.bluesword.maven.api;

import org.junit.jupiter.api.Test;
import top.bluesword.maven.domain.Pack;

import java.io.IOException;

class MavenRemoteRepositoryTest {

    @Test
    void getLatest() throws IOException {
        String repositoryUrlStr = "https://repo1.maven.org/maven2/";
        MavenRemoteRepository remoteRepository = new MavenRemoteRepository(repositoryUrlStr);
        Pack pack = Pack.builder().groupId("org.apache.shiro").artifactId("shiro-spring").build();
        System.out.println(remoteRepository.getVersions(pack));
    }
}