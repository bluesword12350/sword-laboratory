package top.bluesword.maven.api;

import org.junit.jupiter.api.Test;
import top.bluesword.maven.domain.Dependency;

import java.io.IOException;

class MavenRemoteRepositoryTest {

    @Test
    void get() throws IOException {
        String repositoryUrlStr = "https://repo1.maven.org/maven2/";
        MavenRemoteRepository remoteRepository = new MavenRemoteRepository(repositoryUrlStr);
        Dependency okhttp = Dependency.builder().groupId("org.jsoup").artifactId("jsoup").build();
        System.out.println(remoteRepository.getLatest(okhttp));
    }
}